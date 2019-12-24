package app;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Results extends JFrame implements ActionListener, TableModelListener, PropertyChangeListener
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JPanel results;
    JScrollPane scroll;
    JTable jTable;
    JButton confirm;
    JButton delete;
    String[][] table;
    mainFrame frame;
    String tableName;
    DefaultTableModel tableModel;
    String[] rowToUpdate;
    public Results(String[][] table, String[] columns, mainFrame frame, String tableName) {
        this.tableName=tableName;
        this.frame=frame;
        this.table = table;
        delete = new JButton("Usuń");
        confirm = new JButton("Potwierdź");
        confirm.addActionListener(this);
        delete.addActionListener(this);
        results = new JPanel();
        results.setLayout(new FlowLayout(FlowLayout.CENTER));
        results.add(confirm);
        results.add(delete);
        add(results, BorderLayout.NORTH);
        scroll = new JScrollPane();
        tableModel = new DefaultTableModel(table, columns);
        tableModel.addTableModelListener(this);
        jTable = new JTable(tableModel);
        jTable.addPropertyChangeListener(this);

        scroll.setViewportView(jTable);
        add(scroll, BorderLayout.CENTER);

        pack();
        setSize(getWidth(), 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Potwierdź")) 
        {
        }
        if (e.getActionCommand().equals("Usuń")) 
        {
            int[] rows = jTable.getSelectedRows();
            int res=0;
            for(int i=0; i<rows.length; i++)
            {
                String[] data = new String[jTable.getColumnCount()*2];
                for(int j=0,k=0; j<data.length; j++,k++)
                {
                    data[j++] = jTable.getColumnName(k);
                    data[j] =(String) jTable.getValueAt(rows[i], k);
                }
                res+=frame.getDataBase().delete(tableName, data);    
                tableModel.removeRow(rows[i]);
            }
            JOptionPane.showMessageDialog(this, "Usunięto " + res + " wierszy", "Wynik", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        if(jTable.isEditing())
        {
            String value = (String) jTable.getValueAt(jTable.getSelectedRow(), jTable.getSelectedColumn());
            if(frame.getDataBase().update(tableName, rowToUpdate, jTable.getColumnName(jTable.getSelectedColumn()), value)<=0)
                JOptionPane.showMessageDialog(this, "Error", "Błąd", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getSource().equals(jTable))
            if(jTable.isEditing())
            {
                rowToUpdate = new String[jTable.getColumnCount()*2];
                for(int i=0,j=0; i<rowToUpdate.length; i++,j++)
                {
                    rowToUpdate[i++] = jTable.getColumnName(j);
                    rowToUpdate[i] =(String) jTable.getValueAt(jTable.getSelectedRow(), j);
                }
            }

    }

}