

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio3 {

    public static void main(String[] args)
    {
        ArrayList<Integer> baraja = new ArrayList<>();
        generarBaraja(baraja);
        verBaraja(baraja);
        System.out.println("Invertir baraja ");
        Collections.reverse(baraja);
        verBaraja(baraja);
        System.out.println("Desordenar baraja ");
        Collections.shuffle(baraja);
        verBaraja(baraja);
    }

    public static void generarBaraja(List<Integer> lis){
        for (int i = 0; i < 13; i++) {
            lis.add(i+1);
        }
    }
    public static void verBaraja(List<Integer> lis){
        for (Integer valor : lis) {
            System.out.println(valor);
        }
    }
}
