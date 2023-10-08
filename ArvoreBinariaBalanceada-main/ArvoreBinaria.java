public class ArvoreBinaria {
    Node raiz;

    public void inserir(int valor) {
        if (raiz == null) {
            raiz = new Node(valor);
            return;
        }

        Node currentNode = raiz;

        while (true) {
            if (valor < currentNode.info) {
                if (currentNode.esquerda == null) {
                    currentNode.esquerda = new Node(valor);
                    break;
                }
                currentNode = currentNode.esquerda;
            } else if (valor > currentNode.info) {
                if (currentNode.direita == null) {
                    currentNode.direita = new Node(valor);
                    break;
                }
                currentNode = currentNode.direita;
            } else {

                break;
            }
        }
    }

    public boolean buscar(int valor) {
        Node currentNode = raiz;
        while (currentNode != null) {
            if (currentNode.info == valor) {
                return true;
            } else if (valor < currentNode.info) {
                currentNode = currentNode.esquerda;
            } else {
                currentNode = currentNode.direita;
            }
        }
        return false;
    }

    public void remover(int valor) {
        Node currentNode = raiz;
        Node parentNode = null;

        while (currentNode != null) {
            if (valor < currentNode.info) {
                parentNode = currentNode;
                currentNode = currentNode.esquerda;
            } else if (valor > currentNode.info) {
                parentNode = currentNode;
                currentNode = currentNode.direita;
            } else {
                if (currentNode.esquerda == null && currentNode.direita == null) {
                    if (parentNode == null) {
                        raiz = null;
                    } else if (currentNode == parentNode.esquerda) {
                        parentNode.esquerda = null;
                    } else {
                        parentNode.direita = null;
                    }
                } else if (currentNode.esquerda == null) {
                    if (parentNode == null) {
                        raiz = currentNode.direita;
                    } else if (currentNode == parentNode.esquerda) {
                        parentNode.esquerda = currentNode.direita;
                    } else {
                        parentNode.direita = currentNode.direita;
                    }
                } else if (currentNode.direita == null) {
                    if (parentNode == null) {
                        raiz = currentNode.esquerda;
                    } else if (currentNode == parentNode.esquerda) {
                        parentNode.esquerda = currentNode.esquerda;
                    } else {
                        parentNode.direita = currentNode.esquerda;
                    }
                } else {
                    Node menorNoEsquerda = encontrarMenor(currentNode.direita);
                    currentNode.info = menorNoEsquerda.info;
                }
                break;
            }
        }
    }

    private Node encontrarMenor(Node node) {
        while (node.esquerda != null) {
            node = node.esquerda;
        }
        return node;
    }
}
