package listas.circular;

public class ListaCircular<T> {
    private NodoCircular<T> cabeza;
    private NodoCircular<T> cola;

    public ListaCircular() {
        this.cabeza = null;
        this.cola = null;
    }

    public void insertar(T dato) {
        NodoCircular<T> nuevo = new NodoCircular<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            nuevo.siguiente = cabeza;
            cola = nuevo;
        }
    }

    public void imprimir(int n) { // Se imprimen los primeros n elementos para evitar bucles infinitos
        if (cabeza == null) return;

        NodoCircular<T> actual = cabeza;
        for (int i = 0; i < n; i++) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("...");
    }
}
