import java.util.LinkedList;
import java.util.Queue;
import java.util.Comparator;

class NodoGenerico<T> {
    T valor;
    NodoGenerico<T> izquierda;
    NodoGenerico<T> derecha;

    public NodoGenerico(T valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }
}

class ArbolBinarioGenerico<T> {
    NodoGenerico<T> raiz;
    private Comparator<T> comparador;
    private Comparator<T> integerComparator;

    public ArbolBinarioGenerico(Comparator<T> comparador) {
        this.raiz = null;
        this.comparador = comparador;
    }

    public ArbolBinarioGenerico(Comparator<T> integerComparator) {
        this.integerComparator = integerComparator;
    }

    public void insertar(T valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private NodoGenerico<T> insertarRecursivo(NodoGenerico<T> nodo, T valor) {
        if (nodo == null) {
            return new NodoGenerico<>(valor);
        }

        int comparacion = comparador.compare(valor, nodo.valor);
        if (comparacion < 0) {
            nodo.izquierda = insertarRecursivo(nodo.izquierda, valor);
        } else if (comparacion > 0) {
            nodo.derecha = insertarRecursivo(nodo.derecha, valor);
        }
        return nodo;
    }

    public boolean buscar(T valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(NodoGenerico<T> nodo, T valor) {
        if (nodo == null) {
            return false;
        }
        int comparacion = comparador.compare(valor, nodo.valor);
        if (comparacion == 0) {
            return true;
        } else if (comparacion < 0) {
            return buscarRecursivo(nodo.izquierda, valor);
        } else {
            return buscarRecursivo(nodo.derecha, valor);
        }
    }

    public void borrar(T valor) {
        raiz = borrarRecursivo(raiz, valor);
    }

    private NodoGenerico<T> borrarRecursivo(NodoGenerico<T> nodo, T valor) {
        if (nodo == null) {
            return null;
        }

        int comparacion = comparador.compare(valor, nodo.valor);
        if (comparacion < 0) {
            nodo.izquierda = borrarRecursivo(nodo.izquierda, valor);
        } else if (comparacion > 0) {
            nodo.derecha = borrarRecursivo(nodo.derecha, valor);
        } else {
            if (nodo.izquierda == null) {
                return nodo.derecha;
            } else if (nodo.derecha == null) {
                return nodo.izquierda;
            }
            nodo.valor = encontrarMinimo(nodo.derecha);
            nodo.derecha = borrarRecursivo(nodo.derecha, nodo.valor);
        }
        return nodo;
    }

    private T encontrarMinimo(NodoGenerico<T> nodo) {
        T minimo = nodo.valor;
        while (nodo.izquierda != null) {
            minimo = nodo.izquierda.valor;
            nodo = nodo.izquierda;
        }
        return minimo;
    }

    public NodoGenerico<T> getRaiz() {
        return raiz;
    }
}

class ArbolBinarioUtilGenerico {
    public static <T> void inorden(NodoGenerico<T> nodo) {
        if (nodo != null) {
            inorden(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecha);
        }
    }

    public static <T> void preorden(NodoGenerico<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorden(nodo.izquierda);
            preorden(nodo.derecha);
        }
    }

    public static <T> void postorden(NodoGenerico<T> nodo) {
        if (nodo != null) {
            postorden(nodo.izquierda);
            postorden(nodo.derecha);
            System.out.print(nodo.valor + " ");
        }
    }

    public static <T> void recorridoPorNiveles(NodoGenerico<T> raiz) {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }
        Queue<NodoGenerico<T>> cola = new LinkedList<>();
        cola.offer(raiz);
        while (!cola.isEmpty()) {
            NodoGenerico<T> nodoActual = cola.poll();
            System.out.print(nodoActual.valor + " ");
            if (nodoActual.izquierda != null) {
                cola.offer(nodoActual.izquierda);
            }
            if (nodoActual.derecha != null) {
                cola.offer(nodoActual.derecha);
            }
        }
        System.out.println();
    }
}

