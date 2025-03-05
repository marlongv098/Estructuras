package listas.simple;

public class ListaSimple<T> {
    private Nodo<T> cabeza;

    public ListaSimple() {
        this.cabeza = null;
    }

    public void insertar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    public void imprimir() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}
