import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        int numeroConta = 1;  // Número inicial das contas

        while (true) {
            System.out.println("--- SISTEMA BANCÁRIO ---");
            System.out.println("1- Fazer depósito");
            System.out.println("2- Fazer saque");
            System.out.println("3- Consultar saldo");
            System.out.println("4- Exibir dados da conta");
            System.out.println("5- Criar um novo cliente");
            System.out.println("6- Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número da conta: ");
                    int numContaDeposito = scanner.nextInt();
                    Conta contaDeposito = banco.buscarConta(numContaDeposito);
                    if (contaDeposito != null) {
                        System.out.print("Digite o valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        contaDeposito.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 2:
                    System.out.print("Digite o número da conta: ");
                    int numContaSaque = scanner.nextInt();
                    Conta contaSaque = banco.buscarConta(numContaSaque);
                    if (contaSaque != null) {
                        System.out.print("Digite o valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        contaSaque.sacar(valorSaque);
                        if (valorSaque <= contaSaque.getSaldo()) {
                            System.out.println("Saque realizado com sucesso!");
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o número da conta: ");
                    int numContaSaldo = scanner.nextInt();
                    Conta contaSaldo = banco.buscarConta(numContaSaldo);
                    if (contaSaldo != null) {
                        System.out.println("Saldo: R$" + String.format("%.2f", contaSaldo.getSaldo()));
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    banco.exibirContas();
                    break;

                case 5:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    Cliente novoCliente = new Cliente(nomeCliente, cpfCliente);
                    System.out.println("Escolha o tipo de conta:");
                    System.out.println("1. Corrente");
                    System.out.println("2. Poupança");
                    int tipoConta = scanner.nextInt();  
                    Conta novaConta = null;
                    if (tipoConta == 1) {
                        novaConta = new ContaCorrente(numeroConta++, novoCliente, 0);
                    } else if (tipoConta == 2) {
                        novaConta = new ContaPoupanca(numeroConta++, novoCliente, 0);
                    }
                    banco.adicionarConta(novaConta);
                    System.out.println("Conta criada com sucesso! Número da conta: " + novaConta.getNumeroConta());
                    break;

                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
