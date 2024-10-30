package MercaRegala;

public abstract class CarneCongelada extends Carne {
    protected String empresaDistribuidora;

    public CarneCongelada(String nombre, double peso, double precioKilo, String origen, String empresaDistribuidora) {
        super(nombre, peso, precioKilo, origen);
        this.empresaDistribuidora = empresaDistribuidora;
    }
}