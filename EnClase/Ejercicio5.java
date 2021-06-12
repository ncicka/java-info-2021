import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Ejercicio5 {

    public static void main(String[] args) {
        // Leer el archivo
        String arch = "./ListaEmpleado.txt";
        BufferedReader br = null;
        List<Empleados> listaEmpleado = new ArrayList<>();
        
        try {
            br = new BufferedReader(new FileReader(arch));
            String linea = br.readLine();
            while (linea != null){
                cargarEmpleado(listaEmpleado, linea);
                System.out.println(linea);
                linea = br.readLine();
            }

            for (Empleados emp : listaEmpleado) {
                System.out.println(emp.getFechaNac());
                System.out.println(emp.getSueldo());
                System.out.println(emp.getEdad());
            }
            
            // Empleados que comiencen con K
            System.out.println("Empleados que sus apellidos comienzan con K");
            System.out.println(filtroComienzaCon(listaEmpleado, "K"));
            // Empleados que comiencen con U
            System.out.println("Empleados que sus apellidos comienzan con U");
            System.out.println(filtroComienzaCon(listaEmpleado, "U"));

            // Empleado de mayor edad
            System.out.println("Empleado de mayor edad");
            System.out.println(getMayorMenorEdad(listaEmpleado, true));

            // Empleado de  menor edad
            System.out.println("Empleado de menor edad");
            System.out.println(getMayorMenorEdad(listaEmpleado, false));

            // Empleado de mayor sueldo
            System.out.println("Empleado de mayor sueldo");
            System.out.println(getMayorMenorSueldo(listaEmpleado, true));
            
            // Empleado de  menor sueldo
            System.out.println("Empleado de menor sueldo");
            System.out.println(getMayorMenorSueldo(listaEmpleado, false));

            // Ordenar lista por nombre y apellido
            System.out.println("Ordenar por nombre y apellido");
            System.out.println(ordenNombreApellido(listaEmpleado));

            // Ordenar lista por apellido y nombre
            System.out.println("Ordenar por apellido y nombre");
            System.out.println(ordenApellidoNombre(listaEmpleado));
            
        }catch (IOException e){
            e.printStackTrace();
        } 
    }

    public static void cargarEmpleado(List<Empleados> lista, String emp ){
        String[] partes = emp.split(",");
        LocalDate fn = stringToDate(partes[2].trim());

        BigDecimal s = stringToNumber(partes[3]);

        lista.add(new Empleados(partes[0].trim(),partes[1].trim(),fn,s));
    }

    public static LocalDate stringToDate(String sfecha){
        DateTimeFormatter fespana = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate lfecha = LocalDate.parse(sfecha, fespana);
        return lfecha;
    }

    //Devuelve el numero o cero si hay algun dato erróneo
    public static BigDecimal stringToNumber(String snum){
        BigDecimal bnum = null;
        try{
            bnum = new BigDecimal(snum);
        }catch (Exception e) {
            System.out.println("Error al convertir numero");
            bnum = new BigDecimal("0.0");
        }
        return bnum;
    }

    public static List<Empleados> filtroComienzaCon(List<Empleados> lista, String com){
        List<Empleados> listaFiltro = new ArrayList<>();
    
        for (Empleados t : lista) {

            if (t.getApellido().toLowerCase().startsWith(com.toLowerCase())){
                listaFiltro.add(t);
            }
        }
        return listaFiltro;
    }

    //El segundo parameto dice si es mayor = true y menor = false
    public static Empleados getMayorMenorEdad(List<Empleados> lista, boolean mayor){

        Collections.sort(lista, new ordenEdad());

        return mayor ? lista.get(lista.size()-1) : lista.get(0);
    }

    public static Empleados getMayorMenorSueldo(List<Empleados> lista, boolean mayor){

        Collections.sort(lista, new ordenSueldo());

        return mayor ? lista.get(lista.size()-1) : lista.get(0);
    }

    public static List<Empleados> ordenNombreApellido (List<Empleados> lista){
        Collections.sort(lista, new ordenNombreApellido());
        return lista;
    }

    public static List<Empleados> ordenApellidoNombre (List<Empleados> lista){
        Collections.sort(lista, new ordenApellidoNombre());
        return lista;
    }

}
