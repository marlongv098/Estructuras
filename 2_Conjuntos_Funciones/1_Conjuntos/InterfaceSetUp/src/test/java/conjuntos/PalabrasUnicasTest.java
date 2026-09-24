package conjuntos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalabrasUnicasTest {

    @Test
    void deduplicaYNormalizaAMinusculas() {
        PalabrasUnicas pu = new PalabrasUnicas();
        pu.agregarDesdeOracion("Hola hola HOLA mundo");
        assertEquals(2, pu.getPalabras().size());
        assertTrue(pu.getPalabras().contains("hola"));
        assertTrue(pu.getPalabras().contains("mundo"));
    }

    @Test
    void ignoraTokensQueSonSoloPuntuacion() {
        // Antes de la corrección, un token como "--" quedaba como cadena vacía
        // tras el replaceAll y contaminaba el conjunto con "".
        PalabrasUnicas pu = new PalabrasUnicas();
        pu.agregarDesdeOracion("hola -- mundo ...");
        assertEquals(2, pu.getPalabras().size());
        assertFalse(pu.getPalabras().contains(""));
    }

    @Test
    void quitaSignosDePuntuacionDeCadaPalabra() {
        PalabrasUnicas pu = new PalabrasUnicas();
        pu.agregarDesdeOracion("¡Hola, mundo!");
        assertTrue(pu.getPalabras().contains("hola"));
        assertTrue(pu.getPalabras().contains("mundo"));
    }
}
