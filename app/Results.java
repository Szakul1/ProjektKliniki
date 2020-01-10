package app;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Results extends JFrame implements ActionListener, TableModelListener, PropertyChangeListener, ListSelectionListener
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JPanel results;
    JScrollPane scroll;
    JTable jTable;
    JButton selectAll;
    JButton unSelect;
    JButton delete;
    String[][] table;
    mainFrame frame;
    String tableName;
    DefaultTableModel tableModel;
    String[] rowToUpdate;
    String[] columns;
    public Results(String[][] table, String[] columns, mainFrame frame, String tableName, Function fun) {
        this.tableName=tableName;
        this.frame=frame;
        this.table = table;
        this.columns = columns;

        delete = new JButton("Usuń");
        selectAll = new JButton("Zaznacz wszystkie");
        unSelect = new JButton("Odznacz wszystkie");
        selectAll.addActionListener(this);
        unSelect.addActionListener(this);
        delete.addActionListener(this);
        results = new JPanel();
        results.setLayout(new FlowLayout(FlowLayout.CENTER));

        scroll = new JScrollPane();
        tableModel = new DefaultTableModel(table, columns);
        tableModel.addTableModelListener(this);
        jTable = new JTable(tableModel);
        jTable.addPropertyChangeListener(this);
        
        scroll.setViewportView(jTable);
        add(scroll, BorderLayout.CENTER);

        creatFunctionality(fun);

        pack();
        setSize(getWidth(), 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    private void creatFunctionality(Function fun)
    {
        switch (fun) {
            case DELETE:
                results.add(selectAll);
                results.add(unSelect);
                results.add(delete);
                add(results, BorderLayout.NORTH);
        
            case MODIFY:
                break;

            case SELECT:
                jTable.setRowSelectionAllowed(false);
                
            case CHOOSEONE:
                jTable.setModel(new DefaultTableModel(table,columns){
                    private static final long serialVersionUID = 1L;
                    @Override
                    public boolean isCellEditable(int row, int col)
                    {
                        return false;
                    }
                });
                jTable.getSelectionModel().addListSelectionListener(this);
                jTable.setColumnSelectionAllowed(false);
                jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            default:
                break;
        }

    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
            System.out.println(jTable.getSelectedRow());
        

    }

    /*public int getSelectedId()
    {
        return jTable.getSelectedRow();
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Zaznacz wszystkie")) 
        {
            jTable.selectAll();
        }
        if(e.getActionCommand().equals("Odznacz wszystkie"))
        {
            jTable.clearSelection();
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