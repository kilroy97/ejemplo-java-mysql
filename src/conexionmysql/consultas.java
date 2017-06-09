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
      public int nuevo(String dpi, String nombre, String apellido, String edad){
      int filas = 0;
      Statement st = null;
      try{
          st = connection.createStatement();
          String consulta = "insert into usuario(dpi, Nombre, Apellido, Edad)values "+"('"+dpi+"','"+nombre+"','"+apellido+"','"+edad+"')";
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
      String status = "1";
      try{
          st = connection.createStatement();

          String consulta = "SELECT * FROM usuario WHERE status = "+status ;
          filas = st.executeQuery(consulta);
      }
      catch(SQLException e){
          System.out.println("error de conexion"+ e.getMessage());

      }
      return filas;
      }

      public int actualizar(int codigo, String dpi, String nombre, String apellido, String edad){
      int filas = 0;
      Statement st = null;
          try{
          st = connection.createStatement();
          String consulta = "UPDATE usuario " +
                      "SET dpi = '" + dpi + "', Nombre = '" + nombre + "'," +" Apellido = '" + apellido + "',"
                      +" Edad = '" + edad + "'" +
                      " WHERE Codigo ="+codigo+";";
              filas = st.executeUpdate(consulta);
          }
          catch(SQLException e){
              System.out.println("error de conexion"+ e.getMessage());

          }
          return filas;
      }
     public int eliminar(int codigo,String status){
     int filas = 0;

     Statement st = null;
          try{
              st = connection.createStatement();
              String consulta = "UPDATE usuario " +
                      "SET status = '" + status + "'"
                      + " WHERE Codigo ='"+codigo+"';";
              filas = st.executeUpdate(consulta);

          }
          catch(SQLException e){
              System.out.println("Error No ha introducido correctamente los datos: " + e.getMessage());
          }
     return filas;
     }
     public ResultSet getUno(int id) {
          ResultSet filas = null;
          Statement st = null;
          try {
              st = connection.createStatement();
              String consultaSQL = "SELECT * FROM usuario WHERE Codigo='"+id+"'";
              filas = st.executeQuery(consultaSQL);
          } catch (SQLException e) {
              System.err.println("Error en la carga del driver: " + e.getMessage());
          }
          return filas;
     }
  }
