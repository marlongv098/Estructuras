package floydwarshall;

/**
 * Algoritmo de Floyd-Warshall: caminos más cortos entre <b>todos</b> los
 * pares de vértices, mediante programación dinámica.
 *
 * <p>La idea central: {@code dist[i][j]} se va refinando considerando, para
 * cada vértice intermedio {@code k} (en orden de 0 a n-1), si pasar por
 * {@code k} acorta el camino de {@code i} a {@code j}. Después de considerar
 * los n vértices como posibles intermediarios, {@code dist[i][j]} contiene
 * garantizadamente la distancia mínima real entre {@code i} y {@code j}.</p>
 *
 * <p>A diferencia de Dijkstra (que resuelve el problema de un-solo-origen y
 * requiere pesos no negativos), Floyd-Warshall admite pesos negativos —
 * siempre que no haya un <b>ciclo negativo</b> alcanzable, en cuyo caso la
 * noción de "camino más corto" deja de tener sentido (se podría dar vueltas
 * al ciclo indefinidamente reduciendo el costo). Ver {@link #tieneCicloNegativo}.</p>
 */
public class FloydWarshall {

    public static int[][] calcular(GrafoMatriz grafo) {
        int n = grafo.numeroDeVertices();
        int[][] distancia = grafo.matrizOriginal();

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distancia[i][k] + distancia[k][j] < distancia[i][j]) {
                        distancia[i][j] = distancia[i][k] + distancia[k][j];
                    }
                }
            }
        }
        return distancia;
    }

    public static int distanciaEntre(int[][] distancias, GrafoMatriz grafo, String origen, String destino) {
        return distancias[grafo.indiceDe(origen)][grafo.indiceDe(destino)];
    }

    /**
     * Un ciclo negativo alcanzable desde un vértice {@code i} hace que
     * {@code dist[i][i]} termine siendo negativo (dar la vuelta al ciclo
     * "mejora" el costo de volver al mismo lugar). Revisar la diagonal
     * después de correr el algoritmo es la forma estándar de detectarlo.
     */
    public static boolean tieneCicloNegativo(int[][] distancias) {
        for (int i = 0; i < distancias.length; i++) {
            if (distancias[i][i] < 0) {
                return true;
            }
        }
        return false;
    }
}
