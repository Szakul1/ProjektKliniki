package app;
import app.panele.*;

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
    private static final String services = "uslugi";
    private static final String users = "uzytkownicy";
    private static final String clients = "klienci";
    private static final String animals = "zwierzeta";
    private static final String visits = "wizyty";
    private static final String grafic = "grafik";
    private static final String vaccinations = "szczepienia";
    private static final String myData = "informacje";
    DataBaseConnection dataBase;
    Permision perm;
    public mainFrame(Permision perm)
    {
        this.perm = perm;
        //perm.setId(1);
        dataBase = new DataBaseConnection(this);
        //myDataJButton = new JButton(myData);

        cards = new JTabbedPane();
        addCards(this.perm);

        add(cards);
        pack();
        setSize(this.getWidth(),200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public DataBaseConnection getDataBase()
    {
        return dataBase;
    }

    private void addCards(Permision permissions)
    {
        switch (permissions) {
            case ADMIN:
                cards.addTab(admin, new adminPanel(this));
                cards.addTab(users, new userPanel(this));
                
            case DIRECTOR:
                cards.addTab(employees,new employeePanel(this, permissions));

            case VET:
                cards.addTab(clients, new clientPanel(this, permissions));
                
            case TECHNICIAN:
                cards.addTab(vaccinations, new vaccinationsPanel(this, permissions));

            case CLIENT:
                cards.addTab(services, new servicePanel(this, permissions));
                cards.addTab(visits, new visitPanel(this, permissions));
                cards.addTab(animals, new petPanel(this, permissions));
                cards.addTab(grafic, new graficPanel(this,permissions));
                //cards.addTab(myData, null);
                //cards.add(myDataJButton);
            default:
                break;
        }
        if(permissions==Permision.VET || permissions==Permision.CLIENT || permissions==Permision.TECHNICIAN) {
        	cards.addTab(myData, new Info(this.getDataBase().select_info(permissions)));
        }
    }
    public static void main(String[] args) {
        Permision p = Permision.TECHNICIAN;
        p.setId(4);
        new mainFrame(p);
    }
}
