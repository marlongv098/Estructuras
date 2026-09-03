package prim;

import java.util.List;

/**
 * Demostración de Prim sobre el mismo grafo ponderado de {@code 3_Dijsktra}
 * y {@code 4_Floyd_Warshall}, para comparar el MST resultante con las
 * distancias de camino más corto calculadas en esos módulos (son problemas
 * distintos: el MST minimiza el peso total de las aristas usadas para
 * conectar todos los vértices, no la distancia entre un par en particular).
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

        List<Prim.AristaMST> mst = Prim.calcularMST(grafo, "A");
        System.out.println("Aristas del MST: " + mst);
        System.out.println("Peso total del MST: " + Prim.pesoTotal(mst));
    }
}
