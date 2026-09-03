package kruskal;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Grafo no dirigido y ponderado representado como una simple <b>lista de
 * aristas</b> (en vez de lista o matriz de adyacencia). Kruskal recorre
 * todas las aristas ordenadas por peso sin importar a qué vértice
 * pertenecen, así que una lista de aristas es la representación más directa
 * para este algoritmo — no se necesita consultar "los vecinos de un vértice"
 * en ningún momento.
 */
public class Grafo {

    public record Arista(String origen, String destino, int peso) {}

    private final Set<String> vertices = new LinkedHashSet<>();
    private final List<Arista> aristas = new ArrayList<>();

    public void agregarVertice(String vertice) {
        vertices.add(vertice);
    }

    public void agregarArista(String origen, String destino, int peso) {
        agregarVertice(origen);
        agregarVertice(destino);
        aristas.add(new Arista(origen, destino, peso));
    }

    public Set<String> vertices() {
        return vertices;
    }

    public List<Arista> aristas() {
        return aristas;
    }
}
