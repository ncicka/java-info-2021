

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args){
        ArrayList<Integer> listaEnteros = new ArrayList<> ();

        try{
            cargarLista(listaEnteros);
            verLista(listaEnteros);
        }catch (Exception e){
            System.out.println("Debe ingresar valores enteros");
        }
        
        System.out.println("Agregar el valor 10 al comienzo ");
        listaEnteros.add(0,10);
        verLista(listaEnteros);
        System.out.println("Agregar el valor 99 al final ");
        listaEnteros.add(99);
        verLista(listaEnteros);
    }

    public static void cargarLista(List<Integer> lis){
        int valor = 0;
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            valor = Libreria2.leerInt(i+1 +"°-entero ", scan);
            lis.add(valor);
        }
        
    }
    public static void verLista(List<Integer> lis){

        System.out.println("Tamaño de la lista "+lis.size());
        for (Integer valor : lis) {
            System.out.print(valor+" ");
        }
        System.out.println("");
    }
    
}
