
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try{
            int nro = Libreria.leerInt("Ingrese un numero entero: ", scan);
            verSecuencia(nro);
        } catch (Exception e){
            System.out.println("Debe ingresar un nro entero");
        }
        scan.close();
    }
    
    public static void verSecuencia(int nro){

        for (int i = 1; i <= nro ; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);        
            }
            System.out.println(" ");
        }
    }
}
