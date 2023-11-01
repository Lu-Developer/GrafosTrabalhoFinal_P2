package model;

public class Aresta {

    private Vertice origem;
    private Vertice destino;
    private int peso = 0;

    public Aresta(final Vertice origem, final Vertice destino) {
        this.origem = origem;
        this.destino = destino;
    }
    public Aresta(final Vertice origem, final Vertice destino, final int peso) {        
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public int setPeso(int peso) {
        this.peso = peso;
        return peso;
    }

    public int getPeso() {
        return peso;
    }

}
