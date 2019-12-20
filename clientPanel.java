import javax.swing.JFrame;

public class clientPanel extends myPanel
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public clientPanel(JFrame frame) 
    {
        super(new String[]{"id","imię","nazwisko","numer_tel","zniżka%"},frame);
    }

    
}