
import java.util.Scanner;

public class Ejercicio8 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try{
            String nombre = Libreria.leerConsola("Nombre y Apellido: ", scan);
            int edad = Libreria.leerInt("Edad: ", scan);
            scan.nextLine(); // limpiar el buffer despues de leer numeros porque  salta a ciudad
            String direccion = Libreria.leerConsola("Direccion: ", scan);
            String ciudad = Libreria.leerConsola("Ciudad: ", scan);
    
            System.out.printf("%s - %s - %d - %s", ciudad, direccion, edad, nombre);
    
        }catch(EntidadVacia e){
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("La edad debe ser numerica ");
        }finally{
            scan.close();
        }
        
    }

}
