package questao2;

import questao2.comissoes.Arte;
import questao2.comissoes.Eletronicos;
import questao2.comissoes.Veiculos;
import questao2.servicos.CertificadoDecorator;
import questao2.servicos.EmbalagemDecorator;
import questao2.servicos.SeguroDecorator;

public class Main {
    public static void main(String[] args) {
        Lote quadro = new Lote("Quadro", "Arte", 1000, 1200, new Arte());
        Lote carro = new Lote("Carro", "Veiculos", 20000, 30000, new Veiculos());
        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        Painel painel = new Painel();
        Auditor auditor = new Auditor();

        for (Lote lote : new Lote[]{quadro, carro}) {
            lote.adicionarObserver(ana);
            lote.adicionarObserver(bruno);
            lote.adicionarObserver(carla);
            lote.adicionarObserver(painel);
            lote.adicionarObserver(auditor);
        }

        quadro.darLance(ana, 1050);
        quadro.darLance(bruno, 1060);
        quadro.darLance(bruno, 1150);
        quadro.removerObserver(carla);
        quadro.darLance(ana, 1250);
        quadro.setStrategy(new Eletronicos());
        carro.darLance(carla, 21000);
        quadro.encerrar();
        carro.encerrar();
        quadro.darLance(bruno, 1400);
        quadro.imprimirAcerto();

        Fatura fatura = new Venda(quadro);
        fatura = new SeguroDecorator(fatura);
        fatura = new CertificadoDecorator(fatura);
        fatura = new EmbalagemDecorator(fatura);
        fatura = new EmbalagemDecorator(fatura);
        new ImpressoraFatura().imprimir(fatura);
    }
}
