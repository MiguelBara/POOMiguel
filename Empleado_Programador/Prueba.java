package Empleado_Programador;

public class Prueba {
    public static void main(String[] args) {
        // Crear un empleado
        Empleado empleado1 = new Empleado("Juan Pérez", "12345678A", 30, true, 3000);
        System.out.println("Empleado 1:");
        System.out.println(empleado1);
        System.out.println("Clasificación: " + empleado1.clasifica());

        // Subir salario
        empleado1.subirSalario(10);
        System.out.println("Salario después de aumento: " + empleado1.getSalario());
        System.out.println();

        // Crear otro empleado
        Empleado empleado2 = new Empleado("María López", "23456789B", 22, false, 2800);
        System.out.println("Empleado 2:");
        System.out.println(empleado2);
        System.out.println("Clasificación: " + empleado2.clasifica());
        System.out.println();

        // Crear un programador
        Programador programador1 = new Programador("Ana Gómez", "87654321B", 25, false, 4000, 50, "Java");
        System.out.println("Programador 1:");
        System.out.println(programador1);
        System.out.println("Clasificación: " + programador1.clasifica());
        System.out.println("Salario calculado: " + programador1.calculaSalario());

        // Subir salario del programador
        programador1.subirSalario(15);
        System.out.println("Salario después de aumento: " + programador1.getSalario());
        System.out.println();

        // Crear otro programador
        Programador programador2 = new Programador("Luis Martínez", "34567890C", 35, true, 5000, 60, "Python");
        System.out.println("Programador 2:");
        System.out.println(programador2);
        System.out.println("Clasificación: " + programador2.clasifica());
        System.out.println("Salario calculado: " + programador2.calculaSalario());

        // Subir salario del segundo programador
        programador2.subirSalario(20);
        System.out.println("Salario después de aumento: " + programador2.getSalario());
    }
}