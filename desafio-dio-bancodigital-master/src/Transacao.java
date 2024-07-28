public class Transacao {
    private String tipo;
    private double valor;
    private String data;

    public Transacao(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = java.time.LocalDate.now().toString(); 
    }

    @Override
    public String toString() {
        return String.format("Data: %s | Tipo: %s | Valor: R$ %.2f", this.data, this.tipo, this.valor);
    }
}