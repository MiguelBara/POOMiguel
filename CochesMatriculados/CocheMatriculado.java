package CochesMatriculados;

public class CocheMatriculado extends Coche {
    private int anioMatriculacion;
    private int mesMatriculacion;
    private double impuestoMatriculacion;

    // Constructor
    public CocheMatriculado(String marca, String color, double precio, double factorContaminacion, int anio,
            String matricula, String dniTitular, int anioMatriculacion, int mesMatriculacion) {
        super(marca, color, precio, factorContaminacion, anio);
        setMatricula(matricula);
        setDniTitular(dniTitular);
        this.anioMatriculacion = anioMatriculacion;
        this.mesMatriculacion = mesMatriculacion;
        calculaImpuestoMatriculacion(); // Calcula el impuesto de matriculación
    }

    // Método para calcular el impuesto de matriculación
    public void calculaImpuestoMatriculacion() {
        impuestoMatriculacion = getPrecio() / 20; // Vigesima parte del precio
        if (2023 - getAnio() > 10) { // Si el coche tiene más de 10 años
            impuestoMatriculacion += 100; // Recargo de 100 euros
        }
    }

    // Métodos de acceso
    public int getAnioMatriculacion() {
        return anioMatriculacion;
    }

    public void setAnioMatriculacion(int anioMatriculacion) {
        this.anioMatriculacion = anioMatriculacion;
    }

    public int getMesMatriculacion() {
        return mesMatriculacion;
    }

    public void setMesMatriculacion(int mesMatriculacion) {
        this.mesMatriculacion = mesMatriculacion;
    }

    public double getImpuestoMatriculacion() {
        return impuestoMatriculacion;
    }

    public void setImpuestoMatriculacion(double impuestoMatriculacion) {
        this.impuestoMatriculacion = impuestoMatriculacion;
        calculaImpuestoMatriculacion(); // Recalcula el impuesto
    }
}