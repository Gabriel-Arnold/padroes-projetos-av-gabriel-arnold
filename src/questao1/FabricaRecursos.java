package questao1;

public interface FabricaRecursos<P> {
    String getProvedor();
    double estimarCusto(int maquinas, int gigabytes);
    MaquinaVirtual<P> criarMaquina();
    Armazenamento<P> criarArmazenamento();
    Fila<P> criarFila();
}
