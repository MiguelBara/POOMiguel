package Desguace;

abstract class Vehiculo {
    protected double precioCompra;
    protected String marca;

    public Vehiculo(double precioCompra, String marca) {
        this.precioCompra = precioCompra;
        this.marca = marca;
    }

    public abstract double precioVenta();
}
