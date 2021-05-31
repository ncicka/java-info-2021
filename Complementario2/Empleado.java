package Complementario2;

public class Empleado {

    private int dni;
    private String nombre;
    private String apellido;
    private int horasTrabajadas;
    private double valorHora;

    public Empleado(int dni, String nombre, String apellido, int horas, double valor){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.horasTrabajadas = horas;
        this.valorHora = valor;
    }

    public double Sueldo(){
        return this.horasTrabajadas * this.valorHora;
    }

    public int getDni(){
        return this.dni;
    }

    public int getHoras(){
        return this.horasTrabajadas;
    }

    @Override
    public String toString() {
        return this.apellido+", "+this.nombre;
    }
    
}
