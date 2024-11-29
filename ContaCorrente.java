public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(int numeroConta, Cliente cliente, double saldoInicial) {
        super(numeroConta, cliente, saldoInicial);
        this.limite = 1000.0;  // Limite padrão de R$1000
    }

    @Override
    public void sacar(double valor) {
        if (valor <= getSaldo() + limite && valor > 0) {
            super.sacar(valor);
        } else {
            System.out.println("Saldo insuficiente, incluindo limite.");
        }
    }

    @Override
    public String getTipoConta() {
        return "Corrente";  // Tipo da conta
    }
}