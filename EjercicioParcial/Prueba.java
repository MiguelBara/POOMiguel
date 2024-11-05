package EjercicioParcial;

import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        Garaje garaje = new Garaje();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do { // do while es la mas adecuada para un menu
             // Menú de opciones
            System.out.println("\nMenú de gestión del Garaje:");
            System.out.println("1. Alquilar un espacio");
            System.out.println("2. Retirar vehículo");
            System.out.println("3. Consulta de ingresos mensuales");
            System.out.println("4. Consulta proporción autos / motos");
            System.out.println("5. Listado de matrículas y cuota mensual y tipo vehículo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Leer siguiente linea

            switch (opcion) {
                case 1:
                    // Lógica para alquilar un espacio
                    System.out.println("Ingrese el tipo de vehículo (1 para Auto, 2 para Moto): ");
                    int tipoVehiculo = scanner.nextInt();
                    scanner.nextLine(); // Leer la siguiente línea

                    System.out.print("Ingrese la marca del vehículo: ");
                    String marca = scanner.nextLine();

                    System.out.print("Ingrese el precio del vehículo: ");
                    double precio = scanner.nextDouble();

                    System.out.print("Ingrese el cilindraje del vehículo: ");
                    int cilindraje = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Vehiculo vehiculo = null;

                    if (tipoVehiculo == 1) {
                        // Crear un Auto
                        System.out.print("¿Tiene radio? (true/false): ");
                        boolean tieneRadio = scanner.nextBoolean();
                        System.out.print("¿Tiene navegador? (true/false): ");
                        boolean tieneNavegador = scanner.nextBoolean();

                        vehiculo = new Auto(marca, precio, cilindraje, tieneRadio, tieneNavegador);
                    } else if (tipoVehiculo == 2) {
                        // Crear una Moto
                        System.out.print("¿Tiene sidecar? (true/false): ");
                        boolean tieneSidecar = scanner.nextBoolean();

                        vehiculo = new Moto(marca, precio, cilindraje, tieneSidecar);
                    }

                    if (vehiculo != null) {
                        System.out.print("Ingrese la matrícula del vehículo (6 caracteres): ");
                        String matricula = scanner.next();
                        if (vehiculo.setPlaca(matricula)) {
                            if (garaje.alquilarEspacio(vehiculo)) {
                                System.out.println("Vehículo alquilado con éxito.");
                            } else {
                                System.out.println("No se pudo alquilar el espacio. Verifique las condiciones.");
                            }
                        } else {
                            System.out.println("Matrícula inválida. Debe tener 6 caracteres.");
                        }
                    }
                    break;

                case 2:
                    // Lógica para retirar un vehículo
                    System.out.print("Ingrese la matrícula del vehículo a retirar: ");
                    String matriculaRetirar = scanner.next();
                    if (garaje.retirarVehiculo(matriculaRetirar)) {
                        System.out.println("Vehículo retirado con éxito.");
                    } else {
                        System.out.println("No se encontró un vehículo con esa matrícula.");
                    }
                    break;

                case 3:
                    // Consulta de ingresos mensuales
                    System.out.println("Ingresos mensuales: " + garaje.calcularIngresos());
                    break;

                case 4:
                    // Consulta proporción autos / motos
                    int autos = garaje.calcularOcupacionPorTipoVehiculo(Auto.class);
                    int motos = garaje.calcularOcupacionPorTipoVehiculo(Moto.class);
                    System.out.println("Autos: " + autos + ", Motos: " + motos);
                    if (autos + motos > 0) {
                        double proporcion = (double) autos / (autos + motos);
                        System.out.println("Proporción Autos / Motos: " + proporcion);
                    } else {
                        System.out.println("No hay vehículos en el garaje.");
                    }
                    break;

                case 5:
                    // Listado de matrículas, cuota mensual y tipo de vehículo
                    System.out.println("Listado de vehículos en el garaje:");
                    for (int i = 0; i < garaje.getOcupados(); i++) {
                        Vehiculo v = garaje.getEspacio(i);
                        if (v != null) {
                            String tipo = (v instanceof Auto) ? "Auto" : "Moto";
                            System.out.println("Matrícula: " + v.getPlaca() + ", Cuota: " + v.getCuotaMesGaraje()
                                    + ", Tipo: " + tipo);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
