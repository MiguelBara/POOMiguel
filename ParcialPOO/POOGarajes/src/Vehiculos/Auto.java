
package Vehiculos;


public class Auto extends Vehiculo {
    private boolean tieneRadio;
    private boolean tieneNavegador;

    public Auto(String marca, double precio, int cilindraje, boolean tieneRadio, boolean tieneNavegador) {
        super(marca, precio, cilindraje);
        this.tieneRadio = tieneRadio;
        this.tieneNavegador = tieneNavegador;

        if (tieneRadio) {
            this.impuestoCirculacion += precio * 0.01;
        }
        if (tieneNavegador) {
            this.impuestoCirculacion += precio * 0.02;
        }
        if (cilindraje > 2499) {
            this.cuotaMesGaraje += CUOTA_BASE * 0.20;
        }
    }

    public boolean isTieneRadio() {
        return tieneRadio;
    }

    public boolean isTieneNavegador() {
        return tieneNavegador;
    }
}
