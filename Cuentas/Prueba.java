package Cuentas;

public class Prueba {
    public static void main(String[] args) {
        // Crear personas
        Persona persona1 = new Persona("Juan Pérez", "12345678A");
        Persona persona2 = new Persona("María López", "23456789B");

        // Crear cuentas
        CuentaCorriente cuentaCorriente = new CuentaCorriente(persona1, 1001, 500);
        CuentaAhorro cuentaAhorro = new CuentaAhorro(persona2, 2001, 1000);

        // Probar ingresar dinero
        System.out.println("Ingresando dinero en cuentas...");
        cuentaCorriente.ingresar(1000);
        cuentaAhorro.ingresar(1500);

        // Mostrar estado de las cuentas
        System.out.println(cuentaCorriente);
        System.out.println(cuentaAhorro);

        // Probar retirar dinero
        System.out.println("\nIntentando retirar dinero...");
        cuentaCorriente.retirar(300); // Debe funcionar
        cuentaAhorro.retirar(400); // Debe funcionar

        // Mostrar estado de las cuentas después de los retiros
        System.out.println(cuentaCorriente);
        System.out.println(cuentaAhorro);

        // Intentar retirar más de lo permitido
        System.out.println("\nIntentando retirar más de lo permitido...");
        cuentaCorriente.retirar(600); // No debe funcionar
        cuentaAhorro.retirar(1200); // No debe funcionar

        // Mostrar estado final de las cuentas
        System.out.println(cuentaCorriente);
        System.out.println(cuentaAhorro);
    }
}