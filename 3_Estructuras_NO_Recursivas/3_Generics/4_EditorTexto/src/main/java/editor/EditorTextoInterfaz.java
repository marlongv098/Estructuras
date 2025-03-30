package editor;

public interface EditorTextoInterfaz {
    void escribir(String texto);
    void deshacer();
    void rehacer();
    String obtenerTextoActual();

    String obtenerTopeDeshacer();

    String obtenerTopeRehacer();
}
