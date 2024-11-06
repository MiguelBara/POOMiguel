package EjercicioParcial;

public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    public Moto(String marca, double precio, int cilindraje, boolean tieneSidecar) {
        super(marca, precio, cilindraje);
        this.tieneSidecar = tieneSidecar;
        calcularImpuestoCirculacion(); // calcular impuesto al crear la moto
        if (tieneSidecar) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.5); // aumenta cuota en 50%
        }
    }

    @Override
    public double calcularImpuestoCirculacion() {
        double impuestoBase = super.calcularImpuestoCirculacion();
        if (tieneSidecar) {
            impuestoBase *= 1.1; // incrementa 10%
        }
        return impuestoBase;
    }
}