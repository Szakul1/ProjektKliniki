
package app;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

//import org.jdesktop.swingx.JXDataPicker;

public class makeVist extends JFrame implements ActionListener
{
    JComboBox<String> services;
    JComboBox<String> workers;
    mainFrame frame;
    JLabel chooseService;
    JLabel chooseWorker;
    Calendar calendar;
    public makeVist(mainFrame frame)
    {
        this.frame = frame;

        services = new JComboBox<String>(frame.getDataBase().selectColumn("usługi", "nazwa",""));
        workers = new JComboBox<String>();
        chooseService = new JLabel("Wybierz usługę");
        chooseWorker = new JLabel("Pracownika usługę");
        calendar = new Ca
        
        add(chooseService);
        add(services);
        add(chooseWorker);
        add(workers);

        setLayout(new FlowLayout());
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //String[] names = frame.getDataBase().selectColumn("pracownicy", "imię","Where zawód="+e.getActionCommand());
        //workers = new JComboBox<>());
    }
    public static void main(String[] args)
    {
        new makeVist(new mainFrame("admin"));
    }
}