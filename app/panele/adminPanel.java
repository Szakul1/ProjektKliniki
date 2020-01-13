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
	JButton btSearch;
	JTextArea taT_search;
	mainFrame main;
	GridBagLayout gbPanel0 = new GridBagLayout();
	GridBagConstraints gbcPanel0 = new GridBagConstraints();
	
	adminPanel(mainFrame main){
		this.main = main;
		setLayout( gbPanel0 );

		btSearch = new JButton( "Wykonaj"  );
		gbcPanel0.gridx = 14;
		gbcPanel0.gridy = 8;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 3;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btSearch, gbcPanel0 );
		add( btSearch );

		taT_search = new JTextArea(2,10);
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 5;
		gbcPanel0.gridwidth = 10;
		gbcPanel0.gridheight = 10;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( taT_search, gbcPanel0 );
		add( taT_search );

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btSearch)) {
			try {
				main.getDataBase().call(taT_search.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
