package questao1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Provisionador<P> {
    private final FabricaRecursos<P> fabrica;

    public Provisionador(FabricaRecursos<P> fabrica) { this.fabrica = Objects.requireNonNull(fabrica); }

    public Ambiente<P> provisionar(String nome, int maquinas, int gigabytes) {
        if (nome == null || nome.isBlank() || maquinas < 0 || gigabytes < 0) {
            return recusar(nome, "solicitacao invalida");
        }
        double custo = fabrica.estimarCusto(maquinas, gigabytes);
        if (custo > Configuracao.getInstancia().getOrcamentoMensal()) {
            return recusar(nome, "custo estimado ultrapassa o orcamento");
        }

        List<MaquinaVirtual<P>> recursos = new ArrayList<>();
        for (int i = 0; i < maquinas; i++) recursos.add(fabrica.criarMaquina());
        Ambiente<P> ambiente = new Ambiente<>(nome, fabrica.getProvedor(), gigabytes, custo,
                recursos, fabrica.criarArmazenamento(), fabrica.criarFila());
        ambiente.imprimirResumo();
        Auditoria.getInstancia().registrar(nome, fabrica.getProvedor(), "ACEITO");
        return ambiente;
    }

    private Ambiente<P> recusar(String nome, String motivo) {
        System.out.println("Ambiente " + nome + " RECUSADO: " + motivo);
        Auditoria.getInstancia().registrar(nome, fabrica.getProvedor(), "RECUSADO: " + motivo);
        return null;
    }
}
