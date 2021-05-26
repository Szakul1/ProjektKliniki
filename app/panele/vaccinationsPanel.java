package app.panele;
import app.*;
import app.adders.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class vaccinationsPanel extends JPanel implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    myPanel select;
    JButton add;
    mainFrame frame;
    JPanel panel;

    public vaccinationsPanel(mainFrame frame, Permision perm) 
    {
        this.frame = frame;
        Function fun;

        setLayout(new BorderLayout());
        add = new JButton("Dodaj Szczepienie");
        add.addActionListener(this);
        if(perm != Permision.TECHNICIAN)
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
        select = new myPanel("szczepienia",new String[]{"id_zwierzecia","choroba","czy_w_tej_klinice"},frame, fun);
        add(select, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Dodaj Szczepienie"))
            new AddVaccination(frame);
    }
}

