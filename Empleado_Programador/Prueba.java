package Empleado_Programador;

public class Prueba {
    public static void main(String[] args) {
        // Crear un empleado
        Empleado empleado1 = new Empleado("Juan Pérez", "12345678A", 30, true, 3000);
        System.out.println(empleado1);
        System.out.println("Clasificación: " + empleado1.clasifica());
        
        // Subir salario
        empleado1.subirSalario(10);
        System.out.println("Salario después de aumento: " + empleado1.getSalario());

        // Crear un programador
        Programador programador1 = new Programador("Ana Gómez", "87654321B", 25, false, 4000, 50, "Java");
        System}

}