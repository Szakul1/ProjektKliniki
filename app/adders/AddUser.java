package adders;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.mainFrame;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;

public class AddUser extends JFrame implements ActionListener{
JPanel pnPanel0;
JLabel lbLabel0;
JLabel lbLabel3;
JLabel lbLabel4;
JLabel lbLabel5;
JLabel lbLabel6;
JTextField tfText0;
JTextField tfText1;
JComboBox cmbCombo0;
JTextField tfText2;
JButton btBut0;
mainFrame frame;

public AddUser(mainFrame frame){
	this.frame = frame;
	pnPanel0 = new JPanel();
	GridBagLayout gbPanel0 = new GridBagLayout();
	GridBagConstraints gbcPanel0 = new GridBagConstraints();
	setLayout( gbPanel0 );

	lbLabel0 = new JLabel( "Dodaj uzytkownika"  );
	gbcPanel0.gridx = 1;
	gbcPanel0.gridy = 0;
	gbcPanel0.gridwidth = 2;
	gbcPanel0.gridheight = 1;
	gbcPanel0.fill = GridBagConstraints.BOTH;
	gbcPanel0.weightx = 1;
	gbcPanel0.weighty = 1;
	gbcPanel0.anchor = GridBagConstraints.NORTH;
	gbPanel0.setConstraints( lbLabel0, gbcPanel0 );
	add( lbLabel0 );

	lbLabel3 = new JLabel( "login"  );
	gbcPanel0.gridx = 0;
	gbcPanel0.gridy = 1;
	gbcPanel0.gridwidth = 2;
	gbcPanel0.gridheight = 1;
	gbcPanel0.fill = GridBagConstraints.BOTH;
	gbcPanel0.weightx = 1;
	gbcPanel0.weighty = 1;
	gbcPanel0.anchor = GridBagConstraints.NORTH;
	gbPanel0.setConstraints( lbLabel3, gbcPanel0 );
	add( lbLabel3 );

	lbLabel4 = new JLabel( "haslo"  );
	gbcPanel0.gridx = 0;
	gbcPanel0.gridy = 2;
	gbcPanel0.gridwidth = 2;
	gbcPanel0.gridheight = 1;
	gbcPanel0.fill = GridBagConstraints.BOTH;
	gbcPanel0.weightx = 1;
	gbcPanel0.weighty = 1;
	gbcPanel0.anchor = GridBagConstraints.NORTH;
	gbPanel0.setConstraints( lbLabel4, gbcPanel0 );
	add( lbLabel4 );

	lbLabel5 = new JLabel( "uprawnienia"  );
	gbcPanel0.gridx = 0;
	gbcPanel0.gridy = 3;
	gbcPanel0.gridwidth = 2;
	gbcPanel0.gridheight = 1;
	gbcPanel0.fill = GridBagConstraints.BOTH;
	gbcPanel0.weightx = 1;
	gbcPanel0.weighty = 1;
	gbcPanel0.anchor = GridBagConstraints.NORTH;
	gbPanel0.setConstraints( lbLabel5, gbcPanel0 );
	add( lbLabel5 );

	lbLabel6 = new JLabel( "id"  );
	gbcPanel0.gridx = 0;
	gbcPanel0.gridy = 4;
	gbcPanel0.gridwidth = 2;
	gbcPanel0.gridheight = 1;
	gbcPanel0.fill = GridBagConstraints.BOTH;
	gbcPanel0.weightx = 1;
	gbcPanel0.weighty = 1;
	gbcPanel0.anchor = GridBagConstraints.NORTH;
	gbPanel0.setConstraints( lbLabel6, gbcPanel0 );
	add( lbLabel6 );

	tfText0 = new JTextField( );
	gbcPanel0.gridx = 2;
	gbcPanel0.gridy = 1;
	gbcPanel0.gridwidth = 1;
	gbcPanel0.gridheight = 1;
	gbcPanel0.fill = GridBagConstraints.BOTH;
	gbcPanel0.weightx = 1;
	gbcPanel0.weighty = 0;
	gbcPanel0.anchor = GridBagConstraints.NORTH;
	gbPanel0.setConstraints( tfText0, gbcPanel0 );
	add( tfText0 );

	tfText1 = new JTextField( );
	gbcPanel0.gridx = 2;
	gbcPanel0.gridy = 2;
	gbcPanel0.gridwidth = 1;
	gbcPanel0.gridheight = 1;
	gbcPanel0.fill = GridBagConstraints.BOTH;
	gbcPanel0.weightx = 1;
	gbcPanel0.weighty = 0;
	gbcPanel0.anchor = GridBagConstraints.NORTH;
	gbPanel0.setConstraints( tfText1, gbcPanel0 );
	add( tfText1 );

	String []dataCombo0 = {"klient","weterynarz","technik"};
	cmbCombo0 = new JComboBox( dataCombo0 );
	gbcPanel0.gridx = 2;
	gbcPanel0.gridy = 3;
	gbcPanel0.gridwidth = 1;
	gbcPanel0.gridheight = 1;
	gbcPanel0.fill = GridBagConstraints.BOTH;
	gbcPanel0.weightx = 1;
	gbcPanel0.weighty = 0;
	gbcPanel0.anchor = GridBagConstraints.NORTH;
	gbPanel0.setConstraints( cmbCombo0, gbcPanel0 );
	add( cmbCombo0 );
	
	tfText2 = new JTextField( );
	gbcPanel0.gridx = 2;
	gbcPanel0.gridy = 4;
	gbcPanel0.gridwidth = 1;
	gbcPanel0.gridheight = 1;
	gbcPanel0.fill = GridBagConstraints.BOTH;
	gbcPanel0.weightx = 1;
	gbcPanel0.weighty = 0;
	gbcPanel0.anchor = GridBagConstraints.NORTH;
	gbPanel0.setConstraints( tfText2, gbcPanel0 );
	add( tfText2 );

	btBut0 = new JButton( "Dodaj"  );
	gbcPanel0.gridx = 1;
	gbcPanel0.gridy = 5;
	gbcPanel0.gridwidth = 2;
	gbcPanel0.gridheight = 1;
	gbcPanel0.fill = GridBagConstraints.BOTH;
	gbcPanel0.weightx = 1;
	gbcPanel0.weighty = 0;
	gbcPanel0.anchor = GridBagConstraints.NORTH;
	gbPanel0.setConstraints( btBut0, gbcPanel0 );
	add( btBut0 );
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource().equals(btBut0)) {
		boolean puste = false;
		String s0 = tfText0.getText();
		if(s0.equals("")) {
			puste = true;
		}
		String s1 = tfText1.getText();
		if(s1.equals("")) {
			puste = true;
		}
		String s2 = tfText2.getText();
		if(s2.equals("")) {
			puste = true;
		}
		String s3 = cmbCombo0.getSelectedItem().toString();
		if(s3.equals("")) {
			puste = true;
		}
		if(puste==true) {
			puste = false;
			JOptionPane.showMessageDialog(this, "Wypelnij wszystkie pola");
		}
		else {
			ArrayList<String> values = new ArrayList();
			values.add(s0);
			values.add(s1);
			values.add(s3);
			values.add(s2);
			
			
			String[] wyniki = (String[]) values.toArray();
			
			frame.getDataBase().insert("uzytkownicy",wyniki);
		}
		
	}
}
}