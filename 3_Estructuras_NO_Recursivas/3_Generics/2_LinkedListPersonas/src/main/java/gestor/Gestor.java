package gestor;

import estructuras.ListaEnlazada;

    public class Gestor<T> {
    private final ListaEnlazada<T> lista;

    public Gestor() {
        this.lista = new ListaEnlazada<>();
    }

    // Agrega un elemento al final
    public void agregar(T elemento) {
        lista.agregar(elemento);
    }

    // Retorna el elemento en la posición dada — el compilador ya sabe que es T
    public T obtener(int indice) {
        return lista.obtener(indice);
    }

    // Busca por contenido usando equals() del tipo T
    // Retorna el índice si lo encuentra, -1 si no existe
    public int buscar(T elemento) {
        return lista.buscar(elemento);
    }

    // Elimina y RETORNA el elemento en la posición dada
    public T eliminar(int indice) {
        return lista.eliminar(indice);
    }

    public int size() {
        return lista.size();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}

