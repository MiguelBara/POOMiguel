package CochesMatriculados;

public class Coche {
    private final String marca; // "final quiere decir que no puede modificarse"
    private String color;
    private int km;
    private double precio;
    private final double factorContaminacion;
    private final int anio;
    private String matricula;
    private String dniTitular;

    // Constructor
    public Coche(String marca, String color, double precio, double factorContaminacion, int anio) {
        this.marca = marca;
        this.color = color;
        this.km = 0; // Inicializa km a 0
        this.precio = precio;
        this.factorContaminacion = factorContaminacion;
        this.anio = anio;
        this.matricula = null; // Inicializa matricula como null
        this.dniTitular = null; // Inicializa dniTitular como null
    }

    // Métodos de acceso
    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKm() {
        return km;
    }

    public void incrementarKm(int km) { // metodo incremetarKm
        if (km > 0) {
            this.km += km;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getFactorContaminacion() {
        return factorContaminacion;
    }

    public int getAnio() {
        return anio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (this.matricula == null) {
            this.matricula = matricula;
        }
    }

    public String getDniTitular() {
        return dniTitular;
    }

    public void setDniTitular(String dniTitular) {
        this.dniTitular = dniTitular;
    }

    // Método para comprar coche
    public void comprarCoche(Coche otroCoche) {
        if (this.dniTitular != null && otroCoche.dniTitular != null) {
            this.dniTitular = otroCoche.dniTitular;
        } else {
            System.out.println("No se puede cambiar el DNI del titular. Ambos coches deben tener un DNI asignado.");
        }
    }
}