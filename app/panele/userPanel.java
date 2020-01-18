package app.panele;
import app.*;
import app.adders.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class userPanel extends JPanel implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    myPanel select;
    JButton add;
    mainFrame frame;
    JPanel panel;

    public userPanel(mainFrame frame, Permision perm) 
    {
        this.frame = frame;
        Function fun;

        setLayout(new BorderLayout());
        add = new JButton("Dodaj Uzytkownika");
        add.addActionListener(this);
        fun = Function.DELETE;
        fun.setId(-1);
        panel = new JPanel();
        panel.add(add);
        add(panel, BorderLayout.EAST);

        select = new myPanel("uzytkownicy",new String[]{"login","haslo","uprawnienia","id"},frame, fun);
        add(select, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Dodaj Uzytkownika"))
            new AddClient(frame);
    }
}
