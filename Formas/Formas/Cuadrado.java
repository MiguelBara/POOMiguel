package Formas;

class Cuadrado extends Forma {
    private double lado;

    // Constructor
    public Cuadrado(String nombre, double posicionX, double posicionY, String color, double lado) {
        super(nombre, posicionX, posicionY, color);
        this.lado = lado;
    }

    // Implementación del método calcularArea
    @Override
    public double calcularArea() {
        return lado * lado;
    }

    // Método para calcular el perímetro
    public double calcularPerimetro() {
        return 4 * lado;
    }

    // Getters y Setters
    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
}
