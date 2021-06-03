import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


/*
Dado un archivo de texto (alumnos.txt), 
crear una función que lea todos los nombres de los alumnos 
y los imprima por pantalla.
Observación:
Cada línea del archivo representa un nombre de alumno.

*/

public class Ejercicio3{

    public static void main(String[] args){
        
        //Nombre de archivo y path
        System.out.println("\nLeer con Files");
        leerArchivo("./Alumnos.txt");

        // Otra forma de leer
        System.out.println("\nLeer con BufferReader");
        try {
            leerArchivo_otro("./Alumnos.txt");
        } catch (Exception e) {
            System.out.println("No se encontro el archivo");
        }
        
    }

    public static void leerArchivo(String arch) {
        try {
            Path path = Paths.get(arch);
            List<String> contentList = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String linea : contentList) {
                System.out.println(linea);    
            }
            
        }catch (IOException e){
            e.printStackTrace();
        } 
    }

    public static void leerArchivo_otro(String arch) throws IOException{

        try (BufferedReader br = new BufferedReader(new FileReader(arch))){
            String line = br.readLine();
            while (line != null){
                System.out.println(line);
                line = br.readLine();
            }   
        }
    }
}