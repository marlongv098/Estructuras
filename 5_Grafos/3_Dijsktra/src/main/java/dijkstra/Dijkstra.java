package dijkstra;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Algoritmo de Dijkstra: caminos más cortos desde un único origen en un
 * grafo ponderado con pesos no negativos.
 *
 * <p>Es una variante "greedy" (voraz) de BFS: en vez de una cola FIFO simple
 * (donde todos los "pasos" cuestan 1), usa una cola de prioridad ordenada
 * por la distancia acumulada. En cada paso se procesa el vértice no visitado
 * con menor distancia conocida — y una vez procesado, esa distancia es
 * definitiva, porque no puede existir un camino más corto que pase por un
 * vértice todavía no descubierto (todos los pesos son ≥ 0).</p>
 *
 * <p>Esta implementación usa <b>eliminación perezosa</b> ("lazy deletion"):
 * en vez de disminuir la prioridad de un elemento ya en la cola (operación
 * que {@link PriorityQueue} no soporta directamente), simplemente se agrega
 * una nueva entrada con la distancia mejorada, y las entradas obsoletas se
 * descartan cuando salen de la cola comprobando si el vértice ya fue
 * visitado. Por eso cada entrada de la cola guarda tanto el vértice como la
 * distancia que tenía en el momento en que se agregó.</p>
 */
public class Dijkstra {

    private record NodoDistancia(String vertice, int distancia) {}

    /** Distancias mínimas desde el origen y el predecesor de cada vértice en el camino más corto. */
    public record Resultado(Map<String, Integer> distancias, Map<String, String> predecesores) {}

    public static Resultado calcular(GrafoPonderado grafo, String origen) {
        Map<String, Integer> distancia = new HashMap<>();
        Map<String, String> predecesor = new HashMap<>();
        for (String vertice : grafo.vertices()) {
            distancia.put(vertice, Integer.MAX_VALUE);
        }
        distancia.put(origen, 0);

        PriorityQueue<NodoDistancia> cola = new PriorityQueue<>(Comparator.comparingInt(NodoDistancia::distancia));
        cola.add(new NodoDistancia(origen, 0));
        Set<String> visitados = new HashSet<>();

        while (!cola.isEmpty()) {
            NodoDistancia actual = cola.poll();
            if (!visitados.add(actual.vertice())) {
                continue; // entrada obsoleta (ya se procesó este vértice con una distancia mejor)
            }

            for (GrafoPonderado.Arista arista : grafo.vecinosDe(actual.vertice())) {
                int nuevaDistancia = distancia.get(actual.vertice()) + arista.peso();
                if (nuevaDistancia < distancia.get(arista.destino())) {
                    distancia.put(arista.destino(), nuevaDistancia);
                    predecesor.put(arista.destino(), actual.vertice());
                    cola.add(new NodoDistancia(arista.destino(), nuevaDistancia));
                }
            }
        }
        return new Resultado(distancia, predecesor);
    }

    /**
     * Reconstruye el camino más corto de {@code origen} a {@code destino}
     * siguiendo el mapa de predecesores calculado por {@link #calcular}.
     * Devuelve una lista vacía si {@code destino} no es alcanzable.
     */
    public static List<String> reconstruirCamino(Map<String, String> predecesores, String origen, String destino) {
        if (origen.equals(destino)) {
            return List.of(origen);
        }
        LinkedList<String> camino = new LinkedList<>();
        String actual = destino;
        while (actual != null && !actual.equals(origen)) {
            camino.addFirst(actual);
            actual = predecesores.get(actual);
        }
        if (actual == null) {
            return List.of(); // destino no alcanzable desde origen
        }
        camino.addFirst(origen);
        return camino;
    }
}
