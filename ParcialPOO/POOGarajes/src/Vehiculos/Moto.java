
package Vehiculos;


public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    public Moto(String marca, double precio, int cilindraje, boolean tieneSidecar) {
        super(marca, precio, cilindraje);
        this.tieneSidecar = tieneSidecar;
        if (tieneSidecar) {
            this.impuestoCirculacion += precio * 0.10;
            this.cuotaMesGaraje += CUOTA_BASE * 0.50;
        }
    
    }
    

    public boolean isTieneSidecar() {
        return tieneSidecar;
    }
}
