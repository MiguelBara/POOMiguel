public class Main {
    public static void main(String[] args) {
        // Crear un objeto Triangulo
        Triangulo triangulo = new Triangulo("Triángulo", 0, 0, "Rojo", 5, 10);
        System.out.println("Área del " + triangulo.getNombre() + ": " + triangulo.calcularArea());

        // Crear un objeto Cuadrado
        Cuadrado cuadrado = new Cuadrado("Cuadrado", 0, 0, "Azul", 4);
        System.out.println("Área del " + cuadrado.getNombre() + ": " + cuadrado.calcularArea());
        System.out.println("Perímetro del " + cuadrado.getNombre() + ": " + cuadrado.calcularPerimetro());
    }
}