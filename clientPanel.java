package app;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class clientPanel extends JPanel
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    myPanel select;
    public clientPanel(JFrame frame) 
    {
        select = new myPanel(new String[]{"id","imię","nazwisko","numer_tel","zniżka%"},frame);
        add(select);
    }

    
}