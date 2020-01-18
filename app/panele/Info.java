package app.panele;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Info extends JPanel{
	
	JLabel lbName;
	JLabel lbSurname;
	JLabel lbTelephone;
	JLabel tfTname;
	JLabel tfTsurname;
	JLabel tfTphone;

	JLabel btName;
	JLabel btSurname;
	JLabel btTelephone;
	JLabel btBirtday;
	JLabel btSalary;
	JLabel btOccupation;
	JLabel tfT_name;
	JLabel tfT_surname;
	JLabel tfT_phone;
	JLabel tfT_birth;
	JLabel tfT_salary;
	JLabel tfT_occupation;

	public Info(ArrayList<String> data) {
		
		
	if(data.get(0).equals("klienci")) {
		GridBagLayout gbPanel0 = new GridBagLayout();
		GridBagConstraints gbcPanel0 = new GridBagConstraints();
		setLayout( gbPanel0 );

		lbName = new JLabel( "Imie"  );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 2;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbName, gbcPanel0 );
		add( lbName );

		lbSurname = new JLabel( "Nazwisko"  );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 6;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbSurname, gbcPanel0 );
		add( lbSurname );

		lbTelephone = new JLabel( "Numer tel"  );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 10;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbTelephone, gbcPanel0 );
		add( lbTelephone );

		tfTname = new JLabel(data.get(1));
		gbcPanel0.gridx = 9;
		gbcPanel0.gridy = 2;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfTname, gbcPanel0 );
		add( tfTname );

		tfTsurname = new JLabel(data.get(2));
		gbcPanel0.gridx = 9;
		gbcPanel0.gridy = 6;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfTsurname, gbcPanel0 );
		add( tfTsurname );

		tfTphone = new JLabel(data.get(3));
		gbcPanel0.gridx = 9;
		gbcPanel0.gridy = 10;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfTphone, gbcPanel0 );
		add( tfTphone );
	}
	else {
		//pracownicy
		
		GridBagLayout gbPanel0 = new GridBagLayout();
		GridBagConstraints gbcPanel0 = new GridBagConstraints();
		setLayout( gbPanel0 );

		btName = new JLabel( "Imie"  );
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 1;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btName, gbcPanel0 );
		add( btName );

		btSurname = new JLabel( "Nazwisko"  );
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 4;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btSurname, gbcPanel0 );
		add( btSurname );

		btTelephone = new JLabel( "Numer tel"  );
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 7;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btTelephone, gbcPanel0 );
		add( btTelephone );

		btBirtday = new JLabel( "Data urodzenia"  );
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 10;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBirtday, gbcPanel0 );
		add( btBirtday );
		
		btSalary = new JLabel( "Pensja"  );
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 13;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btSalary, gbcPanel0 );
		add( btSalary );

		btOccupation = new JLabel("Zawod");
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 16;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btOccupation, gbcPanel0 );
		add( btOccupation );
		
		tfT_name = new JLabel(data.get(1));
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 1;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfT_name, gbcPanel0 );
		add( tfT_name );

		tfT_surname = new JLabel(data.get(2));
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 4;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfT_surname, gbcPanel0 );
		add( tfT_surname );

		tfT_phone = new JLabel(data.get(3));
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 7;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfT_phone, gbcPanel0 );
		add( tfT_phone );

		tfT_birth = new JLabel(data.get(4));
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 10;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfT_birth, gbcPanel0 );
		add( tfT_birth );
		
		tfT_salary = new JLabel(data.get(5));
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 13;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfT_salary, gbcPanel0 );
		add( tfT_salary );
		
		tfT_occupation = new JLabel(data.get(6));
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 16;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfT_occupation, gbcPanel0 );
		add( tfT_occupation );
	}
	}

}
