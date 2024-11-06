package EjercicioParcial;

public class Vehiculo {
    private String placa;
    private String marca;
    private double precio;
    private int cilindraje;
    private double impuestoCirculacion;
    private double cuotaMesGaraje;
    private static final double CUOTA_BASE = 100;

    public Vehiculo(String marca, double precio, int cilindraje) {
        this.placa = null; // se inicia por defecto con valor null
        this.marca = marca;
        this.precio = precio;
        this.cilindraje = cilindraje;
        this.cuotaMesGaraje = CUOTA_BASE; // cuota mensual por defecto
        calcularImpuestoCirculacion(); // calcular impuesto al crear el vehículo
    }

    public double calcularImpuestoCirculacion() {
        this.impuestoCirculacion = 0.02 * precio; // 2% del precio
        return this.impuestoCirculacion;
    }

    public boolean matricular(String matricula) {
        if (matricula.length() == 6) {
            this.placa = matricula;
            return true;
        }
        return false;
    }

    public void setCuotaMesGaraje(double cuotaMesGaraje) {
        if (cuotaMesGaraje >= 0) {
            this.cuotaMesGaraje = cuotaMesGaraje;
        }
    }

    // Getters
    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public double getImpuestoCirculacion() {
        return impuestoCirculacion;
    }

    public double getCuotaMesGaraje() {
        return cuotaMesGaraje;
    }
}