package MercaRegala;

public class CarneCongeladaPiezaTroceada extends CarneCongelada {
    private int numeroPiezas;

    public CarneCongeladaPiezaTroceada(String nombre, double peso, double precioKilo, String origen,
            String empresaDistribuidora, int numeroPiezas) {
        super(nombre, peso, precioKilo, origen, empresaDistribuidora);
        this.numeroPiezas = numeroPiezas;
    }

    public int getNumeroPiezas() {
        return numeroPiezas;
    }
}