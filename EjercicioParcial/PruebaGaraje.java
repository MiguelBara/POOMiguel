package EjercicioParcial;

import java.util.Scanner;

public class PruebaGaraje {
    public static void main(String[] args) {
        Garaje garaje = new Garaje();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú del Garaje");
            System.out.println("1. Alquilar un espacio");
            System.out.println("2. Retirar vehículo");
            System.out.println("3. Consulta de ingresos mensuales");
            System.out.println("4. Consulta proporción Autos / Motos / Camionetas");
            System.out.println("5. Listado de matrículas y cuota mensual y tipo vehículo");
            System.out.println("6. Buscar vehículo por matrícula");
            System.out.println("7. Informe de camionetas por tipo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Código para alquilar un espacio
                    break;
                case 2:
                    // Código para retirar un vehículo
                    break;
                case 3:
                    System.out.println("Ingresos mensuales: " + garaje.calcularIngresos());
                    break;
                case 4:
                    // Código para calcular proporción Autos / Motos / Camionetas
                    break;
                case 5:
                    // Código para listar matrículas y cuotas
                    break;
                case 6:
                    System.out.print("Ingrese matrícula a buscar: ");
                    String matricula = scanner.next();
                    int posicion = garaje.buscarVehiculoPorMatricula(matricula);
                    if (posicion == -99) {
                        System.out.println("Vehículo no encontrado.");
                    } else {
                        System.out.println("Vehículo encontrado en la posición: " + posicion);
                    }
                    break;
                case 7:
                    // Código para informar sobre camionetas por tipo
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
