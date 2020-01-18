package app.panele;
import app.*;
import app.adders.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class visitPanel extends JPanel implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    myPanel select;
    JButton add;
    mainFrame frame;
    JPanel panel;
    Permision perm;

    public visitPanel(mainFrame frame, Permision perm) 
    {
        this.frame = frame;
        this.perm = perm;
        Function fun;

        setLayout(new BorderLayout());
        add = new JButton("Dodaj Wizyte");
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
        select = new myPanel("wizyty",new String[]{"termin","cel_wizyty"},frame, fun);
        add(select, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Dodaj Wizyte"))
            new makeVist(frame, perm);
    }
}