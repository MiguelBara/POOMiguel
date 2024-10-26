package EjerciciosJava;

import java.util.Scanner;

/* Un proveedor de reproductores de música ofrece un descuento del 10% sobre el precio sin IVA,
de algún aparato, si este cuesta U$500 o más. Además, independientemente de esto, ofrece un
5% de descuento si la marca es “NOSY”. Determinar cuánto pagará, con IVA incluido, un cliente
cualquiera por la compra de su aparato. El IVA es del 19%. */
public class Musica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ofrecemos descuentos sobre el precio sin IVA de nuestros productos!");
        System.out.println("Si este cuesta 500$ o más tendrá un 10% de descuento (sin IVA)");
        System.out.println("Además de un 5% de descuento si compra algún producto NOSY");

        // Ingreso del precio sin IVA
        System.out.println("Ingrese el precio sin IVA del producto: ");
        double precioSinIva = sc.nextDouble(); // Cambie a double para manejar decimales
        sc.nextLine(); // lee la siguiente línea después de leer un número

        // Ingreso de la marca del producto
        System.out.println("Ingrese la marca del producto: ");
        String marca = sc.nextLine();

        // Inicio el precio con descuento como el precio sin IVA
        double precioConDescuento = precioSinIva;

        // Aplica descuento del 10% si el precio es 500 o más
        if (precioConDescuento >= 500) {
            precioConDescuento *= 0.9; // Multiplico por 0.9 para aplicar el descuento del 10%
        }

        // Aplica el descuento del 5% adicional si la marca "nosy", el
        // marca.equalsIgnoreCase es pa que no importe mayusculas o minusculas
        if (marca.equalsIgnoreCase("NOSY")) {
            precioConDescuento *= 0.95; // Multiplica por 0.95 para aplicar el descuento del 5%
        }

        // Calcula el precio final con IVA incluido
        double IVA = 1.19;
        double precioConIva = precioConDescuento * IVA;

        // Muestra el valor total
        System.out.println("El precio final con IVA incluido es: $" + precioConIva);
    }
}
