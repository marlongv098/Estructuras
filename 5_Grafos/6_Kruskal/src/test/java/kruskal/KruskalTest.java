package kruskal;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class KruskalTest {

    private Grafo grafoDeEjemplo() {
        //        4
        //    A ----- B
        //    |       |
        //  1 |       | 2
        //    |       |
        //    C ----- D
        //        5
        //    C ------------ E   (peso 8)
        //    D ------------ E   (peso 3)
        Grafo grafo = new Grafo();
        grafo.agregarArista("A", "B", 4);
        grafo.agregarArista("A", "C", 1);
        grafo.agregarArista("B", "D", 2);
        grafo.agregarArista("C", "D", 5);
        grafo.agregarArista("C", "E", 8);
        grafo.agregarArista("D", "E", 3);
        return grafo;
    }

    @Test
    void elMSTTieneNMenosUnAristasParaNVertices() {
        Grafo grafo = grafoDeEjemplo();
        List<Grafo.Arista> mst = Kruskal.calcularMST(grafo);
        assertEquals(grafo.vertices().size() - 1, mst.size());
    }

    @Test
    void elPesoTotalCoincideConElCalculadoPorPrim() {
        // Mismo grafo, mismo peso mínimo que en 5_Prim/PrimTest: A-C(1) + B-D(2) + D-E(3) + A-B(4) = 10.
        Grafo grafo = grafoDeEjemplo();
        List<Grafo.Arista> mst = Kruskal.calcularMST(grafo);
        assertEquals(10, Kruskal.pesoTotal(mst));
    }

    @Test
    void elMSTNoContieneCiclos() {
        // Con n-1 aristas y todos los vértices conectados, la ausencia de ciclos
        // está garantizada por construcción (Union-Find rechaza toda arista que
        // conecte dos vértices ya unidos); esta prueba confirma indirectamente
        // ese invariante verificando que Union-Find aceptó cada arista del MST.
        Grafo grafo = grafoDeEjemplo();
        List<Grafo.Arista> mst = Kruskal.calcularMST(grafo);

        ConjuntosDisjuntos conjuntos = new ConjuntosDisjuntos();
        for (String vertice : grafo.vertices()) {
            conjuntos.hacerConjunto(vertice);
        }
        for (Grafo.Arista arista : mst) {
            assertTrue(conjuntos.unir(arista.origen(), arista.destino()),
                    "La arista " + arista + " no debería formar un ciclo dentro del MST");
        }
    }

    @Test
    void elMSTConectaTodosLosVertices() {
        Grafo grafo = grafoDeEjemplo();
        List<Grafo.Arista> mst = Kruskal.calcularMST(grafo);

        Set<String> conectados = new HashSet<>();
        for (Grafo.Arista arista : mst) {
            conectados.add(arista.origen());
            conectados.add(arista.destino());
        }
        assertEquals(grafo.vertices(), conectados);
    }

    @Test
    void conjuntosDisjuntosDetectaCicloAlIntentarUnirElMismoConjuntoDosVeces() {
        ConjuntosDisjuntos conjuntos = new ConjuntosDisjuntos();
        conjuntos.hacerConjunto("A");
        conjuntos.hacerConjunto("B");
        conjuntos.hacerConjunto("C");

        assertTrue(conjuntos.unir("A", "B"));
        assertTrue(conjuntos.unir("B", "C"));
        assertFalse(conjuntos.unir("A", "C")); // ya están en el mismo conjunto (A-B-C)
    }
}
