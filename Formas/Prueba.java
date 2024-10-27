package Formas;

import javax.sound.sampled.SourceDataLine;

public class Prueba {
    public static void main(String[] args) {
        triangulo triangulo1 = new triangulo(5, 3, "azul", "triangulo 1", 5, 10);
        System.out.println("El area de" + triangulo1.getNombre() + "es : " + triangulo.calcularArea());

        cuadrado  cuadrado1 = new cuadrado("amarillo", "cuadrado 1", 0, 0, 4);
     System.out.println("El area del " + cuadrado1.getNombre() "es : " + cuadrado.calcularArea());
     System.out.println("El perimetro del " + cuadrado1.getNombre() "es : " + cuadrado.calcularPerimetro());

    }

}
