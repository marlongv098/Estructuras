package estructuras;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TablaHash")
class TablaHashTest {

    private TablaHash<String, Integer> tabla;

    @BeforeEach
    void setUp() {
        tabla = new TablaHash<>();
    }

    // -----------------------------------------------------------------------
    // Insertar
    // -----------------------------------------------------------------------

    @Nested
    @DisplayName("insertar()")
    class InsertarTest {

        @Test
        @DisplayName("inserta un par clave-valor y lo recupera correctamente")
        void insertarUnaEntrada() {
            tabla.insertar("uno", 1);
            assertEquals(1, tabla.obtener("uno"));
        }

        @Test
        @DisplayName("inserta múltiples pares sin colisión")
        void insertarVariasEntradas() {
            tabla.insertar("uno",  1);
            tabla.insertar("dos",  2);
            tabla.insertar("tres", 3);

            assertEquals(1, tabla.obtener("uno"));
            assertEquals(2, tabla.obtener("dos"));
            assertEquals(3, tabla.obtener("tres"));
            assertEquals(3, tabla.size());
        }

        @Test
        @DisplayName("insertar una clave existente actualiza el valor sin incrementar size")
        void insertarClaveExistenteActualizaValor() {
            tabla.insertar("java", 1);
            tabla.insertar("java", 99); // misma clave, nuevo valor

            assertEquals(99, tabla.obtener("java"));
            assertEquals(1, tabla.size(), "size no debe incrementarse al actualizar");
        }

        @Test
        @DisplayName("lanza excepción si la clave es null")
        void insertarClaveNullLanzaExcepcion() {
            assertThrows(IllegalArgumentException.class,
                    () -> tabla.insertar(null, 1));
        }
    }

    // -----------------------------------------------------------------------
    // Obtener
    // -----------------------------------------------------------------------

    @Nested
    @DisplayName("obtener()")
    class ObtenerTest {

        @Test
        @DisplayName("retorna null para una clave inexistente")
        void obtenerClaveInexistente() {
            assertNull(tabla.obtener("inexistente"));
        }

        @Test
        @DisplayName("retorna el valor correcto después de varias inserciones")
        void obtenerDespuesDeVariasInserciones() {
            tabla.insertar("a", 10);
            tabla.insertar("b", 20);
            tabla.insertar("c", 30);

            assertEquals(20, tabla.obtener("b"));
        }

        @Test
        @DisplayName("lanza excepción si la clave es null")
        void obtenerClaveNull() {
            assertThrows(IllegalArgumentException.class,
                    () -> tabla.obtener(null));
        }
    }

    // -----------------------------------------------------------------------
    // Eliminar
    // -----------------------------------------------------------------------

    @Nested
    @DisplayName("eliminar()")
    class EliminarTest {

        @Test
        @DisplayName("elimina una clave existente y retorna null al buscarla")
        void eliminarClaveExistente() {
            tabla.insertar("uno", 1);
            tabla.eliminar("uno");

            assertNull(tabla.obtener("uno"));
            assertEquals(0, tabla.size());
        }

        @Test
        @DisplayName("BUG CORREGIDO: eliminar clave inexistente NO decrementa size")
        void eliminarClaveInexistenteNoAlteraSize() {
            tabla.insertar("uno", 1);
            tabla.insertar("dos", 2);

            tabla.eliminar("inexistente"); // clave que no existe

            assertEquals(2, tabla.size(),
                    "size no debe cambiar al intentar eliminar una clave inexistente");
        }

        @Test
        @DisplayName("eliminar es idempotente: eliminar dos veces no lanza excepción")
        void eliminarDosVecesEsIdempotente() {
            tabla.insertar("uno", 1);
            tabla.eliminar("uno");

            assertDoesNotThrow(() -> tabla.eliminar("uno"),
                    "eliminar una clave ya eliminada no debe lanzar excepción");
            assertEquals(0, tabla.size());
        }

        @Test
        @DisplayName("lanza excepción si la clave es null")
        void eliminarClaveNull() {
            assertThrows(IllegalArgumentException.class,
                    () -> tabla.eliminar(null));
        }
    }

    // -----------------------------------------------------------------------
    // Actualizar
    // -----------------------------------------------------------------------

    @Nested
    @DisplayName("actualizar()")
    class ActualizarTest {

        @Test
        @DisplayName("BUG CORREGIDO: actualizar realmente modifica el valor almacenado")
        void actualizarModificaValor() {
            tabla.insertar("clave", 10);
            tabla.actualizar("clave", 99);

            assertEquals(99, tabla.obtener("clave"),
                    "actualizar debe cambiar el valor, no dejarlo igual");
        }

        @Test
        @DisplayName("actualizar no modifica size")
        void actualizarNoModificaSize() {
            tabla.insertar("clave", 10);
            int sizeAntes = tabla.size();
            tabla.actualizar("clave", 99);

            assertEquals(sizeAntes, tabla.size());
        }

        @Test
        @DisplayName("actualizar clave inexistente lanza IllegalArgumentException")
        void actualizarClaveInexistenteLanzaExcepcion() {
            assertThrows(IllegalArgumentException.class,
                    () -> tabla.actualizar("noExiste", 5));
        }
    }

    // -----------------------------------------------------------------------
    // Contiene
    // -----------------------------------------------------------------------

    @Nested
    @DisplayName("contiene()")
    class ContieneTest {

        @Test
        @DisplayName("retorna true para una clave existente")
        void contieneClaveExistente() {
            tabla.insertar("java", 1);
            assertTrue(tabla.contiene("java"));
        }

        @Test
        @DisplayName("retorna false para una clave inexistente")
        void contieneClaveInexistente() {
            assertFalse(tabla.contiene("kotlin"));
        }

        @Test
        @DisplayName("retorna false después de eliminar la clave")
        void noContieneDespuesDeEliminar() {
            tabla.insertar("java", 1);
            tabla.eliminar("java");
            assertFalse(tabla.contiene("java"));
        }
    }

    // -----------------------------------------------------------------------
    // size() y estaVacia()
    // -----------------------------------------------------------------------

    @Nested
    @DisplayName("size() y estaVacia()")
    class SizeYVaciaTest {

        @Test
        @DisplayName("tabla nueva tiene size 0 y está vacía")
        void tablaVaciaInicial() {
            assertEquals(0, tabla.size());
            assertTrue(tabla.estaVacia());
        }

        @Test
        @DisplayName("size crece con las inserciones")
        void sizeCreceCorrecto() {
            assertEquals(0, tabla.size());
            tabla.insertar("a", 1);
            assertEquals(1, tabla.size());
            tabla.insertar("b", 2);
            assertEquals(2, tabla.size());
        }

        @Test
        @DisplayName("size decrementa correctamente al eliminar")
        void sizeDecrementaAlEliminar() {
            tabla.insertar("a", 1);
            tabla.insertar("b", 2);
            tabla.eliminar("a");
            assertEquals(1, tabla.size());
        }

        @Test
        @DisplayName("estaVacia retorna false después de insertar")
        void noEstaVaciaDespuesDeInsertar() {
            tabla.insertar("a", 1);
            assertFalse(tabla.estaVacia());
        }
    }

    // -----------------------------------------------------------------------
    // Rehashing
    // -----------------------------------------------------------------------

    @Nested
    @DisplayName("rehashing automático")
    class RehashingTest {

        @Test
        @DisplayName("inserta más de 12 elementos sin perder datos (factor de carga > 0.75)")
        void insertarMasDeCapacidadInicialSinPerderDatos() {
            // Con capacidad=16 y factor=0.75, rehash ocurre alrededor de 12 inserciones
            int total = 20;
            for (int i = 0; i < total; i++) {
                tabla.insertar("clave" + i, i * 10);
            }

            assertEquals(total, tabla.size());

            // Verificar que todos los valores siguen accesibles después del rehash
            for (int i = 0; i < total; i++) {
                assertEquals(i * 10, tabla.obtener("clave" + i),
                        "clave" + i + " debería seguir accesible tras el rehash");
            }
        }
    }

    // -----------------------------------------------------------------------
    // Edge cases
    // -----------------------------------------------------------------------

    @Nested
    @DisplayName("edge cases")
    class EdgeCasesTest {

        @Test
        @DisplayName("BUG CORREGIDO: clave con hashCode negativo no lanza excepción")
        void claveConHashCodeNegativo() {
            // Se usa una TablaHash<Integer, String> para forzar hashCodes negativos
            TablaHash<Integer, String> tablaInt = new TablaHash<>();

            // Integer.MIN_VALUE tiene hashCode negativo: Math.abs(MIN_VALUE) == MIN_VALUE
            assertDoesNotThrow(() -> {
                tablaInt.insertar(-1,                 "negativo uno");
                tablaInt.insertar(Integer.MIN_VALUE,  "min value");
                tablaInt.insertar(-999,               "negativo grande");
            });

            assertEquals("negativo uno",  tablaInt.obtener(-1));
            assertEquals("min value",     tablaInt.obtener(Integer.MIN_VALUE));
            assertEquals("negativo grande", tablaInt.obtener(-999));
        }

        @Test
        @DisplayName("operaciones sobre tabla vacía son seguras")
        void operacionesSobreTablaVacia() {
            assertNull(tabla.obtener("x"));
            assertFalse(tabla.contiene("x"));
            assertDoesNotThrow(() -> tabla.eliminar("x"));
        }
    }
}
