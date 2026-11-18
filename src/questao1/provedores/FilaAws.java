package questao1.provedores;

import questao1.Fila;

public class FilaAws implements Fila<FabricaAws> {
    private final String identificador;

    FilaAws(String identificador) { this.identificador = identificador; }

    @Override
    public String getIdentificador() { return identificador; }
}
