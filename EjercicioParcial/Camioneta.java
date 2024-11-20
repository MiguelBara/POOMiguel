package EjercicioParcial;

public class Camioneta extends Vehiculo {
    private String tipoServicio; // SUV, Pickup, Carga, Otro
    private int numeroPasajeros;
    private boolean tieneRemolque;

    public Camioneta(String marca, double precio, int cilindraje, String tipoServicio, int numeroPasajeros,
            boolean tieneRemolque) {
        super(marca, precio, cilindraje);
        this.tipoServicio = tipoServicio;
        this.numeroPasajeros = validarPasajeros(tipoServicio, numeroPasajeros);
        this.tieneRemolque = tieneRemolque;
        ajustarCuotaEImpuesto();
    }

    private int validarPasajeros(String tipoServicio, int numeroPasajeros) {
        if ((tipoServicio.equalsIgnoreCase("Pickup") || tipoServicio.equalsIgnoreCase("Carga"))
                && numeroPasajeros > 2) {
            throw new IllegalArgumentException("Camionetas de tipo Pickup o Carga no pueden tener más de 2 pasajeros.");
        }
        if (numeroPasajeros > 5) {
            throw new IllegalArgumentException("El número máximo de pasajeros permitido es 5.");
        }
        return numeroPasajeros;
    }

    private void ajustarCuotaEImpuesto() {
        double cuotaExtra = 1.0;
        if (tipoServicio.equalsIgnoreCase("SUV")) {
            cuotaExtra += 0.1;
        } else {
            cuotaExtra += 0.45;
        }

        if (numeroPasajeros == 2) {
            cuotaExtra += 0.5;
        } else if (numeroPasajeros > 2) {
            cuotaExtra += 0.6;
        }

        if (tieneRemolque) {
            cuotaExtra += 0.1;
        }

        setCuotaMesGaraje(getCuotaMesGaraje() * cuotaExtra);
        super.calcularImpuestoCirculacion();
    }
}
