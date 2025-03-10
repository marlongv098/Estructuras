package estructuras;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaEnlazadaTest {

    @Test
    void agregar() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        lista.agregar(20);
    }

    @Test
    void obtener() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregar(10);
        lista.agregar(20);
        assertEquals(10, lista.obtener(0));
        assertEquals(20, lista.obtener(1));
    }

    @Test
    void size() {
        ListaEnlazada<String> lista = new ListaEnlazada<>();
        assertEquals(0, lista.size());
        lista.agregar("Hola");
        assertEquals(1, lista.size());
        lista.agregar("Mundo");
        assertEquals(2, lista.size());
    }

    @Test
    void estaVacia() {
        ListaEnlazada<Double> lista = new ListaEnlazada<>();
        assertTrue(lista.estaVacia());
        lista.agregar(3.14);
        assertFalse(lista.estaVacia());
    }

    @Test
    void eliminar() {
        ListaEnlazada<Character> lista = new ListaEnlazada<>();
        lista.agregar('a');
        lista.agregar('b');
        lista.agregar('c');
        lista.eliminar(1);
        assertEquals(2, lista.size());
        assertEquals('a', lista.obtener(0));
        assertEquals('c', lista.obtener(1));
    }
}