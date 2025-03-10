package tablahash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TablaHashTest {

    @Test
    void insertar() {
        TablaHash<String, Integer> tablaHash = new TablaHash<>();
        tablaHash.insertar("uno", 1);
        tablaHash.insertar("dos", 2);
    }

    @Test
    void obtener() {
        TablaHash<String, Integer> tablaHash = new TablaHash<>();
        tablaHash.insertar("uno", 1);
        tablaHash.insertar("dos", 2);
        assertEquals(1, tablaHash.obtener("uno"));
        assertEquals(2, tablaHash.obtener("dos"));
    }

    @Test
    void eliminar() {
        TablaHash<String, Integer> tablaHash = new TablaHash<>();
        tablaHash.insertar("uno", 1);
        tablaHash.eliminar("uno");
        assertNull(tablaHash.obtener("uno"));
    }

    @Test
    void size() {
        TablaHash<String, Integer> tablaHash = new TablaHash<>();
        assertEquals(0, tablaHash.size());
        tablaHash.insertar("uno", 1);
        assertEquals(1, tablaHash.size());
        tablaHash.insertar("dos", 2);
        assertEquals(2, tablaHash.size());
    }

    @Test
    void estaVacia() {
        TablaHash<String, Integer> tablaHash = new TablaHash<>();
        assertTrue(tablaHash.estaVacia());
        tablaHash.insertar("uno", 1);
        assertFalse(tablaHash.estaVacia());
    }
}