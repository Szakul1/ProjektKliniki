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

    private static final String column = "id";
    JLabel chooseColumn;
    JLabel writeCondition;
    String[] names;
    List<JPanel> help;
    List<JComboBox<String>> columns;
    List<JTextField> condition;
    List<JButton> remove;
    JButton select;
    mainFrame frame;
    String table;
    Function fun;
    public myPanel(String table, String[] names, mainFrame frame, Function fun)
    {
        this.fun = fun;
        this.table=table;
        this.names = names;
        this.frame= frame;
        help = new ArrayList<>();
        columns = new ArrayList<>();
        condition = new ArrayList<>();
        remove = new ArrayList<>();
        chooseColumn = new JLabel("Kolumna                       ");
        writeCondition = new JLabel("Warunek");
        select = new JButton("Wyszukaj");
        select.addActionListener(this);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        help.add(new JPanel());
        help.get(0).setLayout(new FlowLayout(FlowLayout.LEFT));
        help.get(0).add(chooseColumn);
        help.get(0).add(writeCondition);
        help.get(0).add(select);
        add(help.get(0));

        addCondition();
    }
    
    private void addCondition()
    {
        JComboBox<String> comboBox = new JComboBox<>(names); 
        if(fun.getId() != -1)
            comboBox.removeItem(column);
        columns.add(comboBox);

        columns.get(columns.size()-1).addActionListener(this);
        condition.add(new JTextField(20));
        remove.add(new JButton("X"));
        remove.get(remove.size()-1).addActionListener(this);;
        help.add(new JPanel());
        help.get(help.size()-1).setLayout(new FlowLayout());
        help.get(help.size()-1).add(columns.get(columns.size()-1));
        help.get(help.size()-1).add(condition.get(condition.size()-1));
        help.get(help.size()-1).add(remove.get(remove.size()-1));
        add(help.get(help.size()-1));
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
                    remove(help.get(i+1));
                    help.remove(i+1);
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
                if(!condition.get(i).getText().isEmpty())
                {
                    information.add(columns.get(i).getSelectedItem().toString());
                    information.add(condition.get(i).getText());
                }
            }
            if(fun.getId() != -1)
            {
                information.add(table.equals("zwierzęta") ? "id_zwierzęcia" : "id");
                information.add(fun.getId()+"");
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
