package EjercicioParcial;

public class Auto extends Vehiculo {
    private boolean tieneRadio;
    private boolean tieneNavegador;

    public Auto(String marca, double precio, int cilindraje, boolean tieneRadio, boolean tieneNavegador) {
        super(marca, precio, cilindraje);
        this.tieneRadio = tieneRadio;
        this.tieneNavegador = tieneNavegador;
        ajustarCuotaEImpuesto(cilindraje);
    }

    private void ajustarCuotaEImpuesto(int cilindraje) {
        double impuestoExtra = 0;
        if (tieneRadio)
            impuestoExtra += 0.01 * super.precio;
        if (tieneNavegador)
            impuestoExtra += 0.02 * super.precio;
        super.calcularImpuestoCirculacion();
        if (cilindraje > 2499)
            setCuotaMesGaraje(getCuotaMesGaraje());
    }
}
