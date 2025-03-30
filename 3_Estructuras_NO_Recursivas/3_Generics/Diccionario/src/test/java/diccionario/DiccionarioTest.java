package diccionario;

import static org.junit.jupiter.api.Assertions.*;

class DiccionarioTest {

    @org.junit.jupiter.api.Test
    void agregarPalabra() {
        Diccionario diccionario = new Diccionario();
        diccionario.agregarPalabra("java", "Lenguaje de programación");
    }

    @org.junit.jupiter.api.Test
    void obtenerDefinicion() {
        Diccionario diccionario = new Diccionario();
        diccionario.agregarPalabra("java", "Lenguaje de programación");
        assertEquals("Lenguaje de programación", diccionario.obtenerDefinicion("java"));
    }

    @org.junit.jupiter.api.Test
    void eliminarPalabra() {
        Diccionario diccionario = new Diccionario();
        diccionario.agregarPalabra("java", "Lenguaje de programación");
        diccionario.eliminarPalabra("java");
        assertNull(diccionario.obtenerDefinicion("java"));
    }

    @org.junit.jupiter.api.Test
    void size() {
        Diccionario diccionario = new Diccionario();
        assertEquals(0, diccionario.size());
        diccionario.agregarPalabra("java", "Lenguaje de programación");
        assertEquals(1, diccionario.size());
    }

    @org.junit.jupiter.api.Test
    void estaVacio() {
        Diccionario diccionario = new Diccionario();
        diccionario.agregarPalabra("java", "Lenguaje de programación");
        diccionario.eliminarPalabra("java");
        assertFalse(diccionario.estaVacio());

    }
}