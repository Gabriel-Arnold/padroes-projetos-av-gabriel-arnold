package questao2.servicos;

import questao2.Decorator;
import questao2.Dinheiro;
import questao2.Fatura;

public class EmbalagemDecorator extends Decorator {
    public EmbalagemDecorator(Fatura fatura) { super(fatura); }

    private double custoServico() { return 180.00; }

    @Override
    public String descricao() {
        return fatura.descricao() + String.format("%n - Embalagem especial: R$ %.2f", custoServico());
    }

    @Override
    public double custo() { return Dinheiro.arredondar(fatura.custo() + custoServico()); }
}
