package binario;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArbolBinarioTest {

    private ArbolBinario<Integer> arbolDeEjemplo() {
        ArbolBinario<Integer> arbol = new ArbolBinario<>(Comparator.<Integer>naturalOrder());
        for (int v : new int[]{50, 30, 70, 20, 40, 60, 80}) {
            arbol.insertar(v);
        }
        return arbol;
    }

    private List<Integer> inordenComoLista(Nodo<Integer> raiz) {
        List<Integer> resultado = new ArrayList<>();
        inordenAux(raiz, resultado);
        return resultado;
    }

    private void inordenAux(Nodo<Integer> nodo, List<Integer> resultado) {
        if (nodo != null) {
            inordenAux(nodo.izquierdo, resultado);
            resultado.add(nodo.valor);
            inordenAux(nodo.derecho, resultado);
        }
    }

    @Test
    void insertarYRecorridoInordenQuedaOrdenado() {
        ArbolBinario<Integer> arbol = arbolDeEjemplo();
        assertEquals(List.of(20, 30, 40, 50, 60, 70, 80), inordenComoLista(arbol.getRaiz()));
    }

    @Test
    void buscarEncuentraYNoEncuentra() {
        ArbolBinario<Integer> arbol = arbolDeEjemplo();
        assertTrue(arbol.buscar(40));
        assertTrue(arbol.buscar(80));
        assertFalse(arbol.buscar(90));
    }

    @Test
    void eliminarHojaFuncionaCorrectamente() {
        ArbolBinario<Integer> arbol = arbolDeEjemplo();
        arbol.eliminar(20); // 20 es una hoja
        assertFalse(arbol.buscar(20));
        assertEquals(List.of(30, 40, 50, 60, 70, 80), inordenComoLista(arbol.getRaiz()));
    }

    @Test
    void eliminarNodoConDosHijosUsaElSucesorInorden() {
        // Este es el caso que ejercita encontrarMinimo(): antes de la corrección,
        // este caso lanzaba NullPointerException o corrompía el árbol porque
        // encontrarMinimo bajaba por la derecha en vez de por la izquierda.
        ArbolBinario<Integer> arbol = arbolDeEjemplo();
        arbol.eliminar(30); // 30 tiene dos hijos (20 y 40)
        assertFalse(arbol.buscar(30));
        assertEquals(List.of(20, 40, 50, 60, 70, 80), inordenComoLista(arbol.getRaiz()));
    }

    @Test
    void eliminarLaRaizConDosHijos() {
        ArbolBinario<Integer> arbol = arbolDeEjemplo();
        arbol.eliminar(50); // la raíz, con dos hijos
        assertFalse(arbol.buscar(50));
        assertEquals(List.of(20, 30, 40, 60, 70, 80), inordenComoLista(arbol.getRaiz()));
    }

    @Test
    void funcionaConTiposComparablesComoString() {
        ArbolBinario<String> arbol = new ArbolBinario<>(Comparator.<String>naturalOrder());
        arbol.insertar("Manzana");
        arbol.insertar("Banana");
        arbol.insertar("Cereza");
        assertTrue(arbol.buscar("Banana"));
        assertFalse(arbol.buscar("Uva"));
    }
}
