package Aeropuertos;

public class AvionCarga extends Avion {
    private int cargaMaxima;

    public AvionCarga(String nombre, String matricula, int autonomiaVuelo, int cargaMaxima) {
        super(nombre, matricula, autonomiaVuelo);
        this.cargaMaxima = cargaMaxima;
    }

    @Override
    public String obtenerInformacionCompleta() {
        return "AvionCarga{" +
                "nombre='" + getNombre() + '\'' +
                ", matricula='" + getMatricula() + '\'' +
                ", autonomiaVuelo=" + getAutonomiaVuelo() +
                ", cargaMaxima=" + cargaMaxima +
                '}';
    }
}