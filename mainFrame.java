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

    public mainFrame(String permissions)
    {
        myDataJButton = new JButton(myData);
        cards = new JTabbedPane();
        addCards(permissions);

        setLayout(new BorderLayout());
        add(cards, BorderLayout.NORTH);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addCards(String permissions)
    {
        switch (permissions) {
            case "admin":
            cards.addTab(admin, null);
                
            case "dyrektor":
                cards.addTab(employees,null);

            case "wterynarz":
                cards.addTab(clients, new clientPanel(this));
                
            case "technik":
                cards.addTab(vaccinations, new clientPanel(this));

            case "klient":
                cards.addTab(services, null);
                cards.addTab(visits, null);
                cards.addTab(animals, null);
                cards.addTab(grafic, null);
                cards.add(myDataJButton);

            default:
                break;
        }
    }
}