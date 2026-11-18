package questao1.provedores;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

import questao1.Armazenamento;
import questao1.FabricaRecursos;
import questao1.Fila;
import questao1.MaquinaVirtual;

public class FabricaAws implements FabricaRecursos<FabricaAws> {
    private static final AtomicInteger MAQUINAS = new AtomicInteger();
    private static final AtomicInteger ARMAZENAMENTOS = new AtomicInteger();
    private static final AtomicInteger FILAS = new AtomicInteger();

    @Override
    public String getProvedor() { return "Aws"; }
    @Override
    public double estimarCusto(int maquinas, int gigabytes) {
        return new BigDecimal("0.10").multiply(BigDecimal.valueOf(maquinas)).multiply(BigDecimal.valueOf(730))
                .add(new BigDecimal("0.023").multiply(BigDecimal.valueOf(gigabytes)))
                .add(new BigDecimal("0.40")).doubleValue();
    }
    @Override
    public MaquinaVirtual<FabricaAws> criarMaquina() {
        return new MaquinaAws("i-" + MAQUINAS.incrementAndGet());
    }
    @Override
    public Armazenamento<FabricaAws> criarArmazenamento() {
        return new ArmazenamentoAws("s3://" + ARMAZENAMENTOS.incrementAndGet());
    }
    @Override
    public Fila<FabricaAws> criarFila() {
        return new FilaAws("sqs-" + FILAS.incrementAndGet());
    }
}
