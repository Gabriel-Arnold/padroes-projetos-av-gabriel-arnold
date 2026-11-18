package questao2.comissoes;

import questao2.Strategy;

public class Arte implements Strategy {
    @Override
    public double calcularComissao(double valorVenda) { return valorVenda * 0.20; }
}
