package floydwarshall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Grafo ponderado no dirigido representado mediante <b>matriz de
 * adyacencia</b>. Floyd-Warshall calcula distancias entre <em>todos</em> los
 * pares de vértices, así que —a diferencia de BFS/DFS/Dijkstra, que solo
 * necesitan consultar los vecinos de un vértice a la vez— aquí conviene
 * O(1) de acceso a cualquier par (i, j), que es exactamente lo que ofrece
 * una matriz n×n.
 */
public class GrafoMatriz {

    /** Representa "sin conexión directa" evitando overflow al sumar dos infinitos. */
    public static final int INFINITO = Integer.MAX_VALUE / 2;

    private final Map<String, Integer> indice = new LinkedHashMap<>();
    private final List<String> vertices = new ArrayList<>();
    private final int[][] matriz;

    public GrafoMatriz(List<String> vertices) {
        for (String vertice : vertices) {
            indice.put(vertice, this.vertices.size());
            this.vertices.add(vertice);
        }
        int n = this.vertices.size();
        matriz = new int[n][n];
        for (int[] fila : matriz) {
            Arrays.fill(fila, INFINITO);
        }
        for (int i = 0; i < n; i++) {
            matriz[i][i] = 0; // la distancia de un vértice a sí mismo es 0
        }
    }

    /** Agrega una arista no dirigida. Para un grafo dirigido bastaría con omitir la asignación simétrica. */
    public void agregarArista(String origen, String destino, int peso) {
        int i = indice.get(origen);
        int j = indice.get(destino);
        matriz[i][j] = peso;
        matriz[j][i] = peso;
    }

    /** Copia defensiva de la matriz de adyacencia original (antes de correr el algoritmo). */
    public int[][] matrizOriginal() {
        int n = vertices.size();
        int[][] copia = new int[n][n];
        for (int i = 0; i < n; i++) {
            copia[i] = matriz[i].clone();
        }
        return copia;
    }

    public List<String> vertices() {
        return vertices;
    }

    public int indiceDe(String vertice) {
        return indice.get(vertice);
    }

    public int numeroDeVertices() {
        return vertices.size();
    }
}
