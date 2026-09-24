package ListaDoble.Generica;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Lista genérica doblemente enlazada. Mantiene referencias a head y tail para que
 * insertAtStart, insertAtEnd, getHeadData y getTailData sean O(1).
 */
public class ListaG<T> {
    private NodeG<T> head;
    private NodeG<T> tail;
    private int size;

    public void insertAtStart(T data) {
        NodeG<T> nuevo = new NodeG<>(data);
        if (head == null) {
            head = tail = nuevo;
        } else {
            nuevo.next = head;
            head.prev = nuevo;
            head = nuevo;
        }
        size++;
    }

    public void insertAtEnd(T data) {
        NodeG<T> nuevo = new NodeG<>(data);
        if (tail == null) {
            head = tail = nuevo;
        } else {
            nuevo.prev = tail;
            tail.next = nuevo;
            tail = nuevo;
        }
        size++;
    }

    /** Elimina la primera ocurrencia de {@code data}. Si no existe, no hace nada. */
    public void remove(T data) {
        NodeG<T> actual = head;
        while (actual != null) {
            if (Objects.equals(actual.data, data)) {
                if (actual.prev != null) {
                    actual.prev.next = actual.next;
                } else {
                    head = actual.next; // era el head
                }
                if (actual.next != null) {
                    actual.next.prev = actual.prev;
                } else {
                    tail = actual.prev; // era el tail
                }
                size--;
                return; // solo la primera ocurrencia
            }
            actual = actual.next;
        }
    }

    public T getHeadData() {
        if (head == null) throw new NoSuchElementException("La lista está vacía");
        return head.data;
    }

    public T getTailData() {
        if (tail == null) throw new NoSuchElementException("La lista está vacía");
        return tail.data;
    }

    public boolean contains(T data) {
        NodeG<T> actual = head;
        while (actual != null) {
            if (Objects.equals(actual.data, data)) return true;
            actual = actual.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** Recorrido hacia adelante (de head a tail). */
    public List<T> recorrerAdelante() {
        List<T> resultado = new ArrayList<>(size);
        for (NodeG<T> actual = head; actual != null; actual = actual.next) {
            resultado.add(actual.data);
        }
        return resultado;
    }

    /** Recorrido hacia atrás (de tail a head). */
    public List<T> recorrerAtras() {
        List<T> resultado = new ArrayList<>(size);
        for (NodeG<T> actual = tail; actual != null; actual = actual.prev) {
            resultado.add(actual.data);
        }
        return resultado;
    }
}
