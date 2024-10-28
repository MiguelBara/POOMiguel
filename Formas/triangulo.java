package Formas;

public class triangulo extends forma {

    private double base;
    private double altura;

    public triangulo(double altura, double base, String color, String nombre, double posicionX, double posicionY) {
        super(color, nombre, posicionX, posicionY);
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}
