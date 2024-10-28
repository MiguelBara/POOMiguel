package Cuentas;

public class CuentaCorriente extends Cuenta {
    private double maximoRetirable;

    // Constructor completo
    public CuentaCorriente(Persona cliente, long numeroCuenta, double maximoRetirable) {
        super(cliente, numeroCuenta);
        this.maximoRetirable = maximoRetirable;
    }

    // Métodos de acceso

    public double getMaximoRetirable() {
        return maximoRetirable;
    }

    public void setMaximoRetirable(double maximoRetirable) {
        this.maximoRetirable = maximoRetirable;
    }

    // Método toString
    @Override
    public String toString() {
        return "Cuenta Corriente\n" +
                "Número de Cuenta: " + getNumeroCuenta() + "\n" +
                "Saldo: " + getSaldo() + "\n" +
                "Cliente: " + getCliente().getNombre() + "\n" +
                "NIF: " + getCliente().getNif() + "\n" +
                "Máximo Retirable: " + maximoRetirable;
    }

    // Implementación del método retirar
    @Override
    public void retirar(double x) {
        if (x > 0 && x <= maximoRetirable && x <= getSaldo()) {
            double nuevoSaldo = getSaldo() - x;
            // Aquí se podría usar un método setSaldo, pero como no lo hemos definido, se
            // puede hacer directamente
            ingresar(-x); // Resta el importe al saldo
            System.out.println("Retiro de " + x + " realizado. Nuevo saldo: " + nuevoSaldo);
        } else {
            System.out.println("No se puede retirar esa cantidad.");
        }
    }

}
