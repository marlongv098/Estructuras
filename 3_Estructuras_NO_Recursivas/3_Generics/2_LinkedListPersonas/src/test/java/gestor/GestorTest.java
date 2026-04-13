package gestor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorTest {

    private Gestor<String> gestor;

    @BeforeEach
    void setUp() {
        gestor = new Gestor<>();
        gestor.agregar("Java");
        gestor.agregar("Generics");
        gestor.agregar("Estructuras");
    }

    @Test
    void agregar() {
        int tamanoAntes = gestor.size();
        gestor.agregar("NuevoElemento");
        assertEquals(tamanoAntes + 1, gestor.size());
        assertEquals("NuevoElemento", gestor.obtener(gestor.size() - 1));
    }

    @Test
    void obtener() {
        assertEquals("Java",        gestor.obtener(0));
        assertEquals("Generics",    gestor.obtener(1));
        assertEquals("Estructuras", gestor.obtener(2));
    }

    @Test
    void obtener_indiceInvalidoLanzaExcepcion() {
        assertThrows(IndexOutOfBoundsException.class, () -> gestor.obtener(99));
        assertThrows(IndexOutOfBoundsException.class, () -> gestor.obtener(-1));
    }

    @Test
    void buscar() {
        // encuentra elementos en cualquier posición
        assertEquals(0, gestor.buscar("Java"));
        assertEquals(1, gestor.buscar("Generics"));
        assertEquals(2, gestor.buscar("Estructuras"));

        // retorna -1 si el elemento no existe
        assertEquals(-1, gestor.buscar("NoExiste"));
    }

    @Test
    void eliminar() {
        // eliminar retorna el elemento eliminado
        String eliminado = gestor.eliminar(1);
        assertEquals("Generics", eliminado);

        // el tamaño disminuye
        assertEquals(2, gestor.size());

        // los índices se reorganizan correctamente
        assertEquals("Java",        gestor.obtener(0));
        assertEquals("Estructuras", gestor.obtener(1));
    }

    @Test
    void eliminar_indiceInvalidoLanzaExcepcion() {
        assertThrows(IndexOutOfBoundsException.class, () -> gestor.eliminar(99));
        assertThrows(IndexOutOfBoundsException.class, () -> gestor.eliminar(-1));
    }

    @Test
    void size() {
        assertEquals(3, gestor.size());

        gestor.agregar("Nuevo");
        assertEquals(4, gestor.size());

        gestor.eliminar(0);
        assertEquals(3, gestor.size());
    }

    @Test
    void testToString() {
        String resultado = gestor.toString();
        assertTrue(resultado.contains("Java"));
        assertTrue(resultado.contains("Generics"));
        assertTrue(resultado.contains("Estructuras"));

        // gestor vacío tiene representación especial
        Gestor<String> gestorVacio = new Gestor<>();
        assertEquals("[ lista vacía ]", gestorVacio.toString());
    }
}