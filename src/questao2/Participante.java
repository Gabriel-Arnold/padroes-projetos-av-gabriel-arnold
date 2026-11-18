package questao2;

public class Participante implements Licitante {
    private final String nome;

    public Participante(String nome) { this.nome = nome; }
    public String getNome() { return nome; }

    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.printf("[%s] Lote: %s | Novo lance: R$ %.2f%n", nome, lote.getNome(), lance.getValor());
    }
}
