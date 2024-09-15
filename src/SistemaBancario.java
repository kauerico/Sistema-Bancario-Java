public class SistemaBancario {

    // Struct para representar uma conta bancária
    public static class Conta {
        int numeroConta;
        String nomeTitular;
        double saldo;
    }

    public static void main(String[] args) {

        // Array para armazenar as contas (limite de 100 contas por enquanto)
        Conta[] contas = new Conta[100];
        int numeroDeContas = 0; // Contador de contas existentes

        // Lógica para criar uma nova conta
        Conta novaConta = new Conta();
        novaConta.numeroConta = 12345; 
        novaConta.nomeTitular = "João Silva";
        novaConta.saldo = 5000.0;

        // Adicionar a nova conta ao array
        contas[numeroDeContas] = novaConta;
        numeroDeContas++;

        // Lógica para realizar um depósito
        int numeroContaDeposito = 12345;
        double valorDeposito = 2000.0;

        for (int i = 0; i < numeroDeContas; i++) {
            if (contas[i].numeroConta == numeroContaDeposito) {
                contas[i].saldo += valorDeposito;
                System.out.println("Depósito realizado com sucesso!");
                break; // Sair do loop após encontrar a conta
            }
        }

        // Lógica para realizar um saque
        int numeroContaSaque = 12345;
        double valorSaque = 1000.0;

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
    }
}