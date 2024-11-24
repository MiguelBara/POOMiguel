
package Vehiculos;

public class Camioneta extends Vehiculo {
    private String tipoServicio; // SUV, Pickup, Carga, Otro
    private int numeroPasajeros;
    private boolean tieneRemolque;

    public Camioneta(String marca, double precio, int cilindraje, String tipoServicio, int numeroPasajeros, boolean tieneRemolque) {
        super(marca, precio, cilindraje);
        this.tipoServicio = tipoServicio;
        this.numeroPasajeros = numeroPasajeros;
        this.tieneRemolque = tieneRemolque;

        validarNumeroPasajeros();

        if (tipoServicio.equalsIgnoreCase("Pickup") || tipoServicio.equalsIgnoreCase("Carga") || tipoServicio.equalsIgnoreCase("Otro")) {
            this.cuotaMesGaraje += CUOTA_BASE * 0.45;
        } else if (tipoServicio.equalsIgnoreCase("SUV")) {
            this.cuotaMesGaraje += CUOTA_BASE * 0.10;
        }

        if (numeroPasajeros == 2) {
            this.cuotaMesGaraje += CUOTA_BASE * 0.50;
        } else if (numeroPasajeros > 2) {
            this.cuotaMesGaraje += CUOTA_BASE * 0.60;
        }

        if (tieneRemolque) {
            this.cuotaMesGaraje += CUOTA_BASE * 0.10;
        }

        this.impuestoCirculacion = precio * 0.05;
    }

    private void validarNumeroPasajeros() {
        if ((tipoServicio.equalsIgnoreCase("Pickup") || tipoServicio.equalsIgnoreCase("Carga")) && numeroPasajeros > 2) {
            throw new IllegalArgumentException("Las camionetas de tipo Pickup y Carga no pueden tener más de 2 pasajeros.");
        } else if (numeroPasajeros > 5) {
            throw new IllegalArgumentException("El número máximo de pasajeros es 5.");
        }
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public boolean isTieneRemolque() {
        return tieneRemolque;
    }
}
