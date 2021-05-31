

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try {
            int a = Libreria2.leerInt("1° valor entero ", scan);
            int b = Libreria2.leerInt("2° valor entero > que el 1° ", scan);
            if (a < b){
                System.out.println(fizzBuzzFuncion(a,b));    
            }else{
                System.out.println("El 1° valor debe ser < al 2°");
            }
        } catch (Exception e) {
            System.out.println("Debe ingresar un valor entero");
        }
    }

    public static ArrayList<String> fizzBuzzFuncion(int a, int b){
        String valor = "";
        ArrayList<String> array1 = new ArrayList<>();

        for (int i = a; i < b; i++) {
            if (i % 2 == 0){
                valor = "Fizz";
            }
            if (i % 3 == 0){
                valor = valor + "Buzz";
            }
            if (valor.isEmpty()){
                valor = valor + i;
            }
            array1.add(valor);
            valor = "";
        }
        return array1;
    }
    
}
