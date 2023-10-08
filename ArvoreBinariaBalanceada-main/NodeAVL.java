public class NodeAVL {
    NodeAVL esquerda;
    int info;
    NodeAVL direita;
    int altura;

    public NodeAVL(int info) {
        this.info = info;
        esquerda = null;
        direita = null;
        altura = 0;
    }
}
