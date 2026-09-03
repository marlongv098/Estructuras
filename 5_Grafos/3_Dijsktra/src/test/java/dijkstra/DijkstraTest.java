package dijkstra;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    private GrafoPonderado grafoDeEjemplo() {
        //        4
        //    A ----- B
        //    |       |
        //  1 |       | 2
        //    |       |
        //    C ----- D
        //        5
        //    C ------------ E   (peso 8)
        //    D ------------ E   (peso 3)
        GrafoPonderado grafo = new GrafoPonderado();
        grafo.agregarArista("A", "B", 4);
        grafo.agregarArista("A", "C", 1);
        grafo.agregarArista("B", "D", 2);
        grafo.agregarArista("C", "D", 5);
        grafo.agregarArista("C", "E", 8);
        grafo.agregarArista("D", "E", 3);
        return grafo;
    }

    @Test
    void distanciasMinimasSonCorrectas() {
        GrafoPonderado grafo = grafoDeEjemplo();
        Map<String, Integer> distancias = Dijkstra.calcular(grafo, "A").distancias();

        assertEquals(0, distancias.get("A"));
        assertEquals(1, distancias.get("C"));   // directo A-C
        assertEquals(4, distancias.get("B"));   // directo A-B
        assertEquals(6, distancias.get("D"));   // A-C-D (1+5) o A-B-D (4+2), ambos suman 6
        assertEquals(9, distancias.get("E"));   // A-C-D-E (1+5+3) o A-C-E (1+8), ambos suman 9
    }

    @Test
    void elCaminoReconstruidoSumaExactamenteLaDistanciaMinima() {
        GrafoPonderado grafo = grafoDeEjemplo();
        Dijkstra.Resultado resultado = Dijkstra.calcular(grafo, "A");
        List<String> camino = Dijkstra.reconstruirCamino(resultado.predecesores(), "A", "E");

        assertEquals("A", camino.get(0));
        assertEquals("E", camino.get(camino.size() - 1));
        assertEquals(resultado.distancias().get("E").intValue(), pesoTotal(grafo, camino));
    }

    @Test
    void distanciaDeUnVerticeASiMismoEsCero() {
        GrafoPonderado grafo = grafoDeEjemplo();
        assertEquals(List.of("A"), Dijkstra.reconstruirCamino(Dijkstra.calcular(grafo, "A").predecesores(), "A", "A"));
    }

    @Test
    void verticeNoAlcanzableProduceDistanciaInfinitaYCaminoVacio() {
        GrafoPonderado grafo = grafoDeEjemplo();
        grafo.agregarVertice("Z"); // sin aristas, no alcanzable desde A
        Dijkstra.Resultado resultado = Dijkstra.calcular(grafo, "A");

        assertEquals(Integer.MAX_VALUE, resultado.distancias().get("Z"));
        assertTrue(Dijkstra.reconstruirCamino(resultado.predecesores(), "A", "Z").isEmpty());
    }

    @Test
    void rechazaPesosNegativos() {
        GrafoPonderado grafo = new GrafoPonderado();
        assertThrows(IllegalArgumentException.class, () -> grafo.agregarArista("A", "B", -3));
    }

    /** Suma los pesos de las aristas consecutivas de un camino, usado para validar reconstruirCamino. */
    private int pesoTotal(GrafoPonderado grafo, List<String> camino) {
        int total = 0;
        for (int i = 0; i < camino.size() - 1; i++) {
            String desde = camino.get(i);
            String hasta = camino.get(i + 1);
            total += grafo.vecinosDe(desde).stream()
                    .filter(arista -> arista.destino().equals(hasta))
                    .findFirst()
                    .orElseThrow()
                    .peso();
        }
        return total;
    }
}
