package EjerciciosJava;

import java.util.Scanner;

public class Llantas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double precioPorLlanta = 0; // Inicializamos la variable
        double totalAPagar;
        System.out.println("Tenemos promoción en nuestras llantas");
        System.out.println("Si compras menos de 5 llantas, el precio será de 100$ cada una! ");
        System.out.println("Si compras entre 5 y 10 su precio baja a 75$ cada una! ");
        System.out.println("Si compras más de 10 quedan a mitad de precio (50$) cada una! ");
        System.out.println("Ingrese el número de llantas a pagar: ");
        double numeroLlantas = sc.nextDouble();

        // Condicionales corregidos
        if (numeroLlantas < 5) {
            precioPorLlanta = 100;
        } else if (numeroLlantas >= 5 && numeroLlantas <= 10) { // Condición corregida
            precioPorLlanta = 75;
        } else if (numeroLlantas > 10) {
            precioPorLlanta = 50;
        }

        // Cálculo del total
        totalAPagar = precioPorLlanta * numeroLlantas;

        // Imprimir resultados
        System.out.println("El precio por llanta es $ " + precioPorLlanta);
        System.out.println("El total a pagar por " + numeroLlantas + " llantas es: $" + totalAPagar); // Espacio añadido
                                                                                                      // entre palabras

    }
}
