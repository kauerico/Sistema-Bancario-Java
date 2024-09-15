import java.util.Scanner;

public class SistemaBancario {

    // Struct para representar uma conta bancária
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

        // Lógica para criar uma nova conta
        Conta novaConta = new Conta();
        System.out.print("Informe o novo número da conta: ");
        novaConta.numeroConta = teclado.nextInt();
        
        // Consumir a quebra de linha pendente
        teclado.nextLine();

        System.out.print("Informe o nome do titular da conta: ");
        novaConta.nomeTitular = teclado.nextLine();
        
        System.out.print("Informe o saldo da conta: R$");
        novaConta.saldo = teclado.nextDouble();

        // Adicionar a nova conta ao array
        contas[numeroDeContas] = novaConta;
        numeroDeContas++;

        // Lógica para realizar um depósito.
        System.out.println("Informe o número da conta: ");
        int numeroContaDeposito = teclado.nextInt() ;
        System.out.println("Informe o valor do depósito: R$");
        double valorDeposito = teclado.nextDouble();

        for (int i = 0; i < numeroDeContas; i++) {
            if (contas[i].numeroConta == numeroContaDeposito) {
                contas[i].saldo += valorDeposito;
                System.out.println("Depósito realizado com sucesso!");
                break; // Sair do loop após encontrar a conta
            }
        }

        // Lógica para realizar um saque
        System.out.print("Informe o número da conta: ");
        int numeroContaSaque = teclado.nextInt();
        System.out.print("Informe o valor do saque: R$");
        double valorSaque = teclado.nextDouble();

        for (int i = 0; i < numeroDeContas; i++) {
            if (contas[i].numeroConta == numeroContaSaque) {
                if (contas[i].saldo >= valorSaque) {
                    contas[i].saldo -= valorSaque;
                    System.out.println("Saque realizado com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente para saque!");
                }
                break; // Sair do loop após encontrar a conta
            }
        }

        // Lógica para consultar o saldo
        int numeroContaConsulta = 12345;

        for (int i = 0; i < numeroDeContas; i++) {
            if (contas[i].numeroConta == numeroContaConsulta) {
                System.out.println("Saldo da conta: " + contas[i].saldo);
                break; // Sair do loop após encontrar a conta
            }
        }

        teclado.close();
    }
}