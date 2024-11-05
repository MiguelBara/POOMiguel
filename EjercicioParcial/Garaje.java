package EjercicioParcial;

public class Garaje implements IGaraje {
    private Vehiculo[] espacios; // Array de vehículos en el garaje
    private static final int NUM_ESPACIOS = 10; // Número máximo de espacios en el garaje
    private static final double PORCENTAJE_MAXIMO_MOTOS = 0.8; // Porcentaje máximo de espacios ocupados por motos

    // Constructor que inicializa el array de vehículos
    public Garaje() {
        espacios = new Vehiculo[NUM_ESPACIOS]; // Inicializa el array con el tamaño máximo
    }

    // Método para alquilar un espacio a un vehículo
    public boolean alquilarEspacio(Vehiculo vehiculo) {
        // Verifica que no se exceda el número de espacios y que el vehículo tenga
        // matrícula
        if (espaciosCompleto() || vehiculo.getPlaca() == null) {
            return false; // No se puede alquilar el espacio
        }

        int countMotos = calcularOcupacionPorTipoVehiculo(new Moto("", 0, 0, false));
        double porcentajeMotos = (double) countMotos / NUM_ESPACIOS;

        // Verifica que no se exceda el 80% de espacios ocupados por motos
        if (porcentajeMotos < PORCENTAJE_MAXIMO_MOTOS || !(vehiculo instanceof Moto)) {
            for (int i = 0; i < NUM_ESPACIOS; i++) {
                if (espacios[i] == null) { // Encuentra un espacio vacío
                    espacios[i] = vehiculo; // Alquila el espacio al vehículo
                    return true; // Alquiler exitoso
                }
            }
        }
        return false; // No se pudo alquilar el espacio
    }

    // Método para verificar si el garaje está completo
    private boolean espaciosCompleto() {
        for (Vehiculo v : espacios) {
            if (v == null) {
                return false; // Hay espacio disponible
            }
        }
        return true; // No hay espacios disponibles
    }

    // Método para retirar un vehículo del garaje
    public boolean retirarVehiculo(String matricula) {
        for (int i = 0; i < NUM_ESPACIOS; i++) {
            if (espacios[i] != null && espacios[i].getPlaca().equals(matricula)) {
                espacios[i] = null; // Elimina el vehículo de la colección
                return true; // Retiro exitoso
            }
        }
        return false; // No se encontró el vehículo
    }

    // Método para calcular los ingresos mensuales de todos los vehículos en el
    // garaje
    @Override
    public double calcularIngresos() {
        double totalIngresos = 0.0;
        for (Vehiculo v : espacios) {
            if (v != null) { // Asegura que el vehículo no sea nulo
                totalIngresos += v.getCuotaMesGaraje(); // Suma la cuota mensual de cada vehículo
            }
        }
        return totalIngresos; // Retorna el total de ingresos
    }

    // Método para calcular la ocupación por tipo de vehículo
    @Override
    public int calcularOcupacionPorTipoVehiculo(Vehiculo v) {
        int count = 0;
        for (Vehiculo espacio : espacios) {
            if (espacio != null && espacio.getClass() == v.getClass()) { // Compara el tipo de vehículo
                count++;
            }
        }
        return count; // Retorna la cantidad de vehículos del tipo especificado
    }

    // Método para listar las matrículas y cuotas mensuales de los vehículos
    public void listarVehiculos() {
        for (Vehiculo v : espacios) {
            if (v != null) { // Asegura que el vehículo no sea nulo
                String tipo = v instanceof Moto ? "Moto" : "Auto"; // Determina el tipo de vehículo
                System.out.println(
                        "Matrícula: " + v.getPlaca() + ", Cuota Mensual: " + v.getCuotaMesGaraje() + ", Tipo: " + tipo);
            }
        }
    }
}