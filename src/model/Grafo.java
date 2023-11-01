package model;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private List<Vertice> listaVertices;

    public Grafo() {
        listaVertices = new ArrayList<Vertice>();
    }

    public Vertice addVertice(final String nome) {
        Vertice v = new Vertice(nome);
        listaVertices.add(v);
        return v;
    }

    public boolean hasVertice(final String nome) {
        for (Vertice vertice : listaVertices) {
            if (vertice.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public Vertice getVerticeByName(final String nome) {
        for (Vertice vertice : listaVertices) {
            if(vertice.getNome().equals(nome)) {
                return vertice;
            }
        }
        return null;
    }

    public List<Vertice> getListaVertices() {
        return listaVertices;
    }

    public Aresta addAresta(final Vertice origem, final Vertice destino) {
        Aresta a = new Aresta(origem, destino);
        origem.getAdj().add(a);
        return a;
    }

    public Aresta addAresta(final Vertice origem, final Vertice destino, final int peso) {
        Aresta a = new Aresta(origem, destino, peso);
        origem.getAdj().add(a);
        return a;
    }

    public Aresta getAresta(final Vertice origem, final Vertice destino){
        for (Aresta aresta : origem.getAdj()) {
            if (aresta.getDestino().equals(destino)){
                return aresta;
            }
        }
        return null;
    }

    public int getDegree(Vertice vertice) {
        return vertice.getAdj().size();
    }

    public int getInDegree(Vertice vertice) {
        int inDegree = 0;
        for (Vertice v : listaVertices) {
            for (Aresta a : v.getAdj()) {
                if (a.getDestino() == vertice) {
                    inDegree++;
                }
            }
        }
        return inDegree;
    }

    public void printDegree() {
        for (Vertice v : listaVertices) {
            int degree = getDegree(v);
            int inDegree = getInDegree(v);
            System.out.println("Grau de emissão de "+v.getNome()+": "+degree);
            System.out.println("Grau de recepção de "+v.getNome()+": "+inDegree);
        }
    }

    @Override
    public String toString() {

        String r = "";

        for (Vertice v : listaVertices) {
            r += v.getNome() +" -> ";
            for (Aresta a : v.getAdj()) {
                v = a.getDestino();
                r += "["+v.getNome()+"] -> ";
            }
            r += "[/]";
            r += "\n";
        }
        return r;
    }

}
