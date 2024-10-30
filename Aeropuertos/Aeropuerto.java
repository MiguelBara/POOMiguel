package Aeropuertos;

import java.util.ArrayList;
import java.util.List;

public abstract class Aeropuerto {
    private String nombre;
    private String ciudad;
    protected List<Avion> aviones;

    public Aeropuerto(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.aviones = new ArrayList<>();
    }

    public void agregarAvion(Avion avion) {
        aviones.add(avion);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public List<Avion> getAviones() {
        return aviones;
    }

    public void mostrarInformacionAviones() {
        for (Avion avion : aviones) {
            System.out.println(avion.obtenerInformacionCompleta());
        }
    }
}