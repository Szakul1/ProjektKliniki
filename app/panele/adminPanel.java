package app;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class adminPanel extends JPanel implements ActionListener{
	
	JPanel pnPanel0;
	JTextField tfText0;
	JButton btBut0;
	JButton btBut1;
	JButton btBut2;
	mainFrame main;
	GridBagLayout gbPanel0 = new GridBagLayout();
	GridBagConstraints gbcPanel0 = new GridBagConstraints();
	
	adminPanel(mainFrame main){
		this.main = main;

		pnPanel0 = new JPanel();
		GridBagLayout gbPanel0 = new GridBagLayout();
		GridBagConstraints gbcPanel0 = new GridBagConstraints();
		setLayout( gbPanel0 );

		tfText0 = new JTextField( );
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 2;
		gbcPanel0.gridwidth = 15;
		gbcPanel0.gridheight = 7;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfText0, gbcPanel0 );
		add( tfText0 );

		btBut0 = new JButton( "Wykonaj"  );
		gbcPanel0.gridx = 6;
		gbcPanel0.gridy = 10;
		gbcPanel0.gridwidth = 6;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut0, gbcPanel0 );
		add( btBut0 );

		btBut1 = new JButton( "Utworz backup"  );
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 14;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut1, gbcPanel0 );
		add( btBut1 );

		btBut2 = new JButton( "Wczytaj backup"  );
		gbcPanel0.gridx = 11;
		gbcPanel0.gridy = 14;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut2, gbcPanel0 );
		add( btBut2 );

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btBut0)) {
			try {
				main.getDataBase().call(tfText0.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource().equals(btBut1)) {
			
		}
		else if(e.getSource().equals(btBut2)) {
			
		}
	}
}
