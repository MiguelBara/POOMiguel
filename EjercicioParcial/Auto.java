package EjercicioParcial;

public class Auto extends Vehiculo {

    private boolean tieneRadio;
    private boolean tieneNavegador;

    // El atributo cuotaMesGarage se aumenta en 20 % si el cilindraje del auto es
    // mayor de 2499
    public Auto(boolean tieneNavegador, boolean tieneRadio, int Cilindraje, String Marca, Double Precio) {
        super(Cilindraje, Marca, Precio);
        this.tieneNavegador = tieneNavegador;
        this.tieneRadio = tieneRadio;
        calcularImpuestoCirculacion();
        if (Cilindraje > 2499) {
            setCuotaMesGaraje(getCilindraje() * 1.2);
        }

    }

    @Override
    public void calcularImpuestoCirculacion() {
        super.calcularImpuestoCirculacion();
        if (tieneRadio) {
            setImpuestoCirculacion(getImpuestoCirculacion() * 1.01);
        }
        if (tieneNavegador) {
            setImpuestoCirculacion(getImpuestoCirculacion() * 1.02);

        }

    }

    public boolean isTieneRadio() {
        return tieneRadio;
    }

    public void setTieneRadio(boolean tieneRadio) {
        this.tieneRadio = tieneRadio;
    }

    public boolean isTieneNavegador() {
        return tieneNavegador;
    }

    public void setTieneNavegador(boolean tieneNavegador) {
        this.tieneNavegador = tieneNavegador;
    }

}