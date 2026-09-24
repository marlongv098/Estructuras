package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Recorrido en anchura (Breadth-First Search).
 *
 * <p>BFS explora el grafo "por niveles": primero visita todos los vecinos
 * directos del vértice de inicio, luego los vecinos de esos vecinos, y así
 * sucesivamente. Esto se logra con una cola FIFO: cada vértice se encola al
 * descubrirlo y se procesa en el mismo orden en que fue descubierto.</p>
 *
 * <p>Por eso BFS es el algoritmo natural para encontrar el camino más corto
 * (en número de aristas) en un grafo no ponderado: la primera vez que se
 * alcanza un vértice es, garantizadamente, por el camino más corto posible.</p>
 */
public class BFS {

    /**
     * Devuelve el orden en el que BFS visita los vértices alcanzables desde
     * {@code inicio}. Los vértices en otra componente conexa (no alcanzables)
     * no aparecen en el resultado.
     */
    public static List<String> recorrido(Grafo grafo, String inicio) {
        List<String> orden = new ArrayList<>();
        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();

        visitados.add(inicio);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            orden.add(actual);
            for (String vecino : grafo.vecinosDe(actual)) {
                if (visitados.add(vecino)) {
                    cola.add(vecino);
                }
            }
        }
        return orden;
    }

    /**
     * Calcula la distancia mínima (en número de aristas) desde {@code inicio}
     * hasta cada vértice alcanzable. Los vértices no alcanzables no aparecen
     * en el mapa resultante.
     */
    public static Map<String, Integer> distancias(Grafo grafo, String inicio) {
        Map<String, Integer> distancia = new HashMap<>();
        Queue<String> cola = new LinkedList<>();

        distancia.put(inicio, 0);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            int distanciaActual = distancia.get(actual);
            for (String vecino : grafo.vecinosDe(actual)) {
                if (!distancia.containsKey(vecino)) {
                    distancia.put(vecino, distanciaActual + 1);
                    cola.add(vecino);
                }
            }
        }
        return distancia;
    }
}
