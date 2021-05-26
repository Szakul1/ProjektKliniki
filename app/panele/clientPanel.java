package app.panele;

import app.*;
import app.adders.AddClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class clientPanel extends JPanel implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    myPanel select;
    JButton add;
    mainFrame frame;
    JPanel panel;

    public clientPanel(mainFrame frame, Permision perm) 
    {
        this.frame = frame;
        Function fun;

        setLayout(new BorderLayout());
        add = new JButton("Dodaj Klienta");
        add.addActionListener(this);
        if(perm != Permision.TECHNICIAN && perm != Permision.CLIENT)
        {   
            fun = Function.DELETE;
            fun.setId(-1);
            panel = new JPanel();
            panel.add(add);
            add(panel, BorderLayout.EAST);
        }
        else
        {
            fun = Function.SELECT;
            fun.setId(perm.getId());
        }
        select = new myPanel("klienci",new String[]{"id","imie","nazwisko","numer_tel"},frame, fun);
        add(select, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Dodaj Klienta"))
            new AddClient(frame);
    }
}