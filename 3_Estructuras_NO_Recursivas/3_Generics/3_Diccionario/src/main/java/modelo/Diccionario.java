package modelo;

import estructuras.TablaHash;
import estructuras.TablaHashInterfaz;

/**
 * Diccionario de palabras y definiciones.
 * Clase concreta que delega el almacenamiento a una TablaHash.
 * La dependencia se declara contra TablaHashInterfaz (no TablaHash directamente)
 * para mantener el desacoplamiento en la capa de estructura de datos.
 **/

public class Diccionario {

    private final TablaHashInterfaz<String, String> tablaHash;

    /**
     * Crea un diccionario vacío con la implementación por defecto de TablaHash.
     */
    public Diccionario() {
        this.tablaHash = new TablaHash<>();
    }

    /**
     * Constructor para inyección de dependencias.
     * Útil en tests o si en el futuro se quiere cambiar la implementación
     *
     */
    public Diccionario(TablaHashInterfaz<String, String> tablaHash) {
        this.tablaHash = tablaHash;
    }

    /**
     * Agrega una palabra con su definición.
     * Si la palabra ya existe, actualiza la definición sin crear duplicados.
     */
    public void agregarPalabra(String palabra, String definicion) {
        tablaHash.insertar(palabra, definicion);
    }

    /**
     * Retorna la definición de una palabra.
     *
     */
    public String obtenerDefinicion(String palabra) {
        return tablaHash.obtener(palabra);
    }

    /**
     * Actualiza la definición de una palabra ya existente.
     *
     */
    public void actualizarDefinicion(String palabra, String nuevaDefinicion) {
        tablaHash.actualizar(palabra, nuevaDefinicion);
    }

    /**
     * Elimina una palabra del diccionario.
     * Si la palabra no existe, no hace nada (operación idempotente).
     */
    public void eliminarPalabra(String palabra) {
        tablaHash.eliminar(palabra);
    }

    /**
     * Verifica si una palabra existe en el diccionario.
     */
    public boolean contienePalabra(String palabra) {
        return tablaHash.contiene(palabra);
    }

    /**
     * Retorna el número de palabras almacenadas.
     */
    public int size() {
        return tablaHash.size();
    }

    /**
     * Retorna true si el diccionario no contiene ninguna palabra.
     */
    public boolean estaVacio() {
        return tablaHash.estaVacia();
    }
}
