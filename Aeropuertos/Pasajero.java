
package Aeropuertos;

public class Pasajero {
    private String nombre;
    private String dni;
    private int edad;

    public Pasajero(String nombre, String dni, int edad) { // constructor parametrizado
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Pasajero() { // constructor sin parametrizar
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                '}';
    }

}