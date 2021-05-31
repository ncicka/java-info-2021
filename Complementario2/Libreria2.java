
import java.util.Scanner;

public class Libreria2 {
    public static int leerInt(String men, Scanner scan){
        int rta = 0;
        System.out.print(men);
        rta = scan.nextInt();
        return rta;
    }
    public static String leerConsola(String men, Scanner scan) throws EntidadVacia{
        String valor="";
        System.out.print(men);
        valor = scan.nextLine();
        if (valor.isEmpty()){
            throw new EntidadVacia("Debe ingresar algun dato");
        }
        return valor;
    }
}
