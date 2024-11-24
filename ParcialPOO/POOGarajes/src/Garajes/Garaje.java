package Garajes;

import Vehiculos.*;

import java.util.ArrayList;
import java.util.List;

public class Garaje implements IGarage {
    private String departamento;
    private String ciudad;
    private String direccion;
    private String telefono;
    private String email;
    private String nombreAdministrador;
    private int numeroEspacios;
    private List<Vehiculo> vehiculos;

    public Garaje(String departamento, String ciudad, String direccion, String telefono, String email, String nombreAdministrador, int numeroEspacios) {
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.nombreAdministrador = nombreAdministrador;
        this.numeroEspacios = numeroEspacios;
        this.vehiculos = new ArrayList<>();
    }

    // Implementación de la interfaz IGarage

    @Override
    public double calcularIngresos() {
        double totalIngresos = 0;
        for (Vehiculo vehiculo : vehiculos) {
            totalIngresos += vehiculo.getCuotaMesGaraje();
        }
        return totalIngresos;
    }

    @Override
    public int calcularOcupacionPorTipoVehiculo(Class<?> tipoVehiculo) {
        int count = 0;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getClass().equals(tipoVehiculo)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void ingresarVehiculo(Vehiculo vehiculo) {
        if (vehiculos.size() < numeroEspacios) {
            vehiculos.add(vehiculo);
        } else {
            System.out.println("No hay espacio disponible en el garaje.");
        }
    }

    @Override
    public void retirarVehiculo(String placa) {
        Vehiculo vehiculoARetirar = buscarVehiculo(placa);
        if (vehiculoARetirar != null) {
            vehiculos.remove(vehiculoARetirar);
        } else {
            System.out.println("Vehículo con placa " + placa + " no encontrado.");
        }
    }

    @Override
    public Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;
            }
        }
        return null; // Si no lo encuentra, retorna null
    }

    // Métodos adicionales para obtener información del garaje

    public int obtenerOcupacionActual() {
        return vehiculos.size();
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public int getNumeroEspacios() {
        return numeroEspacios;
    }

    // Métodos de conteo para vehículos específicos
    public int contarMotos() {
        return calcularOcupacionPorTipoVehiculo(Moto.class);
    }

    public int contarAutos() {
        return calcularOcupacionPorTipoVehiculo(Auto.class);
    }

    public int contarCamionetas() {
        return calcularOcupacionPorTipoVehiculo(Camioneta.class);
    }

    // Métodos de validación según las reglas de ocupación
    public boolean validarOcupacionMoto() {
        int maxMotos = (int) (numeroEspacios * 0.2);
        return contarMotos() < maxMotos;
    }

    public boolean validarOcupacionCamioneta() {
        int maxCamionetas = (numeroEspacios < 100) ? 10 : 20;
        return contarCamionetas() < maxCamionetas;
    }

    public boolean validarEspaciosDisponibles() {
        return obtenerOcupacionActual() < numeroEspacios;
    }

    // Métodos para mostrar la ocupación por tipo de vehículo
    public void mostrarOcupacionPorTipo() {
        System.out.println("Motos: " + contarMotos());
        System.out.println("Autos: " + contarAutos());
        System.out.println("Camionetas: " + contarCamionetas());
    }

    Object getDireccion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getTelefono() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
