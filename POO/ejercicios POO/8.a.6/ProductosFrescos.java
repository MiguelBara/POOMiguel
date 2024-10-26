class ProductosFrescos extends Producto {
    
    private String fechaEnvasado;
    private String paisOrigen;

    public ProductosFrescos(String fechaCaducidad, String numeroLote, String fechaEnvasado, String paisOrigen) {
        super(fechaCaducidad, numeroLote);
        this.fechaEnvasado = fechaEnvasado;
        this.paisOrigen = paisOrigen;
    }

    @Override
    public String toString() {
        return "Producto Fresco: " + super.toString() + 
               ", Fecha de Envasado: " + fechaEnvasado + 
               ", País de Origen: " + paisOrigen;
    }
}