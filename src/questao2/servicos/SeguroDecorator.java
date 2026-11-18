package questao2.servicos;

import questao2.Decorator;
import questao2.Dinheiro;
import questao2.Fatura;

public class SeguroDecorator extends Decorator {
    public SeguroDecorator(Fatura fatura) { super(fatura); }

    private double custoServico() { return Dinheiro.arredondar(valorVenda() * 0.015); }

    @Override
    public String descricao() {
        return fatura.descricao() + String.format("%n - Seguro de transporte: R$ %.2f", custoServico());
    }

    @Override
    public double custo() { return Dinheiro.arredondar(fatura.custo() + custoServico()); }
}
