package app;

import java.sql.*;
import java.util.ArrayList;
import java.util.*;

public class DataBaseConnection {
    
    List<String> results;
    public DataBaseConnection(String[] information, String[] columns) 
    {
        results = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KlinikaWeterynaryjna", "root", "1234");
                Statement stmt = conn.createStatement();) {
            String testquery = "Select * From klienci Where " + parseConditions(information);
            ResultSet res = stmt.executeQuery(testquery);
            int rowCount = 0;
            while (res.next()) 
            {
                String result = "";
                for(int i=0; i<columns.length; i++)
                    result += res.getString(columns[i]) + " ";
                results.add(result);
                /* ... */ ++rowCount;
            }
            new Results(results.toArray(new String[0]));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private String parseConditions(String[] information)
    {
        String result = "";
        for(int i=0; i<information.length; i+=2)
        {
            result+=information[i] + "=" + "'" + information[i+1] + "'";
            if(i!=information.length-2)
                result+=" AND ";
        }
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        //new DataBaseConnection();
    }
}