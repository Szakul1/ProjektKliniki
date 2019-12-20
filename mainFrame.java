import javax.swing.*;
import java.awt.*;

public class mainFrame extends JFrame
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JTabbedPane cards;
    //JButton admin;
    //JButton employees;
    //JButton services;
    //JButton clients;
    //JButton visits;
    JButton myDataJButton;
    private static final String admin = "admin";
    private static final String employees = "pracownicy";
    private static final String services = "usługi";
    private static final String clients = "klienci";
    private static final String animals = "zwierzęta";
    private static final String visits = "wizyty";
    private static final String myData = "i";
    //String[] items;
    public mainFrame()
    {
        myDataJButton = new JButton(myData);
        cards = new JTabbedPane();
        //items = new String[]{admin, employees, services, clients, visits, myData};
        cards.addTab(admin, null);
        cards.addTab(employees,null);
        cards.addTab(services, null);
        cards.addTab(clients, new clientPanel(this));
        cards.addTab(visits, null);
        cards.addTab(animals, null);
        cards.add(myDataJButton);
        //cards.setTabLayoutPolicy(JTabbedPane.);

        setLayout(new BorderLayout());
        add(cards, BorderLayout.NORTH);
        //setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new mainFrame();
    }
}