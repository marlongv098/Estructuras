package binario;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArbolAVLTest {

    private List<Integer> inorden(NodoAVL<Integer> nodo, List<Integer> acc) {
        if (nodo != null) {
            inorden(nodo.getIzquierdo(), acc);
            acc.add(nodo.getDato());
            inorden(nodo.getDerecho(), acc);
        }
        return acc;
    }

    private int alturaReal(NodoAVL<?> nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(alturaReal(nodo.getIzquierdo()), alturaReal(nodo.getDerecho()));
    }

    /** Verifica recursivamente que |balance| <= 1 en TODOS los nodos, no solo la raíz. */
    private void assertBalanceado(NodoAVL<?> nodo) {
        if (nodo == null) return;
        int balance = alturaReal(nodo.getIzquierdo()) - alturaReal(nodo.getDerecho());
        assertTrue(Math.abs(balance) <= 1, "Nodo " + nodo.getDato() + " desbalanceado: " + balance);
        assertBalanceado(nodo.getIzquierdo());
        assertBalanceado(nodo.getDerecho());
    }

    @Test
    void insertarEnOrdenAscendenteSeMantieneBalanceado() {
        // Con un BST normal (sin rebalanceo), insertar 1,2,3,4,5,6,7 en orden produce
        // una cadena degenerada de altura 7 (equivalente a una lista enlazada, O(n)).
        // Un AVL debe mantenerse balanceado y con altura O(log n).
        ArbolAVL<Integer> arbol = new ArbolAVL<>();
        for (int i = 1; i <= 7; i++) {
            arbol.insertar(i);
        }
        assertBalanceado(arbol.getRaiz());
        assertEquals(3, alturaReal(arbol.getRaiz()), "7 nodos balanceados deben tener altura 3, no 7");
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7), inorden(arbol.getRaiz(), new ArrayList<>()));
    }

    @Test
    void buscarEncuentraYNoEncuentra() {
        ArbolAVL<Integer> arbol = new ArbolAVL<>();
        for (int v : new int[]{10, 20, 30, 40, 50, 25}) arbol.insertar(v);
        assertTrue(arbol.buscar(25));
        assertTrue(arbol.buscar(10));
        assertFalse(arbol.buscar(99));
    }

    @Test
    void noPermiteDuplicados() {
        ArbolAVL<Integer> arbol = new ArbolAVL<>();
        arbol.insertar(10);
        arbol.insertar(10);
        assertEquals(List.of(10), inorden(arbol.getRaiz(), new ArrayList<>()));
    }

    @Test
    void eliminarMantieneElArbolBalanceadoYOrdenado() {
        ArbolAVL<Integer> arbol = new ArbolAVL<>();
        for (int v : new int[]{20, 10, 30, 5, 15, 25, 35, 3, 7}) arbol.insertar(v);

        arbol.eliminar(5);   // nodo con dos hijos
        arbol.eliminar(35);  // hoja
        arbol.eliminar(20);  // la raíz

        assertBalanceado(arbol.getRaiz());
        assertEquals(List.of(3, 7, 10, 15, 25, 30), inorden(arbol.getRaiz(), new ArrayList<>()));
        assertFalse(arbol.buscar(20));
        assertFalse(arbol.buscar(5));
    }

    @Test
    void eliminarDatoQueNoExisteNoAlteraElArbol() {
        ArbolAVL<Integer> arbol = new ArbolAVL<>();
        for (int v : new int[]{10, 20, 30}) arbol.insertar(v);
        arbol.eliminar(999);
        assertEquals(List.of(10, 20, 30), inorden(arbol.getRaiz(), new ArrayList<>()));
    }
}
