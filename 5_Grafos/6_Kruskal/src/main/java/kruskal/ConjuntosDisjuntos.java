package kruskal;

import java.util.HashMap;
import java.util.Map;

/**
 * Estructura Union-Find (también llamada Conjuntos Disjuntos o DSU), usada
 * por Kruskal para detectar en O(casi 1) si agregar una arista formaría un
 * ciclo: dos vértices forman un ciclo si ya están en el mismo conjunto
 * (es decir, ya están conectados por otro camino en el árbol que se está
 * construyendo).
 *
 * <p>Combina dos optimizaciones clásicas que juntas dan la complejidad casi
 * constante O(α(n)) por operación (α = función inversa de Ackermann,
 * que crece tan lento que es ≤ 4 para cualquier n imaginable en la
 * práctica):</p>
 * <ul>
 *   <li><b>Compresión de caminos</b> ("path compression"): al buscar la raíz
 *   de un conjunto, cada nodo visitado en el camino se re-apunta directamente
 *   a la raíz, aplanando el árbol para futuras búsquedas.</li>
 *   <li><b>Unión por rango</b> ("union by rank"): al unir dos conjuntos, la
 *   raíz del árbol más "bajo" (menor rango) se cuelga de la raíz del árbol
 *   más alto, evitando que los árboles crezcan innecesariamente en altura.</li>
 * </ul>
 */
public class ConjuntosDisjuntos {

    private final Map<String, String> padre = new HashMap<>();
    private final Map<String, Integer> rango = new HashMap<>();

    /** Crea un nuevo conjunto que contiene únicamente a {@code vertice} (si no existía ya). */
    public void hacerConjunto(String vertice) {
        padre.putIfAbsent(vertice, vertice);
        rango.putIfAbsent(vertice, 0);
    }

    /** Encuentra la raíz (representante) del conjunto al que pertenece {@code vertice}, con compresión de caminos. */
    public String encontrar(String vertice) {
        if (!padre.get(vertice).equals(vertice)) {
            padre.put(vertice, encontrar(padre.get(vertice)));
        }
        return padre.get(vertice);
    }

    /**
     * Une los conjuntos de {@code a} y {@code b}. Devuelve {@code true} si
     * estaban en conjuntos distintos (la unión se realizó), o {@code false}
     * si ya estaban en el mismo conjunto (unirlos formaría un ciclo).
     */
    public boolean unir(String a, String b) {
        String raizA = encontrar(a);
        String raizB = encontrar(b);
        if (raizA.equals(raizB)) {
            return false;
        }

        int rangoA = rango.get(raizA);
        int rangoB = rango.get(raizB);
        if (rangoA < rangoB) {
            padre.put(raizA, raizB);
        } else if (rangoA > rangoB) {
            padre.put(raizB, raizA);
        } else {
            padre.put(raizB, raizA);
            rango.put(raizA, rangoA + 1);
        }
        return true;
    }
}
