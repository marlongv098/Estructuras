package estructuras;

public class ListaEnlazada<T> {
    private Nodo<T> cabeza;
    private int size;

    public ListaEnlazada() {
        this.cabeza = null;
        this.size = 0;
    }

    // Agrega al final de la lista
    public void agregar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        size++;
    }

    // Retorna el dato en la posición indicada — el compilador ya sabe que es T
    public T obtener(int indice) {
        validarIndice(indice);
        Nodo<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    // Elimina y RETORNA el elemento eliminado — aprovecha el poder de T
    public T eliminar(int indice) {
        validarIndice(indice);
        T datoEliminado;
        if (indice == 0) {
            datoEliminado = cabeza.getDato();
            cabeza = cabeza.getSiguiente();
        } else {
            Nodo<T> actual = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                actual = actual.getSiguiente();
            }
            datoEliminado = actual.getSiguiente().getDato();
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
        }
        size--;
        return datoEliminado;
    }

    // Busca por contenido — usa equals() del tipo T
    public int buscar(T dato) {
        Nodo<T> actual = cabeza;
        int indice = 0;
        while (actual != null) {
            if (actual.getDato().equals(dato)) return indice;
            actual = actual.getSiguiente();
            indice++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean estaVacia() {
        return size == 0;
    }

    // Centraliza la validación — evita duplicar el if en cada método
    private void validarIndice(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException(
                    "Índice " + indice + " fuera de rango. Tamaño actual: " + size
            );
        }
    }

    // Permite visualizar la lista fácilmente en consola
    @Override
    public String toString() {
        if (estaVacia()) return "[ lista vacía ]";
        StringBuilder sb = new StringBuilder("[");
        Nodo<T> actual = cabeza;
        while (actual != null) {
            sb.append(actual.getDato());
            if (actual.getSiguiente() != null) sb.append(" -> ");
            actual = actual.getSiguiente();
        }
        return sb.append("]").toString();
    }
}
