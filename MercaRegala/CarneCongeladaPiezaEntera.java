package MercaRegala;

public class CarneCongeladaPiezaEntera extends CarneCongelada {
    private boolean enBandeja;

    public CarneCongeladaPiezaEntera(String nombre, double peso, double precioKilo, String origen,
            String empresaDistribuidora, boolean enBandeja) {
        super(nombre, peso, precioKilo, origen, empresaDistribuidora);
        this.enBandeja = enBandeja;
    }

    public boolean isEnBandeja() {
        return enBandeja;
    }
}