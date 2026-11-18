package questao1.provedores;

import questao1.Fila;

public class FilaAzure implements Fila<FabricaAzure> {
    private final String identificador;

    FilaAzure(String identificador) { this.identificador = identificador; }

    @Override
    public String getIdentificador() { return identificador; }
}
