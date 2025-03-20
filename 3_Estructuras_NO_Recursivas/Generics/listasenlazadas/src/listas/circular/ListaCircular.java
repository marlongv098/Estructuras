package listas.circular;

public class ListaCircular<T> {
    private NodoCircular<T> cabeza;

    public ListaCircular() {
        this.cabeza = null;
    }

    public void insertar(T dato) {
        NodoCircular<T> nuevo = new NodoCircular<>(dato);
        // Se apunta a sí mismo
        if (cabeza != null) {
            NodoCircular<T> temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        } else {
            cabeza = nuevo;
        }
        nuevo.siguiente = cabeza;
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
        System.out.println(" (cabeza)");
    }

    public void eliminar(T dato) {
        if (cabeza == null) return;

        NodoCircular<T> actual = cabeza;
        NodoCircular<T> preview;

        if (actual.dato.equals(dato)) {
            if (actual.siguiente == cabeza) {
                cabeza = null; // Un solo nodo
            } else {
                NodoCircular<T> temp = cabeza;
                while (temp.siguiente != cabeza) {
                    temp = temp.siguiente;
                }
                temp.siguiente = cabeza.siguiente;
                cabeza = cabeza.siguiente;
            }
            return;
        }

        preview = actual;
        actual = actual.siguiente;

        while (actual != cabeza) {
            if (actual.dato.equals(dato)) {
                preview.siguiente = actual.siguiente;
                return;
            }
            preview = actual;
            actual = actual.siguiente;
        }
    }
}

