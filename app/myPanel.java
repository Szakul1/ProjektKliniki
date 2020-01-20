package app;    

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class myPanel extends JPanel implements ActionListener
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JLabel chooseColumn;
    JLabel writeCondition;
    String[] names;
    JPanel help1;
    JPanel help2;
    JPanel help3;
    List<JComboBox<String>> columns;
    List<JTextField> condition;
    List<JButton> remove;
    JButton select;
    mainFrame frame;
    String table;
    Function fun;
    String column; //wbudowany select na jak kolumne
    String[] animalId;
    public myPanel(String table, String[] names, mainFrame frame, Function fun)
    {
        if(fun.getId() != -1)
        {
            if(table.equals("zwierzeta"))
                column = "id_klienta";
            if(table.equals("wizyty"))
            {
                column = "id_zwierzecia";
                String[][] help = frame.getDataBase().selectColumn("zwierzeta",
                new String[]{"id_zwierzecia"}, "Where id_klienta="+fun.getId());
                animalId = new String[help.length];
                for (int i = 0; i < animalId.length; i++) {
                    animalId[i] = help[i][0];
                }
            }
        }
        this.fun = fun;
        this.table=table;
        this.names = names;
        this.frame= frame;
        columns = new ArrayList<>();
        condition = new ArrayList<>();
        remove = new ArrayList<>();
        chooseColumn = new JLabel("Kolumna",JLabel.CENTER);
        writeCondition = new JLabel("Warunek",JLabel.CENTER);
        select = new JButton("Wyszukaj");
        select.addActionListener(this);
        
        setLayout(new FlowLayout(FlowLayout.CENTER));
        help1 = new JPanel();
        help1.setLayout(new BoxLayout(help1, BoxLayout.Y_AXIS));
        help1.add(chooseColumn);
        chooseColumn.setAlignmentX(Component.CENTER_ALIGNMENT);
        help2 = new JPanel();
        help2.setLayout(new BoxLayout(help2, BoxLayout.Y_AXIS));
        help2.add(writeCondition);
        writeCondition.setAlignmentX(Component.CENTER_ALIGNMENT);
        help3 = new JPanel();
        help3.setLayout(new BoxLayout(help3, BoxLayout.Y_AXIS));
        help3.add(select);
        select.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(help1);
        add(help2);
        add(help3);

        addCondition();
    }
    
    private void addCondition()
    {
        JComboBox<String> comboBox = new JComboBox<>(names); 
        if(fun.getId() != -1)
            comboBox.removeItem(column);
        columns.add(comboBox);
        columns.get(columns.size()-1).setSelectedIndex(-1);

        columns.get(columns.size()-1).addActionListener(this);
        condition.add(new JTextField(20));
        remove.add(new JButton("X"));
        remove.get(remove.size()-1).addActionListener(this);;

        help1.add(Box.createVerticalStrut(10));
        help1.add(columns.get(columns.size()-1));
        columns.get(columns.size()-1).setAlignmentX(Component.CENTER_ALIGNMENT);
        help2.add(Box.createVerticalStrut(15));
        help2.add(condition.get(condition.size()-1));
        condition.get(condition.size()-1).setAlignmentX(Component.CENTER_ALIGNMENT);
        if(remove.size()==1)
            help3.add(Box.createVerticalStrut(1));
        else
            help3.add(Box.createVerticalStrut(8));
        help3.add(remove.get(remove.size()-1));
        remove.get(remove.size()-1).setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("X"))
        {
            for(int i=0; i<remove.size() && remove.size()>1; i++)
            {
                if(e.getSource().equals(remove.get(i)))
                {
                    help1.remove(i+1);
                    help2.remove(i+1);
                    help3.remove(i+1);
                    condition.remove(i);
                    columns.remove(i);
                    remove.remove(i);
                    frame.pack();
                }
            }
        }
        else if(e.getActionCommand().equals("Wyszukaj"))
        {
            List<String> information = new ArrayList<>();
            for(int i=0; i<remove.size(); i++)
            {
                if(!condition.get(i).getText().isEmpty() && columns.get(i).getSelectedIndex() != -1)
                {
                    information.add(columns.get(i).getSelectedItem().toString());
                    information.add(condition.get(i).getText());
                }
            }
            if(fun.getId() != -1)
            {
                // tu zrobic pelte po id w dla zwierzat
                if(table.equals("wizyty"))
                {
                    String str = "(";
                    for (int i = 0; i < animalId.length; i++) {
                            str += column + "=" + animalId[i];
                        if(i!=animalId.length-1)
                            str+=" OR ";
                        else 
                            str+=")";
                    }
                    information.add("OR");
                    information.add(str);
                }
                else if(!table.equals("grafik") && !table.equals("uslugi"))
                {
                    information.add(column);
                    information.add(fun.getId()+""); //wbudowany select
                }
            }
            frame.getDataBase().select(table,information.toArray(new String[0]),names, fun);
        }
        else
        {
            addCondition();
            frame.pack();
        }
    }

}