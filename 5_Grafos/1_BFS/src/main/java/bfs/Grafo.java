package bfs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Grafo no dirigido y no ponderado representado mediante lista de adyacencia.
 *
 * <p>Se usa {@link LinkedHashMap} para que el orden de inserción de los
 * vértices sea predecible (útil para pruebas y para reproducir ejemplos
 * paso a paso), aunque el algoritmo de BFS no depende de ese orden.</p>
 */
public class Grafo {

    private final Map<String, List<String>> adyacencia = new LinkedHashMap<>();

    /** Agrega un vértice aislado (sin aristas) si todavía no existe. */
    public void agregarVertice(String vertice) {
        adyacencia.putIfAbsent(vertice, new ArrayList<>());
    }

    /**
     * Agrega una arista no dirigida entre {@code origen} y {@code destino}.
     * Ambos vértices se crean automáticamente si no existían.
     */
    public void agregarArista(String origen, String destino) {
        agregarVertice(origen);
        agregarVertice(destino);
        adyacencia.get(origen).add(destino);
        adyacencia.get(destino).add(origen);
    }

    /** Vecinos directos de un vértice, en el orden en que se agregaron las aristas. */
    public List<String> vecinosDe(String vertice) {
        return adyacencia.getOrDefault(vertice, List.of());
    }

    /** Todos los vértices del grafo. */
    public Set<String> vertices() {
        return adyacencia.keySet();
    }

    public int numeroDeVertices() {
        return adyacencia.size();
    }
}
