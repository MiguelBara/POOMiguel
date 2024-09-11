package EjerciciosPPO;

import java.util.Scanner;

/*Un proveedor de reproductores de música ofrece un descuento del 10% sobre el precio sin IVA,
de algún aparato, si esta cuesta U$500 o más. Además, independientemente de esto, ofrece un
5% de descuento si la marca es “NOSY”. Determinar cuánto pagara, con IVA incluido, un cliente
cualquiera por la compra de su aparato. El IVA es del 19 */
public class Musica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ofrecemos descuentos sobre el precio sin IVA de nuestros productos!");
        System.out.println("Si este cuesta 500$ o más tendrá un 10% de descuento (sin IVA)");
        System.out.println("Además de un 5% de descuento si compra algún producto NOSY");
        System.out.println("Ingrese el precio sin IVA del producto: ");
        int precioSinIva = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese la marca del producto: ");
        String marca = sc.nextLine();

        double precioConDescuento = precioSinIva;

        if (precioSinIva >= 500) {
            precioConDescuento = precioConDescuento * 0.9;
        }

        if (marca.equals("NOSY") && (marca.equals("nosy")) && (marca.equals("Nosy"))) {
            precioConDescuento *= 0.85;
        }

        double IVA = 0.19;
        double precioConIva = precioConDescuento * (1 + IVA);

        System.out.println("El precio final con IVA incluido es: $" + precioConIva);
    }

}
