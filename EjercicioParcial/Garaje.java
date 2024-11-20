package EjercicioParcial;

import java.util.ArrayList;

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
            if (vehiculos.get(i).getMatricula().equals(matricula)) { // Suponiendo que hay un método getMatricula()
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
        int cantidadAutos = contarVehiculosPorTipo(Auto.class); // Suponiendo que hay una clase Auto

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
        int cantidadAutos = contarVehiculosPorTipo(Auto.class); // Suponiendo que hay una clase Auto

        System.out.println("Proporción de vehículos:");
        System.out.println("Autos: " + cantidadAutos);
        System.out.println("Motos: " + cantidadMotos);
        System.out.println("Camionetas: " + cantidadCamionetas);
    }

    // Método para informar cuántas camionetas hay en el garaje por tipo
    public void informarCamionetasPorTipo() {
        int cantidadSUV = contarVehiculosPorTipo(Camioneta.TipoServicio.SUV.getClass());
        int cantidadPickup = contarVehiculosPorTipo(Camioneta.TipoServicio.Pickup.getClass());
        int cantidadCarga = contarVehiculosPorTipo(Camioneta.TipoServicio.Carga.getClass());
        int cantidadOtro = contarVehiculosPorTipo(Camioneta.TipoServicio.Otro.getClass());

        System.out.println("Cantidad de camionetas por tipo:");
        System.out.println("SUV: " + cantidadSUV);
        System.out.println("Pickup: " + cantidadPickup);
        System.out.println("Carga: " + cantidadCarga);
        System.out.println("Otro: " + cantidadOtro);
    }
}