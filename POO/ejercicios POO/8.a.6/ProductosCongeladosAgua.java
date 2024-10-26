class ProductosCongeladosAgua extends ProductosCongelados {
    private double salinidad;

    public ProductosCongeladosAgua(String fechaCaducidad, String numeroLote, String fechaEnvasado, String paisOrigen,
            double temperaturaMantenimiento, double salinidad) {
        super(fechaCaducidad, numeroLote, fechaEnvasado, paisOrigen, temperaturaMantenimiento);
        this.salinidad = salinidad;
    }

    @Override
    public String toString() {
        return "Producto Congelado por Agua: " + super.toString() +
                ", Salinidad: " + salinidad + " gramos de sal/Litro de agua";
    }
}