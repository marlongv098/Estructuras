package pilalistaenlazada;

public class Pila<T> implements Interfaz<T> {

    private Nodo<T> cabeza;
    private int size;

    public Pila() {
        this.cabeza = null;
        this.size = 0;
    }

    @Override
    public void apilar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        size++;
    }

    @Override
    public T desapilar() {
        if (estaVacia()) {
            return null;
        }
        T dato = cabeza.dato;
        cabeza = cabeza.siguiente;
        size--;
        return dato;
    }

    @Override
    public T tope() {
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
        return size;
    }

    @Override
    public void clear() {
        cabeza = null;
        size = 0;
    }
}
