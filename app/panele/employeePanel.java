package app.panele;

import app.adders.AddWorker;
import app.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class employeePanel extends JPanel implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    myPanel select;
    JButton add;
    mainFrame frame;
    JPanel panel;

    public employeePanel(mainFrame frame, Permision perm) 
    {
        this.frame = frame;
        Function fun;

        setLayout(new BorderLayout());
        add = new JButton("Dodaj Pracownika");
        add.addActionListener(this);
        
        fun = Function.DELETE;
        fun.setId(-1);
        panel = new JPanel();
        panel.add(add);
        add(panel, BorderLayout.EAST);

        select = new myPanel("pracownicy",new String[]{"id","imie","nazwisko","numer_tel","data_urodzenia","pensja","zawod"},frame, fun);
        add(select, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Dodaj Pracownika"))
            new AddWorker(frame);
    }
}

