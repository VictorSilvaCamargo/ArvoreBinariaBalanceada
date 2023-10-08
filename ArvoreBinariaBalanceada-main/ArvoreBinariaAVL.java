public class ArvoreBinariaAVL {
    NodeAVL raiz;

    public void inserir(int valor) {
        if (raiz == null) {
            raiz = new NodeAVL(valor);
            return;
        }

        NodeAVL currentNode = raiz;
        NodeAVL parentNode = null;

        while (currentNode != null) {
            parentNode = currentNode;

            if (valor < currentNode.info) {
                currentNode = currentNode.esquerda;
            } else {
                currentNode = currentNode.direita;
            }
        }

        if (valor < parentNode.info) {
            parentNode.esquerda = new NodeAVL(valor);
        } else {
            parentNode.direita = new NodeAVL(valor);
        }

        currentNode = raiz;
        while (currentNode != null) {
            currentNode.altura = 1 + max(altura(currentNode.esquerda), altura(currentNode.direita));
            currentNode = balancear(currentNode, valor);

            if (valor < currentNode.info) {
                currentNode = currentNode.esquerda;
            } else {
                currentNode = currentNode.direita;
            }
        }
    }


    public boolean buscar(int valor) {
        NodeAVL currentNode = raiz;
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
        if (raiz == null) {
            return;
        }

        NodeAVL currentNode = raiz;
        NodeAVL parentNode = null;

        while (currentNode != null) {
            if (valor < currentNode.info) {
                parentNode = currentNode;
                currentNode = currentNode.esquerda;
            } else if (valor > currentNode.info) {
                parentNode = currentNode;
                currentNode = currentNode.direita;
            } else {
                if (currentNode.esquerda == null || currentNode.direita == null) {
                    NodeAVL temp;
                    if (currentNode.esquerda != null) {
                        temp = currentNode.esquerda;
                    } else {
                        temp = currentNode.direita;
                    }

                    if (parentNode == null) {
                        raiz = temp;
                    } else if (parentNode.esquerda == currentNode) {
                        parentNode.esquerda = temp;
                    } else {
                        parentNode.direita = temp;
                    }
                } else {
                    NodeAVL temp = encontrarMenor(currentNode.direita);
                    currentNode.info = temp.info;
                    valor = temp.info;
                    parentNode = currentNode;
                    currentNode = currentNode.direita;
                }
            }
        }

        currentNode = raiz;
        while (currentNode != null) {
            int alturaEsquerda;
            int alturaDireita;

            if (currentNode.esquerda != null) {
                alturaEsquerda = currentNode.esquerda.altura;
            } else {
                alturaEsquerda = -1;
            }

            if (currentNode.direita != null) {
                alturaDireita = currentNode.direita.altura;
            } else {
                alturaDireita = -1;
            }

            if (alturaEsquerda > alturaDireita) {
                currentNode.altura = 1 + alturaEsquerda;
            } else {
                currentNode.altura = 1 + alturaDireita;
            }

            currentNode = balancear(currentNode, valor);

            if (valor < currentNode.info) {
                currentNode = currentNode.esquerda;
            } else {
                currentNode = currentNode.direita;
            }
        }

    }

    private int altura(NodeAVL node) {
        if (node == null) {
            return -1;
        }
        return node.altura;
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }


    private NodeAVL rotacaoEsquerda(NodeAVL x) {
        if (x == null || x.direita == null) {
            return x;
        }

        NodeAVL y = x.direita;
        NodeAVL T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = 1 + max(altura(x.esquerda), altura(x.direita));
        y.altura = 1 + max(altura(y.esquerda), altura(y.direita));

        return y;
    }

    private NodeAVL rotacaoDireita(NodeAVL x) {
        if (x == null || x.esquerda == null) {
            return x;
        }

        NodeAVL y = x.esquerda;
        NodeAVL T2 = y.direita;

        y.direita = x;
        x.esquerda = T2;

        x.altura = 1 + max(altura(x.esquerda), altura(x.direita));
        y.altura = 1 + max(altura(y.esquerda), altura(y.direita));

        return y;
    }

    private NodeAVL balancear(NodeAVL node, int valor) {
        if (node == null) {
            return node;
        }

        int fb = fatorBalanceamento(node);

        if (fb > 1) {
            if (valor < node.esquerda.info) {
                return rotacaoDireita(node);
            } else {
                node.esquerda = rotacaoEsquerda(node.esquerda);
                return rotacaoDireita(node);
            }
        }

        if (fb < -1) {
            if (valor > node.direita.info) {
                return rotacaoEsquerda(node);
            } else {
                node.direita = rotacaoDireita(node.direita);
                return rotacaoEsquerda(node);
            }
        }

        return node;
    }

    private int fatorBalanceamento(NodeAVL node) {
        if (node == null) {
            return 0;
        }
        return altura(node.esquerda) - altura(node.direita);
    }

    private NodeAVL encontrarMenor(NodeAVL node) {
        while (node.esquerda != null) {
            node = node.esquerda;
        }
        return node;
    }
}
