/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionmysql;
import java.util.Scanner;
/**
 *
 * @author kilroy
 */
public class prueba {
    public static void main(String[] args) {
        int opc = 0;
        String nombre ="";
        String apellido = "";
        String edad = "";
         consultas con = new consultas();
        Scanner entrada = new Scanner(System.in);
        System.out.println("1. Registro de usuarios");
        System.out.println("2. Mostrar usuarios");
        System.out.println("3. Actualizar usuario");
        System.out.println("4. Eliminar usuario");
        System.out.println("5. salir");
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
                        System.out.println("introduzca bien los datos");
                    }
                    break;
                }
                case 2:
                {
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
       
        
        
        
    }
    
}
