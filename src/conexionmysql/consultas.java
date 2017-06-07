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
public class consultas extends Conexionmysql {
    public int nuevo(String nombre, String apellido, String edad){
    int filas = 0;
    Statement st = null;
    try{
        st = connection.createStatement();
        String consulta = "insert into usuario(Nombre, Apellido, Edad)values "+"('"+nombre+"','"+apellido+"','"+edad+"')";
        filas = st.executeUpdate(consulta);
    }
    catch(SQLException e){
       System.err.print("error de conexion: "+ e.toString());
    }
    return filas;
    }
    public ResultSet listado(){
    ResultSet filas = null;
    Statement st = null;
    try{
        st = connection.createStatement();
        String consulta = "SELECT * FROM usuario";
        filas = st.executeQuery(consulta);
    }
    catch(SQLException e){
        System.out.println("error de conexion"+ e.getMessage());
    
    }
    return filas;
    }
}
