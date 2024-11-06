package EjercicioParcial;

public class Auto extends Vehiculo {
    private boolean tieneRadio;
    private boolean tieneNavegador;

    public Auto(String marca, double precio, int cilindraje, boolean tieneRadio, boolean tieneNavegador) {
        super(marca, precio, cilindraje);
        this.tieneRadio = tieneRadio;
        this.tieneNavegador = tieneNavegador;
        calcularImpuestoCirculacion(); // calcular impuesto al crear el auto
        if (cilindraje > 2499) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.2); // aumenta cuota en 20%
        }
    }

    @Override
    public double calcularImpuestoCirculacion() {
        double impuestoBase = super.calcularImpuestoCirculacion();
        if (tieneRadio) {
            impuestoBase *= 1.01; // incrementa 1%
        }
        if (tieneNavegador) {
            impuestoBase *= 1.02; // incrementa 2%
        }
        return impuestoBase;
    }
}