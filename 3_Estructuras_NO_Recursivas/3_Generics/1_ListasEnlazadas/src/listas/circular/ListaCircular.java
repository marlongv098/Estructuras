package listas.circular;

public class ListaCircular<T> {

    private NodoCircular<T> cabeza;
    private NodoCircular<T> cola;
    private int tamano;

    public ListaCircular() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }

    public void insertar(T dato) {
        NodoCircular<T> nuevo = new NodoCircular<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        } else {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            cola.siguiente = cabeza;
        }
        tamano++;
    }

    public void insertarAlFinal(T dato) {
        if (cabeza == null) {
            insertar(dato);
            return;
        }
        NodoCircular<T> nuevo = new NodoCircular<>(dato);
        nuevo.siguiente = cabeza;
        cola.siguiente = nuevo;
        cola = nuevo;
        tamano++;
    }

    public void imprimir() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }

        NodoCircular<T> actual = cabeza;
        do {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("(cabeza)");
    }

    public void eliminar(T dato) {
        if (cabeza == null) return;

        if (cabeza.dato.equals(dato)) {
            if (cabeza == cola) { // only one node
                cabeza = null;
                cola = null;
            } else {
                cabeza = cabeza.siguiente;
                cola.siguiente = cabeza;
            }
            tamano--;
            return;
        }

        NodoCircular<T> actual = cabeza;
        while (actual.siguiente != cabeza && !actual.siguiente.dato.equals(dato)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != cabeza) {
            if (actual.siguiente == cola) {
                cola = actual;
            }
            actual.siguiente = actual.siguiente.siguiente;
            tamano--;
        }
    }

    public int getTamano() {
        return tamano;
    }

    public boolean estaVacia() {
        return tamano == 0;
    }

    private static class NodoCircular<T> {
        T dato;
        NodoCircular<T> siguiente;

        public NodoCircular(T dato) {
            this.dato = dato;
            this.siguiente = this;
        }
    }
}