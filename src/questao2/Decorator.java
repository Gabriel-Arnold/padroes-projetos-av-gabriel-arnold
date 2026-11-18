package questao2;

import java.util.Objects;

public abstract class Decorator implements Fatura {
    protected final Fatura fatura;

    public Decorator(Fatura fatura) { this.fatura = Objects.requireNonNull(fatura); }

    @Override
    public double valorVenda() { return fatura.valorVenda(); }
}
