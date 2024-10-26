class ProductosCongeladosNitrogeno extends ProductosCongelados {
    private String metodoCongelacion;
    private int tiempoExposicion;

    public ProductosCongeladosNitrogeno(String fechaCaducidad, String numeroLote, String fechaEnvasado,
            String paisOrigen, double temperaturaMantenimiento,
            String metodoCongelacion, int tiempoExposicion) {
        super(fechaCaducidad, numeroLote, fechaEnvasado, paisOrigen, temperaturaMantenimiento);
        this.metodoCongelacion = metodoCongelacion;
        this.tiempoExposicion = tiempoExposicion;
    }

    @Override
    public String toString() {
        return "Producto Congelado por Nitrógeno: " + super.toString() +
                ", Método de Congelación: " + metodoCongelacion +
                ", Tiempo de Exposición: " + tiempoExposicion + " segundos";
    }
}