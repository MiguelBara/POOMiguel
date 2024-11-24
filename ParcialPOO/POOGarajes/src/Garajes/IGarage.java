package Garajes;

import Vehiculos.Vehiculo;

public interface IGarage {
    double calcularIngresos(); // Método para calcular los ingresos mensuales
    int calcularOcupacionPorTipoVehiculo(Class<?> tipoVehiculo); // Método para contar vehículos por tipo
    void ingresarVehiculo(Vehiculo vehiculo); // Método para ingresar un vehículo al garaje
    void retirarVehiculo(String placa); // Método para retirar un vehículo usando su placa
    Vehiculo buscarVehiculo(String placa); // Método para buscar un vehículo por su placa
}
