package EjerciciosJava;

import java.util.Scanner;

public class matriz1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] matriz = new double[6][100];
        double tipoServicio = 0, tipoProducto = 0, pesoTrans = 0, tiempoPerma = 0, largoCamion = 0, costoParquea = 0;
        // ingreso manual
        for (int nCamion = 0; nCamion < matriz.length; nCamion++) {
            System.out.println("Servicio a realizar (1 Descarga / 2 Carga: )");
            tipoServicio = sc.nextDouble();
            if (tipoProducto == 1) {
                System.out.println("Tipo de producto (1 Perecedero / 2 No perecedero): ");
                tipoProducto = sc.nextDouble();
                System.out.println("Peso de la carga : ");
                pesoTrans = sc.nextDouble();
                System.out.println();
                switch ((int) tipoProducto) {
                    case 1:
                        if (pesoTrans < 8) {
                            costoParquea = 15000 * pesoTrans;
                        } else {
                            costoParquea = 9000 * pesoTrans;

                        }
                        break;
                    case 2:
                        if (pesoTrans < 8) {
                            costoParquea = 60000;
                        } else {
                            costoParquea = 60000 + (pesoTrans - 10 * 7000);
                        }

                }

            } else {
                System.out.println("tiempo en el parqueadero : ");
                tiempoPerma = sc.nextDouble();
                System.out.println("cuanto mide el camion: ");
                largoCamion = sc.nextDouble();
                if (tiempoPerma <= 2) {
                    costoParquea = 0;
                } else {
                    if (largoCamion <= 4) {
                        costoParquea = (tiempoPerma - 2) * 4000;
                    } else {
                        costoParquea = (tiempoPerma - 2) * 4000 * 1.25;
                    }

                }
            }
            System.out.println("Valor a pagar: " + costoParquea);
            matriz[nCamion][0] = tipoServicio;
            matriz[nCamion][1] = tipoProducto;
            matriz[nCamion][2] = pesoTrans;
            matriz[nCamion][3] = tiempoPerma;
            matriz[nCamion][4] = largoCamion;
            matriz[nCamion][5] = costoParquea;
        }

    }

}
