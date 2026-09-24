package dfs;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DFSTest {

    private Grafo grafoDeEjemplo() {
        // A - B - D
        // |       |
        // C - - - E - F
        Grafo grafo = new Grafo();
        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("B", "D");
        grafo.agregarArista("C", "E");
        grafo.agregarArista("D", "E");
        grafo.agregarArista("E", "F");
        return grafo;
    }

    @Test
    void recorridoRecursivoVisitaTodosLosVerticesAlcanzables() {
        Grafo grafo = grafoDeEjemplo();
        List<String> orden = DFS.recorridoRecursivo(grafo, "A");
        assertEquals(6, orden.size());
        assertEquals(Set.of("A", "B", "C", "D", "E", "F"), new HashSet<>(orden));
        assertEquals("A", orden.get(0));
    }

    @Test
    void recorridoIterativoVisitaLosMismosVerticesQueElRecursivo() {
        Grafo grafo = grafoDeEjemplo();
        List<String> recursivo = DFS.recorridoRecursivo(grafo, "A");
        List<String> iterativo = DFS.recorridoIterativo(grafo, "A");
        assertEquals(new HashSet<>(recursivo), new HashSet<>(iterativo));
        assertEquals(recursivo.size(), iterativo.size());
    }

    @Test
    void recorridoProfundizaAntesDeRetroceder() {
        // Grafo lineal simple: A - B - C
        Grafo grafo = new Grafo();
        grafo.agregarArista("A", "B");
        grafo.agregarArista("B", "C");
        assertEquals(List.of("A", "B", "C"), DFS.recorridoRecursivo(grafo, "A"));
    }

    @Test
    void detectaCicloCuandoExiste() {
        // A - B - C - A (triángulo)
        Grafo grafo = new Grafo();
        grafo.agregarArista("A", "B");
        grafo.agregarArista("B", "C");
        grafo.agregarArista("C", "A");
        assertTrue(DFS.tieneCiclo(grafo));
    }

    @Test
    void noDetectaCicloEnUnArbol() {
        // A - B - C (sin arista de regreso, es un árbol/lista)
        Grafo grafo = new Grafo();
        grafo.agregarArista("A", "B");
        grafo.agregarArista("B", "C");
        assertFalse(DFS.tieneCiclo(grafo));
    }

    @Test
    void verticesNoAlcanzablesNoAparecenEnElRecorrido() {
        Grafo grafo = grafoDeEjemplo();
        grafo.agregarVertice("Z");
        assertFalse(DFS.recorridoRecursivo(grafo, "A").contains("Z"));
    }
}
