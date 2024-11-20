package EjercicioParcial;

public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    public Moto(String marca, double precio, int cilindraje, boolean tieneSidecar) {
        super(marca, precio, cilindraje);
        this.tieneSidecar = tieneSidecar;
        ajustarCuotaEImpuesto();
    }

    private void ajustarCuotaEImpuesto() {
        if (tieneSidecar) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.5);
            calcularImpuestoCirculacion();
            setCuotaMesGaraje(getCuotaMesGaraje());
        }
    }
}
