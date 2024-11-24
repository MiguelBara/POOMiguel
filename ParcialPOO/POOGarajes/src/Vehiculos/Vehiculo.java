package Vehiculos;

public class Vehiculo {

    protected String placa;
    protected String marca;
    protected double precio;
    protected int cilindraje;
    protected double impuestoCirculacion;
    protected double cuotaMesGaraje;
    protected static final double CUOTA_BASE = 100.0;

    public Vehiculo() {
    }

    public Vehiculo(String marca, double precio, int cilindraje) {
        this.placa = null;
        this.marca = marca;
        this.precio = precio;
        this.cilindraje = cilindraje;
        this.cuotaMesGaraje = CUOTA_BASE;
        calcularImpuestoCirculacion();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public double getImpuestoCirculacion() {
        return impuestoCirculacion;
    }

    public void setImpuestoCirculacion(double impuestoCirculacion) {
        this.impuestoCirculacion = impuestoCirculacion;
    }

    public double getCuotaMesGaraje() {
        return cuotaMesGaraje;
    }

    public void setCuotaMesGaraje(double cuotaMesGaraje) {
        this.cuotaMesGaraje = cuotaMesGaraje;
    }

    public void calcularImpuestoCirculacion() {
        this.impuestoCirculacion = precio * 0.02;
    }

    public boolean matricular(String matricula) {
        if (matricula != null && matricula.length() == 6) {
            this.placa = matricula;
            return true;
        }
        return false;
    }

}
