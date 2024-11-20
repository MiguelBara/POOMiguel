package EjercicioParcial;

public class Vehiculo {
    protected String placa = null;
    protected String marca;
    protected double precio;
    protected int cilindraje;
    protected double impuestoCirculacion;
    protected double cuotaMesGaraje;

    public static final double CUOTA_BASE = 100.0;

    public Vehiculo(String marca, double precio, int cilindraje) {
        this.marca = marca;
        this.precio = precio;
        this.cilindraje = cilindraje;
        this.cuotaMesGaraje = CUOTA_BASE;
        calcularImpuestoCirculacion();
    }

    public void calcularImpuestoCirculacion() {
        this.impuestoCirculacion = 0.02 * precio;
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

    public double getCuotaMesGaraje() {
        return cuotaMesGaraje;
    }

    public String getPlaca() {
        return placa;
    }
}
