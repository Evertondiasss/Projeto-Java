import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando cliente e conta
        Cliente cliente = new Cliente("João", "123.456.789-00");
        OperacaoBancaria conta = new ContaCorrente(1, cliente, 1000.0);

        // Menu de opções
        while (true) {
            System.out.println("--- SISTEMA BANCÁRIO ---");
            System.out.println("1- Fazer depósito");
            System.out.println("2- Fazer saque");
            System.out.println("3- Consultar saldo");
            System.out.println("4- Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;

                case 2:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;

                case 3:
                    System.out.println("Saldo: R$" + conta.getSaldo());
                    break;

                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
