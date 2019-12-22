package app;

import javax.swing.JPanel;

public class clientPanel extends JPanel
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    myPanel select;
    public clientPanel(mainFrame frame) 
    {
        select = new myPanel("klienci",new String[]{"id","imię","nazwisko","numer_tel","zniżka%"},frame);
        add(select);
    }

    
}