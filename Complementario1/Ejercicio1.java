
import java.util.Scanner;

/* Solicitar por consola el nombre de Usuario y mostrar por pantalla
 Hola {Usuario}
 */

public class Ejercicio1 {


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try {
            String usuario = Libreria.leerConsola("Ingrese su nombre ", scan);
            if (usuario.isEmpty()){
                System.out.println("No ingreso ningun valor");
            }else {
                System.out.println("Hola "+usuario);
            }       
        } catch (EntidadVacia e) {
            e.printStackTrace();
        }
    }
    

}
