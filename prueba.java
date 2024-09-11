
import java.util.Scanner;

public class prueba {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Leer el precio sin IVA
        System.out.println("Ofrecemos descuentos sobre el precio sin iva de nuestros productos!");
        System.out.println("Si este cuesta 500$ o mas tendra un 10% de descuento (sin iva)");
        System.out.println("Ademas de un 5% de descuento si compra algun producto NOSY");
        System.out.print("Ingrese el precio sin IVA del aparato: ");
        double precioSinIVA = scanner.nextDouble();

        // Leer la marca
        System.out.print("Ingrese la marca del aparato: ");
        scanner.nextLine();  // Consumir el salto de línea pendiente
        String marca = scanner.nextLine();

        // Inicializar el precio con descuento
        double precioConDescuento = precioSinIVA;

        // Aplicar descuento del 10% si el precio es 500 o más
        if (precioSinIVA >= 500) {
            precioConDescuento *= 0.90; // Aplicar descuento del 10%
        }

        // Aplicar descuento del 5% si la marca es "NOSY"
        if (marca.equalsIgnoreCase("NOSY")) {
            precioConDescuento *= 0.95; // Aplicar descuento del 5%
        }

        // Calcular el IVA
        double IVA = 0.19; // 19%
        double precioConIVA = precioConDescuento * (1 + IVA);

        // Mostrar el precio final con IVA incluido
        System.out.printf("El precio final con IVA incluido es: U$%.2f%n", precioConIVA);

        // Cerrar el scanner
        scanner.close();
    }
}
