package EjerciciosJava;

import java.util.Random;
import java.util.Scanner;

/*@ Miguel Barajas 20241222299 */
public class Parcial {

    public static void main(String[] args) {
        int numHabitaciones = 10;
        int[][] matriz = new int[numHabitaciones][7];
        Random random = new Random();

        for (int i = 0; i < numHabitaciones; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == 2) { // Miércoles con promoción
                    matriz[i][j] = random.nextInt(61) + 40; // 40-100
                } else if (j >= 4) { // Fines de semana (viernes, sábado, domingo)
                    matriz[i][j] = random.nextInt(61) + 36; // 20% más que lunes
                } else {
                    matriz[i][j] = random.nextInt(51) + 30; // 30-80
                }
            }
        }

        System.out.println("Matriz generada:");
        for (int i = 0; i < numHabitaciones; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);
        int numHabitacion;

        while (true) {
            System.out.print("Ingrese el número de habitación (1-" + numHabitaciones + "): ");
            numHabitacion = scanner.nextInt();

            if (numHabitacion < 1 || numHabitacion > numHabitaciones) {
                System.out.println("Error: El número de habitación debe estar entre 1 y " + numHabitaciones);
            } else {
                break;
            }
        }

        System.out.println("No. habitación " + numHabitacion);
        System.out.println("Consumo diario:");
        System.out.println("Lunes: " + matriz[numHabitacion - 1][0]);
        System.out.println("Martes: " + matriz[numHabitacion - 1][1]);
        System.out.println("Miércoles: " + matriz[numHabitacion - 1][2]);
        System.out.println("Jueves: " + matriz[numHabitacion - 1][3]);
        System.out.println("Viernes: " + matriz[numHabitacion - 1][4]);
        System.out.println("Sábado: " + matriz[numHabitacion - 1][5]);
        System.out.println("Domingo: " + matriz[numHabitacion - 1][6]);

        double promedioSemana = (matriz[numHabitacion - 1][0] + matriz[numHabitacion - 1][1]
                + matriz[numHabitacion - 1][2] + matriz[numHabitacion - 1][3]) / 4.0;
        double promedioFinDeSemana = (matriz[numHabitacion - 1][4] + matriz[numHabitacion - 1][5]
                + matriz[numHabitacion - 1][6]) / 3.0;

        System.out.printf("Promedio entre semana: %.2f%n", promedioSemana);
        System.out.printf("Promedio fin de semana: %.2f%n", promedioFinDeSemana);

        int[] consumoTotalPorDia = new int[7];

        for (int i = 0; i < numHabitaciones; i++) {
            for (int j = 0; j < 7; j++) {
                consumoTotalPorDia[j] += matriz[i][j];
            }
        }

        System.out.println("Consumo total del hotel discriminado por día:");
        for (int i = 0; i < 7; i++) {
            System.out.println("Día " + (i + 1) + ": " + consumoTotalPorDia[i]);
        }

        double consumoPromedioPorHabitacion = 0;
        for (int i = 0; i < numHabitaciones; i++) {
            for (int j = 0; j < 7; j++) {
                consumoPromedioPorHabitacion += matriz[i][j];
            }
        }
        consumoPromedioPorHabitacion /= numHabitaciones * 7;

        System.out.printf("Consumo promedio por habitación: %.2f%n", consumoPromedioPorHabitacion);

        int maxConsumo = Integer.MIN_VALUE;
        int minConsumo = Integer.MAX_VALUE;

        for (int i = 0; i < numHabitaciones; i++) {
            int consumoHabitacion = 0;
            for (int j = 0; j < 7; j++) {
                consumoHabitacion += matriz[i][j];
            }
            if (consumoHabitacion > maxConsumo) {
                maxConsumo = consumoHabitacion;
            }
            if (consumoHabitacion < minConsumo) {
                minConsumo = consumoHabitacion;
            }
        }

        System.out.println("Habitación que más consume: " + maxConsumo);
        System.out.println("Habitación que menos consume: " + minConsumo);
    }
}
