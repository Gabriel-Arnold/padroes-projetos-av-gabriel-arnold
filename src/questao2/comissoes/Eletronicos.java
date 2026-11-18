package questao2.comissoes;

import questao2.Strategy;

public class Eletronicos implements Strategy {
    @Override
    public double calcularComissao(double valorVenda) { return Math.max(valorVenda * 0.12, 50); }
}
