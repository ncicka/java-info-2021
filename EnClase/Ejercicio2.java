/*
Realizar una función que calcule el factorial de un número dado.
*/
public class Ejercicio2 {
    public static void main(String[] args){

        float a = factorial(30);
        System.out.println(a);
    }

   public static float  factorial(float num){
        if (num>= 1){
            //System.out.println(num);
            return num * factorial(num -1);
        }
        return 1;
    }
        
}
