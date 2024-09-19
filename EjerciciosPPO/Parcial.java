package EjerciciosPPO;

import java.util.Random;

public class Parcial {

    public static void main(String[] args) {
        int numHabitaciones = 10;
        int[][] matrix = generateMatrix(numHabitaciones);

        System.out.println("Matriz generada:");
        for (int i = 0; i < numHabitaciones; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int numHabitacion = Integer.parseInt(System.console().readLine("Ingrese el número de habitación para ver el reporte: "));
        printReport(matrix, numHabitacion);

        generateStatistics(matrix);
    }

    public static int[][] generateMatrix(int numHabitaciones) {
        int[][] matrix = new int[numHabitaciones][7];
        Random random = new Random();

        for (int i = 0; i < numHabitaciones; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == 2) { // Miércoles con promoción
                    matrix[i][j] = random.nextInt(61) + 40; // 40-100
                } else if (j >= 4) { // Fines de semana (viernes, sábado, domingo)
                    matrix[i][j] = random.nextInt(61) + 36; // 20% más que lunes
                } else {
                    matrix[i][j] = random.nextInt(51) + 30; // 30-80
                }
            }
        }
        return matrix;
    }

    public static void printReport(int[][] matrix, int numHabitacion) {
        int[] habitacion = matrix[numHabitacion - 1];

        System.out.println("No. habitación " + numHabitacion);
        System.out.println("Consumo diario:");
        System.out.println("Lunes: " + habitacion[0]);
        System.out.println("Martes: " + habitacion[1]);
        System.out.println("Miércoles: " + habitacion[2]);
        System.out.println("Jueves: " + habitacion[3]);
        System.out.println("Viernes: " + habitacion[4]);
        System.out.println("Sábado: " + habitacion[5]);
        System.out.println("Domingo: " + habitacion[6]);

        double promedioSemana = (habitacion[0] + habitacion[1] + habitacion[2] + habitacion[3]) / 4.0;
        double promedioFinDeSemana = (habitacion[4] + habitacion[5] + habitacion[6]) / 3.0;

        System.out.printf("Promedio entre semana: %.2f%n", promedioSemana);
        System.out.printf("Promedio fin de semana: %.2f%n", promedioFinDeSemana);
    }

    public static void generateStatistics(int[][] matrix) {
        int[] consumoTotalPorDia = new int[7];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < 7; j++) {
                consumoTotalPorDia[j] += matrix[i][j];
            }
        }

        System.out.println("Consumo total del hotel discriminado por día:");
        for (int i = 0; i < 7; i++) {
            System.out.println("Día " + (i + 1) + ": " + consumoTotalPorDia[i]);
        }

        double consumoPromedioPorHabitacion = 0;
        for (int i = 0; i < matrix.length; i++) {
            consumoPromedioPorHabitacion += sumArray(matrix[i]);
        }
        consumoPromedioPorHabitacion /= matrix.length;

        System.out.printf("Consumo promedio por habitación: %.2f%n", consumoPromedioPorHabitacion);

        int maxConsumo = Integer.MIN_VALUE;
        int minConsumo = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            int consumoHabitacion = sumArray(matrix[i]);
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

    public static int sumArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}
