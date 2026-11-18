package questao2;

import java.util.ArrayList;
import java.util.List;

public class Auditor implements Observer {
    private final List<String> historico = new ArrayList<>();

    @Override
    public void atualizar(Lote lote, Lance lance) {
        String registro = lance.getDataHora() + " | " + lote.getNome() + " | "
                + lance.getParticipante().getNome() + String.format(" | R$ %.2f", lance.getValor());
        historico.add(registro);
        System.out.println("[AUDITOR] " + registro);
    }

    public List<String> getHistorico() { return new ArrayList<>(historico); }
}
