package bfs;

import java.util.List;
import java.util.Map;

/**
 * Demostración de BFS sobre un grafo pequeño no ponderado.
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

        List<String> orden = BFS.recorrido(grafo, "A");
        System.out.println("Recorrido BFS desde A: " + orden);

        Map<String, Integer> distancias = BFS.distancias(grafo, "A");
        System.out.println("Distancias desde A: " + distancias);
    }
}
