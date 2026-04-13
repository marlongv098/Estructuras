package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import estructuras.TablaHash;
import estructuras.TablaHashInterfaz;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Diccionario")
class DiccionarioTest {

    private Diccionario diccionario;

    @BeforeEach
    void setUp() {
        // Constructor por defecto: crea su propia TablaHash internamente
        diccionario = new Diccionario();
    }

    // -----------------------------------------------------------------------
    // agregarPalabra
    // -----------------------------------------------------------------------

    @Nested
    @DisplayName("agregarPalabra()")
    class AgregarPalabraTest {

        @Test
        @DisplayName("agrega una palabra y permite recuperarla")
        void agregarYRecuperar() {
            diccionario.agregarPalabra("java", "Lenguaje orientado a objetos");
            assertEquals("Lenguaje orientado a objetos", diccionario.obtenerDefinicion("java"));
        }

        @Test
        @DisplayName("agregar la misma palabra dos veces actualiza la definición sin duplicar")
        void agregarDuplicadaActualizaSinDuplicar() {
            diccionario.agregarPalabra("java", "Versión 1");
            diccionario.agregarPalabra("java", "Versión 2");

            assertEquals("Versión 2", diccionario.obtenerDefinicion("java"));
            assertEquals(1, diccionario.size(), "No deben existir entradas duplicadas");
        }

        @Test
        @DisplayName("agregar múltiples palabras distintas incrementa size correctamente")
        void agregarVariasIncrementaSize() {
            diccionario.agregarPalabra("java",   "...");
            diccionario.agregarPalabra("python", "...");
            diccionario.agregarPalabra("kotlin", "...");
            assertEquals(3, diccionario.size());
        }
    }

    // -----------------------------------------------------------------------
    // obtenerDefinicion
    // -----------------------------------------------------------------------

    @Nested
    @DisplayName("obtenerDefinicion()")
    class ObtenerDefinicionTest {

        @Test
        @DisplayName("retorna la definición exacta que se insertó")
        void retornaDefinicionCorrecta() {
            diccionario.agregarPalabra("compilador", "Traduce código fuente a código máquina");
            assertEquals("Traduce código fuente a código máquina",
                    diccionario.obtenerDefinicion("compilador"));
        }

        @Test
        @DisplayName("retorna null para una palabra inexistente")
        void retornaNullSiNoExiste() {
            assertNull(diccionario.obtenerDefinicion("palabraInexistente"));
        }

        @Test
        @DisplayName("retorna null después de eliminar la palabra")
        void retornaNullDespuesDeEliminar() {
            diccionario.agregarPalabra("java", "...");
            diccionario.eliminarPalabra("java");
            assertNull(diccionario.obtenerDefinicion("java"));
        }
    }

    // -----------------------------------------------------------------------
    // actualizarDefinicion
    // -----------------------------------------------------------------------

    @Nested
    @DisplayName("actualizarDefinicion()")
    class ActualizarDefinicionTest {

        @Test
        @DisplayName("actualiza la definición de una palabra existente")
        void actualizaValorCorrectamente() {
            diccionario.agregarPalabra("java", "Definición original");
            diccionario.actualizarDefinicion("java", "Definición actualizada");

            assertEquals("Definición actualizada", diccionario.obtenerDefinicion("java"));
        }

        @Test
        @DisplayName("actualizar no modifica size")
        void actualizarNoAlteraSize() {
            diccionario.agregarPalabra("java", "...");
            diccionario.actualizarDefinicion("java", "Nueva definición");
            assertEquals(1, diccionario.size());
        }

        @Test
        @DisplayName("actualizar una palabra inexistente lanza IllegalArgumentException")
        void actualizarInexistenteLanzaExcepcion() {
            assertThrows(IllegalArgumentException.class,
                    () -> diccionario.actualizarDefinicion("kotlin", "No existe aún"));
        }
    }

    // -----------------------------------------------------------------------
    // eliminarPalabra
    // -----------------------------------------------------------------------

    @Nested
    @DisplayName("eliminarPalabra()")
    class EliminarPalabraTest {

        @Test
        @DisplayName("elimina la palabra y decrementa size")
        void eliminaYDecrementaSize() {
            diccionario.agregarPalabra("java", "...");
            diccionario.eliminarPalabra("java");

            assertNull(diccionario.obtenerDefinicion("java"));
            assertEquals(0, diccionario.size());
        }

        @Test
        @DisplayName("eliminar una palabra inexistente no altera size")
        void eliminarInexistenteNoAlteraSize() {
            diccionario.agregarPalabra("java", "...");
            diccionario.eliminarPalabra("python"); // no existe

            assertEquals(1, diccionario.size());
        }

        @Test
        @DisplayName("eliminar la misma palabra dos veces no lanza excepción")
        void eliminarDosVecesEsIdempotente() {
            diccionario.agregarPalabra("java", "...");
            diccionario.eliminarPalabra("java");

            assertDoesNotThrow(() -> diccionario.eliminarPalabra("java"));
            assertEquals(0, diccionario.size());
        }
    }

    // -----------------------------------------------------------------------
    // contienePalabra
    // -----------------------------------------------------------------------

    @Nested
    @DisplayName("contienePalabra()")
    class ContienePalabraTest {

        @Test
        @DisplayName("retorna true para una palabra existente")
        void contieneExistente() {
            diccionario.agregarPalabra("java", "...");
            assertTrue(diccionario.contienePalabra("java"));
        }

        @Test
        @DisplayName("retorna false para una palabra inexistente")
        void noContieneInexistente() {
            assertFalse(diccionario.contienePalabra("kotlin"));
        }

        @Test
        @DisplayName("retorna false después de eliminar la palabra")
        void noContieneDespuesDeEliminar() {
            diccionario.agregarPalabra("java", "...");
            diccionario.eliminarPalabra("java");
            assertFalse(diccionario.contienePalabra("java"));
        }
    }

    // -----------------------------------------------------------------------
    // estaVacio y size
    // -----------------------------------------------------------------------

    @Nested
    @DisplayName("estaVacio() y size()")
    class EstaVacioYSizeTest {

        @Test
        @DisplayName("diccionario recién creado está vacío y tiene size 0")
        void estadoInicial() {
            assertTrue(diccionario.estaVacio());
            assertEquals(0, diccionario.size());
        }

        @Test
        @DisplayName("no está vacío después de agregar una palabra")
        void noEstaVacioDespuesDeAgregar() {
            diccionario.agregarPalabra("java", "...");
            assertFalse(diccionario.estaVacio());
        }

        @Test
        @DisplayName("está vacío después de eliminar todas las palabras")
        void estaVacioDespuesDeEliminarTodo() {
            diccionario.agregarPalabra("java", "...");
            diccionario.eliminarPalabra("java");
            assertTrue(diccionario.estaVacio());
        }
    }

    // -----------------------------------------------------------------------
    // Integración: Diccionario + TablaHash
    //
    // Estos tests usan el constructor con inyección de dependencias:
    //   new Diccionario(tablaHash)
    //
    // El objetivo es verificar que la delegación es real: que cada operación
    // del Diccionario efectivamente escribe/lee en la TablaHash subyacente.
    // Esto es posible precisamente porque Diccionario depende de
    // TablaHashInterfaz, no de TablaHash directamente.
    // -----------------------------------------------------------------------

    @Nested
    @DisplayName("Integración Diccionario → TablaHash")
    class IntegracionTablaHashTest {

        private TablaHashInterfaz<String, String> tablaHash;
        private Diccionario dic;

        @BeforeEach
        void setUp() {
            tablaHash = new TablaHash<>();
            dic = new Diccionario(tablaHash); // inyección explícita
        }

        @Test
        @DisplayName("agregarPalabra escribe en la TablaHash subyacente")
        void agregarEscribeEnTablaHash() {
            dic.agregarPalabra("java", "Lenguaje JVM");

            // Verificamos directamente en la TablaHash, no solo en el Diccionario
            assertEquals("Lenguaje JVM", tablaHash.obtener("java"),
                    "La TablaHash debe contener el valor insertado por Diccionario");
        }

        @Test
        @DisplayName("eliminarPalabra se refleja en la TablaHash subyacente")
        void eliminarSincronizaConTablaHash() {
            dic.agregarPalabra("python", "Lenguaje interpretado");
            dic.eliminarPalabra("python");

            assertNull(tablaHash.obtener("python"),
                    "La TablaHash no debe tener la palabra eliminada");
            assertEquals(0, tablaHash.size());
        }

        @Test
        @DisplayName("actualizarDefinicion se refleja en la TablaHash subyacente")
        void actualizarSincronizaConTablaHash() {
            dic.agregarPalabra("kotlin", "Lenguaje para JVM");
            dic.actualizarDefinicion("kotlin", "Lenguaje moderno para JVM y Android");

            assertEquals("Lenguaje moderno para JVM y Android",
                    tablaHash.obtener("kotlin"),
                    "La TablaHash debe reflejar el valor actualizado");
        }

        @Test
        @DisplayName("size de Diccionario y TablaHash son siempre iguales")
        void sizesConsistentes() {
            dic.agregarPalabra("a", "def a");
            dic.agregarPalabra("b", "def b");
            dic.agregarPalabra("c", "def c");
            dic.eliminarPalabra("b");

            assertEquals(dic.size(), tablaHash.size(),
                    "Diccionario y TablaHash deben reportar el mismo size en todo momento");
        }

        @Test
        @DisplayName("Diccionario mantiene todos los datos tras rehashing de la TablaHash")
        void datosIntactosTrasTrasRehashing() {
            // Con 25 palabras se supera la capacidad inicial (16) y ocurre rehashing
            int total = 25;
            for (int i = 0; i < total; i++) {
                dic.agregarPalabra("palabra" + i, "definicion" + i);
            }

            assertEquals(total, dic.size());

            // Todas las palabras deben seguir accesibles desde el Diccionario
            for (int i = 0; i < total; i++) {
                assertEquals("definicion" + i,
                        dic.obtenerDefinicion("palabra" + i),
                        "palabra" + i + " debe ser accesible después del rehash");
            }

            // Y también desde la TablaHash directamente
            for (int i = 0; i < total; i++) {
                assertEquals("definicion" + i,
                        tablaHash.obtener("palabra" + i),
                        "La TablaHash también debe tener intacta la palabra" + i);
            }
        }
    }
}
