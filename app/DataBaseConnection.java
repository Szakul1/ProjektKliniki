package app;

import java.sql.*;
import java.util.ArrayList;
import java.util.*;

public class DataBaseConnection {
    
    Statement stmt;
    mainFrame frame;
    public DataBaseConnection(mainFrame frame) 
    {
        this.frame = frame;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KlinikaWeterynaryjna", "root", "1234");
            stmt = conn.createStatement();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void select(String table, String[] conditions, String[] columns, Function fun)
    {
        try
        {
            List<String[]> results = new ArrayList<>();
            String testquery = "Select * From " + table + parseConditions(conditions);
            ResultSet res = stmt.executeQuery(testquery);
            while (res.next()) 
            {
                String[] row = new String[columns.length];
                for(int i=0; i<columns.length; i++)
                    row[i] = res.getString(columns[i]);
                results.add(row);
            }
            new Results(results.toArray(new String[0][]),columns,frame,table,fun);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    public String[] selectColumn(String table, String column, String condition)
    {
        try
        {
            List<String> results = new ArrayList<>();
            String testquery = "Select " + column +" From " + table + condition;
            ResultSet res = stmt.executeQuery(testquery);
            String row;
            while (res.next()) 
            {
                row = res.getString(column);
                results.add(row);
            }
            return results.toArray(new String[0]);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return new String[]{""};
        }
    }
    public int delete(String table, String[] conditions)
    {
        try
        {
            String deletequery = "Delete From " + table + parseConditions(conditions);
            System.out.println(deletequery);
            int res = stmt.executeUpdate(deletequery);
            return res;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return -1;
        }
    }
    public int update(String table, String[] conditions, String column, String value)
    {
        try
        {
            String updatequery = "Update " + table + " Set " + column + "=" + "'" + value + "'" + parseConditions(conditions);
            System.out.println(updatequery);
            int res = stmt.executeUpdate(updatequery);
            return res;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return -1;
        }
    }
    
    public int insert(String table, String[] values) {
    	try
        {
            String deletequery = "Insert INTO " + table + " VALUES " + parseValues(values);
            System.out.println(deletequery);
            int res = stmt.executeUpdate(deletequery);
            return res;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return -1;
        }
    }

    private String parseConditions(String[] information)
    {
        if(information.length<=0)
            return "";
        String result = " Where ";
        for(int i=0; i<information.length; i+=2)
        {
            if(information[i].contains("%"))
                information[i] = "`"+information[i]+"`";
            result+=information[i] + "=" + "'" + information[i+1] + "'";
            if(i!=information.length-2)
                result+=" AND ";
        }
        return result;
    }
    
    private String parseValues(String[] values) {
    	String sresult = "(";
    	for(String i:values) {
    		sresult += "'"+ i + "',";
    	}
    	String result = sresult.substring(0, sresult.length()-1);
    	result += ")";
    	
    	return result;
    }
    public static void main(String[] args) {
        //new DataBaseConnection();
    }
}