package Prueba;

import Garajes.*;
import Vehiculos.*;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de gestion de garajes");

        // Crear un garaje como ejemplo
        Garaje garaje = new Garaje(
                "Cundinamarca", "Bogota", "Calle 123 #45-67",
                "3201234567", "admin@garaje.com", "Juan Perez",
                50 // Número de espacios
        );

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");

            try {
                switch (opcion) {
                    case 1:
                        alquilarEspacio(garaje);
                        break;
                    case 2:
                        retirarVehiculo(garaje);
                        break;
                    case 3:
                        consultarIngresos(garaje);
                        break;
                    case 4:
                        consultarProporcion(garaje);
                        break;
                    case 5:
                        listarVehiculos(garaje);
                        break;
                    case 6:
                        buscarVehiculo(garaje);
                        break;
                    case 7:
                        System.out.println("¡Gracias por usar el sistema de gestion de garajes!");
                        break;
                    default:
                        System.out.println("Opcion no valida, intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 7);
    }

    private static void mostrarMenu() {
        System.out.println("\n---- Menu de opciones ----");
        System.out.println("1. Alquilar un espacio");
        System.out.println("2. Retirar un vehiculo");
        System.out.println("3. Consulta de ingresos mensuales");
        System.out.println("4. Consulta proporcion autos / motos / camionetas");
        System.out.println("5. Listado de matriculas y cuota mensual");
        System.out.println("6. Buscar un vehiculo");
        System.out.println("7. Salir");
    }

    private static void alquilarEspacio(Garaje garaje) throws Exception {
        System.out.println("\n-- Alquilar un espacio --");

        if (garaje.obtenerOcupacionActual() >= garaje.getNumeroEspacios()) {
            throw new Exception("No hay espacios disponibles en este garaje.");
        }

        String tipo = leerCadena("Ingrese el tipo de vehiculo (Moto, Auto, Camioneta): ").toLowerCase();
        Vehiculo vehiculo;

        switch (tipo) {
            case "moto":
                if (garaje.contarMotos() >= garaje.getNumeroEspacios() * 0.2) {
                    throw new Exception("No se pueden alquilar más espacios para motos (máximo 20% del total).");
                }
                vehiculo = new Moto(
                        leerCadena("Ingrese la marca: "),
                        leerDouble("Ingrese el precio: "),
                        leerEntero("Ingrese el cilindraje: "),
                        leerBooleano("¿Tiene sidecar? (true/false): "));
                break;

            case "auto":
                vehiculo = new Auto(
                        leerCadena("Ingrese la marca: "),
                        leerDouble("Ingrese el precio: "),
                        leerEntero("Ingrese el cilindraje: "),
                        leerBooleano("¿Tiene radio? (true/false): "),
                        leerBooleano("¿Tiene navegador? (true/false): "));
                break;

            case "camioneta":
                if (garaje.contarCamionetas() >= garaje.getNumeroEspacios() * 0.2) {
                    throw new Exception("No se pueden alquilar mas espacios para camionetas (máximo 20% del total).");
                }
                vehiculo = new Camioneta(
                        leerCadena("Ingrese la marca: "),
                        leerDouble("Ingrese el precio: "),
                        leerEntero("Ingrese el cilindraje: "),
                        leerCadena("Ingrese el tipo de servicio (SUV, Pickup, Carga, Otro): "),
                        leerEntero("Ingrese el numero de pasajeros: "),
                        leerBooleano("¿Tiene remolque? (true/false): "));
                break;

            default:
                throw new Exception("Tipo de vehículo no válido.");
        }

        String placa = leerCadena("Ingrese la placa (6 caracteres): ");
        if (!vehiculo.matricular(placa)) {
            throw new Exception("La matrícula debe tener exactamente 6 caracteres.");
        }

        if (garaje.buscarVehiculo(placa) != null) {
            throw new Exception("El veheculo con esta placa ya está registrado en el garaje.");
        }

        garaje.ingresarVehiculo(vehiculo);
        System.out.println("Vehiculo registrado con exito.");
    }

    private static void retirarVehiculo(Garaje garaje) throws Exception {
        System.out.println("\n-- Retirar un vehículo --");
        String placa = leerCadena("Ingrese la placa del vehículo a retirar: ");
        garaje.retirarVehiculo(placa);
        System.out.println("Vehiculo retirado con éxito.");
    }

    private static void consultarIngresos(Garaje garaje) {
        System.out.println("\n-- Consulta de ingresos mensuales --");
        double ingresos = garaje.calcularIngresos();
        System.out.println("Ingresos mensuales totales: $" + ingresos);
    }

    private static void consultarProporcion(Garaje garaje) {
        System.out.println("\n-- Consulta de proporción autos / motos / camionetas --");
        long numAutos = garaje.contarAutos();
        long numMotos = garaje.contarMotos();
        long numCamionetas = garaje.contarCamionetas();
        System.out.println("Autos: " + numAutos);
        System.out.println("Motos: " + numMotos);
        System.out.println("Camionetas: " + numCamionetas);
    }

    private static void listarVehiculos(Garaje garaje) {
        System.out.println("\n-- Listado de matriculas y cuota mensual --");
        if (garaje.obtenerOcupacionActual() == 0) {
            System.out.println("No hay vehiculos registrados.");
        } else {
            garaje.getVehiculos().forEach(v -> System.out.println("Placa: " + v.getPlaca() + ", Cuota: $"
                    + v.getCuotaMesGaraje() + ", Tipo: " + v.getClass().getSimpleName()));
        }
    }

    private static void buscarVehiculo(Garaje garaje) {
        System.out.println("\n-- Buscar un vehiculo --");
        String placa = leerCadena("Ingrese la placa: ");
        Vehiculo vehiculo = garaje.buscarVehiculo(placa);
        if (vehiculo == null) {
            System.out.println("El vehiculo no esta registrado.");
        } else {
            System.out.println(
                    "Vehiculo encontrado: " + vehiculo.getClass().getSimpleName() + ", Placa: " + vehiculo.getPlaca());
        }
    }

    private static String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un numero valido.");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return valor;
    }

    private static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, ingrese un numero valido.");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
        return valor;
    }

    private static boolean leerBooleano(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextBoolean()) {
            System.out.println("Por favor, ingrese true o false.");
            scanner.next();
        }
        boolean valor = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar buffer
        return valor;
    }
}
