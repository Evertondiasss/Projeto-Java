public class ContaCorrente implements OperacaoBancaria {
    private int numeroConta;
    private Cliente cliente;
    private double saldo;

    public ContaCorrente(int numeroConta, Cliente cliente, double saldo) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado com sucesso na Conta Corrente.");
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso na Conta Corrente.");
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}
