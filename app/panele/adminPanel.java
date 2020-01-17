package app.panele;
import app.*;

import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class adminPanel extends JPanel implements ActionListener{
	
	
	JTextArea taArea0;
	JButton btBut0;
	JButton btBut1;
	JButton btBut2;
	mainFrame main;
	GridBagLayout gbPanel0 = new GridBagLayout();
	GridBagConstraints gbcPanel0 = new GridBagConstraints();
	
	public adminPanel(mainFrame main){
		this.main = main;
		setLayout( gbPanel0 );

		GridBagLayout gbPanel0 = new GridBagLayout();
		GridBagConstraints gbcPanel0 = new GridBagConstraints();
		setLayout( gbPanel0 );

		taArea0 = new JTextArea(2,10);
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 1;
		gbcPanel0.gridwidth = 18;
		gbcPanel0.gridheight = 11;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( taArea0, gbcPanel0 );
		add( taArea0 );

		btBut0 = new JButton( "Wykonaj"  );
		btBut0.addActionListener(this);
		gbcPanel0.gridx = 7;
		gbcPanel0.gridy = 13;
		gbcPanel0.gridwidth = 6;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut0, gbcPanel0 );
		add( btBut0 );
		

		btBut1 = new JButton( "Backup"  );
		btBut1.addActionListener(this);
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 16;
		gbcPanel0.gridwidth = 6;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut1, gbcPanel0 );
		add( btBut1 );

		btBut2 = new JButton( "Wczytaj backup"  );
		btBut2.addActionListener(this);
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 16;
		gbcPanel0.gridwidth = 6;
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
				main.getDataBase().call(taArea0.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource().equals(btBut1)) {
			main.getDataBase().backup();
		}
	}
}

