package app;

import javax.swing.*;


public class Results extends JFrame 
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JPanel results;
    JScrollPane scroll;
    public Results(String[] table)
    {
        scroll = new JScrollPane();
        results = new JPanel();
        results.setLayout(new BoxLayout(results, BoxLayout.Y_AXIS));
        
        for(int i=0; i<table.length; i++)
            results.add(new JLabel(table[i]));
        
        scroll.setViewportView(results);
        add(scroll);

        pack();
        setSize(getWidth(),400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

    }
    
    public static void main(String[] args)
    {
        //new Results();
    }

}