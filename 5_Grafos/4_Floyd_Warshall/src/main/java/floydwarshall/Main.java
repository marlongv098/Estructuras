package floydwarshall;

import java.util.List;

/**
 * Demostración de Floyd-Warshall sobre el mismo grafo ponderado de
 * {@code 3_Dijsktra}, para comparar el resultado "un-origen" de Dijkstra
 * contra el resultado "todos-los-pares" de Floyd-Warshall.
 */
public class Main {
    public static void main(String[] args) {
        GrafoMatriz grafo = new GrafoMatriz(List.of("A", "B", "C", "D", "E"));
        grafo.agregarArista("A", "B", 4);
        grafo.agregarArista("A", "C", 1);
        grafo.agregarArista("B", "D", 2);
        grafo.agregarArista("C", "D", 5);
        grafo.agregarArista("C", "E", 8);
        grafo.agregarArista("D", "E", 3);

        int[][] distancias = FloydWarshall.calcular(grafo);

        System.out.println("Distancia A -> E: " + FloydWarshall.distanciaEntre(distancias, grafo, "A", "E"));
        System.out.println("Distancia B -> C: " + FloydWarshall.distanciaEntre(distancias, grafo, "B", "C"));
        System.out.println("¿Ciclo negativo? " + FloydWarshall.tieneCicloNegativo(distancias));
    }
}
