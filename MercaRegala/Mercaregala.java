package MercaRegala;

import java.util.List;
import java.util.Scanner;

public class Mercaregala {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Mercaregala ---");
            System.out.println("1. Añadir producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Productos en peligro");
            System.out.println("4. Calculo precio medio");
            System.out.println("5. Eliminar bandejas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarProducto(almacen, scanner);
                    break;
                case 2:
                    listarProductos(almacen);
                    break;
                case 3:
                    listarProductosEnPeligro(almacen);
                    break;
                case 4:
                    calcularPrecioMedio(almacen);
                    break;
                case 5:
                    eliminarBandejas(almacen);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void agregarProducto(Almacen almacen, Scanner scanner) {
        System.out.print("Ingrese el tipo de producto (carne/pescado): ");
        String tipo = scanner.nextLine().toLowerCase();

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el peso (kg): ");
        double peso = scanner.nextDouble();

        System.out.print("Ingrese el precio por kilo: ");
        double precioKilo = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        if (tipo.equals("carne")) {
            System.out.print("Ingrese el origen (vacuno/avícola): ");
            String origen = scanner.nextLine().toLowerCase();

            System.out.print("¿Es fresca o congelada? (fresca/congelada): ");
            String tipoCarne = scanner.nextLine().toLowerCase();

            if (tipoCarne.equals("fresca")) {
                System.out.print("Ingrese los días de caducidad: ");
                int diasCaducidad = scanner.nextInt();
                almacen.agregarProducto(new CarneFresca(nombre, peso, precioKilo, origen, diasCaducidad));
            } else if (tipoCarne.equals("congelada")) {
                System.out.print("Ingrese la empresa distribuidora: ");
                String empresaDistribuidora = scanner.nextLine();

                System.out.print("¿Es pieza entera o troceada? (entera/troceada): ");
                String tipoCongelada = scanner.nextLine().toLowerCase();

                if (tipoCongelada.equals("entera")) {
                    System.out.print("¿Viene en bandeja? (sí/no): ");
                    boolean enBandeja = scanner.nextLine().equalsIgnoreCase("sí"); // equalsIngoreCase ignora si es
                                                                                   // mayusculas o minusculas
                    almacen.agregarProducto(new CarneCongeladaPiezaEntera(nombre, peso, precioKilo, origen,
                            empresaDistribuidora, enBandeja));
                } else if (tipoCongelada.equals("troceada")) {
                    System.out.print("Ingrese el número medio de piezas: ");
                    int numeroPiezas = scanner.nextInt();
                    almacen.agregarProducto(new CarneCongeladaPiezaTroceada(nombre, peso, precioKilo, origen,
                            empresaDistribuidora, numeroPiezas));
                }
            }
        } else if (tipo.equals("pescado")) {
            System.out.print("Ingrese el tipo de pescado: ");
            String tipoPescado = scanner.nextLine();
            almacen.agregarProducto(new Pescado(nombre, peso, precioKilo, tipoPescado));
        } else {
            System.out.println("Tipo de producto no válido.");
        }
    }

    private static void listarProductos(Almacen almacen) {
        List<Producto> productos = almacen.getProductos();
        System.out.println("\n--- Lista de Productos ---");
        for (Producto producto : productos) {
            System.out.printf("Nombre: %s, Precio: %.2f\n", producto.getNombre(), producto.calcularPrecio());
        }
    }

    private static void listarProductosEnPeligro(Almacen almacen) {
        List<CarneFresca> enPeligro = almacen.obtenerCarnesFrescasEnPeligro();
        System.out.println("\n--- Carnes Frescas en Peligro ---");
        for (CarneFresca carne : enPeligro) {
            System.out.printf("Nombre: %s, Días de Caducidad: %d\n", carne.getNombre(), carne.getDiasCaducidad());
        }
        if (enPeligro.isEmpty()) {
            System.out.println("No hay carnes frescas en peligro.");
        }
    }

    private static void calcularPrecioMedio(Almacen almacen) {
        double precioMedio = almacen.calcularPrecioMedio();
        System.out.printf("El precio medio de los productos es: %.2f\n", precioMedio);
    }

    private static void eliminarBandejas(Almacen almacen) {
        almacen.eliminarBandejas();
        System.out.println("Se han eliminado las carnes congeladas en pieza que vienen en bandeja.");
    }
}
