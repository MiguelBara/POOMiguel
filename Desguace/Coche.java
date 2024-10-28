package Desguace;

class Coche extends Vehiculo {// el modificador de visibilidad queda defualt si no pongo nada
    private int puertas;

    public Coche(double precioCompra, String marca, int puertas) {
        super(precioCompra, marca);
        this.puertas = puertas;
    }

    @Override
    public double precioVenta() {
        return precioCompra * 1.6; // Precio venta inicial
    }
}
