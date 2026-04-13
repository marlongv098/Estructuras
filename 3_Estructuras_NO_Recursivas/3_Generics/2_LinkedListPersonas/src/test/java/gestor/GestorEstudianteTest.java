package gestor;

import modelos.Estudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GestorEstudianteTest {


    private Gestor<Estudiante> gestor;

    @BeforeEach
    void setUp() {
        gestor = new Gestor<>();
        gestor.agregar(new Estudiante(20231001, "Carlos", "Vera",   "Ingeniería de Sistemas"));
        gestor.agregar(new Estudiante(20231045, "Sofía",  "Ríos",   "Matemáticas Aplicadas"));
        gestor.agregar(new Estudiante(20231089, "Diego",  "Moreno", "Física"));
    }

    // ─── agregar ───────────────────────────────────────────────────

    @Test
    void agregar_incrementaTamano() {
        int tamanoAntes = gestor.size();
        gestor.agregar(new Estudiante(20239999, "Laura", "Soto", "Química"));
        assertEquals(tamanoAntes + 1, gestor.size());
    }

    @Test
    void agregar_elementoQuedaAlFinal() {
        Estudiante nuevo = new Estudiante(20239999, "Laura", "Soto", "Química");
        gestor.agregar(nuevo);
        assertEquals(nuevo, gestor.obtener(gestor.size() - 1));
    }

    // ─── obtener ───────────────────────────────────────────────────

    @Test
    void obtener_retornaEstudianteCorrecto() {
        Estudiante resultado = gestor.obtener(1);
        assertEquals(new Estudiante(20231045, "", "", ""), resultado);
    }

    @Test
    void obtener_retornaCarreraCorrecta() {
        Estudiante resultado = gestor.obtener(2);
        assertEquals("Física", resultado.getCarrera());
    }

    @Test
    void obtener_indiceInvalidoLanzaExcepcion() {
        assertThrows(IndexOutOfBoundsException.class, () -> gestor.obtener(99));
    }

    // ─── buscar ────────────────────────────────────────────────────

    @Test
    void buscar_encuentraEstudiantePorCodigo() {
        // equals() en Estudiante compara solo por código
        int indice = gestor.buscar(new Estudiante(20231089, "", "", ""));
        assertEquals(2, indice);
    }

    @Test
    void buscar_retornaMenosUnoSiNoExiste() {
        int indice = gestor.buscar(new Estudiante(99999999, "", "", ""));
        assertEquals(-1, indice);
    }

    // ─── eliminar ──────────────────────────────────────────────────

    @Test
    void eliminar_retornaEstudianteEliminado() {
        Estudiante eliminado = gestor.eliminar(0);
        assertEquals(new Estudiante(20231001, "", "", ""), eliminado);
    }

    @Test
    void eliminar_reduceTamano() {
        int tamanoAntes = gestor.size();
        gestor.eliminar(1);
        assertEquals(tamanoAntes - 1, gestor.size());
    }

    @Test
    void eliminar_listaActualizaCorrectamente() {
        gestor.eliminar(1); // elimina Sofía en [1]
        // Diego que estaba en [2] ahora debe estar en [1]
        assertEquals(new Estudiante(20231089, "", "", ""), gestor.obtener(1));
    }

    @Test
    void eliminar_indiceInvalidoLanzaExcepcion() {
        assertThrows(IndexOutOfBoundsException.class, () -> gestor.eliminar(-1));
    }
}

