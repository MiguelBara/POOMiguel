package Interfaz_8a8;

import java.util.Arrays;

public class Inicio {
    public static void main(String[] args) {
        Math2 math2 = new Math2();

        // Prueba con un array de enteros
        int[] intArray = { 3, 5, 1, 8, 2 };
        System.out.println("Array de enteros: " + Arrays.toString(intArray));
        System.out.println("Mínimo: " + math2.min(intArray));
        System.out.println("Máximo: " + math2.max(intArray));

        // Prueba con un array de dobles
        double[] doubleArray = { 3.5, 5.1, 1.2, 8.3, 2.4 };
        System.out.println("\nArray de dobles: " + Arrays.toString(doubleArray));
        System.out.println("Mínimo: " + math2.min(doubleArray));
        System.out.println("Máximo: " + math2.max(doubleArray));
    }
}