package Empleado_Programador;

public class Programador extends Empleado {
    private int lineasDeCodigoPorHora;
    private String lenguajeDominante;

    // Constructor parametrizado
    public Programador(String nombre, String dni, int edad, boolean casado, double salario, int lineasDeCodigoPorHora,
            String lenguajeDominante) {
        super(nombre, dni, edad, casado, salario);
        this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
        this.lenguajeDominante = lenguajeDominante;
    }

    // Constructor sin parametrizar
    public Programador() {
        super();
        this.lineasDeCodigoPorHora = 0;
        this.lenguajeDominante = "";
    }

    // Método para calcular el salario
    public double calculaSalario() {
        return 10 * lineasDeCodigoPorHora;
    }

    // Método toString (sobreescribiendo el de Empleado)
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Líneas de código por hora: " + lineasDeCodigoPorHora + "\n" +
                "Lenguaje dominante: " + lenguajeDominante;
    }

    // Getters y setters
    public void setLineasDeCodigoPorHora(int lineasDeCodigoPorHora) {
        this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
    }

    public int getLineasDeCodigoPorHora() {
        return lineasDeCodigoPorHora;
    }

    public void setLenguajeDominante(String lenguajeDominante) {
        this.lenguajeDominante = lenguajeDominante;
    }

    public String getLenguajeDominante() {
        return lenguajeDominante;
    }
}