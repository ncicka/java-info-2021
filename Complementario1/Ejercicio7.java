
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try{
            String texto = Libreria.leerConsola("Ingrese un texto: ", scan);
            texto = aMayus(texto);
            System.out.println(texto);
        }catch(EntidadVacia e){
            e.printStackTrace();
        }
        scan.close();
    }
    public static String aMayus(String t){
        String b = "";
        String s = "";
        for (int i = 0; i < t.length(); i++) {
            char a = t.charAt(i);
            if (97 <= a && a <=122){
                a = (char)(a - 32); 
            }
            s = Character.toString(a);
            b = b + s;
        }
        return b;
    }
    
}
