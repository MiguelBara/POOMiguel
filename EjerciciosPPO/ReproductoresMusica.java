package EjerciciosPPO;

import java.util.Scanner;

/*Un proveedor de reproductores de música ofrece un descuento del 10% sobre el precio sin IVA
de algún aparato, si esta cuesta U$500 o más. Además, independientemente de esto, ofrece un
5% de descuento si la marca es “NOSY”. Determinar cuánto pagara, con IVA incluido, un cliente
cualquiera por la compra de su aparato. El IVA es del 19%. */
public class ReproductoresMusica {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ofrecemos descuentos sobre el precio sin iva de nuestros productos!");
        System.out.println("Si este cuesta 500$ o mas tendra un 10% de descuento (sin iva)");
        System.out.println("Ademas de un 5% de descuento si compra algun producto NOSY");
        System.out.println("Ingrese el precio sin iva del producto: ");
        double PrecioSinIva = sc.nextDouble();
        System.out.println("Ingrese la marca del producto: ");
        String marca = sc.nextLine();
        double PrecioConDescuento = PrecioSinIva;
        if (PrecioSinIva >= 500) {
            PrecioConDescuento *= 0.9;
        }
        if (marca.equalsIgnoreCase("NOSY")) {
            PrecioConDescuento *= 0.95;
        }
        double IVA = 0.19;
        double PrecioConIva = PrecioConDescuento * (1 + IVA);
        System.out.println("El precio final con IVA incluido es: $", PrecioConIva);
        Scanner.close();

    }
}
