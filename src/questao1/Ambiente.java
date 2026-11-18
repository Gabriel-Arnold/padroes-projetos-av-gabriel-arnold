package questao1;

import java.util.List;

public class Ambiente<P> {
    private final String nome;
    private final String provedor;
    private final int gigabytes;
    private final double custo;
    private final List<MaquinaVirtual<P>> maquinas;
    private final Armazenamento<P> armazenamento;
    private final Fila<P> fila;

    Ambiente(String nome, String provedor, int gigabytes, double custo,
             List<MaquinaVirtual<P>> maquinas, Armazenamento<P> armazenamento, Fila<P> fila) {
        this.nome = nome;
        this.provedor = provedor;
        this.gigabytes = gigabytes;
        this.custo = custo;
        this.maquinas = List.copyOf(maquinas);
        this.armazenamento = armazenamento;
        this.fila = fila;
    }

    public void imprimirResumo() {
        StringBuilder resumo = new StringBuilder("\nAmbiente: " + nome + " | Provedor: " + provedor
                + " | Regiao: " + Configuracao.getInstancia().getRegiao());
        for (MaquinaVirtual<P> maquina : maquinas) {
            resumo.append("\n - Maquina: ").append(maquina.getIdentificador());
        }
        resumo.append("\n - Armazenamento: ").append(armazenamento.getIdentificador());
        resumo.append("\n - Fila: ").append(fila.getIdentificador());
        resumo.append(String.format("\nArmazenamento: %d GB | Custo mensal estimado: R$ %.2f", gigabytes, custo));
        System.out.println(resumo);
    }

    public double getCusto() { return custo; }
    public List<MaquinaVirtual<P>> getMaquinas() { return maquinas; }
    public Armazenamento<P> getArmazenamento() { return armazenamento; }
    public Fila<P> getFila() { return fila; }
}
