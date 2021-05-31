
import java.util.Scanner;

public class Ejercicio4 {
    
    public static void main(String[] args){
        // crea el objeto para tomar el valor de entrada por consola
        Scanner scan = new Scanner(System.in);

        int continuar = 1;
        int dia = 1;

        while (continuar == 1) {
        // ingresamos el valor
            dia = leerInt("Ingrese un numero entre 1-7: ", scan);
            verDia(dia);
            continuar = leerInt("Desea continuar (1) ", scan);     
        }
        scan.close();
    }

    public static int leerInt(String men, Scanner valor){
        System.out.println(men);
        return valor.nextInt();
    }

    public static void verDia(int valor){
        switch (valor) {
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Lunes");
                break;
            case 3:
                System.out.println("Martes");
                break;
            case 4:
                System.out.println("Miercoles");
                break;
            case 5:
                System.out.println("Jueves");
                break;
            case 6:
                System.out.println("Viernes");
                break;
            case 7:
                System.out.println("Sabado");
                break;
            default:
                System.out.println("No correponde a ningun dia de la semana");
                break;
        }
    }
}
