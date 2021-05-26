package app.adders;
import app.*;

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
	JLabel lbLabel3;
	JLabel lbLabel4;
	JLabel lbLabel5;
	JTextField tfText0;
	JTextField tfText1;
	JButton btBut0;
	JCheckBox cbBox0;


	public AddVaccination(mainFrame frame){
		setTitle("Dodaj szczepienie"); 
        //setBounds(300, 90, 200, 300); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); 
		this.frame = frame;
		
		
		GridBagLayout gbPanel0 = new GridBagLayout();
		GridBagConstraints gbcPanel0 = new GridBagConstraints();
		setLayout( gbPanel0 );

		lbLabel0 = new JLabel( "Dodaj szczepienie"  );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 0;
		gbcPanel0.gridwidth = 3;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbLabel0, gbcPanel0 );
		add( lbLabel0 );

		lbLabel3 = new JLabel( "id zwierzaka"  );
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

		lbLabel4 = new JLabel( "choroba"  );
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

		lbLabel5 = new JLabel( "w tej klinice"  );
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

		btBut0 = new JButton( "Dodaj"  );
		btBut0.addActionListener(this);
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 4;
		gbcPanel0.gridwidth = 3;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut0, gbcPanel0 );
		add( btBut0 );

		cbBox0 = new JCheckBox( ""  );
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 3;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( cbBox0, gbcPanel0 );
		add( cbBox0 );

		pack();
		setVisible(true); 
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
			if(tfText1.getText().equals("")) {
				puste = true;
			}
			else {
				choroba = tfText1.getText();
			}
			if(puste==true) {
				puste = false;
				JOptionPane.showMessageDialog(this, "Wypelnij wszystkie pola");
			}
			else {
				String klinika = "0";
				if(cbBox0.isSelected()) {
					klinika = "1";
				}
				ArrayList<String> values = new ArrayList<String>();
				values.add(id);
				values.add(choroba);
				values.add(klinika);
			
				String[] wyniki = values.toArray(new String[values.size()]);
				frame.getDataBase().insert("szczepienia",wyniki);
			}
	}
		
	}
}
