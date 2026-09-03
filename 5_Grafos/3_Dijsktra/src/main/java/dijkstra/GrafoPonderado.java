package dijkstra;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Grafo no dirigido y ponderado, con pesos no negativos, representado
 * mediante lista de adyacencia. Dijkstra solo es correcto con pesos ≥ 0
 * (ver explicación en el README), por eso {@link #agregarArista} valida
 * el peso al momento de construir el grafo en vez de fallar silenciosamente
 * más adelante dentro del algoritmo.
 */
public class GrafoPonderado {

    /** Arista dirigida hacia {@code destino} con el {@code peso} indicado. */
    public record Arista(String destino, int peso) {}

    private final Map<String, List<Arista>> adyacencia = new LinkedHashMap<>();

    public void agregarVertice(String vertice) {
        adyacencia.putIfAbsent(vertice, new ArrayList<>());
    }

    public void agregarArista(String origen, String destino, int peso) {
        if (peso < 0) {
            throw new IllegalArgumentException(
                    "Dijkstra no admite pesos negativos: " + origen + " -> " + destino + " = " + peso);
        }
        agregarVertice(origen);
        agregarVertice(destino);
        adyacencia.get(origen).add(new Arista(destino, peso));
        adyacencia.get(destino).add(new Arista(origen, peso));
    }

    public List<Arista> vecinosDe(String vertice) {
        return adyacencia.getOrDefault(vertice, List.of());
    }

    public Set<String> vertices() {
        return adyacencia.keySet();
    }
}
