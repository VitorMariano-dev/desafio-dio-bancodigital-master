import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando clientes
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Leandro");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Ruth");

        // Criando contas
        Conta contaCorrente1 = new ContaCorrente(cliente1);
        Conta contaPoupanca1 = new ContaPoupanca(cliente1);

        Conta contaCorrente2 = new ContaCorrente(cliente2);
        Conta contaPoupanca2 = new ContaPoupanca(cliente2);

        // Criando banco e adicionando contas
        Banco banco = new Banco();
        banco.setNome("Banco Exemplo");
        banco.adicionarConta(contaCorrente1);
        banco.adicionarConta(contaPoupanca1);
        banco.adicionarConta(contaCorrente2);
        banco.adicionarConta(contaPoupanca2);

        // Realizando operações
        contaCorrente1.depositar(1000);
        contaPoupanca1.depositar(2000);
        contaCorrente2.depositar(1500);
        contaPoupanca2.depositar(2500);

        contaCorrente1.sacar(200);
        contaPoupanca1.sacar(500);

        contaCorrente1.transferir(300, contaCorrente2);

        ((ContaPoupanca) contaPoupanca1).calcularJuros(0.5); // Calculando juros de 0.5%
        ((ContaPoupanca) contaPoupanca2).calcularJuros(1.0); // Calculando juros de 1.0%

        // Imprimindo extratos
        System.out.println("\nExtratos dos Clientes:");
        contaCorrente1.imprimirExtrato();
        contaPoupanca1.imprimirExtrato();
        contaCorrente2.imprimirExtrato();
        contaPoupanca2.imprimirExtrato();

        // Buscando e imprimindo contas de um cliente específico
        System.out.println("\nContas de " + cliente1.getNome() + ":");
        List<Conta> contasCliente1 = banco.buscarContasPorCliente(cliente1);
        for (Conta conta : contasCliente1) {
            conta.imprimirExtrato();
        }

        System.out.println("\nContas de " + cliente2.getNome() + ":");
        List<Conta> contasCliente2 = banco.buscarContasPorCliente(cliente2);
        for (Conta conta : contasCliente2) {
            conta.imprimirExtrato();
        }
    }
}
