package EjercicioParcial;

public class Garaje implements IGaraje {
    private static final int NUM_ESPACIOS = 10; // Número máximo de espacios en el garaje
    private final Vehiculo[] vehiculos; // Arreglo de vehículos en el garaje
    private int contadorVehiculos; // Contador de vehículos ocupando espacios

    public Garaje() {
        vehiculos = new Vehiculo[NUM_ESPACIOS]; // Inicializa el arreglo de vehículos
        contadorVehiculos = 0; // Inicializa el contador de vehículos
    }

    // Método para alquilar un espacio para un vehículo
    public boolean alquilarEspacio(Vehiculo vehiculo) {
        if (vehiculo == null || vehiculo.getPlaca() == null) {
            return false; // No se puede alquilar un espacio sin vehículo o matrícula
        }

        if (contadorVehiculos < NUM_ESPACIOS) {
            int motosCount = calcularOcupacionPorTipoVehiculo(new Moto("", 0, 0, false)); // Contar motos
            // Verifica que no haya más del 80% de plazas ocupadas por motos
            if (motosCount < 0.8 * NUM_ESPACIOS || !(vehiculo instanceof Moto)) {
                vehiculos[contadorVehiculos] = vehiculo; // Agrega el vehículo al arreglo
                contadorVehiculos++; // Incrementa el contador de vehículos
                return true; // Alquiler exitoso
            }
        }
        return false; // No se pudo alquilar el espacio
    }

    // Método para retirar un vehículo del garaje
    public boolean retirarVehiculo(String matricula) {
        for (int i = 0; i < contadorVehiculos; i++) {
            if (vehiculos[i].getPlaca().equals(matricula)) {
                // Mueve el último vehículo al lugar del vehículo que se retira
                vehiculos[i] = vehiculos[contadorVehiculos - 1];
                vehiculos[contadorVehiculos - 1] = null; // Limpia el último espacio
                contadorVehiculos--; // Decrementa el contador de vehículos
                return true; // Vehículo retirado exitosamente
            }
        }
        return false; // Vehículo no encontrado
    }

    // Método para calcular los ingresos mensuales del garaje
    public double calcularIngresos() {
        double ingresos = 0;
        for (int i = 0; i < contadorVehiculos; i++) {
            ingresos += vehiculos[i].getCuotaMesGaraje(); // Suma la cuota mensual de cada vehículo
        }
        return ingresos; // Retorna el total de ingresos
    }

    // Método para calcular la ocupación por tipo de vehículo
    @Override
    public int calcularOcupacionPorTipoVehiculo(Vehiculo v) {
        int count = 0;
        for (int i = 0; i < contadorVehiculos; i++) {
            if (vehiculos[i].getClass() == v.getClass()) {
                count++; // Incrementa el contador si es del mismo tipo
            }
        }
        return count; // Retorna el número de vehículos del tipo especificado
    }

    // Método para listar todos los vehículos en el garaje
    public void listarVehiculos() {
        for (int i = 0; i < contadorVehiculos; i++) {
            String tipo = (vehiculos[i] instanceof Moto) ? "Moto" : "Auto"; // Determina el tipo de vehículo
            System.out.println("Matrícula: " + vehiculos[i].getPlaca() + ", Cuota Mensual: "
                    + vehiculos[i].getCuotaMesGaraje() + ", Tipo: " + tipo);
        }
    }

    @Override
    public double CalcularIngresos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}