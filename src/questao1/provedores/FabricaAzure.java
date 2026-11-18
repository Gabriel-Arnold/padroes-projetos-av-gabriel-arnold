package questao1.provedores;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

import questao1.Armazenamento;
import questao1.FabricaRecursos;
import questao1.Fila;
import questao1.MaquinaVirtual;

public class FabricaAzure implements FabricaRecursos<FabricaAzure> {
    private static final AtomicInteger MAQUINAS = new AtomicInteger();
    private static final AtomicInteger ARMAZENAMENTOS = new AtomicInteger();
    private static final AtomicInteger FILAS = new AtomicInteger();

    @Override
    public String getProvedor() { return "Azure"; }
    @Override
    public double estimarCusto(int maquinas, int gigabytes) {
        return new BigDecimal("0.12").multiply(BigDecimal.valueOf(maquinas)).multiply(BigDecimal.valueOf(730))
                .add(new BigDecimal("0.02").multiply(BigDecimal.valueOf(gigabytes)))
                .add(new BigDecimal("0.50")).doubleValue();
    }
    @Override
    public MaquinaVirtual<FabricaAzure> criarMaquina() {
        return new MaquinaAzure("vm-" + MAQUINAS.incrementAndGet());
    }
    @Override
    public Armazenamento<FabricaAzure> criarArmazenamento() {
        return new ArmazenamentoAzure("blob://" + ARMAZENAMENTOS.incrementAndGet());
    }
    @Override
    public Fila<FabricaAzure> criarFila() {
        return new FilaAzure("sb-" + FILAS.incrementAndGet());
    }
}
