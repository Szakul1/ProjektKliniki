package app;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Client_card_visits extends JFrame implements ActionListener{
	

	JPanel pnPanel0;

	JPanel pnPanel1;
	JButton btInfo;
	JButton btAdd_visit;

	//to samo dla dodaj wizyte, pracownika,...
	Client_card_visits(String dodaj){
		
		GridBagLayout gbPanel0 = new GridBagLayout();
		GridBagConstraints gbcPanel0 = new GridBagConstraints();
		setLayout( gbPanel0 );

		pnPanel1 = new JPanel();
		GridBagLayout gbPanel1 = new GridBagLayout();
		GridBagConstraints gbcPanel1 = new GridBagConstraints();
		pnPanel1.setLayout( gbPanel1 );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 2;
		gbcPanel0.gridwidth = 20;
		gbcPanel0.gridheight = 18;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( pnPanel1, gbcPanel0 );
		add( pnPanel1 );


		btAdd_visit = new JButton(dodaj);
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 0;
		gbcPanel0.gridwidth = 6;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btAdd_visit, gbcPanel0 );
		add( btAdd_visit );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
