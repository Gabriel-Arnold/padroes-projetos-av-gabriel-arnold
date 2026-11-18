package questao2;

public class Venda implements Fatura {
    private final String lote;
    private final double valor;

    public Venda(Lote lote) {
        lote.exigirVenda();
        this.lote = lote.getNome();
        this.valor = lote.getLanceAtual();
    }

    @Override
    public String descricao() { return String.format("Lote: %s%nValor de venda: R$ %.2f", lote, valor); }
    @Override
    public double custo() { return valor; }
    @Override
    public double valorVenda() { return valor; }
}
