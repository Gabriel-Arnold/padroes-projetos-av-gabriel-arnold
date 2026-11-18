package questao1;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public final class Configuracao {
    private final String regiao;
    private final double orcamentoMensal;

    private Configuracao() {
        Properties propriedades = new Properties();
        try (InputStream arquivo = Files.newInputStream(Path.of("config.properties"))) {
            propriedades.load(arquivo);
        } catch (IOException e) {
            throw new IllegalStateException("Execute na raiz do projeto, onde esta config.properties.", e);
        }
        regiao = propriedades.getProperty("regiao");
        orcamentoMensal = Double.parseDouble(propriedades.getProperty("orcamento.mensal"));
        if (regiao == null || regiao.isBlank() || !Double.isFinite(orcamentoMensal) || orcamentoMensal < 0) {
            throw new IllegalArgumentException("Regiao ou orcamento invalido.");
        }
    }

    private static class Holder {
        private static final Configuracao INSTANCIA = new Configuracao();
    }

    public static Configuracao getInstancia() { return Holder.INSTANCIA; }
    public String getRegiao() { return regiao; }
    public double getOrcamentoMensal() { return orcamentoMensal; }
}
