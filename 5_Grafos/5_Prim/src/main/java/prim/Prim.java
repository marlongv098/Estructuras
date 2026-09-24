package prim;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Algoritmo de Prim: Árbol de Expansión Mínima (MST — Minimum Spanning
 * Tree) de un grafo no dirigido y ponderado, conexo.
 *
 * <p>Prim construye el MST "haciéndolo crecer" desde un vértice inicial:
 * mantiene un conjunto de vértices ya conectados al árbol y, en cada paso,
 * agrega la arista de menor peso que conecta ese conjunto con un vértice
 * todavía fuera de él (estrategia voraz — greedy). Es, en espíritu, muy
 * similar a Dijkstra: ambos usan una cola de prioridad y crecen un árbol
 * vértice por vértice, pero Dijkstra prioriza la <b>distancia acumulada
 * desde el origen</b>, mientras que Prim prioriza el <b>peso de la
 * siguiente arista individual</b> — por eso Prim funciona con pesos
 * negativos y Dijkstra no.</p>
 */
public class Prim {

    /** Arista que forma parte del árbol de expansión mínima. */
    public record AristaMST(String desde, String hasta, int peso) {}

    private record CandidatoArista(String desde, String hasta, int peso) {}

    public static List<AristaMST> calcularMST(Grafo grafo, String inicio) {
        List<AristaMST> mst = new ArrayList<>();
        Set<String> visitados = new HashSet<>();
        PriorityQueue<CandidatoArista> cola =
                new PriorityQueue<>(Comparator.comparingInt(CandidatoArista::peso));

        visitados.add(inicio);
        agregarCandidatos(grafo, inicio, visitados, cola);

        while (!cola.isEmpty() && visitados.size() < grafo.vertices().size()) {
            CandidatoArista candidato = cola.poll();
            if (visitados.contains(candidato.hasta())) {
                continue; // entrada obsoleta: el destino ya se conectó por otro camino más barato
            }
            visitados.add(candidato.hasta());
            mst.add(new AristaMST(candidato.desde(), candidato.hasta(), candidato.peso()));
            agregarCandidatos(grafo, candidato.hasta(), visitados, cola);
        }
        return mst;
    }

    private static void agregarCandidatos(Grafo grafo, String desde, Set<String> visitados,
                                           PriorityQueue<CandidatoArista> cola) {
        for (Grafo.Arista arista : grafo.vecinosDe(desde)) {
            if (!visitados.contains(arista.destino())) {
                cola.add(new CandidatoArista(desde, arista.destino(), arista.peso()));
            }
        }
    }

    public static int pesoTotal(List<AristaMST> mst) {
        return mst.stream().mapToInt(AristaMST::peso).sum();
    }
}
