

import java.util.*;

public class Ejercicio2 {
    public static void main(String[] args){
        //Creamos un objeto scanner que tomarara los valores de entrada por consola
        Scanner scan = new Scanner(System.in);
        
        ingresarDatos(scan);

        scan.close();
    }

    public static void ingresarDatos(Scanner scan){
        
        int a = 0;
        int b = 0;
        int c = 0;
        int continuar = 1;

        while (continuar == 1) {

            a = leerInt("Ingrese primer número: ", scan);
            b = leerInt("Ingrese segundo número: ", scan);
            c = leerInt("Ingrese tercer número: ", scan);

            ver("Primer numero ingresado", a);
            ver("Segundo numero ingresado ",b);
            ver("Tercer numero ingresado ",c);

            continuar = leerInt("Desea continuar (1) ", scan);

        }
    }

    public static void ver(String men, int valor){
        System.out.println(men + valor);
    }

    public static int leerInt(String men, Scanner valor){
        System.out.println(men);
        return valor.nextInt();
    }
}
