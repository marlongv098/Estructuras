package estructuras;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaEnlazadaTest {

    private ListaEnlazada<String> lista;

    @BeforeEach
    void setUp() {
        lista = new ListaEnlazada<>();
        lista.agregar("Java");
        lista.agregar("Generics");
        lista.agregar("Estructuras");
    }

    @Test
    void agregar() {
        int tamanoAntes = lista.size();
        lista.agregar("NuevoElemento");
        assertEquals(tamanoAntes + 1, lista.size());
        assertEquals("NuevoElemento", lista.obtener(lista.size() - 1));
    }

    @Test
    void obtener() {
        assertEquals("Java",       lista.obtener(0));
        assertEquals("Generics",   lista.obtener(1));
        assertEquals("Estructuras",lista.obtener(2));
    }

    @Test
    void obtener_indiceInvalidoLanzaExcepcion() {
        assertThrows(IndexOutOfBoundsException.class, () -> lista.obtener(99));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.obtener(-1));
    }

    @Test
    void eliminar() {
        // eliminar retorna el elemento eliminado
        String eliminado = lista.eliminar(1);
        assertEquals("Generics", eliminado);

        // el tamaño disminuye
        assertEquals(2, lista.size());

        // los índices se reorganizan correctamente
        assertEquals("Java",        lista.obtener(0));
        assertEquals("Estructuras", lista.obtener(1));
    }

    @Test
    void eliminar_indiceInvalidoLanzaExcepcion() {
        assertThrows(IndexOutOfBoundsException.class, () -> lista.eliminar(99));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.eliminar(-1));
    }

    @Test
    void buscar() {
        // encuentra elementos existentes
        assertEquals(0, lista.buscar("Java"));
        assertEquals(1, lista.buscar("Generics"));
        assertEquals(2, lista.buscar("Estructuras"));

        // retorna -1 si no existe
        assertEquals(-1, lista.buscar("NoExiste"));
    }

    @Test
    void size() {
        assertEquals(3, lista.size());

        lista.agregar("Nuevo");
        assertEquals(4, lista.size());

        lista.eliminar(0);
        assertEquals(3, lista.size());
    }

    @Test
    void estaVacia() {
        // lista con elementos no está vacía
        assertFalse(lista.estaVacia());

        // lista recién creada sí está vacía
        ListaEnlazada<String> listaVacia = new ListaEnlazada<>();
        assertTrue(listaVacia.estaVacia());

        // después de eliminar todos los elementos queda vacía
        lista.eliminar(0);
        lista.eliminar(0);
        lista.eliminar(0);
        assertTrue(lista.estaVacia());
    }

    @Test
    void testToString() {
        String resultado = lista.toString();
        assertTrue(resultado.contains("Java"));
        assertTrue(resultado.contains("Generics"));
        assertTrue(resultado.contains("Estructuras"));

        // lista vacía tiene representación especial
        ListaEnlazada<String> listaVacia = new ListaEnlazada<>();
        assertEquals("[ lista vacía ]", listaVacia.toString());
    }
}