
import java.util.Scanner;

public class Ejercicio9 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        try{
            String texto = Libreria.leerConsola("Ingrese un texto: ", scan);
            String letra = Libreria.leerConsola("Letra a buscar: ", scan);
            
            if (letra.length()>1){
                System.out.println("Debe ser solo una letra");
            }else{
                System.out.println(verNroVeces(texto, letra));
            }
    
        }catch(EntidadVacia e){
            e.printStackTrace();
        }finally{
            scan.close();
        }    
    }
    public static int verNroVeces(String men, String buscar){
        int cant = 0;
        String b = buscar.toLowerCase();
        String c = men.toLowerCase();
        for (int i = 0; i < c.length(); i++) {
            if (c.substring(i, i+1).equals(b)){
                cant++;
            }
        }
        return cant;
    }
}
