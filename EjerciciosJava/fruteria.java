package EjerciciosJava;

import java.util.Scanner;

/*4. Una frutería ofrece las manzanas con descuento según la siguiente tabla:
NUM. DE KILOS COMPRADOS % DESCUENTO
0 - 2 0%
2.01 - 5 10%
5.01 - 10 15%
10.01 en adelante 20%
Determinar cuánto pagará una persona que compre manzanas en esa frutería. */
public class fruteria {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ofrecemos descuentos en nuestras manzanas! (7000$ el kg)");
        System.out.println("(Si compras menos de 2 kilos no tiene descuento)");
        System.out.println("Si compra entre 2 y 5 kilos tiene 10% de descuento!");
        System.out.println("Si compra entre 5 a 10 kilos obtiene 15% de descuento!");
        System.out.println("Si compra más de 10 kilos tiene 20% de descuento!");

        final double PRECIO_POR_KILO = 7000.0;

        System.out.print("Ingrese cuántos kilos va a comprar: ");
        double kilos = sc.nextDouble();

        double descuento = 0.0;
        if (kilos > 10) {
            descuento = 0.20;
        } else if (kilos > 5) {
            descuento = 0.15;
        } else if (kilos >= 2) {
            descuento = 0.10;
        } else {
            descuento = 0.00;
        }

        double precioTotalF = kilos * PRECIO_POR_KILO;
        double descuentoF = precioTotalF * descuento;
        double precioFinalF = precioTotalF - descuentoF;

        System.out.printf("El precio total con descuento incluido es: $" + precioFinalF);
    }
}
