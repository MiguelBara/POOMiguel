package EjercicioParcial;

import java.util.ArrayList;
import java.util.List;

public class Garaje implements IGaraje {
    private static final int MAX_ESPACIOS = 100;
    private List<Vehiculo> espacios = new ArrayList<>();

    @Override
    public double calcularIngresos() {
        return espacios.stream().mapToDouble(Vehiculo::getCuotaMesGaraje).sum();
    }

    @Override
    public int calcularOcupacionPorTipoVehiculo(Class<? extends Vehiculo> tipoVehiculo) {
        return (int) espacios.stream().filter(tipoVehiculo::isInstance).count();
    }

    public int buscarVehiculoPorMatricula(String matricula) {
        for (int i = 0; i < espacios.size(); i++) {
            if (espacios.get(i).getPlaca() != null && espacios.get(i).getPlaca().equals(matricula)) {
                return i;
            }
        }
        return -99;
    }

    public boolean alquilarEspacio(Vehiculo vehiculo) {
        if (espacios.size() >= MAX_ESPACIOS)
            return false;

        long numMotos = calcularOcupacionPorTipoVehiculo(Moto.class);
        long numCamionetas = calcularOcupacionPorTipoVehiculo(Camioneta.class);

        if (vehiculo instanceof Moto && numMotos >= 0.3 * MAX_ESPACIOS)
            return false;
        if (vehiculo instanceof Camioneta && numCamionetas >= 0.2 * MAX_ESPACIOS)
            return false;

        if (vehiculo.getPlaca() == null)
            return false;

        espacios.add(vehiculo);
        return true;
    }

    public boolean retirarVehiculo(String matricula) {
        int posicion = buscarVehiculoPorMatricula(matricula);
        if (posicion != -99) {
            espacios.remove(posicion);
            return true;
        }
        return false;
    }
}
