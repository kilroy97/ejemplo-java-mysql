/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionmysql;
import java.sql.*;
/**
 *
 * @author kilroy
 */
public class Conexionmysql {
   public static final String username = "root";
   public static final String pass = "";
   public static final String host = "127.0.0.1";
   public static final String port = "3306";
   public static final String dbname = "primeradb";
   public static final String classname = "com.mysql.jdbc.Driver";
   public static final String url = "jdbc:mysql://"+host+":"+port+"/"+dbname;
   public Connection connection;

    public Conexionmysql() {
        try{
            Class.forName(classname);
            connection = DriverManager.getConnection(url, username, pass);
            System.out.println("connection");
        }
        catch(ClassNotFoundException e){
            System.err.print("error"+ e.toString());
            
        }
        catch(SQLException e){
            System.err.print("error " + e.toString());
        }
    }
   
   
   }
    
    
    
    
       
    
