package kruskal;

import java.util.List;

/**
 * Demostración de Kruskal sobre el mismo grafo ponderado usado en
 * {@code 5_Prim}, para comprobar que ambos algoritmos llegan al mismo peso
 * total de MST por caminos completamente distintos.
 */
public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.agregarArista("A", "B", 4);
        grafo.agregarArista("A", "C", 1);
        grafo.agregarArista("B", "D", 2);
        grafo.agregarArista("C", "D", 5);
        grafo.agregarArista("C", "E", 8);
        grafo.agregarArista("D", "E", 3);

        List<Grafo.Arista> mst = Kruskal.calcularMST(grafo);
        System.out.println("Aristas del MST: " + mst);
        System.out.println("Peso total del MST: " + Kruskal.pesoTotal(mst));
    }
}
