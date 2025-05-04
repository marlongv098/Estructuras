package binario;

public class Nodo<T>{
    public T valor;
    public Nodo<T> izquierdo;
    public Nodo<T> derecho;

    public Nodo(T valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}