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
    Permission perm;
    JComboBox<String> pickTime;
    final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public makeVist(mainFrame frame, Permission perm) {
        this.frame = frame;
        this.perm = perm;

        services = new JComboBox<String>(frame.getDataBase().selectColumn("usługi", new String[] { "nazwa" }, "")[0]);
        services.setSelectedIndex(-1);
        services.addActionListener(this);
        workers = new JComboBox<String>();
        workers.setPrototypeDisplayValue("             ");
        pickTime = new JComboBox<String>();
        pickTime.setPrototypeDisplayValue("             ");
        chooseService = new JLabel("Wybierz usługę");
        chooseWorker = new JLabel("Wybierz pracownika");
        chooseDate = new JLabel("Wybierz date");
        chooseAnimal = new JLabel("Wybierz zwierzę");
        chooseClient = new JLabel("ID klienta");
        chooseTime = new JLabel("Wybierz czas");
        idField = new JTextField(10);
        idField.addActionListener(this);
        confirm = new JButton("Zapisz się");
        confirm.addActionListener(this);

        picker = new JXDatePicker();
        calendar = picker.getMonthView().getCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 1);
        picker.getMonthView().setLowerBound(calendar.getTime());
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    private void createPermisson(Permission perm) {
        if (perm.equals(Permission.CLIENT))
            animals = new JComboBox<>(frame.getDataBase().selectColumn("zwierzęta", new String[] { "imię" },
                    "Where id_klienta=" + perm.getId())[0]);
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
            names = frame.getDataBase().selectColumn("zwierzęta", new String[] { "id", "imię" },
                    "Where id=" + idField.getText());
            model = new DefaultComboBoxModel<>(names[1]);
            idAnimal = names[0];
            animals.setModel(model);
            pack();
        }
        if (e.getSource().equals(services)) {
            names = frame.getDataBase().callProcedure("wyswietlPracownikow",
            new String[] { services.getSelectedItem().toString() }, 3);
            idWorker = names[0];
            help2 = new String[names.length];
            for (int i = 0; i < names.length; i++) {
                help2[i] = "";
                help2[i] += names[i][1] + " ";
                help2[i] += names[i][1];
            }
            model = new DefaultComboBoxModel<>(help2);
            workers.setModel(model);
            workers.setPrototypeDisplayValue(null);

            pack();
        }
        if(e.getSource().equals(picker) && workers.getSelectedIndex() != -1)
        {
            model = new DefaultComboBoxModel<>(frame.getDataBase().callProcedure("wyswietlCzas", 
                new String[]{idWorker[workers.getSelectedIndex()], 
                    format.format(picker.getDate())}, 1)[0]);
            pickTime.setModel(model);

            pack();
        }
        if (e.getActionCommand().equals("Zapisz się") && picker.getDate() != null && services.getSelectedIndex() != -1
                && animals.getSelectedIndex() != -1) {

            if (perm.equals(Permission.CLIENT))
                help = Integer.toString(perm.getId());
            else
                help = idField.getText();
            frame.getDataBase().insert("wizyty", new String[]{
                idWorker[workers.getSelectedIndex()],
                idAnimal[animals.getSelectedIndex()],
                format.format(picker.getDate()) + " " + pickTime.getSelectedItem().toString(),
                services.getSelectedItem().toString()
            });
            /*
            if (frame.getDataBase().callProcedure(procedure,
                    new String[] { idWorker[workers.getSelectedIndex()], idAnimal[animals.getSelectedIndex()],
                            format.format(picker.getDate()), services.getSelectedItem().toString(), },
                    1)[0][0].equals("0"))
                JOptionPane.showConfirmDialog(this, "Termin zajęty lub wyczerpano limit", "Informacja",
                        JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showConfirmDialog(this, "Zapisano", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                */

        }
    }

}