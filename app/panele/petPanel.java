package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class petPanel extends JPanel implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    myPanel select;
    JButton add;
    mainFrame frame;

    public petPanel(mainFrame frame, Permission perm) 
    {
        this.frame = frame;
        Function fun;

        setLayout(new BorderLayout());
        add = new JButton("Dodaj Zwierzaka");
        add.addActionListener(this);
        if(perm != Permission.TECHNICIAN && perm != Permission.CLIENT)
        {   
            fun = Function.DELETE;
            fun.setId(-1);
            add(new JPanel().add(add), BorderLayout.EAST);
        }
        else
        {
            fun = Function.SELECT;
            fun.setId(perm.getId());
        }
        select = new myPanel("zwierzeta",new String[]{"imie","data_urodzenia","gatunek","waga","plec","kastrowane"},frame, fun);
        add(select, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Dodaj Zwierzaka"))
            new AddClient(frame);
    }
}