package app.panele;
import app.*;

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
      
        if(perm != Permision.TECHNICIAN && perm != Permision.CLIENT)
        {   
            fun = Function.DELETE;
            fun.setId(-1);
            panel = new JPanel();
            add = new JButton("Dodaj Wizyte");
            add.addActionListener(this);
            panel.add(add);
            add(panel, BorderLayout.EAST);
        }
        else if(perm == Permision.CLIENT)
        {
            fun = Function.SELECT;
            fun.setId(perm.getId());
            panel = new JPanel();
            add = new JButton("Zapisz sie na wizyte");
            add.addActionListener(this);
            panel.add(add);
            add(panel,BorderLayout.EAST);
        }
        else {
            fun = Function.DELETE;
        	fun.setId(perm.getId());
        }
        select = new myPanel("wizyty",new String[]{"id_pracownika","id_zwierzecia","termin","cel_wizyty"},frame, fun);
        add(select, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(add)) {
            //new AddClient(frame);
        	new makeVist(frame,perm);
        }
    }
}