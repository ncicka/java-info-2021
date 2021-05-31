

import java.util.ArrayList;
import java.util.List;

public class Ejercicio4 {

    public static void main(String[] args){
        ArrayList<String> estudiantes = new ArrayList<>();
        cargarLista(estudiantes);

        List<String> sublista1 = estudiantes.subList(0, 3);
        List<String> sublista2 = estudiantes.subList(4, 7);
        List<String> sublista3 = estudiantes.subList(8, 11);

        System.out.println(sublista1);
        System.out.println(sublista2);
        System.out.println(sublista3);

        
    }
    
    public static void cargarLista(List<String> lis){
        lis.add("Juan Perez");
        lis.add("Jose Ortiz");
        lis.add("Luana Galarza");
        lis.add("Alberto Galarza");
        lis.add("Ramon Galarza");
        lis.add("Walter Perez");
        lis.add("Elisa Perez");
        lis.add("Lorena Ortiz");
        lis.add("Eduardo Ortiz");
        lis.add("Omar Galarza");
        lis.add("Nestor Perez");
        lis.add("Luis Ortiz");        
    }
}
