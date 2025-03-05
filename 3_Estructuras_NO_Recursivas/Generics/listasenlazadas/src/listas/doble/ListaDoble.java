package listas.doble;

public class ListaDoble<T> {
    private NodoDoble<T> cabeza;

    public ListaDoble() {
        this.cabeza = null;
    }

    public void insertar(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (cabeza != null) {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
        }
        cabeza = nuevo;
    }

    public void imprimir() {
        NodoDoble<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}
