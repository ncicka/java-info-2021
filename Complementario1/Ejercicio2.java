
import java.util.Scanner;

//ingresar dos numeros enteros y mostrar la suma, resta 
//multipicacion, division y modulo 

public class Ejercicio2 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a, b;

        try {
            a = Libreria.leerInt("Ingrese un numero entero: ", scan);
            b = Libreria.leerInt("Ingrese otro numero entero: ",scan);
            verSuma(a, b);
            verResta(a, b);
            verMultiplicacion(a, b);
            verDivision(a, b);
            verModulo(a, b);
        } catch (Exception e) {
            System.out.println("Debe ingresar solo números enteros");
        }

        scan.close();
    }

    public static void verSuma(int a, int b){
        System.out.println(a + " + "+ b +" = "+ (a+b));
    }
        
    public static void verResta(int a, int b){
        System.out.println(a + " - "+ b +" = "+ (a-b));
    }

    public static void verMultiplicacion(int a, int b){
        System.out.println(a + " * "+ b +" = "+ (a*b));
    }
    public static void verDivision(int a, int b){
        if (b == 0){
            System.out.println("No se puede dividir por cero");
        }else{
            System.out.println(a + " / "+ b +" = "+ (a/b));
        }
    }

    public static void verModulo(int a, int b){
        if (b == 0){
            System.out.println("No se puede dividir por cero");
        }else{
            System.out.println(a + " % "+ b +" = "+ (a%b));
        }
    }

}
