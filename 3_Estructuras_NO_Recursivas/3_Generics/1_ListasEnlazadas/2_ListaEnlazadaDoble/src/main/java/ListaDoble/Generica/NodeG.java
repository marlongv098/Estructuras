package ListaDoble.Generica;

public class NodeG<T> {
        T data;
        NodeG<T> next;
        NodeG<T> prev;

        NodeG(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
}

