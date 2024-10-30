package MercaRegala;

import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private List<Producto> productos;

    public Almacen() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<CarneFresca> obtenerCarnesFrescasEnPeligro() {
        List<CarneFresca> enPeligro = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto instanceof CarneFresca) {
                CarneFresca carneFresca = (CarneFresca) producto;
                if (carneFresca.getDiasCaducidad() < 10) {
                    enPeligro.add(carneFresca);
                }
            }
        }
        return enPeligro;
    }

    public double calcularPrecioMedio() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcularPrecio();
        }
        return total / productos.size();
    }

    public void eliminarBandejas() {
        productos.removeIf(producto -> producto instanceof CarneCongeladaPiezaEntera &&
                ((CarneCongeladaPiezaEntera) producto).isEnBandeja());
    }
}