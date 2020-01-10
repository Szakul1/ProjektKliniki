package app;

import javax.swing.*;
import java.awt.*;

public class mainFrame extends JFrame
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JTabbedPane cards;
    JButton myDataJButton;
    private static final String admin = "admin";
    private static final String employees = "pracownicy";
    private static final String services = "usługi";
    private static final String clients = "klienci";
    private static final String animals = "zwierzęta";
    private static final String visits = "wizyty";
    private static final String grafic = "grafik";
    private static final String vaccinations = "szczepienia";
    private static final String myData = "i";
    DataBaseConnection dataBase;
    Permission perm;
    public mainFrame(Permission perm)
    {
        this.perm = perm;
        //perm.setId(1);
        dataBase = new DataBaseConnection(this);
        myDataJButton = new JButton(myData);
        cards = new JTabbedPane();
        addCards(this.perm);

        setLayout(new BorderLayout());
        add(cards, BorderLayout.NORTH);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public DataBaseConnection getDataBase()
    {
        return dataBase;
    }

    private void addCards(Permission permissions)
    {
        switch (permissions) {
            case ADMIN:
                cards.addTab(admin, null);
                
            case DIRECTOR:
                cards.addTab(employees,null);

            case VET:
                cards.addTab(clients, new clientPanel(this, Function.DELETE));
                
            case TECHNICIAN:
                cards.addTab(vaccinations, null);

            case CLIENT:
                cards.addTab(services, null);
                cards.addTab(visits, null);
                cards.addTab(animals, null);
                cards.addTab(grafic, null);
                cards.addTab(info, null);
                cards.add(myDataJButton);
            default:
                break;
        }
    }
}