package dfs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Grafo no dirigido y no ponderado representado mediante lista de adyacencia.
 * Misma representación usada en {@code 1_BFS}: una lista de adyacencia es la
 * estructura natural para grafos dispersos, con O(1) amortizado para agregar
 * una arista y O(grado(v)) para recorrer los vecinos de un vértice.
 */
public class Grafo {

    private final Map<String, List<String>> adyacencia = new LinkedHashMap<>();

    public void agregarVertice(String vertice) {
        adyacencia.putIfAbsent(vertice, new ArrayList<>());
    }

    public void agregarArista(String origen, String destino) {
        agregarVertice(origen);
        agregarVertice(destino);
        adyacencia.get(origen).add(destino);
        adyacencia.get(destino).add(origen);
    }

    public List<String> vecinosDe(String vertice) {
        return adyacencia.getOrDefault(vertice, List.of());
    }

    public Set<String> vertices() {
        return adyacencia.keySet();
    }

    public int numeroDeVertices() {
        return adyacencia.size();
    }
}
