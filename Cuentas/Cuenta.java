package Cuentas;

public abstract class Cuenta {
    private long numeroCuenta;
    private double saldo;
    private Persona cliente;

    // Constructor parametrizado
    public Cuenta(Persona cliente, long numeroCuenta) {
        this.cliente = cliente;
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0.0; // Inicializa el saldo a 0
    }

    // Métodos de acceso

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    // Método ingresar dinero
    public void ingresar(double x) {
        if (x > 0) {
            saldo += x;
        } else {
            System.out.println("El importe a ingresar debe ser mayor que 0.");
        }
    }

    // Método abstracto para retirar dinero
    public abstract void retirar(double x);

}