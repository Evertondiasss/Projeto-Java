public class ContaPoupanca extends Conta {
    private static final double TAXA_JUROS = 0.05;  // Taxa de juros de 5%

    public ContaPoupanca(int numeroConta, Cliente cliente, double saldoInicial) {
        super(numeroConta, cliente, saldoInicial);
    }

    public void aplicarJuros() {
        double juros = getSaldo() * TAXA_JUROS;
        depositar(juros);
    }

    @Override
    public String getTipoConta() {
        return "Poupança";  // Tipo da conta
    }
}
