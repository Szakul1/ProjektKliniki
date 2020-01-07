package app;

import java.sql.*;
import java.util.ArrayList;
import java.util.*;

public class DataBaseConnection {
    
    Statement stmt;
    mainFrame frame;
    Connection conn;
    public DataBaseConnection(mainFrame frame) 
    {
        this.frame = frame;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KlinikaWeterynaryjna", "root", "1234");
            stmt = conn.createStatement();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void select(String table, String[] conditions, String[] columns, Function fun)
    {
        List<String[]> results = new ArrayList<>();
        try
        {
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
    public String[][] selectColumn(String table, String[] column, String condition)
    {
        try
        {
            List<String[]> results = new ArrayList<>();
            String columns ="";
            for(String s : column)
                columns += s + ",";
            columns = columns.substring(0, columns.length()-1);
            String testquery = "Select " + columns +" From " + table +" "+ condition;
            ResultSet res = stmt.executeQuery(testquery);
            String[] row = new String[column.length];
            while (res.next()) 
            {
                for(int i=0; i<column.length; i++)
                    row[i] = res.getString(column[i]);
                results.add(row);
            }
            return results.toArray(new String[0][]);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return new String[][]{{""}};
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

    public String[][] callProcedure(String name, String values[], int columnNumber)
    {
        CallableStatement cstmt;
        List<String[]> results = new ArrayList<>();
        try {
            String help="";
            for(String s : values)
                help+=s+",";
            help = help.substring(0, help.length()-1);
            String SQL = "call "+name+" ('"+help+"')";
            cstmt = conn.prepareCall(SQL);
            ResultSet res = cstmt.executeQuery();
            while (res.next()) 
            {
                String[] row = new String[columnNumber];
                for(int i=1; i<=columnNumber; i++)
                    row[i-1] = res.getString(i);
                results.add(row);
            }
            return results.toArray(new String[0][]);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return new String[][]{{""}};
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