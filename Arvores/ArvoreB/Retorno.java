package Arvores.ArvoreB;

@SuppressWarnings("FieldMayBeFinal")
class Retorno {
    private ABNode node;
    private int pos;

    Retorno(ABNode node, int pos){
        this.node = node;
        this.pos = pos;
    }

    ABNode getNodeRetorno() {
        return node;
    }
    int getPosRetorno() {
        return pos;
    }
}
