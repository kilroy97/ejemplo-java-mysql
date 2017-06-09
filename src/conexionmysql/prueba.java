  /*
   * To change this license header, choose License Headers in Project Properties.
   * To change this template file, choose Tools | Templates
   * and open the template in the editor.
   */
  package conexionmysql;
  import java.util.Scanner;
  import java.sql.*;
  /**
   *
   * @author kilroy
   */
  public class prueba {
      public static void main(String[] args) throws SQLException {
          int opc = 0;
          String codigo = "";
          String dpi = "";
          String nombre ="";
          String apellido = "";
          String edad = "";
           consultas con = new consultas();
           do{
          Scanner entrada = new Scanner(System.in);
          System.out.println("1. Registro de usuarios");
          System.out.println("2. Mostrar usuarios");
          System.out.println("3. Actualizar usuario");
          System.out.println("4. Eliminar usuario");
          System.out.println("5. salir");
          System.out.println("Que desea hacer: ");
          opc = entrada.nextInt();


              switch(opc){
                  case 1:
                  {
                      System.out.println("ingrese dpi");
                      dpi = entrada.next();
                      System.out.println("ingrese nombre");
                      nombre = entrada.next();
                      System.out.println("ingrese apellido");
                      apellido = entrada.next();
                      System.out.println("ingrese edad");
                      edad = entrada.next();
                      if(!nombre.isEmpty() && !apellido.isEmpty() && !edad.isEmpty()){
                      con.nuevo(dpi, nombre, apellido, edad);
                          System.out.println("Datos introducidos correctamente");
                      }
                      else{
                          System.out.println("introduzca correctamente los datos");
                      }
                      break;
                  }
                  case 2:
                  {
                      ResultSet datos = con.listado();


                          System.out.println("|Dpi     |Nombre     |   Apellido     |   Edad ");
                      while(datos.next()){
                          System.out.println("|"+datos.getString(2)+"        | "+datos.getString(3)+"    |  "+datos.getString(4)+"| " +datos.getString(5));
                          System.out.println("-------------------------------------------");
                      }

                      break;
                  }
                  case 3:
                  {
                        consultas Conn = new consultas();



                               String cod = "";
                                System.out.println("Ingrese codigo a verificar: ");
                                 codigo = entrada.next();
                                 int ID = Integer.parseInt(codigo);
                                 ResultSet datos = Conn.getUno(ID);
                                 while(datos.next()){
                                       cod = datos.getString(1);
                                       dpi= datos.getString(2);
                                       nombre = datos.getString(3);
                                       apellido = datos.getString(4);
                                       edad = datos.getString(5);
                                 }

                           if(codigo.equals(cod))
                            {
                                 do{


                              System.out.println("1. Modificar DPI de usuario");
                              System.out.println("2. Modificar Nombre de usuario");
                              System.out.println("3. Modificar Apellido de usuario");
                              System.out.println("4. Modificar Edad de usuario");
                              System.out.println("5. salir");
                              System.out.println("Que desea hacer: ");
                              opc = entrada.nextInt();
                              switch(opc){
                                  case 1:
                                  {

                                      System.out.println("Ingrese nuevo dpi");
                                      dpi = entrada.next();
                                      Conn.actualizar(ID, dpi,nombre, apellido, edad);
                                      System.out.println("Dato modificado correctamente");

                                  break;
                                  }
                                  case 2:
                                  {

                                      System.out.println("ingrese nuevo nombre");
                                      nombre = entrada.next();
                                      Conn.actualizar(ID, dpi,nombre, apellido, edad);
                                      System.out.println("Dato modificado correctamente");


                                  break;
                                  }
                                  case 3:
                                  {

                                      System.out.println("ingrese nuevo apellido");
                                      apellido = entrada.next();
                                      Conn.actualizar(ID, dpi,nombre, apellido, edad);
                                      System.out.println("Dato modificado correctamente");

                                  break;
                                  }
                                  case 4:
                                  {
                                      System.out.println("ingrese nueva edad");
                                      edad = entrada.next();
                                      Conn.actualizar(ID, dpi,nombre, apellido, edad);
                                      System.out.println("Dato modificado correctamente");

                                  break;
                                  }
                                  default :{
                                  System.exit(0);
                                  }

                              }

                          }while(opc != 5);

                }
                           else{
                                System.out.println("No existe el codigo que ustéd ingresó. ");
                            }


                   break;
                  }
                  case 4:
                  {

                      String status = "1";
                      consultas Conn = new consultas();
                      String cod = "";
                      System.out.println("Coloque el código del usuario que desea eliminar: ");
                      codigo = entrada.next();
                      int ID = Integer.parseInt(codigo);
                       ResultSet datos = Conn.getUno(ID);
                                 while(datos.next()){
                                 cod = datos.getString(1);
                                 dpi= datos.getString(2);
                                 nombre = datos.getString(3);
                                 apellido = datos.getString(4);
                                 edad = datos.getString(5);
                                 }
                        if(codigo.equals(cod))
                        {

                                status = "0";
                                con.eliminar(ID, status);
                                 System.out.println("usuario eliminado");
                        }
                        else
                        {
                                  System.out.println("El código que usted introdujo es incorrecto");
                        }
                             break;
                  }
                    default:
                  {
                      System.exit(0);
                  }
              }



           }while(opc != 5);
      }

  }
