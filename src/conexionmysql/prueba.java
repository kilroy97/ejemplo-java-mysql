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
                    System.out.println("ingrese nombre");
                    nombre = entrada.next();
                    System.out.println("ingrese apellido");
                    apellido = entrada.next();
                    System.out.println("ingrese edad");
                    edad = entrada.next();
                    if(!nombre.isEmpty() && !apellido.isEmpty() && !edad.isEmpty()){
                    con.nuevo(nombre, apellido, edad);
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
                        System.out.println("Nombre de Usuario  Apellido de Usuario Edad de Usuario");
                    while(datos.next()){
                        System.out.println(" "+datos.getString(2)+" "+datos.getString(3)+" "+datos.getString(4));
                    }
                    break;
                }
                case 3:
                {
                    break;
                }
                case 4:
                {
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
