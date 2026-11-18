package questao1.provedores;

import questao1.Armazenamento;

public class ArmazenamentoAzure implements Armazenamento<FabricaAzure> {
    private final String identificador;

    ArmazenamentoAzure(String identificador) { this.identificador = identificador; }

    @Override
    public String getIdentificador() { return identificador; }
}
