package CochesMatriculados;

public class Prueba {
    public static void main(String[] args) {
        // Crear un coche
        Coche coche1 = new Coche("Toyota", "Rojo", 20000, 0.1, 2015);
        coche1.setDniTitular("12345678A");
        coche1.setMatricula("ABC1234");

        // Mostrar información del coche
        System.out.println("Coche 1:");
        System.out.println("Marca: " + coche1.getMarca());
        System.out.println("Color: " + coche1.getColor());
        System.out.println("Kilómetros: " + coche1.getKm());
        System.out.println("Precio: " + coche1.getPrecio());
        System.out.println("Año: " + coche1.getAnio());
        System.out.println("Matrícula: " + coche1.getMatricula());
        System.out.println("DNI del titular: " + coche1.getDniTitular());

        // Crear un objeto de la clase CocheMatriculado
        CocheMatriculado cocheMatriculado = new CocheMatriculado("Ford", "Azul", 25000, 0.2, 2010,
                "XYZ5678", "87654321B", 2010, 5);

        // Mostrar información del coche matriculado
        System.out.println("\nCoche Matriculado:");
        System.out.println("Marca: " + cocheMatriculado.getMarca());
        System.out.println("Color: " + cocheMatriculado.getColor());
        System.out.println("Kilómetros: " + cocheMatriculado.getKm());
        System.out.println("Precio: " + cocheMatriculado.getPrecio());
        System.out.println("Año: " + cocheMatriculado.getAnio());
        System.out.println("Matrícula: " + cocheMatriculado.getMatricula());
        System.out.println("DNI del titular: " + cocheMatriculado.getDniTitular());
        System.out.println("Año de matriculación: " + cocheMatriculado.getAnioMatriculacion());
        System.out.println("Mes de matriculación: " + cocheMatriculado.getMesMatriculacion());
        System.out.println("Impuesto de matriculación: " + cocheMatriculado.getImpuestoMatriculacion());

        // Probar el método de compra de coche
        Coche coche2 = new Coche("Honda", "Verde", 18000, 0.15, 2018);
        coche2.setDniTitular("11223344C");
        coche2.setMatricula("DEF5678");

        System.out.println("\nAntes de comprar:");
        System.out.println("DNI del titular del coche 1: " + coche1.getDniTitular());
        System.out.println("DNI del titular del coche 2: " + coche2.getDniTitular());

        coche1.comprarCoche(coche2);

        System.out.println("\nDespués de comprar:");
        System.out.println("DNI del titular del coche 1: " + coche1.getDniTitular());
        System.out.println("DNI del titular del coche 2: " + coche2.getDniTitular());
    }
}