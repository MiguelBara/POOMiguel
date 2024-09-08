package EjerciciosPPO;

import java.util.Scanner;

/*En una serviteca se ha establecido una promoción de las llantas marca “Pinchadas”, que consiste
en lo siguiente:
• Si se compran menos de cinco llantas el precio es de U$100 cada una, de U$75 si se
compran de cinco a 10 y de U$50 si se compran más de 10.
• Obtener la cantidad de dinero que una persona tiene que pagar por cada una de las llantas
que compra y la que tiene que pagar por el total de la compra. */
public class Llantas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double PrecioPorLLanta 
        double totalAPagar
        System.out.println("Tenemos promocion en nuestras llantas");
        System.out.println("Si compras menos de 5 llantas, el precio sera de 100$ cada una! ");
        System.out.println("Si compras entre 5 y 10 su precio baja a 75$ cada una! ");
        System.out.println("Si compras mas de 10 quedan a mitad de precio (50$) cada una! ");
        System.out.println("Ingrese el numero de llantas a pagar: ");
        int numeroLlantas = sc.nextInt();
        if (numeroLlantas < 5) {
            PrecioPorLLanta = 100;
        } else if ((numeroLlantas >= 5) && (numeroLlantas <= 10)) {
            PrecioPorLLanta = 75;
        } else if (numeroLlantas > 10) {
            PrecioPorLLanta = 50;
        }
        totalAPagar = PrecioPorLLanta * numeroLlantas
        System.out.println("El precio por llanta es $ " + PrecioPorLLanta);
        System.out.println("El total a pagar es por" + numeroLlantas + "llantas es: $" + totalAPagar
        );
        Scanner.close();

    }

}
