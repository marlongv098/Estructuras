package listas.simple;

public class ListaSimple<T> {

    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamano;

    public ListaSimple() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }

    public void insertar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        if (cola == null) {
            cola = cabeza;
        }
        tamano++;
    }

    public void insertarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }
        tamano++;
    }

    public void imprimir() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public void invertir() {
        Nodo<T> previo = null;
        Nodo<T> actual = cabeza;
        Nodo<T> siguiente;
        cola = cabeza;

        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = previo;
            previo = actual;
            actual = siguiente;
        }
        cabeza = previo;
    }

    public int getTamano() {
        return tamano;
    }

    public boolean estaVacia() {
        return tamano == 0;
    }

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
}