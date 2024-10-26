class ProductosCongelados extends Producto {
    private String fechaEnvasado;
    private String paisOrigen;
    private double temperaturaMantenimiento;

    public ProductosCongelados(String fechaCaducidad, String numeroLote, String fechaEnvasado, String paisOrigen,
            double temperaturaMantenimiento) {
        super(fechaCaducidad, numeroLote);
        this.fechaEnvasado = fechaEnvasado;
        this.paisOrigen = paisOrigen;
        this.temperaturaMantenimiento = temperaturaMantenimiento;
    }

    @Override
    public String toString() {
        return "Producto Congelado: " + super.toString() +
                ", Fecha de Envasado: " + fechaEnvasado +
                ", País de Origen: " + paisOrigen +
                ", Temperatura de Mantenimiento: " + temperaturaMantenimiento + "°C";
    }
}
