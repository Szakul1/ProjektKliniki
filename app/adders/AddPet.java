package app.adders;
import app.*;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class AddPet extends JFrame implements ActionListener{
	private mainFrame frame;
	private Container c; 
    private JLabel title; 
    private JLabel name; 
    private JTextField tname; 
    private JLabel species; 
    private JTextField tspecies;
    private JLabel weight; 
    private JTextField tweight; 
    private JLabel gender; 
    private JRadioButton male; 
    private JRadioButton female; 
    private ButtonGroup gengp; 
    private JLabel dob; 
    private JComboBox date; 
    private JComboBox month; 
    private JComboBox year;
    private JLabel tpet;
    private JComboBox pettype;
    private JLabel des;
    private JLabel coun;
    private JTextField destiny;
    private JTextField country;
    private JCheckBox checkBox;
    private JLabel add; 
    private JTextArea tadd; 
    private JCheckBox term; 
    private JButton sub; 
    private JButton reset; 
    private JTextArea tout; 
    private JLabel res; 
    private JTextArea resadd;
    private String whattype;
  
    private String dates[] 
        = { "1", "2", "3", "4", "5", 
            "6", "7", "8", "9", "10", 
            "11", "12", "13", "14", "15", 
            "16", "17", "18", "19", "20", 
            "21", "22", "23", "24", "25", 
            "26", "27", "28", "29", "30", 
            "31" }; 
    private String months[] 
        = { "Sty", "Lut", "Mar", "Kwi", 
            "Maj", "Cze", "Lip", "Sie", 
            "Wrz", "Paz", "Lis", "Gru" }; 
    private String years[] 
        = {"1940", "1941", "1942", "1943", 
           "1944", "1945", "1946", "1947",
           "1948", "1949", "1950", "1951",
           "1952", "1953", "1954", "1955",
           "1956", "1957", "1958", "1959",
           "1960", "1961", "1962", "1963",
           "1964", "1965", "1966", "1967",
           "1968", "1969", "1970", "1971",
           "1972", "1973", "1974", "1975",
           "1976", "1977", "1978", "1979",
           "1980", "1981", "1982", "1983",
           "1984", "1985", "1986", "1987",
           "1988", "1989", "1990", "1991",
           "1992", "1993", "1994", "1995",
           "1996", "1997", "1998", "1999",
           "2000", "2001", "2002"}; 
    
    private String types[]
    	= {"hodowlane","domowe","egzotyczne"};
    
    
    public void adds(String s) {
    	switch(s) {
    		case "hodowlane":
    			whattype = "h";
    			destiny = new JTextField();
    			destiny.setFont(new Font("Arial", Font.PLAIN, 15)); 
    			destiny.setSize(100, 20); 
    			destiny.setLocation(300, 350); 
    	        c.add(destiny); 
    			break;
    		case "domowe":
    			whattype = "d";
    			checkBox = new JCheckBox("Kastrowane"); 
    		    checkBox.setFont(new Font("Arial", Font.PLAIN, 20)); 
    		    checkBox.setSize(70,20); 
    		    checkBox.setLocation(300, 350); 
    		    c.add(checkBox); 
    			break;
    		case "egzotyczne":
    			whattype = "e";
    			country = new JTextField();
    			country.setFont(new Font("Arial", Font.PLAIN, 15)); 
    			country.setSize(100, 20); 
    			country.setLocation(300, 350); 
    			c.add(country);
    			break;
    	}
    }
    // constructor, to initialize the components 
    // with default values. 
    public AddPet(mainFrame frame) 
    {
    	this.frame = frame;
        setTitle("Formularz rejestracji"); 
        setBounds(300, 90, 900, 600); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Formularz rejestracji"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(300, 30); 
        c.add(title); 
  
        name = new JLabel("Imi�"); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(100, 20); 
        name.setLocation(100, 100); 
        c.add(name); 
  
        tname = new JTextField(); 
        tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname.setSize(100, 20); 
        tname.setLocation(200, 100); 
        c.add(tname); 
        
        species = new JLabel("Gatunek"); 
        species.setFont(new Font("Arial", Font.PLAIN, 20)); 
        species.setSize(100, 20); 
        species.setLocation(100, 150); 
        c.add(species); 
  
        tspecies = new JTextField(); 
        tspecies.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tspecies.setSize(100, 20); 
        tspecies.setLocation(200, 150); 
        c.add(tspecies); 
  
        weight = new JLabel("Waga"); 
        weight.setFont(new Font("Arial", Font.PLAIN, 20)); 
        weight.setSize(100, 20); 
        weight.setLocation(100, 200); 
        c.add(weight); 
  
        tweight = new JTextField();
        tweight.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tweight.setSize(50, 20); 
        tweight.setLocation(200, 200); 
        c.add(tweight); 
  
        gender = new JLabel("Płeć"); 
        gender.setFont(new Font("Arial", Font.PLAIN, 20)); 
        gender.setSize(100, 20); 
        gender.setLocation(100, 250); 
        c.add(gender); 
  
        male = new JRadioButton("Samiec"); 
        male.setFont(new Font("Arial", Font.PLAIN, 15)); 
        male.setSelected(true); 
        male.setSize(100, 20); 
        male.setLocation(200, 250); 
        c.add(male); 
  
        female = new JRadioButton("Samica"); 
        female.setFont(new Font("Arial", Font.PLAIN, 15)); 
        female.setSelected(false); 
        female.setSize(100, 20); 
        female.setLocation(300, 250); 
        c.add(female); 
  
        gengp = new ButtonGroup(); 
        gengp.add(male); 
        gengp.add(female); 
  
        dob = new JLabel("Data Urodzenia"); 
        dob.setFont(new Font("Arial", Font.PLAIN, 20)); 
        dob.setSize(100, 20); 
        dob.setLocation(100, 300); 
        c.add(dob); 
  
        date = new JComboBox(dates); 
        date.setFont(new Font("Arial", Font.PLAIN, 15)); 
        date.setSize(50, 20); 
        date.setLocation(200, 300); 
        c.add(date); 
  
        month = new JComboBox(months); 
        month.setFont(new Font("Arial", Font.PLAIN, 15)); 
        month.setSize(60, 20); 
        month.setLocation(250, 300); 
        c.add(month); 
  
        year = new JComboBox(years); 
        year.setFont(new Font("Arial", Font.PLAIN, 15)); 
        year.setSize(60, 20); 
        year.setLocation(320, 300); 
        c.add(year); 
        
        tpet = new JLabel("typ");
        tpet.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tpet.setSize(40,20);
        tpet.setLocation(100,350);
        c.add(tpet);
       
        pettype = new JComboBox(types);
        pettype.setSelectedIndex(0);
        pettype.setFont(new Font("Arial", Font.PLAIN, 15));
        pettype.setSize(80,20);
        pettype.setLocation(200,350);
        pettype.addActionListener(this);
        c.add(pettype);
        
        /*
       
		*/
  
  
        sub = new JButton("Dodaj"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(100, 20); 
        sub.setLocation(150, 400); 
        sub.addActionListener(this); 
        c.add(sub); 
  
        reset = new JButton("Wyczyść"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(270, 400); 
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
		if(e.getSource()==pettype) {
			String s = (String) pettype.getSelectedItem();
			adds(s);
		}
		else if(e.getSource()==add) {
			String name = tname.getText();
			if(name.equals("")) {
				puste = true;
			}
			String species = tspecies.getText();
			if(species.equals("")) {
				puste = true;
			}
			String weight = tweight.getText();
			if(weight.equals("")) {
				puste = true;
			}
			String sex;
			if(male.isSelected()) {
				sex = "m";
			}
			else if(female.isSelected()) {
				sex = "f";
			}
			else {
				sex = "";
			}
			if(sex.equals("")) {
				puste = true;
			}
			String sday = date.getSelectedItem().toString();
			if(sday.equals("")) {
				puste = true;
			}
			String smonth = month.getSelectedItem().toString();
			if(smonth.equals("")) {
				puste = true;
			}
			String syear = year.getSelectedItem().toString();
			if(syear.equals("")) {
				puste = true;
			}
			
			String typo = "";
			
			switch(whattype) {
				case "h":
					typo = destiny.getText();
					if(typo.equals("")) {
						puste = true;
					}
					break;
				case "d":
					if(checkBox.isSelected()) {
						typo = "True";
					}
					else {
						typo = "False";
					}
					break;
				case "e":
					typo = country.getText();
					if(typo.equals("")) {
						puste = true;
					}
					break;
			}
			//jaki format to ma miec
			if(puste==true) {
				puste = false;
				JOptionPane.showMessageDialog(this, "Wypelnij wszystkie pola");
			}
			else {
				String birthday = sday + smonth + syear;
				ArrayList<String> values = new ArrayList();
				values.add(name);
				values.add(species);
				values.add(weight);
				values.add(sex);
				values.add(birthday);
				values.add(typo);
				
				
				String[] wyniki = (String[]) values.toArray();
				
				frame.getDataBase().insert("zwierzeta",wyniki);
			}
		}
		
	}
	
	public static void main(String[] args) {
		//new AddPet();
	}
}
