package Cuentas;

public class CuentaAhorro extends Cuenta {
    private double saldoMinimo;

    // Constructor parametrizado
    public CuentaAhorro(Persona cliente, long numeroCuenta, double saldoMinimo) {
        super(cliente, numeroCuenta);
        this.saldoMinimo = saldoMinimo;
    }

    // Métodos de acceso
    public double getSaldoMinimo() {
        return saldoMinimo;
    }

    // Método toString
    @Override
    public String toString() {
        return "Cuenta Ahorro\n" +
                "Número de Cuenta: " + getNumeroCuenta() + "\n" +
                "Saldo: " + getSaldo() + "\n" +
                "Cliente: " + getCliente().getNombre() + "\n" +
                "NIF: " + getCliente().getNif() + "\n" +
                "Saldo Mínimo: " + saldoMinimo;
    }

    // Implementación del método retirar
    @Override
    public void retirar(double x) {
        if (x > 0 && (getSaldo() - x) >= saldoMinimo) {
            double nuevoSaldo = getSaldo() - x;
            // Aquí se podría usar un método setSaldo, pero como no lo hemos definido, se
            // puede hacer directamente
            ingresar(-x); // Resta el importe al saldo
            System.out.println("Retiro de " + x + " realizado. Nuevo saldo: " + nuevoSaldo);
        }
    }
}