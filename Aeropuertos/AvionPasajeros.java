package Aeropuertos;

public class AvionPasajeros extends Avion {
    private int numeroPasajeros;

    public AvionPasajeros(String nombre, String matricula, int autonomiaVuelo, int numeroPasajeros) {
        super(nombre, matricula, autonomiaVuelo);
        this.numeroPasajeros = numeroPasajeros;
    }

    @Override
    public String obtenerInformacionCompleta() {
        return "AvionPasajeros{" +
                "nombre='" + getNombre() + '\'' +
                ", matricula='" + getMatricula() + '\'' +
                ", autonomiaVuelo=" + getAutonomiaVuelo() +
                ", numeroPasajeros=" + numeroPasajeros +
                ", pasajeros=" + getPasajeros() +
                '}';
    }
}