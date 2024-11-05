package EjercicioParcial;

public class Vehiculo {

    private String Placa;
    private String Marca;
    private Double Precio;
    private int Cilindraje;
    private double ImpuestoCirculacion;
    private double CuotaMesGaraje;
    private static final double CUOTA_BASE = 100;

    public Vehiculo(int Cilindraje, String Marca, Double Precio) {
        this.Cilindraje = Cilindraje;
        this.Marca = Marca;
        this.Precio = Precio;
        this.CuotaMesGaraje = CUOTA_BASE;
    }

    public Vehiculo(double ImpuestoCirculacion) {
        this.ImpuestoCirculacion = ImpuestoCirculacion;
    }

    public boolean Vehiculo(String Placa) {
        if (Placa.length() == 6) {
            this.Placa = Placa;
            return true;
        }

        else {
            return false;
        }
    }

    public void calcularImpuestoCirculacion() {
        this.ImpuestoCirculacion = 0.02 * this.Precio;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public int getCilindraje() {
        return Cilindraje;
    }

    public void setCilindraje(int Cilindraje) {
        this.Cilindraje = Cilindraje;
    }

    public double getImpuestoCirculacion() {
        return ImpuestoCirculacion;
    }

    public void setImpuestoCirculacion(double ImpuestoCirculacion) {
        this.ImpuestoCirculacion = ImpuestoCirculacion;
    }

    public double getCuotaMesGaraje() {
        return CuotaMesGaraje;
    }

    public void setCuotaMesGaraje(double CuotaMesGaraje) {
        if (CuotaMesGaraje >= 0)
            this.CuotaMesGaraje = CuotaMesGaraje;
    }

}