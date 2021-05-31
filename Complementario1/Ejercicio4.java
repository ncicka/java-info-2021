
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try{
            int nro = Libreria.leerInt("Ingrese un numero entero: ", scan);
            int fact = verFactorial(nro);
            System.out.println("El factorial de "+nro +" es "+fact);
        } catch (Exception e){
            System.out.println("Debe ingresar un nro entero");
        }
        scan.close();

    }
    public static int verFactorial(int nro){
        int fact = 1;
        for (int i = 2; i <= nro; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
