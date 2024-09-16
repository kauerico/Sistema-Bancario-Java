import java.util.Scanner;

public class SistemaBancario {

    // Classe para representar uma conta bancária
    public static class Conta {
        int numeroConta;
        String nomeTitular;
        double saldo;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Array para armazenar as contas (limite de 100 contas por enquanto)
        Conta[] contas = new Conta[100];
        int numeroDeContas = 0; // Contador de contas existentes

        while (true) {
            System.out.println("\n*** Sistema Bancário ***");
            System.out.println("1. Criar nova conta");
            System.out.println("2. Realizar depósito");
            System.out.println("3. Realizar saque");
            System.out.println("4. Consultar saldo");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            // Entrada do usúario
            int opcao = teclado.nextInt();
            teclado.nextLine(); // Consumir a quebra de linha pendente

            switch (opcao) {
                case 1:
                    // Criar uma nova conta
                    Conta novaConta = new Conta();
                    System.out.print("Informe o número da nova conta: ");
                    novaConta.numeroConta = teclado.nextInt();
                    teclado.nextLine(); // Consumir a quebra de linha pendente

                    System.out.print("Informe o nome do titular da conta: ");
                    novaConta.nomeTitular = teclado.nextLine();
                    
                    System.out.print("Informe o saldo inicial da conta: R$");
                    novaConta.saldo = teclado.nextDouble();
                    teclado.nextLine(); // Consumir a quebra de linha pendente
                    
                    // Adicionar a nova conta ao array
                    contas[numeroDeContas] = novaConta;
                    numeroDeContas++;
                    
                    System.out.println("\nConta criada com sucesso!");
                    break;
                    
                    
                case 2:
                    // Realizar um depósito
                    System.out.print("Informe o número da conta para depósito: ");
                    int numeroContaDeposito = teclado.nextInt();
                    
                    System.out.print("Informe o valor do depósito: R$");
                    double valorDeposito = teclado.nextDouble();
                    
                    boolean depositoRealizado = false;
                    for (int i = 0; i < numeroDeContas; i++) {
                        if (contas[i].numeroConta == numeroContaDeposito) {
                            contas[i].saldo += valorDeposito;
                            System.out.println("\nDepósito realizado com sucesso!");
                            depositoRealizado = true;
                            break;
                        }
                    }
                    if (!depositoRealizado) {
                        System.out.println("\nConta não encontrada!");
                    }
                    break;

                case 3:
                    // Realizar um saque
                    System.out.print("Informe o número da conta para saque: ");
                    int numeroContaSaque = teclado.nextInt();
                    
                    System.out.print("Informe o valor do saque: R$");
                    double valorSaque = teclado.nextDouble();
                    
                    boolean saqueRealizado = false;
                    for (int i = 0; i < numeroDeContas; i++) {
                        if (contas[i].numeroConta == numeroContaSaque) {
                            if (contas[i].saldo >= valorSaque) {
                                contas[i].saldo -= valorSaque;
                                System.out.println("\nSaque realizado com sucesso!");
                            } else {
                                System.out.println("\nSaldo insuficiente para saque!");
                            }
                            saqueRealizado = true;
                            break;
                        }
                    }
                    if (!saqueRealizado) {
                        System.out.println("\nConta não encontrada!");
                    }
                    break;

                case 4:
                    // Consultar saldo
                    System.out.print("Informe o número da conta para consulta de saldo: ");
                    int numeroContaConsulta = teclado.nextInt();
                    
                    boolean contaEncontrada = false;
                    for (int i = 0; i < numeroDeContas; i++) {
                        if (contas[i].numeroConta == numeroContaConsulta) {
                            System.out.printf("\nSaldo da conta: R$ %.2f%n", contas[i].saldo);
                            contaEncontrada = true;
                            break;
                        }
                    }
                    if (!contaEncontrada) {
                        System.out.println("\nConta não encontrada!");
                    }
                    break;

                case 5:
                    // Sair
                    System.out.println("\nObrigado por usar o Sistema Bancário!");
                    teclado.close();
                    return;

                default:
                    System.out.println("\nOpção inválida! Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }
}
