import org.jgrapht.graph.DefaultUndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.Graph;

import java.util.List;

public class GrafoPropriedades {

    private Graph<Propriedade, DefaultEdge> grafo;

    public GrafoPropriedades() {
        grafo = new DefaultUndirectedGraph<>(DefaultEdge.class); // Grafo não direcionado
    }

    // Método para adicionar uma propriedade ao grafo
    public void adicionarPropriedade(Propriedade propriedade) {
        grafo.addVertex(propriedade);
    }

    // Método para conectar propriedades (relações de adjacência)
    public void adicionarAdjacencia(Propriedade p1, Propriedade p2) {
        if (!grafo.containsVertex(p1)) {
            grafo.addVertex(p1);
        }
        if (!grafo.containsVertex(p2)) {
            grafo.addVertex(p2);
        }

        // Adicionar uma aresta entre as propriedades, representando a adjacência
        grafo.addEdge(p1, p2);
    }

    // Exibir o grafo (os nós e as conexões)
    // Método para exibir as propriedades e suas adjacências
    public void exibirGrafo() {
        for (Propriedade propriedade : grafo.vertexSet()) {
            System.out.println("Propriedade: " + propriedade);
            System.out.print("Adjacente a: ");

            // Iterar sobre todas as arestas conectando a propriedade
            for (DefaultEdge aresta : grafo.edgesOf(propriedade)) {
                // Recuperar os nós (propriedades) conectados pela aresta
                Propriedade adjacente = getAdjacente(propriedade, aresta);
                System.out.print(adjacente + " ");
            }
            System.out.println();
        }
    }

    // Método auxiliar para obter o nó adjacente à propriedade atual
    private Propriedade getAdjacente(Propriedade propriedade, DefaultEdge aresta) {
        // Se a aresta conectar a propriedade à sua origem ou destino, retorna o nó adjacente
        if (grafo.getEdgeSource(aresta).equals(propriedade)) {
            return grafo.getEdgeTarget(aresta);  // Retorna o nó adjacente (o destino da aresta)
        } else {
            return grafo.getEdgeSource(aresta);  // Retorna o nó adjacente (a origem da aresta)
        }
    }



    public Graph<Propriedade, DefaultEdge> getGrafo() {
        return grafo;
    }
}
