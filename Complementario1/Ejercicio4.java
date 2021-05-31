
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try{
            int nro = Libreria.leerInt("Ingrese un numero entero: ", scan);
            float fact = verFactorial(nro);
            System.out.println("El factorial de "+nro +" es "+fact);
        } catch (Exception e){
            System.out.println("Debe ingresar un nro entero");
        }
        scan.close();

    }
    public static float verFactorial(int nro){
        if (nro <= 1){
            return 1;
        }
        return nro * verFactorial(nro-1);
    }
}
