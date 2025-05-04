package binario;
import java.util.LinkedList;
import java.util.Queue;

public class RecorridoArbol {
    public static <T> void inorden(Nodo<T> nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecho);
        }
    }

    public static <T> void preorden(Nodo<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorden(nodo.izquierdo);
            preorden(nodo.derecho);
        }
    }

    public static <T> void postorden(Nodo<T> nodo) {
        if (nodo != null) {
            postorden(nodo.izquierdo);
            postorden(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    public static <T> void recorridoPorNiveles(Nodo<T> raiz) {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }
        Queue<Nodo<T>> cola = new LinkedList<>();
        cola.offer(raiz);
        while (!cola.isEmpty()) {
            Nodo<T> nodoActual = cola.poll();
            System.out.print(nodoActual.valor + " ");
            if (nodoActual.izquierdo != null) {
                cola.offer(nodoActual.izquierdo);
            }
            if (nodoActual.derecho != null) {
                cola.offer(nodoActual.derecho);
            }
        }
        System.out.println();
    }
}
