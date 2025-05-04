package binario;

class Recorrido {
    // Recorrido en preorden (raíz, izquierdo, derecho)
    public static <T extends Comparable<T>> void preorden(NodoAVL<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            preorden(nodo.getIzquierdo());
            preorden(nodo.getDerecho());
        }
    }

    // Recorrido en inorden (izquierdo, raíz, derecho)
    public static <T extends Comparable<T>> void inorden(NodoAVL<T> nodo) {
        if (nodo != null) {
            inorden(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + " ");
            inorden(nodo.getDerecho());
        }
    }

    // Recorrido en postorden (izquierdo, derecho, raíz)
    public static <T extends Comparable<T>> void postorden(NodoAVL<T> nodo) {
        if (nodo != null) {
            postorden(nodo.getIzquierdo());
            postorden(nodo.getDerecho());
            System.out.print(nodo.getDato() + " ");
        }
    }
}