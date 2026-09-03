package colaprioridad;

import org.junit.jupiter.api.Test;
import tareas.Tarea;

import static org.junit.jupiter.api.Assertions.*;

class HeapMinimoTest {

    @Test
    void extraeSiempreLaMenorPrioridadPrimero() {
        HeapMinimo<Tarea, String> heap = new HeapMinimo<>();
        heap.agregar(new Tarea("baja", 5));
        heap.agregar(new Tarea("alta", 1));
        heap.agregar(new Tarea("media", 3));

        assertEquals("alta", heap.extraerMinimo().obtenerDatos());
        assertEquals("media", heap.extraerMinimo().obtenerDatos());
        assertEquals("baja", heap.extraerMinimo().obtenerDatos());
        assertTrue(heap.estaVacio());
    }

    @Test
    void mantienePropiedadDeHeapConInsercionesEnDesorden() {
        HeapMinimo<Tarea, String> heap = new HeapMinimo<>();
        int[] prioridades = {9, 3, 7, 1, 8, 2, 6, 4, 5, 0};
        for (int p : prioridades) {
            heap.agregar(new Tarea("t" + p, p));
        }

        int anterior = -1;
        while (!heap.estaVacio()) {
            Tarea t = heap.extraerMinimo();
            assertTrue(t.obtenerPrioridad() > anterior, "el heap debe extraer en orden ascendente de prioridad");
            anterior = t.obtenerPrioridad();
        }
    }

    @Test
    void extraerMinimoEnHeapVacioRetornaNull() {
        HeapMinimo<Tarea, String> heap = new HeapMinimo<>();
        assertNull(heap.extraerMinimo());
    }
}
