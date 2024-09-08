/*
 * 20241222299 Miguel Angel Barajas Bustos

En una tienda de computadoras se planea ofrecer a los clientes un descuento que dependerá
del número de equipos que compre. Si las computadoras son menos de cinco se les dará un
10% de descuento sobre el total de la compra; si el número de computadoras es mayor o igual
a cinco pero menos de diez se le otorga un 20% de descuento; y si son 10 o más se les da un
40% de descuento. El precio de cada computadora es de U$500.

 */
package EjerciciosPPO;

import java.util.Scanner;

public class EjercicioTienda {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            final double PRECIO_COMPUTADORA = 500.0;
            double descuento = 0.0;
            double totalPagar;

            System.out.println("Hay descuentos para nuestras computadoras!, este descuento dependera de cuantos equipos haya comprado!");

            System.out.println("Si has comprado menos de 5, tendras un 10% de descuento!");

            System.out.println("Si compraste entre 5 a 10 equipos, tendras un 20% de descuento!");

            System.out.println("Y si has comprado 10 o mas tendras un 40% de descuento!");

            System.out.println("Ingrese el numero de computadoras a pagar: ");

            int numeroComputadoras = sc.nextInt();

            if (numeroComputadoras < 5) {
                descuento = 0.1;
            } else if ((numeroComputadoras >= 5) && (numeroComputadoras > 10)) {
                descuento = 0.2;

            } else if (numeroComputadoras >= 10) {
                descuento = 0.4;
            }
            double totalSinDescuento = numeroComputadoras * PRECIO_COMPUTADORA;

            totalPagar = totalSinDescuento - (totalSinDescuento * descuento);

            System.out.println("Precio sin descuento: $" + totalSinDescuento);
            System.out.println("El Descuento aplicado fue del: " + (descuento * 100) + "%");
            System.out.println("El total a pagar: $" + totalPagar);
        }

    }
}
