package diccionario;

public interface DiccionarioInterfaz {
    void agregarPalabra(String palabra, String definicion);
    String obtenerDefinicion(String palabra);
    void eliminarPalabra(String palabra);
    int size();
    boolean estaVacio();
}