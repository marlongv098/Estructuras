package colaPrioridad;

public interface ColaPrioridadInterfaz<T> {
    void insertar(T elemento, int prioridad);
    T eliminar();
    T frente();
    boolean estaVacia();
    int size();
}