package adders;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.mainFrame;

public class AddGrafic extends JFrame implements ActionListener{
	
	mainFrame frame;
	JPanel pnPanel0;
	JLabel id;
	JLabel btBut0;
	JLabel btBut1;
	JLabel btBut2;
	JLabel btBut3;
	JButton btBut4;
	JLabel btBut5;
	JLabel btBut6;
	JTextField tfText0;
	JTextField tfText1;
	JTextField tfText2;
	JTextField tfText3;
	JTextField tfText4;
	JTextField tfText5;

	public AddGrafic(mainFrame frame) {
		this.frame = frame;
		GridBagLayout gbPanel0 = new GridBagLayout();
		GridBagConstraints gbcPanel0 = new GridBagConstraints();
		setLayout( gbPanel0 );
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        setResizable(false); 

		btBut0 = new JLabel( "Dodaj Grafik"  );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 0;
		gbcPanel0.gridwidth = 2;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut0, gbcPanel0 );
		add( btBut0 );
	
		id = new JLabel( "id"  );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 1;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( id, gbcPanel0 );
		add( id );
		
		btBut1 = new JLabel( "pon"  );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 2;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut1, gbcPanel0 );
		add( btBut1 );
	
		btBut2 = new JLabel( "wt"  );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 3;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut2, gbcPanel0 );
		add( btBut2 );

		btBut3 = new JLabel( "sr"  );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 4;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut3, gbcPanel0 );
		add( btBut3 );

		tfText0 = new JTextField( );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 2;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfText0, gbcPanel0 );
		add( tfText0 );

		tfText1 = new JTextField( );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 3;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfText1, gbcPanel0 );
		add( tfText1 );
		
		tfText2 = new JTextField( );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 4;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfText1, gbcPanel0 );
		add( tfText1 );
		
		tfText3 = new JTextField( );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 5;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfText1, gbcPanel0 );
		add( tfText1 );
		
		tfText4 = new JTextField( );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 6;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfText1, gbcPanel0 );
		add( tfText1 );
		
		tfText5 = new JTextField( );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 1;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfText5, gbcPanel0 );
		add( tfText5 );
	
		btBut4 = new JButton( "Dodaj"  );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 7;
		gbcPanel0.gridwidth = 2;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut4, gbcPanel0 );
		add( btBut4 );

		btBut5 = new JLabel( "czw"  );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 5;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut5, gbcPanel0 );
		add( btBut5 );

		btBut6 = new JLabel( "pt"  );
		gbcPanel0.gridx = 0;
		gbcPanel0.gridy = 6;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut6, gbcPanel0 );
		add( btBut6 );

		}
	
	String[] parsing(String input) {
		String[] h = input.split("/");
		String[] result = new String[2];
		result[0] = h[0] + ":00";
		result[1] = h[1] + ":00";
		return result;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id;
		String pn;
		String wt;
		String sr;
		String czw;
		String pt;
		if(e.getSource().equals(btBut4)) {
			boolean puste = false;
			id = tfText5.getText();
			if(id.equals("")) {
				puste = true;
			}
			pn = tfText0.getText();
			wt = tfText1.getText();
			sr = tfText2.getText();
			czw = tfText3.getText();
			pt = tfText4.getText();
			
			if(puste==true) {
				puste = false;
				JOptionPane.showMessageDialog(this, "Wypelnij pole id");
			}
			else {
				ArrayList<String> values = new ArrayList();
			
				if(!pn.equals("")) {
					values.add(id);
					values.add("poniedzialek");
					String[] hours = parsing(pn);
					values.add(hours[0]);
					values.add(hours[1]);
					String[] wyniki = values.toArray(new String[values.size()]);
					frame.getDataBase().insert("grafik",wyniki);
				}
				
				if(!wt.equals("")) {
					values.add(id);
					values.add("wtorek");
					String[] hours = parsing(wt);
					values.add(hours[0]);
					values.add(hours[1]);
					String[] wyniki = values.toArray(new String[values.size()]);
					frame.getDataBase().insert("grafik",wyniki);
				}
				
				if(!sr.equals("")) {
					values.add(id);
					values.add("sroda");
					String[] hours = parsing(sr);
					values.add(hours[0]);
					values.add(hours[1]);
					String[] wyniki = values.toArray(new String[values.size()]);
					frame.getDataBase().insert("grafik",wyniki);
				}
				
				if(!czw.equals("")) {
					values.add(id);
					values.add("czwartek");
					String[] hours = parsing(czw);
					values.add(hours[0]);
					values.add(hours[1]);
					String[] wyniki = values.toArray(new String[values.size()]);
					frame.getDataBase().insert("grafik",wyniki);
				}
				
				if(!pt.equals("")) {
					values.add(id);
					values.add("piatek");
					String[] hours = parsing(pt);
					values.add(hours[0]);
					values.add(hours[1]);
					String[] wyniki = values.toArray(new String[values.size()]);
					frame.getDataBase().insert("grafik",wyniki);
				}
				
			}
		}
	}
}
