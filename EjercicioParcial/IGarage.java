package EjercicioParcial;

public interface IGarage {
    double calcularIngresos();

    int calcularOcupacionPorTipoVehiculo(Class<? extends Vehiculo> tipoVehiculo);
}
