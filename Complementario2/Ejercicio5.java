

import java.util.ArrayList;
import java.util.List;

public class Ejercicio5 {
    public static void main(String[] args){
        ArrayList<Integer> horasTrabajadas = new ArrayList<>();
        ArrayList<Integer> valorPorHora = new ArrayList<>();
        ArrayList<Integer> totales = new ArrayList<>();

        cargaHoras(horasTrabajadas);
        cargaValor(valorPorHora);
        cargaTotales(horasTrabajadas, valorPorHora, totales);
        System.out.println(totales);
        System.out.println("Total Final: $"+verTotal(totales));

    }

    public static void cargaHoras(List<Integer> lis){
        lis.add(6);
        lis.add(7);
        lis.add(8);
        lis.add(4);
        lis.add(5);
    }

    public static void cargaValor(List<Integer> lis){
        lis.add(350);
        lis.add(345);
        lis.add(550);
        lis.add(600);
        lis.add(320);
    }

    public static void cargaTotales(List<Integer> horas, List<Integer> valores, List<Integer> total){
        for (int i = 0; i < valores.size(); i++) {
            total.add(valores.get(i)*horas.get(i));
        }
    }

    public static int verTotal(List<Integer> totales){
        int t = 0;
        for (Integer valor : totales) {
            t = t + valor;
        }
        return t;
    }
}
