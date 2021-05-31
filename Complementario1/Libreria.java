
import java.util.Scanner;

public class Libreria {
    public static int leerInt(String men, Scanner scan){
        System.out.print(men);
        return scan.nextInt();
    }
    public static String leerConsola(String men, Scanner scan) throws EntidadVacia{
        System.out.print(men);
        String valor = scan.nextLine();
        if (valor.isEmpty()){
            throw new EntidadVacia("Debe ingresar algun dato");
        }
        return valor;
    }
}
