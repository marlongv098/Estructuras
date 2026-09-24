package prim;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PrimTest {

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
        List<Prim.AristaMST> mst = Prim.calcularMST(grafo, "A");
        assertEquals(grafo.vertices().size() - 1, mst.size());
    }

    @Test
    void elPesoTotalDelMSTEsElMinimoConocido() {
        // Verificado a mano: A-C(1) + B-D(2) + D-E(3) + A-B(4) = 10,
        // descartando C-D(5) y C-E(8) por formar ciclo.
        Grafo grafo = grafoDeEjemplo();
        List<Prim.AristaMST> mst = Prim.calcularMST(grafo, "A");
        assertEquals(10, Prim.pesoTotal(mst));
    }

    @Test
    void elMSTConectaTodosLosVertices() {
        Grafo grafo = grafoDeEjemplo();
        List<Prim.AristaMST> mst = Prim.calcularMST(grafo, "A");

        Set<String> conectados = new HashSet<>();
        conectados.add("A"); // vértice inicial, ya "conectado" antes de agregar aristas
        for (Prim.AristaMST arista : mst) {
            conectados.add(arista.desde());
            conectados.add(arista.hasta());
        }
        assertEquals(grafo.vertices(), conectados);
    }

    @Test
    void elResultadoEsElMismoSinImportarElVerticeInicial() {
        Grafo grafo = grafoDeEjemplo();
        int pesoDesdeA = Prim.pesoTotal(Prim.calcularMST(grafo, "A"));
        int pesoDesdeE = Prim.pesoTotal(Prim.calcularMST(grafo, "E"));
        assertEquals(pesoDesdeA, pesoDesdeE);
    }
}
