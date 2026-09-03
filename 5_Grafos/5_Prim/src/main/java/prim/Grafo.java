package prim;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Grafo no dirigido y ponderado representado mediante lista de adyacencia.
 * A diferencia de {@code 3_Dijsktra}, aquí sí tiene sentido permitir pesos
 * negativos: el algoritmo de Prim (a diferencia de Dijkstra) no depende de
 * que los pesos sean no negativos para ser correcto.
 */
public class Grafo {

    public record Arista(String destino, int peso) {}

    private final Map<String, List<Arista>> adyacencia = new LinkedHashMap<>();

    public void agregarVertice(String vertice) {
        adyacencia.putIfAbsent(vertice, new ArrayList<>());
    }

    public void agregarArista(String a, String b, int peso) {
        agregarVertice(a);
        agregarVertice(b);
        adyacencia.get(a).add(new Arista(b, peso));
        adyacencia.get(b).add(new Arista(a, peso));
    }

    public List<Arista> vecinosDe(String vertice) {
        return adyacencia.getOrDefault(vertice, List.of());
    }

    public Set<String> vertices() {
        return adyacencia.keySet();
    }
}
