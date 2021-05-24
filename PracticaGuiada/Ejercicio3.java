package PracticaGuiada;
import  java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args){
        // crea el objeto para tomar el valor de entrada por consola
        Scanner scan = new Scanner(System.in);
        // ingresamos el valor
        int nota = 0;
        int continuar = 1;

        while (continuar == 1) {
            nota = leerInt("Ingrese la nota: ", scan);
            verNota(nota);
            continuar = leerInt("Desea continuar (1) ", scan);         
        }
        scan.close();

    }
    public static void verNota(int valor){
        if (valor > 92){
            System.out.println("Excelente");
        }else if (valor > 84){
            System.out.println("Sobresaliente");          
        }else if (valor > 74){
            System.out.println("Distinguido");
        }else if (valor > 59){
            System.out.println("Bueno");
        }else {
            System.out.println("Desaprobado");
        }

    }

    public static int leerInt(String men, Scanner valor){
        System.out.println(men);
        return valor.nextInt();
    }
    
}
