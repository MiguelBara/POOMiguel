package Aeropuertos;

public class AeropuertoComercial extends Aeropuerto {
    private int numeroTerminales;

    public AeropuertoComercial(String nombre, String ciudad, int numeroTerminales) {
        super(nombre, ciudad);
        this.numeroTerminales = numeroTerminales;
    }

    @Override
    public String toString() {
        return "AeropuertoComercial{" +
                "nombre='" + getNombre() + '\'' +
                ", ciudad='" + getCiudad() + '\'' +
                ", numeroTerminales=" + numeroTerminales +
                '}';
    }
}