package bfs;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

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
    void recorridoVisitaTodosLosVerticesAlcanzables() {
        Grafo grafo = grafoDeEjemplo();
        List<String> orden = BFS.recorrido(grafo, "A");
        assertEquals(6, orden.size());
        assertEquals(Set.of("A", "B", "C", "D", "E", "F"), new HashSet<>(orden));
        assertEquals("A", orden.get(0)); // el inicio siempre es el primero
    }

    @Test
    void recorridoRespetaElOrdenPorNiveles() {
        Grafo grafo = grafoDeEjemplo();
        List<String> orden = BFS.recorrido(grafo, "A");
        // B y C están a distancia 1 de A, deben aparecer antes que D, E (distancia 2)
        int posB = orden.indexOf("B");
        int posC = orden.indexOf("C");
        int posD = orden.indexOf("D");
        int posE = orden.indexOf("E");
        assertTrue(posB < posD);
        assertTrue(posC < posE);
    }

    @Test
    void distanciasSonCorrectas() {
        Grafo grafo = grafoDeEjemplo();
        Map<String, Integer> distancias = BFS.distancias(grafo, "A");
        assertEquals(0, distancias.get("A"));
        assertEquals(1, distancias.get("B"));
        assertEquals(1, distancias.get("C"));
        assertEquals(2, distancias.get("D"));
        assertEquals(2, distancias.get("E"));
        assertEquals(3, distancias.get("F"));
    }

    @Test
    void verticesNoAlcanzablesNoAparecenEnElResultado() {
        Grafo grafo = grafoDeEjemplo();
        grafo.agregarVertice("Z"); // componente separada, sin aristas
        List<String> orden = BFS.recorrido(grafo, "A");
        assertFalse(orden.contains("Z"));
        assertFalse(BFS.distancias(grafo, "A").containsKey("Z"));
    }
}
