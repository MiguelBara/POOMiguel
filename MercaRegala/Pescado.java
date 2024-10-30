package MercaRegala;

public class Pescado extends ProductoBase {
    private String tipoPescado;

    public Pescado(String nombre, double peso, double precioKilo, String tipoPescado) {
        super(nombre, peso, precioKilo);
        this.tipoPescado = tipoPescado;
    }

    public String getTipoPescado() {
        return tipoPescado;
    }
}