package app.adders;
import app.*;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddService extends JFrame implements ActionListener{
	private mainFrame frame;
	private Container c; 
    private JLabel title; 
    private JLabel name; 
    private JTextField tname; 
    private JLabel price; 
    private JTextField tprice;
    private JLabel occupation; 
    private JTextField toccupation; 
    private JCheckBox vet;
    private JCheckBox ass;
    private JLabel add; 
    private JTextArea tadd; 
    private JCheckBox term; 
    private JButton sub; 
    private JButton reset; 
    private JTextArea tout; 
    private JLabel res; 
    private JTextArea resadd;
    private String whattype;
    
    
    
    // constructor, to initialize the components 
    // with default values. 
    //mainFrame frame
    public AddService() 
    {
    	//this.frame = frame;
        setTitle("Formularz rejestracji"); 
        setBounds(300, 90, 400, 500); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Dodaj usluge"); 
        title.setFont(new Font("Arial", Font.PLAIN, 20)); 
        title.setSize(200, 30); 
        title.setLocation(100, 30); 
        c.add(title); 
  
        name = new JLabel("Nazwa"); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(100, 20); 
        name.setLocation(100, 100); 
        c.add(name); 
  
        tname = new JTextField(); 
        tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname.setSize(100, 20); 
        tname.setLocation(200, 100); 
        c.add(tname); 
        
        price = new JLabel("Cena"); 
        price.setFont(new Font("Arial", Font.PLAIN, 20)); 
        price.setSize(100, 20); 
        price.setLocation(100, 150); 
        c.add(price); 
  
        tprice = new JTextField(); 
        tprice.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tprice.setSize(100, 20); 
        tprice.setLocation(200, 150); 
        c.add(tprice); 
  
        occupation = new JLabel("Zawod"); 
        occupation.setFont(new Font("Arial", Font.PLAIN, 20)); 
        occupation.setSize(100, 20); 
        occupation.setLocation(100, 200); 
        c.add(occupation); 
  
        vet = new JCheckBox("weterynarz");
        vet.setFont(new Font("Arial", Font.PLAIN, 20)); 
        vet.setSize(150, 20); 
        vet.setLocation(100, 250); 
        c.add(vet);
        
        ass = new JCheckBox("technik");
        ass.setFont(new Font("Arial", Font.PLAIN, 20)); 
        ass.setSize(150, 20); 
        ass.setLocation(100, 300); 
        c.add(ass);
  
        
        
        /*
       
		*/
  
  
        sub = new JButton("Dodaj"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(100, 20); 
        sub.setLocation(50, 400); 
        sub.addActionListener(this); 
        c.add(sub); 
  
        reset = new JButton("Wyczysc"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(200, 400); 
        reset.addActionListener(this); 
        c.add(reset); 
  
        res = new JLabel(""); 
        res.setFont(new Font("Arial", Font.PLAIN, 20)); 
        res.setSize(500, 25); 
        res.setLocation(100, 500); 
        c.add(res); 
        
        setVisible(true); 
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean puste = false;
		String occup = null;
		if(e.getSource()==add) {
			String names = tname.getText();
			if(names.equals("")) {
				puste = true;
			}
			String prices = tprice.getText();
			if(prices.equals("")) {
				puste = true;
			}
			if(!vet.isSelected() && !ass.isSelected()) {
				puste = true;
			}
			else if(ass.isSelected()) {
				occup = "Technik";
			}
			else {
				occup = "Weterynarz";
			}
			
		
			
			//jaki format to ma miec
			if(puste==true) {
				puste = false;
				JOptionPane.showMessageDialog(this, "Wypelnij wszystkie pola");
			}
			else {
				ArrayList<String> values = new ArrayList();
				values.add(names);
				values.add(prices);
				values.add(occup);
				
				
				String[] wyniki = (String[]) values.toArray();
				
				frame.getDataBase().insert("uslugi",wyniki);
			}
		}
		
	}
	
	public static void main(String[] args) {
		new AddService();
	}
}
