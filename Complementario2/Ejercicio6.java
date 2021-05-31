
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ejercicio6 {
    public static void main (String[] args){
        Set<Empleado1> setEmpleados = new HashSet<>();

        cargaSet(setEmpleados);
        
        Map<Integer, Double> totalSueldo = new HashMap<>();

        for (Empleado1 nombre : setEmpleados) {
            System.out.println("Apellido y Nombre: " +nombre.getDni()+" "+nombre+"- horas Trabajadas "+nombre.getHoras());
            totalSueldo.put(nombre.getDni(), nombre.Sueldo());
        }

        System.out.println("Dni  -  Sueldo");
        for (Map.Entry<Integer,Double> registro: totalSueldo.entrySet()) {
            System.out.println(registro.getKey()+" - "+registro.getValue());
        }
    }

    public static void cargaSet(Set<Empleado1> emp){
        Empleado1 e1 = new Empleado1(1234,"Martin","Lopez",4,345.2);
        Empleado1 e2 = new Empleado1(4434,"Lorena","Martinez",5,350.2);
        Empleado1 e3 = new Empleado1(7788,"Joaquin","Suarez",6,550.0);

        emp.add(e1);
        emp.add(e2);
        emp.add(e3);

    }
}
