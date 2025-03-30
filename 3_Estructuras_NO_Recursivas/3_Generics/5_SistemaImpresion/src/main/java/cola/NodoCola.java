package cola;

public class NodoCola<T> {
    T dato;
    NodoCola<T> siguiente;

    public NodoCola(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}