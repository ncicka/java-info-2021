import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/*
Teniendo una lista de objetos Empleado, 
cargar la misma en un archivo empleado.txt.
Observación:
Cada empleado se almacena en una sola líne 
con el formato que uds definan
*/
public class Ejercicio4 {
    public static void main(String[] args){
        List<Empleado> listaEmple = new ArrayList<>();

        cargarLista(listaEmple);
        
        try {
            escribirArchivo("./empleado.txt", listaEmple);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Cargo el array con los empleados
    public static void cargarLista(List<Empleado> listaEmple){
        Empleado e1 = new Empleado(1234,"Martin","López",4,345.2);
        Empleado e2 = new Empleado(4434,"Lorena","Martinez",5,350.2);
        Empleado e3 = new Empleado(7788,"Joaquín","Suarez",6,550.0);

        listaEmple.add(e1);
        listaEmple.add(e2);
        listaEmple.add(e3);
    }

    //Guardo la lista en un archivo
    public static void escribirArchivo(String arch, List<Empleado> lista) throws IOException{
        File archivo = new File(arch);
        BufferedWriter bw = null;
        try {
            //si ya existe agrego datos
            boolean existe = (archivo.exists())?true:false;
            FileOutputStream oFile = new FileOutputStream(archivo,existe);
            OutputStreamWriter oStream = new OutputStreamWriter(oFile, StandardCharsets.UTF_8);
            bw = new BufferedWriter(oStream);     
            for (Empleado emp : lista) {
                bw.write(emp.toString()+"\n"); 
                //otra forma de agregar un salto de linea
                //bw.newLine();
            }  
            bw.flush();
        }finally{
            bw.close();
        }
        
    }
    
}
