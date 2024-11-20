package EjercicioParcial;

import java.util.ArrayList;
import java.util.Scanner;

public class Garaje {
    private ArrayList<Vehiculo> vehiculos;
    private int capacidad;

    public Garaje(int capacidad) {
        this.capacidad = capacidad;
        this.vehiculos = new ArrayList<>(capacidad);
    }

    // Método para buscar un vehículo por matrícula
    public int buscarVehiculo(String matricula) {
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getMatricula().equals(matricula)) {
                return i; // Retorna la posición del vehículo encontrado
            }
        }
        return -99; // Retorna -99 si no se encuentra
    }

    // Método para contar vehículos de un tipo determinado
    public int contarVehiculosPorTipo(Class<?> tipo) {
        int contador = 0;
        for (Vehiculo vehiculo : vehiculos) {
            if (tipo.isInstance(vehiculo)) {
                contador++;
            }
        }
        return contador;
    }

    // Método para alquilar un espacio
    public boolean alquilarEspacio(Vehiculo vehiculo) {
        int cantidadCamionetas = contarVehiculosPorTipo(Camioneta.class);
        int cantidadMotos = contarVehiculosPorTipo(Moto.class);

        // Validación para camionetas (20%)
        if (vehiculo instanceof Camioneta && cantidadCamionetas >= capacidad * 0.2) {
            System.out.println("No se puede alquilar espacio para más camionetas.");
            return false;
        }

        // Validación para motos (30%)
        if (vehiculo instanceof Moto && cantidadMotos >= capacidad * 0.3) {
            System.out.println("No se puede alquilar espacio para más motos.");
            return false;
        }

        // Si se pasa la validación, se agrega el vehículo
        vehiculos.add(vehiculo);
        return true;
    }

    // Método para calcular la proporción Auto/Moto/Camionetas
    public void calcularProporcion() {
        int cantidadCamionetas = contarVehiculosPorTipo(Camioneta.class);
        int cantidadMotos = contarVehiculosPorTipo(Moto.class);
        int cantidadAutos = contarVehiculosPorTipo(Auto.class);

        System.out.println("Proporción de vehículos:");
        System.out.println("Autos: " + cantidadAutos);
        System.out.println("Motos: " + cantidadMotos);
        System.out.println("Camionetas: " + cantidadCamionetas);
    }

    // Método para informar cuántas camionetas hay en el garaje por tipo
    public void informarCamionetasPorTipo() {
        int cantidadSUV = 0;
        int cantidadPickup = 0;
        int cantidadCarga = 0;
        int cantidadOtro = 0;

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Camioneta) {
                Camioneta camioneta = (Camioneta) vehiculo;
                switch (camioneta.getTipoServicio()) {
                    case SUV:
                        cantidadSUV++;
                        break;
                    case Pickup:
                        cantidadPickup++;
                        break;
                    case Carga:
                        cantidadCarga++;
                        break;
                    case Otro:
                        cantidadOtro++;
                        break;
                }
            }
        }

        System.out.println("Cantidad de camionetas por tipo:");
        System.out.println("SUV: " + cantidadSUV);
        System.out.println("Pickup: " + cantidadPickup);
        System.out.println("Carga: " + cantidadCarga);
        System.out.println("Otro: " + cantidadOtro);
    }

    // Método para mostrar el menú y manejar las opciones
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú del Garaje:");
            System.out.println("1. Alquilar espacio");
            System.out.println("2. Buscar vehículo por matrícula");
            System.out.println("3. Contar vehículos por tipo");
            System.out.println("4. Calcular proporción de vehículos");
            System.out.println("5. Informar camionetas por tipo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la matrícula del vehículo: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Ingrese el tipo de vehículo (Moto, Auto, Camioneta): ");
                    String tipo = scanner.nextLine();
                    Vehiculo vehiculo = null;
                    if (tipo.equalsIgnoreCase("Moto")) {
                        vehiculo = new Moto(matricula);
                    } else if (tipo.equalsIgnoreCase("Auto")) {
                        vehiculo = new Auto(matricula);
                    } else if (tipo.equalsIgnoreCase("Camioneta")) {
                        System.out.print("Ingrese el tipo de servicio (SUV, Pickup, Carga, Otro): ");
                        String tipoServicio = scanner.nextLine();
                        Camioneta.TipoServicio servicio = Camioneta.TipoServicio.valueOf(tipoServicio.toUpperCase());
                        vehiculo = new Camioneta(matricula, servicio);
                    } else {
                        System.out.println("Tipo de vehículo no reconocido.");
                    }

                    if (vehiculo != null && alquilarEspacio(vehiculo)) {
                        System.out.println("Vehículo alquilado exitosamente.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese la matrícula a buscar: ");
                    String matriculaBuscar = scanner.nextLine();
                    int posicion = buscarVehiculo(matriculaBuscar);
                    if (posicion != -99) {
                        System.out.println("Vehículo encontrado en la posición: " + posicion);
                    } else {
                        System.out.println("Vehículo no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el tipo de vehículo a contar (Moto, Auto, Camioneta): ");
                    String tipoContar = scanner.nextLine();
                    int cantidad = 0;
                    if (tipoContar.equalsIgnoreCase("Moto")) {
                        cantidad = contarVehiculosPorTipo(Moto.class);
                    } else if (tipoContar.equalsIgnoreCase("Auto")) {
                        cantidad = contarVehiculosPorTipo(Auto.class);
                    } else if (tipoContar.equalsIgnoreCase("Camioneta")) {
                        cantidad = contarVehiculosPorTipo(Camioneta.class);
                    } else {
                        System.out.println("Tipo de vehículo no reconocido.");
                    }
                    System.out.println("Cantidad de " + tipoContar + "s: " + cantidad);
                    break;

                case 4:
                    calcularProporcion();
                    break;

                case 5:
                    informarCamionetasPorTipo();
                    break;

                case 6:
                    System.out.println("Saliendo del menú.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

            System.out.println(); // Línea en blanco para mejor legibilidad
        } while (opcion != 6);

        scanner.close(); // Cerrar el escáner al finalizar
    }
}