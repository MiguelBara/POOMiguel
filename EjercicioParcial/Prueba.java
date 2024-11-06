
package EjercicioParcial;

import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Garaje garaje = new Garaje();
        int opcion;

        do {
            System.out.println("Menu del Garaje:");
            System.out.println("1. Alquilar un espacio");
            System.out.println("2. Retirar vehiculo");
            System.out.println("3. Consulta de ingresos mensuales");
            System.out.println("4. Consulta proporcion autos / motos");
            System.out.println("5. Listado de matriculas y cuota mensual y tipo vehículo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese tipo de vehículo (moto/auto): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Ingrese marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Ingrese cilindraje: ");
                    int cilindraje = scanner.nextInt();

                    if (tipo.equalsIgnoreCase("moto")) {
                        System.out.print("¿Tiene sidecar? (true/false): ");
                        boolean tieneSidecar = scanner.nextBoolean();
                        Moto moto = new Moto(marca, precio, cilindraje, tieneSidecar);
                        System.out.print("Ingrese matrícula (6 caracteres): ");
                        String matriculaMoto = scanner.next();
                        if (moto.matricular(matriculaMoto)) {
                            if (garaje.alquilarEspacio(moto)) {
                                System.out.println("Moto alquilada exitosamente.");
                            } else {
                                System.out.println("No se pudo alquilar la moto.");
                            }
                        } else {
                            System.out.println("Matrícula inválida.");
                        }
                    } else if (tipo.equalsIgnoreCase("auto")) {
                        System.out.print("¿Tiene radio? (true/false): ");
                        boolean tieneRadio = scanner.nextBoolean();
                        System.out.print("¿Tiene navegador? (true/false): ");
                        boolean tieneNavegador = scanner.nextBoolean();
                        Auto auto = new Auto(marca, precio, cilindraje, tieneRadio, tieneNavegador);
                        System.out.print("Ingrese matrícula (6 caracteres): ");
                        String matriculaAuto = scanner.next();
                        if (auto.matricular(matriculaAuto)) {
                            if (garaje.alquilarEspacio(auto)) {
                                System.out.println("Auto alquilado exitosamente.");
                            } else {
                                System.out.println("No se pudo alquilar el auto.");
                            }
                        } else {
                            System.out.println("Matrícula inválida.");
                        }
                    } else {
                        System.out.println("Tipo de vehículo no reconocido.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese matrícula del vehículo a retirar: ");
                    String matriculaRetiro = scanner.nextLine();
                    if (garaje.retirarVehiculo(matriculaRetiro)) {
                        System.out.println("Vehículo retirado exitosamente.");
                    } else {
                        System.out.println("Vehículo no encontrado.");
                    }
                    break;

                case 3:
                    double ingresos = garaje.calcularIngresos();
                    System.out.println("Ingresos mensuales del garaje: " + ingresos);
                    break;

                case 4:
                    int ocupacionAutos = garaje.calcularOcupacionPorTipoVehiculo(new Auto("", 0, 0, false, false));
                    int ocupacionMotos = garaje.calcularOcupacionPorTipoVehiculo(new Moto("", 0, 0, false));
                    System.out.println("Ocupación de autos: " + ocupacionAutos);
                    System.out.println("Ocupación de motos: " + ocupacionMotos);
                    break;

                case 5:
                    System.out.println("Listado de vehículos en el garaje:");
                    garaje.listarVehiculos();
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }

            System.out.println(); // Línea en blanco para mejor legibilidad
        } while (opcion != 6);

        scanner.close(); // Cierra el scanner
    }
}