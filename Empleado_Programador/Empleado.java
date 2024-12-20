package Empleado_Programador;

public class Empleado {
    private String nombre;
    private String dni;
    private int edad; // entre 18 y 45 años
    private boolean casado;
    private double salario;

    // Constructor parametrizado
    public Empleado(String nombre, String dni, int edad, boolean casado, double salario) {
        this.nombre = nombre;
        this.dni = dni;
        setEdad(edad); // Usar el setter para validar
        this.casado = casado;
        this.salario = salario;
    }

    // Constructor sin parametrizar
    public Empleado() {

    }

    // Método para clasificar según la edad
    public String clasifica() {
        if (edad <= 21) {
            return "Principiante";
        } else if (edad >= 22 && edad <= 35) {
            return "Intermedio";
        } else {
            return "Senior";
        }
    }

    // Método toString para imprimir los datos de un empleado
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "DNI: " + dni + "\n" +
                "Edad: " + edad + "\n" +
                "Casado: " + (casado ? "Sí" : "No") + "\n" +
                "Salario: " + salario;
    }

    // Método subir el salario
    public void subirSalario(int x) {
        salario += salario * x / 100.0;
    }

    // Getters y Setters
    public void setEdad(int edad) {
        if (edad < 18 || edad > 45) {
            throw new IllegalArgumentException("La edad debe estar entre 18 y 45 años.");
        }
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}