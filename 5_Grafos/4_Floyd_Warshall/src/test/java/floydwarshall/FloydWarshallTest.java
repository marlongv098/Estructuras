package floydwarshall;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FloydWarshallTest {

    private GrafoMatriz grafoDeEjemplo() {
        //        4
        //    A ----- B
        //    |       |
        //  1 |       | 2
        //    |       |
        //    C ----- D
        //        5
        //    C ------------ E   (peso 8)
        //    D ------------ E   (peso 3)
        GrafoMatriz grafo = new GrafoMatriz(List.of("A", "B", "C", "D", "E"));
        grafo.agregarArista("A", "B", 4);
        grafo.agregarArista("A", "C", 1);
        grafo.agregarArista("B", "D", 2);
        grafo.agregarArista("C", "D", 5);
        grafo.agregarArista("C", "E", 8);
        grafo.agregarArista("D", "E", 3);
        return grafo;
    }

    @Test
    void distanciasCoincidenConLasCalculadasManualmente() {
        GrafoMatriz grafo = grafoDeEjemplo();
        int[][] distancias = FloydWarshall.calcular(grafo);

        assertEquals(0, FloydWarshall.distanciaEntre(distancias, grafo, "A", "A"));
        assertEquals(1, FloydWarshall.distanciaEntre(distancias, grafo, "A", "C"));
        assertEquals(6, FloydWarshall.distanciaEntre(distancias, grafo, "A", "D")); // A-C-D (1+5) o A-B-D (4+2)
        assertEquals(9, FloydWarshall.distanciaEntre(distancias, grafo, "A", "E")); // A-C-D-E (1+5+3)
        assertEquals(5, FloydWarshall.distanciaEntre(distancias, grafo, "B", "C")); // B-A-C (4+1)
    }

    @Test
    void laMatrizEsSimetricaParaUnGrafoNoDirigido() {
        GrafoMatriz grafo = grafoDeEjemplo();
        int[][] distancias = FloydWarshall.calcular(grafo);
        for (int i = 0; i < distancias.length; i++) {
            for (int j = 0; j < distancias.length; j++) {
                assertEquals(distancias[i][j], distancias[j][i]);
            }
        }
    }

    @Test
    void verticesSinCaminoQuedanEnInfinito() {
        GrafoMatriz grafo = new GrafoMatriz(List.of("A", "B", "Z"));
        grafo.agregarArista("A", "B", 1);
        // Z queda aislado, sin aristas
        int[][] distancias = FloydWarshall.calcular(grafo);
        assertEquals(GrafoMatriz.INFINITO, FloydWarshall.distanciaEntre(distancias, grafo, "A", "Z"));
    }

    @Test
    void noReportaCicloNegativoEnUnGrafoSinPesosNegativos() {
        GrafoMatriz grafo = grafoDeEjemplo();
        int[][] distancias = FloydWarshall.calcular(grafo);
        assertFalse(FloydWarshall.tieneCicloNegativo(distancias));
    }

    @Test
    void detectaCicloNegativo() {
        // A -> B (peso 1), B -> A (peso -3): dar la vuelta reduce el costo indefinidamente
        GrafoMatriz grafo = new GrafoMatriz(List.of("A", "B"));
        grafo.agregarArista("A", "B", 1);
        // Se simula un ciclo negativo modificando directamente la matriz vía una segunda arista dirigida:
        // en este grafo no dirigido simple no se puede tener peso distinto en cada sentido, así que
        // se prueba el caso general de detección construyendo la matriz manualmente.
        int[][] distancias = FloydWarshall.calcular(grafo);
        distancias[0][0] = -1; // fuerza el escenario que tieneCicloNegativo debe detectar
        assertTrue(FloydWarshall.tieneCicloNegativo(distancias));
    }
}
