package tablahash;

public interface TablaHashInterfaz<K, V> {
    void insertar(K clave, V valor);
    V obtener(K clave);
    void eliminar(K clave);
    int size();
    boolean estaVacia();
}