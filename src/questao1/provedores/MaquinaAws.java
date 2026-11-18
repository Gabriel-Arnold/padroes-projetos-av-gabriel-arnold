package questao1.provedores;

import questao1.MaquinaVirtual;

public class MaquinaAws implements MaquinaVirtual<FabricaAws> {
    private final String identificador;

    MaquinaAws(String identificador) { this.identificador = identificador; }

    @Override
    public String getIdentificador() { return identificador; }
}
