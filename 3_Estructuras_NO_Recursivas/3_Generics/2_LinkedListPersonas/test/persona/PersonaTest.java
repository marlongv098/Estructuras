package persona;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    @Test
    void getNombre() {
        Persona persona = new Persona("Juan", 30);
        assertEquals("Juan", persona.getNombre());
    }

    @Test
    void setNombre() {
    }

    @Test
    void getEdad() {
        Persona persona = new Persona("Juan", 30);
        assertEquals(30, persona.getEdad());
    }

    @Test
    void setEdad() {
    }

    @Test
    void testToString() {
    }
}