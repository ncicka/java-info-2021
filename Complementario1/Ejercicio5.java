
import java.util.Scanner;


public class Ejercicio5 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try{
            int nro1 = Libreria.leerInt("Ingrese un numero entero: ", scan);
            int nro2 = Libreria.leerInt("Ingrese otro numero entero: ", scan);
            int prod = verMultiplica(nro1,nro2);
            System.out.println(nro1 +" x "+nro2 +" = "+ prod);
        } catch (Exception e){
            System.out.println("Debe ingresar un nro entero");
        }
        scan.close();

    }
    public static int verMultiplica(int nro1, int nro2){
        int producto = 0;
        for (int i = 1; i <= nro1; i++) {
            producto = producto + nro2;
        }
        return producto;
    }
   
}
