

import java.util.HashMap;
import java.util.Map;

public class MapEjemplo {
    public static void main(String[] args){
        Map<Integer, String> alumnos = new HashMap<>();

        //carga el Map y muestra el tamaño luego
        cargarMap(alumnos);

        System.out.println("Tamaño del Map luego de cargarlo "+alumnos.size());

        //iterar y mostrar clave y valor

        for (Map.Entry<Integer,String> registro: alumnos.entrySet()) {
            System.out.println("Id: "+ registro.getKey()+" Nombre: "+registro.getValue());
        }

        //iterar solo claves
        for (Integer clave : alumnos.keySet()) {
            System.out.println("Id: "+ clave);
        }
        //iterar solo valores
        for (String valor : alumnos.values()) {
            System.out.println("Valor: "+ valor);           
        }
        //pregunto si map tiene una clave dada
        System.out.println("Existe la clave 1234 en el Map " +alumnos.containsKey(1234));
        System.out.println("Existe el valor 1234 en el Map " +alumnos.containsValue("1234"));

        //eliminar un elemento
        alumnos.remove(1234);
        System.out.println("Tamaño del Map luego de remover "+alumnos.size());
    }

    public static void cargarMap(Map<Integer, String> nombres){
        nombres.put(1234,"Juan");
        nombres.put(2345, "Maria");
        nombres.put(3456, "Homero");
        nombres.put(4567, "Lisa");
        nombres.put(5678, "Pablo");
    }
    
}
