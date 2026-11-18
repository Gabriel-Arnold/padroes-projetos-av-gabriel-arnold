package questao2.comissoes;

import questao2.Strategy;

public class Veiculos implements Strategy {
    @Override
    public double calcularComissao(double valorVenda) { return Math.min(valorVenda * 0.08, 5000); }
}
