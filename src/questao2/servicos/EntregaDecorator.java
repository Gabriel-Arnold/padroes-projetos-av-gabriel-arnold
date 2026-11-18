package questao2.servicos;

import questao2.Decorator;
import questao2.Dinheiro;
import questao2.Fatura;

public class EntregaDecorator extends Decorator {
    public EntregaDecorator(Fatura fatura) { super(fatura); }

    private double custoServico() { return 450.00; }

    @Override
    public String descricao() {
        return fatura.descricao() + String.format("%n - Entrega expressa: R$ %.2f", custoServico());
    }

    @Override
    public double custo() { return Dinheiro.arredondar(fatura.custo() + custoServico()); }
}
