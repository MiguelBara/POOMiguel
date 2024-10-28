package Formas;

public class Main {
    public static void main(String[] args) {

        Cuadrado cuadrado1 = new Cuadrado("c1", 0, 0, "azul", 3);
        System.out.println("El area de: " + cuadrado1.getNombre() + "es :" + cuadrado1.calcularArea());
        System.out.println("El perimetro de: " + cuadrado1.getNombre() + "es :" + cuadrado1.calcularPerimetro());

        Triangulo triangulo1 = new Triangulo("t1", 0, 0, "verde", 4, 6);
        System.out.println("El area de: " + triangulo1.getNombre() + "es :" + triangulo1.calcularArea());

    }

}