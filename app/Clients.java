package app;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

public class Clients extends JPanel implements ActionListener{
	
	JButton add;
	JButton del;
	JList lista;
	
	
	Clients(){
		setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
		add = new JButton("Dodaj");
		del = new JButton("Usuń");
	}
	
	Clients(String[] lista){
		setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
		add = new JButton("Dodaj");
		del = new JButton("Usuń");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==add) {
			//new AddClient();
		}
		else if(e.getSource()==del) {
			
		}
	}
	
	

}
