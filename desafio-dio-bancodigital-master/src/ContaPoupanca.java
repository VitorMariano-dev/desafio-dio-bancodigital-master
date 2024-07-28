public class ContaPoupanca extends Conta {
    
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }
    
    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
        super.imprimirExtratoDetalhado();
    }
    
    public void calcularJuros(double taxa) {
        double juros = this.saldo * (taxa / 100);
        this.depositar(juros);
        historicoTransacoes.add(new Transacao("Juros", juros));
    }
}