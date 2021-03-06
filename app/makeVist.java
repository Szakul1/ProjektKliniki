package app;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

import org.jdesktop.swingx.*;

public class makeVist extends JFrame implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JComboBox<String> services;
    JComboBox<String> workers;
    JComboBox<String> animals;
    mainFrame frame;
    JLabel chooseService;
    JLabel chooseWorker;
    JLabel chooseDate;
    JLabel chooseAnimal;
    JLabel chooseClient;
    JLabel chooseTime;
    JTextField idField;
    JXDatePicker picker;
    Calendar calendar;
    Calendar calendar2;
    JButton confirm;
    Permision perm;
    JComboBox<String> pickTime;
    final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public makeVist(mainFrame frame, Permision perm) {
        this.frame = frame;
        this.perm = perm;

        services = new JComboBox<String>();
        for (String[] s : frame.getDataBase().selectColumn("uslugi", new String[] { "nazwa" }, "")) {
            services.addItem(s[0]);
        }
        
        services.setSelectedIndex(-1);
        services.addActionListener(this);
        workers = new JComboBox<String>();
        workers.setPrototypeDisplayValue("             ");
        pickTime = new JComboBox<String>();
        pickTime.setPrototypeDisplayValue("00:00:00");
        chooseService = new JLabel("Wybierz usluge");
        chooseWorker = new JLabel("Wybierz pracownika");
        chooseDate = new JLabel("Wybierz date");
        chooseAnimal = new JLabel("Wybierz zwierze");
        chooseClient = new JLabel("ID klienta");
        chooseTime = new JLabel("Wybierz czas");
        idField = new JTextField(10);
        idField.addActionListener(this);
        confirm = new JButton("Zapisz sie");
        confirm.addActionListener(this);

        picker = new JXDatePicker();
        calendar = picker.getMonthView().getCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 1);
        picker.getMonthView().setLowerBound(calendar.getTime());
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        if(perm == Permision.CLIENT)
            picker.getMonthView().setUpperBound(calendar.getTime());

        calendar = Calendar.getInstance();
        calendar2 = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        calendar2.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        picker.getMonthView().setUnselectableDates(calendar.getTime(), calendar2.getTime());
        picker.setFormats(format);
        picker.addActionListener(this);

        addComp(chooseService, services);
        addComp(chooseWorker, workers);
        createPermisson(perm);
        addComp(chooseAnimal, animals);
        addComp(chooseDate, picker);
        addComp(chooseTime, pickTime);
        confirm.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(confirm);

        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void addComp(Component comp1, Component comp2) {
        JPanel layout = new JPanel();
        layout.setLayout(new FlowLayout(FlowLayout.CENTER));
        layout.add(comp1);
        layout.add(comp2);
        add(layout);
    }

    private void createPermisson(Permision perm) {
        if (perm.equals(Permision.CLIENT))
        {
            String[][] help = frame.getDataBase().selectColumn("zwierzeta", new String[] { "imie" },
                    "Where id_klienta=" + perm.getId());
            String[] help2 = new String[help.length];           
            for (int i = 0; i < help2.length; i++) {
                help2[i] = help[i][0];
            }
            animals = new JComboBox<>(help2);
        }
        else {
            animals = new JComboBox<>();
            animals.setPrototypeDisplayValue("            ");
            addComp(chooseClient, idField);
        }
    }

    String[] idWorker;
    String[] idAnimal;

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultComboBoxModel<String> model;
        String[][] names;
        String help;
        String[] help2;
        //String procedure;
        if (e.getSource().equals(idField)) {
            names = frame.getDataBase().selectColumn("zwierzeta", new String[] { "id_zwierzecia", "imie" },
                    "Where id_klienta=" + idField.getText());
            if(names.length==0)
                return;
            help2 = new String[names.length];
            idAnimal= new String[names.length];
            for (int i = 0; i < names.length; i++) {
                idAnimal[i] = names[i][0];
                help2[i] = names[i][1];
            }

            model = new DefaultComboBoxModel<>(help2);
            animals.setModel(model);
            pack();
        }
        if (e.getSource().equals(services)) {
            names = frame.getDataBase().callProcedure("wyswietlPracownikow",
            new String[] { services.getSelectedItem().toString() }, 3);
            if(names.length==0)
                return;
            idWorker = names[0];
            help2 = new String[names.length];
            for (int i = 0; i < names.length; i++) {
                help2[i] = "";
                help2[i] += names[i][1] + " ";
                help2[i] += names[i][2];
            }
            model = new DefaultComboBoxModel<>(help2);
            workers.setModel(model);
            workers.setPrototypeDisplayValue(null);

            pack();
        }
        if(e.getSource().equals(picker) && workers.getSelectedIndex() != -1)
        {
            String work;
            if(perm == Permision.CLIENT)
                work="false";
            else
                work="true";
            names = frame.getDataBase().callProcedure("wyswietlCzas", 
            new String[]{idWorker[workers.getSelectedIndex()], 
                format.format(picker.getDate()), work}, 1);
            help2 = new String[names.length];
            for (int i = 0; i < names.length; i++) {
                help2[i] = names[i][0];
            }
            model = new DefaultComboBoxModel<>(help2);
            pickTime.setModel(model);
            
            pack();
        }
        if (e.getActionCommand().equals("Zapisz sie") && picker.getDate() != null && services.getSelectedIndex() != -1
                && animals.getSelectedIndex() != -1 && !pickTime.getSelectedItem().toString().equals("") ) {
            if (perm.equals(Permision.CLIENT))
                help = Integer.toString(perm.getId());
            else
                help = idField.getText();
            String[] maciek = format.format(picker.getDate()).split("-");
            maciek[0] = maciek[2]+"-"+maciek[1]+"-"+maciek[0];
            if(frame.getDataBase().insert("wizyty", new String[]{
                idWorker[workers.getSelectedIndex()],
                idAnimal[animals.getSelectedIndex()],
                maciek[0] + " " + pickTime.getSelectedItem().toString(),
                services.getSelectedItem().toString()
                })>0)
            {
                JOptionPane.showMessageDialog(this, "Zapisano", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
            else
                JOptionPane.showMessageDialog(this, "Termin juz zajety", "Blad", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}