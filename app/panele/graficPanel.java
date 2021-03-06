package app.panele;
import app.*;

import app.adders.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class graficPanel extends JPanel implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    myPanel select;
    JButton add;
    mainFrame frame;
    JPanel help;

    public graficPanel(mainFrame frame, Permision perm) 
    {
        this.frame = frame;
        Function fun;

        help = new JPanel();
        setLayout(new BorderLayout());
        add = new JButton("Dodaj Grafik");
        add.addActionListener(this);
        if(perm != Permision.VET && perm != Permision.TECHNICIAN && perm != Permision.CLIENT)
        {
            help.add(add);   
            fun = Function.DELETE;
            fun.setId(-1);
            add(help, BorderLayout.EAST);
        }
        else
        {
            fun = Function.SELECT;
            fun.setId(perm.getId());
        }
        select = new myPanel("grafik",new String[]{"id_pracownika","dzien","rozpoczecie","zakonczenie"},frame, fun);
        add(select, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Dodaj Grafik"))
            new AddGrafic(frame);
    }
}
