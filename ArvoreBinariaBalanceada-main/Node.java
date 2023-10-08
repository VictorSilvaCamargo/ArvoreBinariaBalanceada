public class Node {
    Node esquerda;
    int info;
    Node direita;

    public Node(int info) {
        this.info = info;
        esquerda = null;
        direita = null;
    }
}