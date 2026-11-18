package questao2.comissoes;

import questao2.Strategy;

public class Imoveis implements Strategy {
    @Override
    public double calcularComissao(double valorVenda) { return valorVenda * 0.03 + 1500; }
}
