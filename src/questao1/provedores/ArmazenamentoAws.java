package questao1.provedores;

import questao1.Armazenamento;

public class ArmazenamentoAws implements Armazenamento<FabricaAws> {
    private final String identificador;

    ArmazenamentoAws(String identificador) { this.identificador = identificador; }

    @Override
    public String getIdentificador() { return identificador; }
}
