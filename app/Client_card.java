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

public class Client_card extends JFrame{

	myPanel pnPanel1;
	JButton btB_info;

	
	//zaleznie od karty do ktorej dodaje zeby zmienialy sie uprawnienia
	Client_card(){
		super();
		GridBagLayout gbPanel0 = new GridBagLayout();
		GridBagConstraints gbcPanel0 = new GridBagConstraints();
		setLayout( gbPanel0 );
	
		pnPanel1 = new myPanel();
		GridBagLayout gbPanel1 = new GridBagLayout();
		GridBagConstraints gbcPanel1 = new GridBagConstraints();

		pnPanel1.setLayout( gbPanel1 );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 1;
		gbcPanel0.gridwidth = 20;
		gbcPanel0.gridheight = 19;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( pnPanel1, gbcPanel0 );
		add( pnPanel1 );
	
}
	

}
