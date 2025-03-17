package editor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditorTextoTest {

    @Test
    void escribir() {
        EditorTextoInterfaz editor = new EditorTexto();
        editor.escribir("Hola");
        assertEquals("Hola", editor.obtenerTextoActual());
        editor.escribir(", mundo!");
        assertEquals("Hola, mundo!", editor.obtenerTextoActual());
    }

    @Test
    void deshacer() {
        EditorTextoInterfaz editor = new EditorTexto();
        editor.escribir("Hola");
        editor.escribir(", mundo!");
        editor.deshacer();
        assertEquals("Hola", editor.obtenerTextoActual());
    }

    @Test
    void rehacer() {
        EditorTextoInterfaz editor = new EditorTexto();
        editor.escribir("Hola");
        editor.escribir(", mundo!");
        editor.deshacer();
        editor.rehacer();
        assertEquals("Hola, mundo!", editor.obtenerTextoActual());
    }

    @Test
    void obtenerTextoActual() {
        EditorTextoInterfaz editor = new EditorTexto();
        editor.escribir("Hola");
        assertEquals("Hola", editor.obtenerTextoActual());
        editor.escribir(", mundo!");
        assertEquals("Hola, mundo!", editor.obtenerTextoActual());
    }

    @Test
    void obtenerTopeDeshacer() {
        EditorTextoInterfaz editor = new EditorTexto();
        editor.escribir("Hola");
        editor.escribir(", mundo!");
        assertEquals("Hola", editor.obtenerTopeDeshacer());
        editor.deshacer();
        assertEquals("", editor.obtenerTopeDeshacer());
    }

    @Test
    void obtenerTopeRehacer() {
        EditorTextoInterfaz editor = new EditorTexto();
        editor.escribir("Hola");
        editor.escribir(", mundo!");
        editor.deshacer();
        assertEquals("Hola, mundo!", editor.obtenerTopeRehacer());
        editor.rehacer();
        assertNull(editor.obtenerTopeRehacer());
    }
}