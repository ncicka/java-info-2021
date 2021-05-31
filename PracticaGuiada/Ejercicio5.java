
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args){
        // crea el objeto para tomar el valor de entrada por consola
        Scanner scan = new Scanner(System.in);
        // ingresamos el valor
        int continuar = 1;
        int nro = 0;

        while (continuar== 1) {

            nro = leerInt("Ingrese un numero ", scan);
    
            for (int i = 1; i < 11; i++) {
                System.out.println( nro + " * " + i+" = "+ nro*i);
            }
            continuar = leerInt("Desea continuar (1) ", scan);
        }

        scan.close();
    }

    public static int leerInt(String men, Scanner valor){
        System.out.println(men);
        return valor.nextInt();
    }
}
