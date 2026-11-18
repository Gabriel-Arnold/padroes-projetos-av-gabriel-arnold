package questao2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lote {
    private final String nome;
    private final String categoria;
    private final double precoInicial;
    private final double precoReserva;
    private double lanceAtual;
    private boolean aberto = true;
    private boolean vendido;
    private double comissao;
    private Strategy strategy;
    private final List<Observer> observers = new ArrayList<>();
    private final List<Lance> lances = new ArrayList<>();

    public Lote(String nome, String categoria, double precoInicial, double precoReserva, Strategy strategy) {
        if (!Double.isFinite(precoInicial) || !Double.isFinite(precoReserva) || precoInicial < 0 || precoReserva < 0) {
            throw new IllegalArgumentException("Precos invalidos.");
        }
        this.nome = Objects.requireNonNull(nome);
        this.categoria = Objects.requireNonNull(categoria);
        this.precoInicial = precoInicial;
        this.lanceAtual = precoInicial;
        this.precoReserva = precoReserva;
        this.strategy = Objects.requireNonNull(strategy);
    }

    public void adicionarObserver(Observer observer) {
        Objects.requireNonNull(observer);
        if (!observers.contains(observer)) observers.add(observer);
    }

    public void removerObserver(Observer observer) { observers.remove(observer); }

    public void setStrategy(Strategy strategy) {
        if (!aberto) throw new IllegalStateException("Lote encerrado.");
        this.strategy = Objects.requireNonNull(strategy);
    }

    public boolean darLance(Licitante participante, double valor) {
        if (!aberto) {
            System.out.println("Lance recusado: lote " + nome + " encerrado.");
            return false;
        }

        double minimo = BigDecimal.valueOf(lanceAtual).multiply(new BigDecimal("1.05"))
                .setScale(2, RoundingMode.CEILING).doubleValue();
        if (participante == null || !Double.isFinite(valor) || valor < minimo
                || BigDecimal.valueOf(valor).stripTrailingZeros().scale() > 2) {
            System.out.printf("Lance recusado em %s: informe participante e valor em centavos de pelo menos R$ %.2f.%n", nome, minimo);
            return false;
        }
        Lance lance = new Lance(participante, valor);
        lanceAtual = valor;
        lances.add(lance);
        for (Observer observer : new ArrayList<>(observers)) {
            if (observer != participante) observer.atualizar(this, lance);
        }
        return true;
    }

    public void encerrar() {
        if (!aberto) throw new IllegalStateException("Lote ja encerrado.");
        aberto = false;
        vendido = !lances.isEmpty() && lanceAtual >= precoReserva;
        if (vendido) comissao = Dinheiro.arredondar(strategy.calcularComissao(lanceAtual));
        System.out.println("Lote " + nome + (vendido ? " vendido." : " nao vendido."));
    }

    public void imprimirAcerto() {
        exigirVenda();
        System.out.printf("Acerto do vendedor - %s%nVenda: R$ %.2f%nComissao: R$ %.2f%nLiquido: R$ %.2f%n",
                nome, lanceAtual, comissao, Dinheiro.arredondar(lanceAtual - comissao));
    }

    public void exigirVenda() {
        if (aberto || !vendido) throw new IllegalStateException("O lote precisa estar encerrado e vendido.");
    }

    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public double getPrecoInicial() { return precoInicial; }
    public double getLanceAtual() { return lanceAtual; }
    public boolean isVendido() { return vendido; }
    public double getComissao() { exigirVenda(); return comissao; }
    public List<Lance> getLances() { return new ArrayList<>(lances); }
}
