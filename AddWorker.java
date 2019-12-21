
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddWorker extends JFrame implements ActionListener{
	private Container c; 
    private JLabel title; 
    private JLabel name; 
    private JTextField tname; 
    private JLabel surname; 
    private JTextField tsurname;
    private JLabel mno; 
    private JTextField tmno; 
    private JLabel gender; 
    private JRadioButton male; 
    private JRadioButton female; 
    private ButtonGroup gengp; 
    private JLabel dob; 
    private JComboBox date; 
    private JComboBox month; 
    private JComboBox year;
    private JLabel salary;
    private JTextField tsalary;
    private JLabel occupation;
    private String[] jobs;
    private JComboBox coccupation;
    private JLabel add; 
    private JTextArea tadd; 
    private JCheckBox term; 
    private JButton sub; 
    private JButton reset; 
    private JTextArea tout; 
    private JLabel res; 
    private JTextArea resadd; 
  
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
  
    // constructor, to initialize the components 
    // with default values. 
    public AddWorker() 
    { 
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
  
        name = new JLabel("Imiê"); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(100, 20); 
        name.setLocation(100, 100); 
        c.add(name); 
  
        tname = new JTextField(); 
        tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname.setSize(100, 20); 
        tname.setLocation(200, 100); 
        c.add(tname); 
        
        surname = new JLabel("Nazwisko"); 
        surname.setFont(new Font("Arial", Font.PLAIN, 20)); 
        surname.setSize(100, 20); 
        surname.setLocation(100, 150); 
        c.add(surname); 
  
        tsurname = new JTextField(); 
        tsurname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tsurname.setSize(100, 20); 
        tsurname.setLocation(200, 150); 
        c.add(tsurname); 
  
        mno = new JLabel("Numer tel"); 
        mno.setFont(new Font("Arial", Font.PLAIN, 20)); 
        mno.setSize(100, 20); 
        mno.setLocation(100, 200); 
        c.add(mno); 
  
        tmno = new JTextField();
        tmno.setText("+48 ");
        tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tmno.setSize(140, 20); 
        tmno.setLocation(200, 200); 
        c.add(tmno); 
  
        gender = new JLabel("P³eæ"); 
        gender.setFont(new Font("Arial", Font.PLAIN, 20)); 
        gender.setSize(100, 20); 
        gender.setLocation(100, 250); 
        c.add(gender); 
  
        male = new JRadioButton("Mê¿czyzna"); 
        male.setFont(new Font("Arial", Font.PLAIN, 15)); 
        male.setSelected(false); 
        male.setSize(120, 20); 
        male.setLocation(200, 250); 
        c.add(male); 
  
        female = new JRadioButton("Kobieta"); 
        female.setFont(new Font("Arial", Font.PLAIN, 15)); 
        female.setSelected(false); 
        female.setSize(100, 20); 
        female.setLocation(320, 250); 
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
        year.setLocation(310, 300); 
        c.add(year); 
        
        salary = new JLabel("Pensja"); 
        salary.setFont(new Font("Arial", Font.PLAIN, 20)); 
        salary.setSize(100, 20); 
        salary.setLocation(100, 350); 
        c.add(salary);
  
        tsalary = new JTextField(); 
        tsalary.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tsalary.setSize(50, 20); 
        tsalary.setLocation(200, 350); 
        c.add(tsalary);
        
        occupation = new JLabel("Zawód"); 
        occupation.setFont(new Font("Arial", Font.PLAIN, 20)); 
        occupation.setSize(100, 20); 
        occupation.setLocation(100, 400); 
        c.add(occupation);
        
        jobs = new String[] {"weterynarz", "technik"};
        coccupation = new JComboBox(jobs);
        coccupation.setFont(new Font("Arial", Font.PLAIN, 15)); 
        coccupation.setSize(130, 20); 
        coccupation.setLocation(200, 400); 
        c.add(coccupation); 
        
        sub = new JButton("Dodaj"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(100, 20); 
        sub.setLocation(150, 450); 
        sub.addActionListener(this); 
        c.add(sub); 
  
        reset = new JButton("Wyczyœæ"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(270, 450); 
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
		
	}
	
	public static void main(String[] args) {
		new AddWorker();
	}
}
