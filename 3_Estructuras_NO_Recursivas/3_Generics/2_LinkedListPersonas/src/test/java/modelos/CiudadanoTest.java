package modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CiudadanoTest {

    private Ciudadano ciudadano;

    @BeforeEach
    void setUp() {
        ciudadano = new Ciudadano("1020304050", "Ana", "López");
    }

    @Test
    void getCedula() {
        assertEquals("1020304050", ciudadano.getCedula());
    }

    @Test
    void setCedula() {
        ciudadano.setCedula("9999999999");
        assertEquals("9999999999", ciudadano.getCedula());
    }

    @Test
    void getNombre() {
        assertEquals("Ana", ciudadano.getNombre());
    }

    @Test
    void setNombre() {
        ciudadano.setNombre("María");
        assertEquals("María", ciudadano.getNombre());
    }

    @Test
    void getApellido() {
        assertEquals("López", ciudadano.getApellido());
    }

    @Test
    void setApellido() {
        ciudadano.setApellido("Torres");
        assertEquals("Torres", ciudadano.getApellido());
    }

    @Test
    void testEquals() {
        // Misma cédula → son iguales (equals compara solo por cédula)
        Ciudadano mismaCedula = new Ciudadano("1020304050", "", "");
        assertEquals(ciudadano, mismaCedula);

        // Distinta cédula → son distintos
        Ciudadano otraCedula = new Ciudadano("0000000000", "Ana", "López");
        assertNotEquals(ciudadano, otraCedula);
    }

    @Test
    void testToString() {
        String resultado = ciudadano.toString();
        assertTrue(resultado.contains("1020304050"));
        assertTrue(resultado.contains("Ana"));
        assertTrue(resultado.contains("López"));
    }
}