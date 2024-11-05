package EjercicioParcial;

public class Moto extends Vehiculo {

    private boolean tieneSidecar;

    public Moto(boolean tieneSidecar, int Cilindraje, String Marca, Double Precio) {
        super(Cilindraje, Marca, Precio);
        this.tieneSidecar = tieneSidecar;
        calcularImpuestoCirculacion();
        if (tieneSidecar) {

            setCuotaMesGaraje(getCuotaMesGaraje() * 1.5);
        }
    }

    @Override
    public void calcularImpuestoCirculacion() {
        super.calcularImpuestoCirculacion();
        if (tieneSidecar) {
            setImpuestoCirculacion((getImpuestoCirculacion() * 1.1));
        }
    }

    public boolean isTieneSidecar() {
        return tieneSidecar;
    }

    public void setTieneSidecar(boolean tieneSidecar) {
        this.tieneSidecar = tieneSidecar;
    }

}