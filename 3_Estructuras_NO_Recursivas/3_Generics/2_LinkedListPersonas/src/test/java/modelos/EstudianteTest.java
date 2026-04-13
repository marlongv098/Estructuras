package modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstudianteTest {

    private Estudiante estudiante;

    @BeforeEach
    void setUp() {
        estudiante = new Estudiante(20231001, "Carlos", "Vera", "Ingeniería de Sistemas");
    }

    @Test
    void getCodigo() {
        assertEquals(20231001, estudiante.getCodigo());
    }

    @Test
    void setCodigo() {
        estudiante.setCodigo(20239999);
        assertEquals(20239999, estudiante.getCodigo());
    }

    @Test
    void getNombre() {
        assertEquals("Carlos", estudiante.getNombre());
    }

    @Test
    void setNombre() {
        estudiante.setNombre("Laura");
        assertEquals("Laura", estudiante.getNombre());
    }

    @Test
    void getApellido() {
        assertEquals("Vera", estudiante.getApellido());
    }

    @Test
    void setApellido() {
        estudiante.setApellido("Soto");
        assertEquals("Soto", estudiante.getApellido());
    }

    @Test
    void getCarrera() {
        assertEquals("Ingeniería de Sistemas", estudiante.getCarrera());
    }

    @Test
    void setCarrera() {
        estudiante.setCarrera("Matemáticas Aplicadas");
        assertEquals("Matemáticas Aplicadas", estudiante.getCarrera());
    }

    @Test
    void testEquals() {
        // Mismo código → son iguales (equals compara solo por código)
        Estudiante mismocodigo = new Estudiante(20231001, "", "", "");
        assertEquals(estudiante, mismocodigo);

        // Distinto código → son distintos
        Estudiante otroCodigo = new Estudiante(99999999, "Carlos", "Vera", "Ingeniería de Sistemas");
        assertNotEquals(estudiante, otroCodigo);
    }

    @Test
    void testToString() {
        String resultado = estudiante.toString();
        assertTrue(resultado.contains("20231001"));
        assertTrue(resultado.contains("Carlos"));
        assertTrue(resultado.contains("Vera"));
        assertTrue(resultado.contains("Ingeniería de Sistemas"));
    }
}