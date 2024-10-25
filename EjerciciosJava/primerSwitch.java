package EjerciciosPPO;

/*13. Un supermercado realiza una tómbola con todos los clientes, si son hombres tienen que sacar
de una canasta una bolita la cual tiene un número grabado y si son mujeres lo mismo pero de
otra canasta, los premios se dan bajo la siguiente tabla:
HOMBRES MUJERES
# Bolita Premio # bolita Premio
1 Desodorante 1 Loción
2 Six-Pack de cerveza 2 Bikini
3 Camiseta 3 Crema para la cara
4 Pantaloneta 4 Plancha para el cabello
5 Sudadera 5 Esmalte de uñas */
import java.util.Scanner;

public class primerSwitch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Estamos regalando premios!");
        System.out.println("Tienes que sacar una bolita (del 1 al 5)");
        System.out.println("Eres hombre o mujer?: ");
        String Genero = sc.nextLine();
        System.out.println("Ingrese el numero de la bolita: ");
        int numbolita = sc.nextInt();
        if (numbolita < 1 || numbolita > 5) {
            System.out.println("No existe ese numero de bolita (es del 1 al 5)");
            return;
        }
        String premio = "";
        if (Genero.equalsIgnoreCase("hombre")) {
            switch (numbolita) {
                case 1:
                    premio = "Desodorante";
                    break;
                case 2:
                    premio = "Six pack de cerveza";
                    break;
                case 3:
                    premio = "Camiseta";
                    break;
                case 4:
                    premio = "Pantaloneta";
                    break;
                case 5:
                    premio = "Sudadera";
                    break;
            }
        } else if (Genero.equalsIgnoreCase("mujer")) {
            switch (numbolita) {
                case 1:
                    premio = "Locion";
                    break;
                case 2:
                    premio = "Bikini";
                    break;
                case 3:
                    premio = "Crema para la cara";
                    break;
                case 4:
                    premio = "Plancha para el cabello";
                    break;
                case 5:
                    premio = "Esmalte uñas";
                    break;
            }

        } else {
            System.out.println("Genero invalido, debe ser hombre o mujer.");
            return;
        }
        System.out.println("El premio es: " + premio);

    }
}
