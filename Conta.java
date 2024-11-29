public abstract class Conta {
    private int numeroConta;
    private Cliente cliente;
    private double saldo;

    public Conta(int numeroConta, Cliente cliente, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = saldoInicial;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor <= saldo && valor > 0) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    // Método para obter o tipo da conta, será implementado nas subclasses
    public abstract String getTipoConta();

    @Override
    public String toString() {
        return "Conta: " + numeroConta + " | Cliente: " + cliente.getNome() + " | Tipo: " + getTipoConta() + " | Saldo: R$" + String.format("%.2f", saldo);
    }
}
