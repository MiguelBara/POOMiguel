package Formas;

public class cuadrado extends forma {

    private double lado;

    public cuadrado(String color, String nombre, double posicionX, double posicionY, double lado) {
        super(color, nombre, posicionX, posicionY);
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return (lado * lado);
    }

    public double calcularPerimetro() {
        return 4 * lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

}
