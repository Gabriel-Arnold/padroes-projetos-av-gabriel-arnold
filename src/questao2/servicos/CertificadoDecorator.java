package questao2.servicos;

import questao2.Decorator;
import questao2.Dinheiro;
import questao2.Fatura;

public class CertificadoDecorator extends Decorator {
    public CertificadoDecorator(Fatura fatura) { super(fatura); }

    private double custoServico() { return 300.00; }

    @Override
    public String descricao() {
        return fatura.descricao() + String.format("%n - Certificado de autenticidade: R$ %.2f", custoServico());
    }

    @Override
    public double custo() { return Dinheiro.arredondar(fatura.custo() + custoServico()); }
}
