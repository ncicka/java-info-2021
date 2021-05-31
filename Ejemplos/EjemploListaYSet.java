

import java.util.ArrayList;
import java.util.List;

public class EjemploListaYSet {
    
    public static void main(String[] args){
        ArrayList<String> nombres = new ArrayList<> ();

        // carga la lista y muestra el tamaño
        cargalista(nombres);

        System.out.println("Tamaño de la lista luego de cargarla "+nombres.size());

        //iterar y mostrar
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        //pregunto si la lista contiene un elemento dado
        System.out.println("Existe \"Maria\" en la lista "+nombres.contains("Maria"));

        nombres.remove("Juan");

        System.out.println("Tamaño de la lista luego de remover "+nombres.size());
        
    }

    public static void cargalista(List<String> nombres){
        nombres.add("Juan");
        nombres.add("Maria");
        nombres.add("Homero");
        nombres.add("Lista");
        nombres.add("Pablo");

    }
}
