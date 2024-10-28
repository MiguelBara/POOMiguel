package Desguace;

class Furgoneta extends Vehiculo {// el modificador de visibilidad queda defualt si no pongo nada
    private double capacidadCarga;

    public Furgoneta(double precioCompra, String marca, double capacidadCarga) {
        super(precioCompra, marca);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double precioVenta() {
        double precioVentaInicial = precioCompra * 1.6; // Precio de venta inicial
        if (capacidadCarga > 10) {
            precioVentaInicial *= 1.2; // Aumentar un 20% si la capacidad de carga es mayor de 10
        }
        return precioVentaInicial;
    }
}
