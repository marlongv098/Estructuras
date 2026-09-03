package dijkstra;

import java.util.List;

/**
 * Demostración de Dijkstra sobre un grafo ponderado pequeño.
 *
 * <pre>
 *        4
 *    A ----- B
 *    |       |
 *  1 |       | 2
 *    |       |
 *    C ----- D
 *        5
 *    C ------------ E   (peso 8)
 *    D ------------ E   (peso 3)
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        GrafoPonderado grafo = new GrafoPonderado();
        grafo.agregarArista("A", "B", 4);
        grafo.agregarArista("A", "C", 1);
        grafo.agregarArista("B", "D", 2);
        grafo.agregarArista("C", "D", 5);
        grafo.agregarArista("C", "E", 8);
        grafo.agregarArista("D", "E", 3);

        Dijkstra.Resultado resultado = Dijkstra.calcular(grafo, "A");
        System.out.println("Distancias desde A: " + resultado.distancias());

        List<String> camino = Dijkstra.reconstruirCamino(resultado.predecesores(), "A", "E");
        System.out.println("Camino más corto A -> E: " + camino);
    }
}
