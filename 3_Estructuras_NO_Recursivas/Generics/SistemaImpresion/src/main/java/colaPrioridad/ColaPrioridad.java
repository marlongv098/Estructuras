package colaPrioridad;

public class ColaPrioridad<T> implements ColaPrioridadInterfaz<T> {

    private NodoPrioridad<T> cabeza;
    private int tamano;

    public ColaPrioridad() {
        this.cabeza = null;
        this.tamano = 0;
    }

    @Override
    public void insertar(T elemento, int prioridad) {
        NodoPrioridad<T> nuevoNodo = new NodoPrioridad<>(elemento, prioridad);
        if (estaVacia() || prioridad < cabeza.prioridad) {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        } else {
            NodoPrioridad<T> actual = cabeza;
            while (actual.siguiente != null && actual.siguiente.prioridad <= prioridad) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }
        tamano++;
    }

    @Override
    public T eliminar() {
        if (estaVacia()) {
            return null;
        }
        T dato = cabeza.dato;
        cabeza = cabeza.siguiente;
        tamano--;
        return dato;
    }

    @Override
    public T frente() {
        if (estaVacia()) {
            return null;
        }
        return cabeza.dato;
    }

    @Override
    public boolean estaVacia() {
        return cabeza == null;
    }

    @Override
    public int size() {
        return tamano;
    }
}
