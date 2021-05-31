

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args){
        ArrayList<String> ciudades = new ArrayList<> ();

        cargarLista(ciudades);
        verLista(ciudades);
        
    }

    public static void cargarLista(List<String> ciudades){
        //BufferedReader scan=new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        String continuar = "1";
        try{
            while (continuar.equals("1")) {
                String ciudad = Libreria2.leerConsola("Ciudad: ", scan);
                ciudades.add(ciudad);
                continuar = Libreria2.leerConsola("Desea continuar (1) ", scan);
            }
        }catch(EntidadVacia e){
            e.printStackTrace();
        }
        scan.close();
    }

    public static void verLista(List<String> ciudades){
        for (int i = 0; i < ciudades.size(); i++) {
            System.out.printf(" #%d-%s", i+1, ciudades.get(i));
        }
    }
    
}
