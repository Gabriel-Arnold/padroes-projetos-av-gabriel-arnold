package questao2;

public class Painel implements Observer {
    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.printf("[PAINEL] %s | Maior lance: R$ %.2f | Total de lances: %d%n",
                lote.getNome(), lance.getValor(), lote.getLances().size());
    }
}
