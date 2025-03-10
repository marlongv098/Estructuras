package persona;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaGenericaTest {

    @Test
    void getNombre() {
        PersonaGenerica<String,Integer> persona = new PersonaGenerica<>("Juan", 30);
        assertEquals("Juan", persona.getNombre());
    }

    @Test
    void setNombre() {
        PersonaGenerica<String, Integer> persona = new PersonaGenerica<>("Juan", 30);
        persona.setNombre("Pedro");
        assertEquals("Pedro", persona.getNombre());
    }

    @Test
    void getEdad() {
        PersonaGenerica<String, Integer> persona = new PersonaGenerica<>("Juan", 30);
        assertEquals(30, persona.getEdad());
    }

    @Test
    void setEdad() {
        PersonaGenerica<String, Integer> persona = new PersonaGenerica<>("Juan", 30);
        persona.setEdad(25);
        assertEquals(25, persona.getEdad());
    }

    @Test
    void testToString() {
        PersonaGenerica<String, Integer> persona = new PersonaGenerica<>("Juan", 30);
        String expectedString = "Persona{nombre=Juan, edad=30}";
        assertEquals(expectedString, persona.toString());
    }
}