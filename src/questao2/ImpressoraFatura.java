package questao2;

public class ImpressoraFatura {
    public void imprimir(Fatura fatura) {
        System.out.println("\nFatura do comprador:");
        System.out.println(fatura.descricao());
        System.out.printf("Total a pagar: R$ %.2f%n", fatura.custo());
    }
}
