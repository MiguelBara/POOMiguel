package MercaRegala;

public abstract class Carne extends ProductoBase {
    protected String origen;

    public Carne(String nombre, double peso, double precioKilo, String origen) {
        super(nombre, peso, precioKilo);
        this.origen = origen;
    }
}