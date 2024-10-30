package Aeropuertos;

import java.util.List;

public class Biberia {
    public static void main(String[] args) {
        // Crear aeropuertos
        AeropuertoComercial aeropuerto1 = new AeropuertoComercial("Aeropuerto A", "Ciudad A", 3);
        AeropuertoComercial aeropuerto2 = new AeropuertoComercial("Aeropuerto B", "Ciudad B", 2);
        AeropuertoMilitar aeropuertoMilitar = new AeropuertoMilitar("Aeropuerto Militar", "Ciudad C", "Eagle");

        // Crear aviones
        AvionPasajeros avionPasajeros = new AvionPasajeros("Avión de Pasajeros 1", "ABC123", 1500, 180);
        AvionCarga avionCarga = new AvionCarga("Avión de Carga 1", "XYZ456", 2000, 10000);
        Avioneta avioneta = new Avioneta("Avioneta 1", "AVN789", 800, 4);

        // Agregar pasajeros
        avionPasajeros.agregarPasajero(new Pasajero("Juan Pérez", "12345678A", 30));
        avionPasajeros.agregarPasajero(new Pasajero("Ana Gómez", "87654321B", 25));
        avioneta.agregarPasajero(new Pasajero("Luis Martínez", "11223344C", 22));

        // Agregar aviones a los aeropuertos
        aeropuerto1.agregarAvion(avionPasajeros);
        aeropuerto1.agregarAvion(avionCarga);
        aeropuerto2.agregarAvion(avioneta);
        aeropuertoMilitar.agregarAvion(avionCarga); // Ejemplo de asignación

        // Mostrar información de los aeropuertos y sus aviones
        System.out.println("Información del Aeropuerto A:");
        aeropuerto1.mostrarInformacionAviones();

        System.out.println("\nInformación del Aeropuerto B:");
        aeropuerto2.mostrarInformacionAviones();

        System.out.println("\nInformación del Aeropuerto Militar:");
        aeropuertoMilitar.mostrarInformacionAviones();

        // Consultar información de un pasajero
        String nombreBuscado = "Juan Pérez";
        buscarPasajero(nombreBuscado, aeropuerto1, aeropuerto2, aeropuertoMilitar);
    }

    public static void buscarPasajero(String nombre, Aeropuerto... aeropuertos) {
        for (Aeropuerto aeropuerto : aeropuertos) {
            for (Avion avion : aeropuerto.getAviones()) {
                for (Pasajero pasajero : avion.getPasajeros()) {
                    if (pasajero.getNombre().equalsIgnoreCase(nombre)) {
                        System.out.println("Pasajero " + nombre + " encontrado en el avión " + avion.getNombre() +
                                " (Matrícula: " + avion.getMatricula() + ") en el aeropuerto " + aeropuerto.getNombre()
                                +
                                " (Ciudad: " + aeropuerto.getCiudad() + ")");
                        return;
                    }
                }
            }
        }
        System.out.println("Pasajero " + nombre + " no encontrado.");
    }
}