package app;

import java.sql.*;
import javax.swing.JOptionPane;

import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;


public class DataBaseConnection {
    
    Statement stmt;
    mainFrame frame;
    Connection conn;
    public DataBaseConnection(mainFrame frame) 
    {
        this.frame = frame;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/klinikaweterynaryjna?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
            stmt = conn.createStatement();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public DataBaseConnection() {
    	
    	 try {
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/klinikaweterynaryjna?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
             stmt = conn.createStatement();
             
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
    
    }

    public ArrayList<String> select_info(Permision perm) {
    	ArrayList<String> results = new ArrayList<String>();
    	String table = "";
    	if(perm == Permision.CLIENT) {
    		table = "klienci";
    	}
    	else if(perm == Permision.VET || perm == Permision.TECHNICIAN) {
    		table = "pracownicy";
    	}
        String id = Integer.toString(perm.getId());
        results.add(table);
        try
        {
        	String testquery;
        	if(table.equals("klienci")) {
        		testquery = "Select imie,nazwisko,numer_tel From " + table + " WHERE id=" + id;
        	}
        	else {
                testquery = "Select imie,nazwisko,numer_tel,data_urodzenia,pensja,zawod From " + table + " WHERE id=" + id;
        	}
            ResultSet res = stmt.executeQuery(testquery);
            if(res.next())
            {
                results.add(res.getString("imie"));
                results.add(res.getString("nazwisko"));
                results.add(res.getString("numer_tel"));
                if(table.equals("pracownicy")) {
                    results.add(res.getString("data_urodzenia"));
                    results.add(res.getString("pensja"));
                    results.add(res.getString("zawod"));
                }
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return results;
    }
    
    
    
    
    
    public void select(String table, String[] conditions, String[] columns, Function fun)
    {
        List<String[]> results = new ArrayList<String[]>();
        try
        {
            String testquery;
            if(conditions.length>0 && conditions[0]=="OR")
                testquery = "Select * From " + table + (conditions.length > 2 ?
                 parseConditions(Arrays.copyOfRange(conditions, 2, conditions.length)) + " AND " : 
                 " Where ") + conditions[1];
            else
                testquery = "Select * From " + table + parseConditions(conditions);
            System.out.println(testquery);
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
            JOptionPane.showMessageDialog(null, "Bledne zapytanie", "Blad", JOptionPane.ERROR_MESSAGE);
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
            while (res.next()) 
            {
                String[] row = new String[column.length];
                for(int i=0; i<column.length; i++)
                    row[i] = res.getString(column[i]);
                results.add(row);
            }
            if(results.isEmpty())
            {
                //JOptionPane.showMessageDialog(null, "Brak wynikow", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                return new String[][]{new String[]{""}};
            }
            return results.toArray(new String[][]{});
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
    
    public void giveRaise(int salary,int percent) {
    	
    	List<Integer> results = new ArrayList<Integer>();
    	String testquery = "Select pensja From pracownicy Where pensja<="+Integer.toString(salary);
        ResultSet res = null;
		try {
			res = stmt.executeQuery(testquery);
			while(res.next()) {
				results.add(res.getInt("pensja"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	
    	PreparedStatement updateSalary = null;
    	try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	for(int s:results) {
    		int raise = s+s*percent/100;
    		String updateString = 
    				"Update pracownicy Set pensja=" + raise + " Where pensja=" + s;
    		try {
				updateSalary = conn.prepareStatement(updateString);
				updateSalary.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(conn!=null) {
				try {
					System.err.print("Transaction is being rolled back");
					conn.rollback();
				} catch(SQLException excep) {
					e.printStackTrace();
				}
			}
		}
    	
    	try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
    
    public int insert_columns(String table,String[] values) {
    	try
        {
    		String insertquery = "";
    		if(table.equals("klienci")) {
    			insertquery = "Insert INTO " + table + "(imie,nazwisko,numer_tel) VALUES " + parseValues(values);
    		}
    		else if(table.equals("pracownicy")) {
    			insertquery = "Insert INTO " + table + "(imie,nazwisko,numer_tel,data_urodzenia,pensja,zawod) VALUES " + parseValues(values);
    		} 
    		System.out.println(insertquery);
            int res = stmt.executeUpdate(insertquery);
            return res;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return -1;
        }
    }
    
    public void backup() {
    	Process p =null;
    	try {
    		Runtime runtime = Runtime.getRuntime();
    		p = runtime.exec("C:/Program Files/MySQL/MySQL Server 8.0/bin/mysqldump.exe --databases --add-drop-database -uroot -p1234 klinikaweterynaryjna -rC:/Users/lukia/OneDrive/Pulpit/bazydanych/lista5/data.sql");
    		int complete = p.waitFor();
    		if(complete==0) {
    			System.out.println("backup");
    		}
    		else {
    			int len;
    			if ((len = p.getErrorStream().available()) > 0) {
    			  byte[] buf = new byte[len];
    			  p.getErrorStream().read(buf);
    			  System.err.println("Command error:\t\""+new String(buf)+"\"");
    			}
    			System.out.println("no backup");
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    }
	
	public void read_backup() {
    	Process p = null;
    	try {
    		Runtime runtime = Runtime.getRuntime();
    		p = runtime.exec("C:/Program Files/MySQL/MySQL Server 8.0/bin/mysql.exe -uroot -pparyta22 klinika < C:/Users/Public/Music/data.sql");
    		int complete = p.waitFor();
    		
    		if(complete==0) {
    			System.out.println("read backup");
    		}
    		else {
    			int len;
    			if ((len = p.getErrorStream().available()) > 0) {
    			  byte[] buf = new byte[len];
    			  p.getErrorStream().read(buf);
    			  System.err.println("Command error:\t\""+new String(buf)+"\"");
    			}
    			System.out.println("no read backup");
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    
    public String[][] callProcedure(String name, String value[], int columnNumber)
    {
        CallableStatement cstmt;
        List<String[]> results = new ArrayList<>();
        try {
            String help="";
            String SQL;
            if(value.length==1)
            {
                SQL = "call "+name+" ('"+value[0]+"')";
                cstmt = conn.prepareCall(SQL);
            }
            else
            {
                String[] maciek = value[1].split("-");
                value[1] = maciek[2]+"-"+maciek[1]+"-"+maciek[0];
                SQL = "{call " + name + " (?,?,?)}";
                cstmt = conn.prepareCall(SQL);
                cstmt.setInt(1, Integer.parseInt(value[0]));
                cstmt.setString(2, value[1]);
                cstmt.setBoolean(3, Boolean.parseBoolean(value[2]));
            }
            ResultSet res = cstmt.executeQuery();
            while (res.next()) 
            {
                String[] row = new String[columnNumber];
                for(int i=1; i<=columnNumber; i++)
                    row[i-1] = res.getString(i);
                results.add(row);
            }
            if(results.isEmpty())
            {
                if(value[2].equals("1"))
                    JOptionPane.showMessageDialog(null, "Brak wolnych terminów w tym dniu",
                    "Informacja", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Brak wolnych terminów w tym dniu lub jestes juz zapisany wiecj niz dwa razy w tygodniu",
                    "Informacja", JOptionPane.INFORMATION_MESSAGE);

                return new String[][]{new String[]{""}};
            }
            return results.toArray(new String[results.size()][]);
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
    
    public void call(String query) throws SQLException {
    	stmt.executeQuery(query);
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
    
    private String parseLogin(String[] values) throws NoSuchAlgorithmException {
    	
    	MessageDigest md = MessageDigest.getInstance("SHA-1"); 
    	byte[] messageDigest = md.digest(values[1].getBytes()); 
    	BigInteger no = new BigInteger(1, messageDigest); 
    	String hashtext = no.toString(16); 
    	while (hashtext.length() < 32) { 
             hashtext = "0" + hashtext; 
        } 
    	
    	String result = "Where login='" + values[0] + "' AND haslo='" + hashtext + "'";
    	return result;
    }
    
    Permision login(String[] values) throws NoSuchAlgorithmException {
    	 Permision permision = null;
         try
         {
        	 String perm = "";
        	 int id;
             String testquery = "Select * From uzytkownicy " + parseLogin(values);
             ResultSet res = stmt.executeQuery(testquery);
             if(res.next() == false) {
            	 return permision;
             }
            
             
            
	             perm = res.getString("uprawnienia");
	             id = Integer.parseInt(res.getString("id"));
	
	             if(perm.equals("technik")) {
	            	 permision = Permision.TECHNICIAN;
	             }
	             else if(perm.equals("weterynarz")) {
	            	 permision = Permision.VET;
	             }
	             else if(perm.equals("dyrektor")) {
	            	 permision = Permision.DIRECTOR;
	             }
	             else if(perm.equals("admin")) {
	            	 permision = Permision.ADMIN;
	             }
	             else if(perm.equals("klient")){
	            	 permision = Permision.CLIENT;
	             }
	             else {
            	 //cos poszlo nie tak
	             }
             
             permision.setId(id);
         
         }
         catch(SQLException ex)
         {
             ex.printStackTrace();
         }
        return permision;
    }

    public static void main(String[] args) {
        //new DataBaseConnection();
    }
}
