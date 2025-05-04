package binario;
import java.util.Comparator;

public class ArbolBinario<T> {
    private Nodo<T> raiz;
    private Comparator<T> comparador;

    public ArbolBinario(Comparator<T> comparador) {
        this.comparador = comparador;
        this.raiz = null;
    }



    // Método para insertar un valor en el árbol
    public void insertar(T valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo<T> insertarRecursivo(Nodo<T> actual, T valor) {
        if (actual == null) {
            return new Nodo<>(valor);
        }

        int comparacion = comparador.compare(valor, actual.valor);
        if (comparacion < 0) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, valor);
        } else if (comparacion  > 0) {
            actual.derecho = insertarRecursivo(actual.derecho, valor);
        }
        // Si el valor ya existe, no lo insertamos nuevamente
        return actual;
    }

    // Búsqueda de un elemento
    public boolean buscar(T valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(Nodo<T> actual, T valor) {
        if (actual == null) {
            return false;
        }
        int comparacion = comparador.compare(valor, actual.valor);
        if (comparacion == 0) {
            return true;
        }else if (comparacion < 0) {
            return buscarRecursivo(actual.izquierdo, valor);
        }else{
            return buscarRecursivo(actual.derecho, valor);
        }
    }

    public void eliminar(T valor) {
        raiz=eliminarRecursivo(raiz, valor);
    }

    public Nodo<T> eliminarRecursivo(Nodo<T> actual, T valor) {

        if(actual==null) {
            return null;
        }
        int comparacion = comparador.compare(valor, actual.valor);
        if (comparacion < 0) {
            actual.izquierdo = eliminarRecursivo(actual.izquierdo, valor);
        }else if (comparacion > 0) {
            actual.derecho = eliminarRecursivo(actual.derecho, valor);
        }else{
            if (actual.izquierdo == null) {
                return actual.derecho;
            }else if (actual.derecho == null){
                return actual.izquierdo;
            }
            actual.valor = encontrarMinimo(actual.derecho);
            actual.derecho = eliminarRecursivo(actual.derecho, actual.valor);
        }
        return actual;
    }

    private T encontrarMinimo(Nodo<T> actual) {
        T minimo = actual.valor;
        while (actual.izquierdo != null) {
            minimo = actual.izquierdo.valor;
            actual = actual.derecho;
        }
        return minimo;
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }

    public Comparator<T> getComparador() {
        return comparador;
    }

    public void setComparador(Comparator<T> comparador) {
        this.comparador = comparador;
    }
}
