package gestor;

import modelos.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class GestorProductoTest {


    private Gestor<Producto> gestor;

    @BeforeEach
    void setUp() {
        gestor = new Gestor<>();
        gestor.agregar(new Producto("P-001", "Cuaderno",  3500.0));
        gestor.agregar(new Producto("P-002", "Bolígrafo",  800.0));
        gestor.agregar(new Producto("P-003", "Resma",     9900.0));
    }

    // ─── agregar ───────────────────────────────────────────────────

    @Test
    void agregar_incrementaTamano() {
        int tamanoAntes = gestor.size();
        gestor.agregar(new Producto("P-004", "Tijeras", 2500.0));
        assertEquals(tamanoAntes + 1, gestor.size());
    }

    @Test
    void agregar_elementoQuedaAlFinal() {
        Producto nuevo = new Producto("P-004", "Tijeras", 2500.0);
        gestor.agregar(nuevo);
        assertEquals(nuevo, gestor.obtener(gestor.size() - 1));
    }

    // ─── obtener ───────────────────────────────────────────────────

    @Test
    void obtener_retornaProductoCorrecto() {
        Producto resultado = gestor.obtener(0);
        assertEquals(new Producto("P-001", "", 0), resultado);
    }

    @Test
    void obtener_retornaPrecioCorrecto() {
        Producto resultado = gestor.obtener(2);
        assertEquals(9900.0, resultado.getPrecio());
    }

    @Test
    void obtener_indiceInvalidoLanzaExcepcion() {
        assertThrows(IndexOutOfBoundsException.class, () -> gestor.obtener(99));
    }

    // ─── buscar ────────────────────────────────────────────────────

    @Test
    void buscar_encuentraProductoPorCodigo() {
        // equals() en Producto compara solo por codigoProducto
        int indice = gestor.buscar(new Producto("P-002", "", 0));
        assertEquals(1, indice);
    }

    @Test
    void buscar_retornaMenosUnoSiNoExiste() {
        int indice = gestor.buscar(new Producto("P-999", "", 0));
        assertEquals(-1, indice);
    }

    @Test
    void buscar_primerElemento() {
        int indice = gestor.buscar(new Producto("P-001", "", 0));
        assertEquals(0, indice);
    }

    @Test
    void buscar_ultimoElemento() {
        int indice = gestor.buscar(new Producto("P-003", "", 0));
        assertEquals(2, indice);
    }

    // ─── eliminar ──────────────────────────────────────────────────

    @Test
    void eliminar_retornaProductoEliminado() {
        Producto eliminado = gestor.eliminar(1);
        assertEquals(new Producto("P-002", "", 0), eliminado);
    }

    @Test
    void eliminar_reduceTamano() {
        int tamanoAntes = gestor.size();
        gestor.eliminar(0);
        assertEquals(tamanoAntes - 1, gestor.size());
    }

    @Test
    void eliminar_listaActualizaCorrectamente() {
        gestor.eliminar(0); // elimina P-001 en [0]
        // P-002 que estaba en [1] ahora debe estar en [0]
        assertEquals(new Producto("P-002", "", 0), gestor.obtener(0));
    }

    @Test
    void eliminar_indiceInvalidoLanzaExcepcion() {
        assertThrows(IndexOutOfBoundsException.class, () -> gestor.eliminar(99));
    }
}


