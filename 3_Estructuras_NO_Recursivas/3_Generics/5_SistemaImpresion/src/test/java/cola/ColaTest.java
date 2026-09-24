package cola;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColaTest {

    @Test
    void esFIFOOrdenDeInsercion() {
        Cola<String> cola = new Cola<>();
        cola.encolar("a");
        cola.encolar("b");
        cola.encolar("c");

        assertEquals("a", cola.frente());
        assertEquals("a", cola.desencolar());
        assertEquals("b", cola.desencolar());
        assertEquals("c", cola.desencolar());
        assertTrue(cola.estaVacia());
    }

    @Test
    void desencolarYFrenteEnColaVaciaRetornanNull() {
        Cola<Integer> cola = new Cola<>();
        assertNull(cola.desencolar());
        assertNull(cola.frente());
    }

    @Test
    void sizeSeActualizaCorrectamente() {
        Cola<Integer> cola = new Cola<>();
        assertEquals(0, cola.size());
        cola.encolar(1);
        cola.encolar(2);
        assertEquals(2, cola.size());
        cola.desencolar();
        assertEquals(1, cola.size());
    }
}
