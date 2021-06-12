import java.math.BigDecimal;
import java.text.Collator;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.Locale;

public class Empleados {

    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private BigDecimal sueldo;

    public Empleados(String nombre, String apellido, LocalDate fecNac, BigDecimal sueldo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fecNac;
        this.sueldo = sueldo;
    }
    
    public Empleados(){
        this.nombre = "";
        this.apellido = "";
        this.fechaNac = LocalDate.now();
        this.sueldo = BigDecimal.ZERO;
    }

    public BigDecimal getSueldo(){
        return this.sueldo;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getApellido(){
        return this.apellido;
    }    

    public LocalDate getFechaNac(){
        return this.fechaNac;
    }

    public Integer getEdad(){
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(this.fechaNac, ahora);
        return periodo.getYears();
    }

    @Override
    public String toString(){
        return this.apellido +" "+ this.nombre;
    }
}

class ordenEdad implements Comparator<Empleados>{

    public int compare (Empleados a, Empleados b){
        return a.getEdad() - b.getEdad();
    }
}

class ordenSueldo implements Comparator<Empleados>{

    public int compare (Empleados a, Empleados b){
        return a.getSueldo().compareTo(b.getSueldo());
    }
}

class ordenNombreApellido implements Comparator<Empleados>{

    private Collator collator = Collator.getInstance(new Locale("es"));

    public int compare (Empleados a, Empleados b){
        String naa = a.getNombre() + a.getApellido();
        String nab = b.getNombre() + b.getApellido();
        return collator.compare(naa,nab);
    }
}

class ordenApellidoNombre implements Comparator<Empleados>{

    private Collator collator = Collator.getInstance(new Locale("es"));

    public int compare (Empleados a, Empleados b){
        String naa = a.getApellido() + a.getNombre();
        String nab = b.getApellido() + b.getNombre();
        return collator.compare(naa, nab);
    }
}
