package questao1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class Auditoria {
    private static final Auditoria INSTANCIA = new Auditoria();
    private final List<String> historico = new ArrayList<>();

    private Auditoria() {}
    public static Auditoria getInstancia() { return INSTANCIA; }

    public synchronized void registrar(String ambiente, String provedor, String resultado) {
        historico.add(LocalDateTime.now() + " | " + ambiente + " | " + provedor + " | " + resultado);
    }

    public synchronized List<String> getHistorico() { return new ArrayList<>(historico); }

    public synchronized void imprimirHistorico() {
        System.out.println("\nHistorico de auditoria:");
        for (String registro : historico) System.out.println(registro);
    }
}
