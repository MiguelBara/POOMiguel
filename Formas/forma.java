package Formas;

public class forma {

    private String nombre;
    private double posicionX;
    private double posicionY;
    private String color;

    public forma(String color, String nombre, double posicionX, double posicionY) {
        this.color = color;
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double calcularArea();

    public double calcularPerimetro() {
        throw new UnsupportedOperationException("El método calcularPerimetro no está implementado en la clase abstracta Forma");



}
