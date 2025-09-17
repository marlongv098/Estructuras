package listasimple.Generica;

public class ListG<T> {
    private NodeG<T> head;

    public ListG() {
        this.head = null;
    }

    public void add(T data) {
        NodeG<T> newNode = new NodeG<>(data);
        if (head == null) {
            head = newNode;
        } else {
            NodeG<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void remove(T data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        NodeG<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        NodeG<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public NodeG<T> getHead() {
        return head;
    }
}