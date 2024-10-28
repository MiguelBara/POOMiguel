package Formas;

public class Rectangulo extends Forma {
    private double ancho;
    private double alto;

    public Rectangulo(String nombre, double posicionX, double posicionY, String color, double ancho, double alto) {
        super(nombre, posicionX, posicionY, color);
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double calcularArea() {
        return ancho * alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }
}
