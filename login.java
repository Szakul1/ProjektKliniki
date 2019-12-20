import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame implements ActionListener
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JLabel login;
    JLabel password;
    JTextField loginField;
    JPasswordField passwordField;
    JButton loginButton;
    JPanel help;
    public login()
    {
        login = new JLabel("Login: ");
        password = new JLabel("Hasło: ");
        loginField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        
        addPanel(login, loginField);
        addPanel(password, passwordField);
        
        help = new JPanel();
        help.setLayout(new FlowLayout(FlowLayout.CENTER));
        help.add(loginButton);
        add(help);
        
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    private void addPanel(Component comp1, Component comp2)
    {
        help = new JPanel();
        help.setLayout(new FlowLayout(FlowLayout.CENTER));
        help.add(comp1);
        help.add(comp2);
        add(help);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Login"))
        {
            new mainFrame(loginField.getText());
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new login();
    }
}