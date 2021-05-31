
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try{
            int nro1 = Libreria.leerInt("Ingrese un numero entero: ", scan);
            int elev = Libreria.leerInt("Ingrese la potencia: ", scan);
            int pot = verPotencia(nro1,elev);
            System.out.println(nro1 +" elevado a "+elev +" = "+ pot);
        } catch (Exception e){
            System.out.println("Debe ingresar un nro entero");
        }
        scan.close();

    }
    public static int verPotencia(int nro1, int elev){
        int potencia = 1;
        for (int i = 1; i <= elev; i++) {
            potencia = potencia * nro1;
        }
        return potencia;
    }

}
