package Garajes;


import java.util.ArrayList;
import java.util.List;

public class RedGarajes {
    private List<Garaje> garajes;

    public RedGarajes() {
        this.garajes = new ArrayList<>();
    }

    // Método para agregar un nuevo garaje a la red
    public void agregarGaraje(Garaje garaje) {
        garajes.add(garaje);
    }

    // Método para eliminar un garaje de la red por su dirección
    public boolean eliminarGaraje(String direccion) {
        for (Garaje garaje : garajes) {
            if (garaje.getDireccion().equals(direccion)) {
                garajes.remove(garaje);
                return true;
            }
        }
        return false;
    }

    // Método para actualizar un garaje en la red, usando su dirección para buscarlo
    public boolean actualizarGaraje(String direccion, Garaje nuevoGaraje) {
        for (int i = 0; i < garajes.size(); i++) {
            if (garajes.get(i).getDireccion().equals(direccion)) {
                garajes.set(i, nuevoGaraje);
                return true;
            }
        }
        return false;
    }

    // Método para obtener un garaje específico por su dirección
    public Garaje obtenerGarajePorDireccion(String direccion) {
        for (Garaje garaje : garajes) {
            if (garaje.getDireccion().equals(direccion)) {
                return garaje;
            }
        }
        return null;  // Si no se encuentra el garaje
    }

    // Método para obtener la cantidad total de vehículos en la red de garajes
    public int obtenerTotalVehiculos() {
        int total = 0;
        for (Garaje garaje : garajes) {
            total += garaje.obtenerOcupacionActual();
        }
        return total;
    }

    // Método para obtener el recaudo mensual total de la red de garajes
    public double obtenerRecaudoMensualTotal() {
        double totalRecaudo = 0;
        for (Garaje garaje : garajes) {
            totalRecaudo += garaje.calcularIngresos();
        }
        return totalRecaudo;
    }

    // Método para mostrar la ocupación de todos los garajes
    public void mostrarOcupacionDeTodosLosGarajes() {
        for (Garaje garaje : garajes) {
            System.out.println("Garaje en " + garaje.getDireccion() + ":");
            System.out.println("Ocupación: " + garaje.obtenerOcupacionActual() + "/" + garaje.getNumeroEspacios());
            garaje.mostrarOcupacionPorTipo();
        }
    }

    // Método para mostrar el listado de garajes en la red
    public void listarGarajes() {
        if (garajes.isEmpty()) {
            System.out.println("No hay garajes en la red.");
        } else {
            for (Garaje garaje : garajes) {
                System.out.println("Garaje en " + garaje.getDireccion() + " - Teléfono: " + garaje.getTelefono());
            }
        }
    }

    // Métodos para obtener estadísticas específicas por tipo de vehículo
    public int contarMotosEnRed() {
        int totalMotos = 0;
        for (Garaje garaje : garajes) {
            totalMotos += garaje.contarMotos();
        }
        return totalMotos;
    }

    public int contarAutosEnRed() {
        int totalAutos = 0;
        for (Garaje garaje : garajes) {
            totalAutos += garaje.contarAutos();
        }
        return totalAutos;
    }

    public int contarCamionetasEnRed() {
        int totalCamionetas = 0;
        for (Garaje garaje : garajes) {
            totalCamionetas += garaje.contarCamionetas();
        }
        return totalCamionetas;
    }
}
