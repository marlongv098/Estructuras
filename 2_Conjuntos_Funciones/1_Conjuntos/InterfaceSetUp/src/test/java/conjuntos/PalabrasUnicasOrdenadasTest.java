package conjuntos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class PalabrasUnicasOrdenadasTest {

    @Test
    void ordenaAlfabeticamenteYDeduplica(@TempDir Path tempDir) throws IOException {
        Path archivo = tempDir.resolve("texto.txt");
        Files.writeString(archivo, "zebra Arbol arbol banana Zebra");

        PalabrasUnicasOrdenadas p = new PalabrasUnicasOrdenadas();
        p.leerDesdeArchivo(archivo.toString());

        assertEquals(3, p.getPalabras().size());
        Iterator<String> it = p.getPalabras().iterator();
        assertEquals("arbol", it.next());
        assertEquals("banana", it.next());
        assertEquals("zebra", it.next());
    }

    @Test
    void archivoInexistenteNoLanzaExcepcionYDejaConjuntoVacio() {
        PalabrasUnicasOrdenadas p = new PalabrasUnicasOrdenadas();
        assertDoesNotThrow(() -> p.leerDesdeArchivo("/ruta/que/no/existe.txt"));
        assertTrue(p.getPalabras().isEmpty());
    }
}
