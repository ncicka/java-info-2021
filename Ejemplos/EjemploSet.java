
import java.util.HashSet;
import java.util.Set;

public class EjemploSet {
    
    public static void main(String[] args){
        Set<String> nombres = new HashSet<>();

        //cargar el Set y mostrar el tamaño
        cargarSet(nombres);

        System.out.println("Tamaño del Set luego de cargarlo "+nombres.size());

        //iterar y mostrar
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
        
        //pregunto si tiene un elemento dado
        System.out.println("Existe \"Maria\" al Set "+nombres.contains("Maria"));

        nombres.remove("Juan");

        System.out.println("Tamaño del Set luego de remover "+nombres.size());
    }

    public static void cargarSet(Set<String> nombres){
        nombres.add("Juan");
        nombres.add("Maria");
        nombres.add("Homero");
        nombres.add("Lista");
        nombres.add("Pablo");

    }
}
