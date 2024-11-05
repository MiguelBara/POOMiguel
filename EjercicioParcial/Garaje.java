package EjercicioParcial;

public class Garaje {
    private Vehiculo[] espacios;
    private static final int MAX_ESPACIOS = 10; // Constante que define el número máximo de espacios
    private int ocupados; // Contador de los espacios ocupados

    // Constructor
    public Garaje() {
        this.espacios = new Vehiculo[MAX_ESPACIOS];
        this.ocupados = 0;
    }

    // Método para alquilar un espacio
    public boolean alquilarEspacio(Vehiculo vehiculo) {
        if (ocupados >= MAX_ESPACIOS || vehiculo.getPlaca() == null) {
            return false; // No se pueden alquilar más espacios o si la matrícula es nula
        }

        int motosContador = 0;
        for (int i = 0; i < ocupados; i++) {
            if (espacios[i] instanceof Moto) {
                motosContador++;
            }
        }

        // Comprobar que no haya más del 80% de los espacios ocupados por motos
        if ((double) motosContador / MAX_ESPACIOS > 0.8) {
            return false;
        }

        // Agregar el vehículo en el primer espacio disponible
        espacios[ocupados] = vehiculo;
        ocupados++;
        return true;
    }

    // Método para retirar un vehículo por su matrícula
    public boolean retirarVehiculo(String placa) {
        for (int i = 0; i < ocupados; i++) {
            if (espacios[i] != null && espacios[i].getPlaca().equals(placa)) { // != significa (no es igual a)
                // Desplazar los vehículos hacia la izquierda para llenar el espacio vacío
                for (int j = i; j < ocupados - 1; j++) {
                    espacios[j] = espacios[j + 1];
                }
                espacios[ocupados - 1] = null; // Vaciar el último espacio
                ocupados--;
                return true;
            }
        }
        return false;
    }

    // Método para calcular los ingresos mensuales
    public double calcularIngresos() {
        double ingresos = 0;
        for (int i = 0; i < ocupados; i++) {
            if (espacios[i] != null) {
                ingresos += espacios[i].getCuotaMesGaraje();
            }
        }
        return ingresos;
    }

    // Método para calcular la ocupación por tipo de vehículo
    public int calcularOcupacionPorTipoVehiculo(Class<? extends Vehiculo> tipo) { // el <? quiere decir que acepta
                                                                                  // cualquier cosa de la clase vehiculo
        int count = 0;
        for (int i = 0; i < ocupados; i++) {
            if (espacios[i] != null && espacios[i].getClass().equals(tipo)) {
                count++;
            }
        }
        return count;
    }

    // Método adicional para obtener el número de espacios ocupados
    public int getOcupados() {
        return ocupados;
    }
}
