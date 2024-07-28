import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta{
    private static final int AGENCIA_PADRAO = 0;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<Transacao> historicoTransacoes = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        historicoTransacoes.add(new Transacao("Depósito", valor));
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
        historicoTransacoes.add(new Transacao("Saque", -valor));
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        historicoTransacoes.add(new Transacao("Transferência para conta " + contaDestino.getNumero(), -valor));
        contaDestino.historicoTransacoes.add(new Transacao("Transferência da conta " + this.getNumero(), valor));
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: R$ %.2f", this.saldo));
    }

    public void imprimirExtratoDetalhado() {
        for (Transacao transacao : historicoTransacoes) {
            System.out.println(transacao);
        }
    }
    
}