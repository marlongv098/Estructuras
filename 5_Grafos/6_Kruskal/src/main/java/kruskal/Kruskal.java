package kruskal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Algoritmo de Kruskal: Árbol de Expansión Mínima (MST), alternativa a Prim.
 *
 * <p>Mientras Prim hace crecer <b>un solo árbol</b> agregando siempre la
 * arista más barata que lo conecta con un vértice externo, Kruskal razona
 * de forma completamente distinta: ordena <b>todas</b> las aristas del
 * grafo por peso ascendente y las va agregando una por una al MST, siempre
 * que no formen un ciclo con lo ya agregado (verificado con Union-Find en
 * {@link ConjuntosDisjuntos}). El resultado —el peso total mínimo— es el
 * mismo que con Prim; ambos son correctos por la misma propiedad de "corte"
 * de los MST, solo difiere la estrategia para llegar a él.</p>
 */
public class Kruskal {

    public static List<Grafo.Arista> calcularMST(Grafo grafo) {
        List<Grafo.Arista> aristasOrdenadas = new ArrayList<>(grafo.aristas());
        aristasOrdenadas.sort(Comparator.comparingInt(Grafo.Arista::peso));

        ConjuntosDisjuntos conjuntos = new ConjuntosDisjuntos();
        for (String vertice : grafo.vertices()) {
            conjuntos.hacerConjunto(vertice);
        }

        List<Grafo.Arista> mst = new ArrayList<>();
        int aristasNecesarias = grafo.vertices().size() - 1;

        for (Grafo.Arista arista : aristasOrdenadas) {
            if (mst.size() == aristasNecesarias) {
                break; // el árbol ya está completo, no hace falta seguir revisando aristas
            }
            if (conjuntos.unir(arista.origen(), arista.destino())) {
                mst.add(arista);
            }
            // si unir() devuelve false, arista.origen() y arista.destino() ya estaban
            // conectados: agregarla formaría un ciclo, así que se descarta.
        }
        return mst;
    }

    public static int pesoTotal(List<Grafo.Arista> mst) {
        return mst.stream().mapToInt(Grafo.Arista::peso).sum();
    }
}
