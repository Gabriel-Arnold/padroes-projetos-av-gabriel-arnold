package questao1.provedores;

import questao1.MaquinaVirtual;

public class MaquinaAzure implements MaquinaVirtual<FabricaAzure> {
    private final String identificador;

    MaquinaAzure(String identificador) { this.identificador = identificador; }

    @Override
    public String getIdentificador() { return identificador; }
}
