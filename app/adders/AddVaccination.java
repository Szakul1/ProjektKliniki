package app;

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
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class AddVaccination extends JFrame implements ActionListener{
	
	mainFrame frame;
	JPanel pnPanel0;
	JLabel lbLabel0;
	JLabel lbLabel1;
	JLabel lbLabel2;
	JLabel lbLabel3;
	JButton btBut0;
	JCheckBox cbBox0;
	JTextField tfText0;
	JTextField tfText2;

	AddVaccination(mainFrame frame){
		this.frame = frame;
		
		GridBagLayout gbPanel0 = new GridBagLayout();
		GridBagConstraints gbcPanel0 = new GridBagConstraints();
		setLayout( gbPanel0 );

		lbLabel0 = new JLabel( "Dodaj szczepienie"  );
		gbcPanel0.gridx = 6;
		gbcPanel0.gridy = 1;
		gbcPanel0.gridwidth = 7;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbLabel0, gbcPanel0 );
		add( lbLabel0 );

		lbLabel1 = new JLabel( "Id zwierzecia"  );
		JScrollPane scpLabel1 = new JScrollPane( lbLabel1 );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 5;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( scpLabel1, gbcPanel0 );
		add( scpLabel1 );

		lbLabel2 = new JLabel( "Choroba"  );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 9;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbLabel2, gbcPanel0 );
		add( lbLabel2 );

		lbLabel3 = new JLabel( "W tej klinice"  );
		JScrollPane scpLabel3 = new JScrollPane( lbLabel3 );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 13;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( scpLabel3, gbcPanel0 );
		add( scpLabel3 );

		btBut0 = new JButton( "Dodaj"  );
		gbcPanel0.gridx = 7;
		gbcPanel0.gridy = 16;
		gbcPanel0.gridwidth = 4;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut0, gbcPanel0 );
		add( btBut0 );

		cbBox0 = new JCheckBox( ""  );
		gbcPanel0.gridx = 9;
		gbcPanel0.gridy = 13;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( cbBox0, gbcPanel0 );
		add( cbBox0 );

		tfText0 = new JTextField( );
		gbcPanel0.gridx = 9;
		gbcPanel0.gridy = 9;
		gbcPanel0.gridwidth = 4;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfText0, gbcPanel0 );
		add( tfText0 );

		tfText2 = new JTextField( );
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 5;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfText2, gbcPanel0 );
		add( tfText2 );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btBut0)) {
			boolean puste = false;
			String id = "";
			String choroba = "";
			if(tfText0.getText().equals("")) {
				puste = true;
			}
			else {
				id = tfText0.getText();
			}
			if(tfText2.getText().equals("")) {
				puste = true;
			}
			else {
				choroba = tfText2.getText();
			}
			if(puste==true) {
				puste = false;
				JOptionPane.showMessageDialog(this, "Wypelnij wszystkie pola");
			}
			else {
				String klinika = "false";
				if(cbBox0.isSelected()) {
					klinika = "true";
				}
				ArrayList<String> values = new ArrayList<String>();
				values.add(id);
				values.add(choroba);
				values.add(klinika);
			
				String[] wyniki = (String[]) values.toArray();
				frame.getDataBase().insert("szczepienia",wyniki);
			}
	}
		
	}
}
