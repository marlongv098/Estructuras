package listasimple.Generica;

public class NodeG<T> {
    public T data;
    public NodeG<T> next;

    public NodeG(T data) {
        this.data = data;
        this.next = null;
    }
}
