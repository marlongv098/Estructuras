package dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Recorrido en profundidad (Depth-First Search).
 *
 * <p>A diferencia de BFS (que avanza "por niveles" con una cola FIFO), DFS
 * avanza todo lo posible por una rama antes de retroceder ("backtrack") y
 * probar la siguiente. Esto se implementa naturalmente con recursión (la
 * pila de llamadas hace el trabajo de "recordar" por dónde retroceder) o,
 * de forma equivalente, con una pila explícita.</p>
 */
public class DFS {

    /** Recorrido en profundidad usando la pila de llamadas (recursivo). */
    public static List<String> recorridoRecursivo(Grafo grafo, String inicio) {
        List<String> orden = new ArrayList<>();
        Set<String> visitados = new HashSet<>();
        dfsRecursivo(grafo, inicio, visitados, orden);
        return orden;
    }

    private static void dfsRecursivo(Grafo grafo, String actual, Set<String> visitados, List<String> orden) {
        visitados.add(actual);
        orden.add(actual);
        for (String vecino : grafo.vecinosDe(actual)) {
            if (!visitados.contains(vecino)) {
                dfsRecursivo(grafo, vecino, visitados, orden);
            }
        }
    }

    /**
     * Recorrido en profundidad equivalente al recursivo, pero usando una
     * pila explícita ({@link Deque}) en vez de la pila de llamadas. Útil
     * cuando se quiere evitar el límite de profundidad de recursión en
     * grafos muy grandes.
     */
    public static List<String> recorridoIterativo(Grafo grafo, String inicio) {
        List<String> orden = new ArrayList<>();
        Set<String> visitados = new HashSet<>();
        Deque<String> pila = new ArrayDeque<>();
        pila.push(inicio);

        while (!pila.isEmpty()) {
            String actual = pila.pop();
            if (visitados.add(actual)) {
                orden.add(actual);
                List<String> vecinos = grafo.vecinosDe(actual);
                // Se apilan en orden inverso para que el primer vecino
                // agregado al grafo sea el primero en visitarse, igual
                // que en la versión recursiva.
                for (int i = vecinos.size() - 1; i >= 0; i--) {
                    if (!visitados.contains(vecinos.get(i))) {
                        pila.push(vecinos.get(i));
                    }
                }
            }
        }
        return orden;
    }

    /**
     * Detecta si un grafo no dirigido tiene al menos un ciclo, recorriendo
     * cada componente conexa con DFS y comparando cada vecino visitado con
     * el "padre" desde el que se llegó al vértice actual (para no confundir
     * la arista de regreso trivial u—v, v—u con un ciclo real).
     */
    public static boolean tieneCiclo(Grafo grafo) {
        Set<String> visitados = new HashSet<>();
        for (String vertice : grafo.vertices()) {
            if (!visitados.contains(vertice)) {
                if (tieneCicloDesde(grafo, vertice, null, visitados)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean tieneCicloDesde(Grafo grafo, String actual, String padre, Set<String> visitados) {
        visitados.add(actual);
        for (String vecino : grafo.vecinosDe(actual)) {
            if (!visitados.contains(vecino)) {
                if (tieneCicloDesde(grafo, vecino, actual, visitados)) {
                    return true;
                }
            } else if (!vecino.equals(padre)) {
                return true; // vértice ya visitado que no es el padre => ciclo
            }
        }
        return false;
    }
}
