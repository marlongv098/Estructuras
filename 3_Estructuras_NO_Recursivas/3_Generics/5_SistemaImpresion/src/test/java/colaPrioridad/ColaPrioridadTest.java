package colaPrioridad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColaPrioridadTest {

    @Test
    void eliminaSiempreElDeMenorPrioridadPrimero() {
        // Convención de este proyecto: menor número = mayor prioridad (1 se atiende antes que 5)
        ColaPrioridad<String> cola = new ColaPrioridad<>();
        cola.insertar("normal", 5);
        cola.insertar("urgente", 1);
        cola.insertar("media", 3);

        assertEquals("urgente", cola.eliminar());
        assertEquals("media", cola.eliminar());
        assertEquals("normal", cola.eliminar());
        assertTrue(cola.estaVacia());
    }

    @Test
    void insertarEnOrdenNoAlteraElOrdenDePrioridad() {
        ColaPrioridad<Integer> cola = new ColaPrioridad<>();
        cola.insertar(100, 1);
        cola.insertar(200, 1); // misma prioridad: debe respetar el orden de llegada (FIFO dentro de la misma prioridad)
        assertEquals(100, cola.eliminar());
        assertEquals(200, cola.eliminar());
    }

    @Test
    void eliminarYFrenteEnColaVaciaRetornanNull() {
        ColaPrioridad<Integer> cola = new ColaPrioridad<>();
        assertNull(cola.eliminar());
        assertNull(cola.frente());
    }
}
