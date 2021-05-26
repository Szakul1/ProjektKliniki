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
    JButton give;

    public employeePanel(mainFrame frame, Permision perm) 
    {
        this.frame = frame;
        Function fun;

        setLayout(new BorderLayout());
        add = new JButton("Dodaj Pracownika");
        add.addActionListener(this);
        
        give = new JButton("Daj Podwyzke");
        give.addActionListener(this);
        
        fun = Function.DELETE;
        fun.setId(-1);
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(add);
        add.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(give);
        give.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(panel, BorderLayout.EAST);

        select = new myPanel("pracownicy",new String[]{"id","imie","nazwisko","numer_tel","data_urodzenia","pensja","zawod"},frame, fun);
        add(select, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Dodaj Pracownika")) {
            new AddWorker(frame);
        }

    	if(e.getActionCommand().equals("Daj Podwyzke")) {
    		String pensja = JOptionPane.showInputDialog(this,"Dla pracownikow zarabiajacych mniej niz:");
    		String podwyzka = JOptionPane.showInputDialog(this,"Wysokosc podwyzki w procentach");
    		frame.getDataBase().giveRaise(Integer.parseInt(pensja),Integer.parseInt(podwyzka));
    	}
    }
}

