

//Excepciones no chequeadas
public class ExcepcionesEjemplos{
    
    public static void main(String[] args){

        try{
            System.out.println("Cargar un array de 3 elementos");

            int[] dnis = new int[]{12345678, 12345679, 12345670};
            imprimirCuartoElemento(dnis);

            // Integer horasTrabajadasEnMes = 0;
            // //Integer diasTrabajados = 0;
            // Integer diasTrabajados = null;
            // System.out.println("El promedio de horas trabajadas del empleado es: "
            // + horasTrabajadasEnMes / diasTrabajados + " por día"); //ArithmeticException
        } catch(Exception exp){
            System.out.println(("Exepcion ocurrida: "+exp));
        }
    }

    public static void imprimirCuartoElemento(int[] array){
        System.out.println("Este es el 4to elemento: "+array[3]); //ArraysIndexOutOfBoundsException
    }
}