package listas.doble;

public class ListaDoble<T> {

    private NodoDoble<T> cabeza;
    private NodoDoble<T> cola;
    private int tamano;

    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }

    public void insertar(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (cabeza != null) {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
        }
        cabeza = nuevo;
        if (cola == null) {
            cola = cabeza;
        }
        tamano++;
    }

    public void insertarAlFinal(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
        tamano++;
    }

    public void imprimir() {
        NodoDoble<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public void insertarDespuesDe(T referencia, T dato) {
        NodoDoble<T> actual = cabeza;
        while (actual != null && !actual.dato.equals(referencia)) {
            actual = actual.siguiente;
        }
        if (actual != null) {
            NodoDoble<T> nuevo = new NodoDoble<>(dato);
            nuevo.siguiente = actual.siguiente;
            if (actual.siguiente != null) {
                actual.siguiente.anterior = nuevo;
            }
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
            if (nuevo.siguiente == null) {
                cola = nuevo;
            }
            tamano++;
        }
    }

    public int getTamano() {
        return tamano;
    }

    public boolean estaVacia() {
        return tamano == 0;
    }

    private static class NodoDoble<T> {
        T dato;
        NodoDoble<T> siguiente;
        NodoDoble<T> anterior;

        public NodoDoble(T dato) {
            this.dato = dato;
            this.siguiente = null;
            this.anterior = null;
        }
    }
}