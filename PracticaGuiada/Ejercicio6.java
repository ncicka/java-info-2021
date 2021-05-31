
import java.util.Scanner;

public class Ejercicio6 {
    
    public static void main(String[] args){
        // crea el objeto para tomar el valor de entrada por consola
        Scanner scan = new Scanner(System.in);
        // ingresamos el valor
        
        int continuar = 1;
        int nro = 0;

        while (continuar == 1 ) {
            nro = leerInt("Ingrese un numero ", scan);
            System.out.println("El numero ingresado es "+nro);
            continuar = leerInt("Desea continuar (1) ", scan);
        }
        scan.close();
    }
    public static int leerInt(String men, Scanner valor){
        System.out.println(men);
        return valor.nextInt();
    }

}


