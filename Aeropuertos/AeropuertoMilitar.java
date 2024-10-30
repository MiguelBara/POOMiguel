package Aeropuertos;

public class AeropuertoMilitar extends Aeropuerto {
    private String nombreEnClave;

    public AeropuertoMilitar(String nombre, String ciudad, String nombreEnClave) {
        super(nombre, ciudad);
        this.nombreEnClave = nombreEnClave;
    }

    @Override
    public String toString() {
        return "AeropuertoMilitar{" +
                "nombre='" + getNombre() + '\'' +
                ", ciudad='" + getCiudad() + '\'' +
                ", nombreEnClave='" + nombreEnClave + '\'' +
                '}';
    }
}