package questao1;

import questao1.provedores.FabricaAws;
import questao1.provedores.FabricaAzure;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Provisionador<FabricaAws> aws = new Provisionador<>(new FabricaAws());
        Provisionador<FabricaAzure> azure = new Provisionador<>(new FabricaAzure());
        Thread primeira = new Thread(() -> aws.provisionar("Loja", 2, 100));
        Thread segunda = new Thread(() -> aws.provisionar("Portal", 1, 50));
        primeira.start();
        segunda.start();
        primeira.join();
        segunda.join();

        azure.provisionar("Relatorios", 3, 200);
        aws.provisionar("Acima do orcamento", 1000, 10000);
        Auditoria.getInstancia().imprimirHistorico();
    }
}
