package dfs;

import java.util.List;

/**
 * Demostración de DFS sobre el mismo grafo usado en {@code 1_BFS}, para
 * comparar directamente el orden de visita de ambos algoritmos:
 *
 * <pre>
 *      A - B - D
 *      |       |
 *      C - - - E - F
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("B", "D");
        grafo.agregarArista("C", "E");
        grafo.agregarArista("D", "E");
        grafo.agregarArista("E", "F");

        List<String> recursivo = DFS.recorridoRecursivo(grafo, "A");
        System.out.println("DFS recursivo desde A: " + recursivo);

        List<String> iterativo = DFS.recorridoIterativo(grafo, "A");
        System.out.println("DFS iterativo desde A: " + iterativo);

        System.out.println("¿Tiene ciclo? " + DFS.tieneCiclo(grafo));
    }
}
