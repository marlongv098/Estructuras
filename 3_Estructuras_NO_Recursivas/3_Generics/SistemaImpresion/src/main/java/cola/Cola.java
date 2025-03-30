package cola;

public class Cola<T> implements ColaInterfaz<T> {

    private NodoCola<T> cabeza;
    private NodoCola<T> cola;
    private int tamano;

    public Cola() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }

    @Override
    public void encolar(T elemento) {
        NodoCola<T> nuevoNodo = new NodoCola<>(elemento);
        if (estaVacia()) {
            cabeza = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
        }
        cola = nuevoNodo;
        tamano++;
    }

    @Override
    public T desencolar() {
        if (estaVacia()) {
            return null;
        }
        T dato = cabeza.dato;
        cabeza = cabeza.siguiente;
        tamano--;
        if (cabeza == null) {
            cola = null;
        }
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