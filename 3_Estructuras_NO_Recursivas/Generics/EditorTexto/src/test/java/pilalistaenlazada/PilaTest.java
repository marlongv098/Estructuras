package pilalistaenlazada;

import org.junit.jupiter.api.Test;
import pila.Pila;

import static org.junit.jupiter.api.Assertions.*;

class PilaTest {

    @Test
    void apilar() {
        pila.Pila<Integer> pila = new pila.Pila<>();
        pila.apilar(1);
        pila.apilar(2);
        assertEquals(2, pila.size());
        assertEquals(2, pila.tope());

    }

    @Test
    void desapilar() {
        pila.Pila<Integer> pila = new pila.Pila<>();
        pila.apilar(1);
        pila.apilar(2);
        assertEquals(2, pila.desapilar());
        assertEquals(1, pila.desapilar());
        assertTrue(pila.estaVacia());
    }

    @Test
    void tope() {
        pila.Pila<String> pila = new pila.Pila<>();
        pila.apilar("Hola");
        assertEquals("Hola", pila.tope());
        pila.apilar("Mundo");
        assertEquals("Mundo", pila.tope());
    }

    @Test
    void estaVacia() {
        pila.Pila<Double> pila = new pila.Pila<>();
        assertTrue(pila.estaVacia());
        pila.apilar(3.14);
        assertFalse(pila.estaVacia());
    }

    @Test
    void size() {
        pila.Pila<Character> pila = new pila.Pila<>();
        assertEquals(0, pila.size());
        pila.apilar('a');
        assertEquals(1, pila.size());
        pila.apilar('b');
        assertEquals(2, pila.size());
    }

    @Test
    void clear() {
        pila.Pila<Double> pila = new Pila<>();
        pila.apilar(3.14);
        pila.apilar(2.71);
        pila.clear();
        assertTrue(pila.estaVacia());
        assertEquals(0, pila.size());

    }

}