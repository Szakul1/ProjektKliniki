package app;

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

    public graficPanel(mainFrame frame, Permission perm) 
    {
        this.frame = frame;
        Function fun;

        setLayout(new BorderLayout());
        add = new JButton("Dodaj Wizyte");
        add.addActionListener(this);
        if(perm != Permission.VET && perm != Permission.TECHNICIAN && perm != Permission.CLIENT)
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
        select = new myPanel("grafik",new String[]{"dzien","rozpoczecie","zakonczenie"},frame, fun);
        add(select, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Dodaj Wizyte"))
            new AddClient(frame);
    }
}