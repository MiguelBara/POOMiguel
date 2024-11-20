package EjercicioParcial;

public class Camioneta extends Vehiculo {
    public enum TipoServicio { // tipo enumerado por eso el "enum"
        SUV, Pickup, Carga, Otro
    }

    private TipoServicio tipoServicio;
    private int numeroPasajeros;
    private boolean tieneRemolque;

    public Camioneta(String marca, double precio, int cilindraje, TipoServicio tipoServicio, int numeroPasajeros,
            boolean tieneRemolque) {
        super(marca, precio, cilindraje);
        this.tipoServicio = tipoServicio;
        this.tieneRemolque = tieneRemolque;

        // Validación del número de pasajeros
        if (tipoServicio == TipoServicio.Pickup || tipoServicio == TipoServicio.Carga) {
            if (numeroPasajeros > 2) {
                throw new IllegalArgumentException("El número de pasajeros para Pickup o Carga no puede ser más de 2.");
            }
        } else {
            if (numeroPasajeros > 5) {
                throw new IllegalArgumentException("El número de pasajeros no puede ser más de 5 para SUV u Otro.");
            }
        }
        this.numeroPasajeros = numeroPasajeros;

        calcularImpuestoCirculacion(); // calcular impuesto al crear la camioneta

        // Ajustar cuota mensual del garaje
        if (tipoServicio == TipoServicio.Pickup || tipoServicio == TipoServicio.Carga
                || tipoServicio == TipoServicio.Otro) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.45); // aumenta cuota en 45%
        } else if (tipoServicio == TipoServicio.SUV) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.10); // aumenta cuota en 10%
        }

        // Ajustar cuota mensual según el número de pasajeros
        if (numeroPasajeros == 2) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.50); // 50% más si tiene 2 pasajeros
        } else {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.60); // 60% más si tiene más de 2 pasajeros
        }

        // Ajustar cuota si tiene remolque
        if (tieneRemolque) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.10); // 10% más si tiene remolque
        }
    }

    @Override
    public double calcularImpuestoCirculacion() {
        return getPrecio() * 0.05; // 5% del precio
    }
}