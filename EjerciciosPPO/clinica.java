package EjerciciosPPO;

import java.util.Scanner;

public class clinica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad total de nacimientos: ");
        int cantNacimientos = sc.nextInt();
        sc.nextLine();

        int contMasculino = 0;
        int contFemenino = 0;

        for (int i = 1; i <= cantNacimientos; i++) {
            System.out.print("Ingrese el nombre del bebé " + i + ": ");
            String nombre = sc.nextLine();

            String sexo;
            do {
                System.out.print("Ingrese el sexo del bebé " + i + " (Masculino/Femenino): ");
                sexo = sc.nextLine();
            } while (!sexo.equalsIgnoreCase("Masculino") && !sexo.equalsIgnoreCase("Femenino"));

            if (sexo.equalsIgnoreCase("Masculino")) {
                contMasculino++;
            } else {
                contFemenino++;
            }
        }

        System.out.println("Cantidad de bebés masculinos: " + contMasculino);
        System.out.println("Cantidad de bebés femeninos: " + contFemenino);
    }
}
