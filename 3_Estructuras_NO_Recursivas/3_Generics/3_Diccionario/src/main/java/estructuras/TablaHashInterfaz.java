package estructuras;

public interface TablaHashInterfaz<K, V> {

    /**
     * Inserta un par clave-valor.
     * Si la clave ya existe, actualiza el valor sin incrementar size.
     */
    void insertar(K clave, V valor);

    /**
     * Retorna el valor asociado a la clave.
     * Retorna null si la clave no existe.
     */
    V obtener(K clave);

    /**
     * Elimina la entrada con la clave dada.
     * Si la clave no existe, no hace nada (operación idempotente).
     */
    void eliminar(K clave);

    /**
     * Actualiza el valor de una clave existente.
     * */
    void actualizar(K clave, V nuevoValor);

    /**
     * Verifica si una clave existe en la tabla.
     */
    boolean contiene(K clave);

    /**
     * Retorna el número total de entradas en la tabla.
     */
    int size();

    /**
     * Retorna true si la tabla no contiene ninguna entrada.
     */
    boolean estaVacia();
}
