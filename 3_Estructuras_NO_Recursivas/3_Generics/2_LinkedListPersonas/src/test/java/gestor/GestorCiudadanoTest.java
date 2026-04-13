package gestor;

import modelos.Ciudadano;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GestorCiudadanoTest {

    private Gestor<Ciudadano> gestor;

    @BeforeEach
    void setUp() {
        gestor = new Gestor<>();
        gestor.agregar(new Ciudadano("1020304050", "Ana",   "López"));
        gestor.agregar(new Ciudadano("9876543210", "Luis",  "Gómez"));
        gestor.agregar(new Ciudadano("1122334455", "María", "Torres"));
    }

    // ─── agregar ───────────────────────────────────────────────────

    @Test
    void agregar_incrementaTamano() {
        int tamanoAntes = gestor.size();
        gestor.agregar(new Ciudadano("5544332211", "Pedro", "Ruiz"));
        assertEquals(tamanoAntes + 1, gestor.size());
    }

    @Test
    void agregar_elementoQuedaAlFinal() {
        Ciudadano nuevo = new Ciudadano("5544332211", "Pedro", "Ruiz");
        gestor.agregar(nuevo);
        assertEquals(nuevo, gestor.obtener(gestor.size() - 1));
    }

    // ─── obtener ───────────────────────────────────────────────────

    @Test
    void obtener_retornaElementoCorrecto() {
        Ciudadano resultado = gestor.obtener(0);
        assertEquals(new Ciudadano("1020304050", "", ""), resultado);
    }

    @Test
    void obtener_indiceInvalidoLanzaExcepcion() {
        assertThrows(IndexOutOfBoundsException.class, () -> gestor.obtener(99));
    }

    @Test
    void obtener_indiceNegativoLanzaExcepcion() {
        assertThrows(IndexOutOfBoundsException.class, () -> gestor.obtener(-1));
    }

    // ─── buscar ────────────────────────────────────────────────────

    @Test
    void buscar_encuentraElementoExistente() {
        // equals() en Ciudadano compara solo por cédula
        int indice = gestor.buscar(new Ciudadano("9876543210", "", ""));
        assertEquals(1, indice);
    }

    @Test
    void buscar_retornaMenosUnoSiNoExiste() {
        int indice = gestor.buscar(new Ciudadano("0000000000", "", ""));
        assertEquals(-1, indice);
    }

    // ─── eliminar ──────────────────────────────────────────────────

    @Test
    void eliminar_retornaElementoEliminado() {
        Ciudadano eliminado = gestor.eliminar(1);
        assertEquals(new Ciudadano("9876543210", "", ""), eliminado);
    }

    @Test
    void eliminar_reduceTamano() {
        int tamanoAntes = gestor.size();
        gestor.eliminar(0);
        assertEquals(tamanoAntes - 1, gestor.size());
    }

    @Test
    void eliminar_indiceInvalidoLanzaExcepcion() {
        assertThrows(IndexOutOfBoundsException.class, () -> gestor.eliminar(99));
    }
}

