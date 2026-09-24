package binario;

class ArbolAVL<T extends Comparable<T>> {
    private NodoAVL<T> raiz;

    public ArbolAVL() {
        raiz = null;
    }

    public NodoAVL<T> getRaiz() {
        return raiz;
    }

    // Obtener la altura de un nodo
    private int altura(NodoAVL<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.getAltura();
    }

    // Obtener el factor de balance de un nodo
    private int factorBalance(NodoAVL<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.getIzquierdo()) - altura(nodo.getDerecho());
    }

    // Rotación simple a la derecha
    private NodoAVL<T> rotacionDerecha(NodoAVL<T> y) {
        NodoAVL<T> x = y.getIzquierdo();
        NodoAVL<T> T2 = x.getDerecho();

        // Realizar rotación
        x.setDerecho(y);
        y.setIzquierdo(T2);

        // Actualizar alturas
        y.setAltura(Math.max(altura(y.getIzquierdo()), altura(y.getDerecho())) + 1);
        x.setAltura(Math.max(altura(x.getIzquierdo()), altura(x.getDerecho())) + 1);

        return x;
    }

    // Rotación simple a la izquierda
    private NodoAVL<T> rotacionIzquierda(NodoAVL<T> x) {
        NodoAVL<T> y = x.getDerecho();
        NodoAVL<T> T2 = y.getIzquierdo();

        // Realizar rotación
        y.setIzquierdo(x);
        x.setDerecho(T2);

        // Actualizar alturas
        x.setAltura(Math.max(altura(x.getIzquierdo()), altura(x.getDerecho())) + 1);
        y.setAltura(Math.max(altura(y.getIzquierdo()), altura(y.getDerecho())) + 1);

        return y;
    }

    // Insertar un nuevo dato en el árbol
    public void insertar(T dato) {
        raiz = insertar(raiz, dato);
    }

    private NodoAVL<T> insertar(NodoAVL<T> nodo, T dato) {
        // 1. Inserción normal en un BST
        if (nodo == null) {
            return new NodoAVL<>(dato);
        }

        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierdo(insertar(nodo.getIzquierdo(), dato));
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecho(insertar(nodo.getDerecho(), dato));
        } else {
            // No se permiten duplicados
            return nodo;
        }

        // 2. Actualizar altura del nodo actual
        nodo.setAltura(1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho())));

        // 3. Obtener el factor de balance para verificar si está desbalanceado
        int balance = factorBalance(nodo);

        // Si el nodo está desbalanceado, hay 4 casos posibles

        // Caso izquierda-izquierda
        if (balance > 1 && dato.compareTo(nodo.getIzquierdo().getDato()) < 0) {
            return rotacionDerecha(nodo);
        }

        // Caso derecha-derecha
        if (balance < -1 && dato.compareTo(nodo.getDerecho().getDato()) > 0) {
            return rotacionIzquierda(nodo);
        }

        // Caso izquierda-derecha
        if (balance > 1 && dato.compareTo(nodo.getIzquierdo().getDato()) > 0) {
            nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
            return rotacionDerecha(nodo);
        }

        // Caso derecha-izquierda
        if (balance < -1 && dato.compareTo(nodo.getDerecho().getDato()) < 0) {
            nodo.setDerecho(rotacionDerecha(nodo.getDerecho()));
            return rotacionIzquierda(nodo);
        }

        // Si no necesita balanceo, devolver el nodo sin cambios
        return nodo;
    }

    /**
     * Elimina un dato del árbol, re-balanceando en el camino de vuelta igual que insertar.
     * Si el dato no existe, el árbol queda sin cambios.
     */
    public void eliminar(T dato) {
        raiz = eliminar(raiz, dato);
    }

    private NodoAVL<T> eliminar(NodoAVL<T> nodo, T dato) {
        if (nodo == null) {
            return null; // el dato no existe, no hay nada que hacer
        }

        // 1. Eliminación normal de BST
        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierdo(eliminar(nodo.getIzquierdo(), dato));
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecho(eliminar(nodo.getDerecho(), dato));
        } else {
            // Este es el nodo a eliminar
            if (nodo.getIzquierdo() == null || nodo.getDerecho() == null) {
                NodoAVL<T> hijo = (nodo.getIzquierdo() != null) ? nodo.getIzquierdo() : nodo.getDerecho();
                nodo = hijo; // 0 o 1 hijo: se reemplaza directamente (puede quedar null)
            } else {
                // 2 hijos: reemplazar por el sucesor in-order (el mínimo del subárbol derecho)
                NodoAVL<T> sucesor = minimo(nodo.getDerecho());
                nodo.setDato(sucesor.getDato());
                nodo.setDerecho(eliminar(nodo.getDerecho(), sucesor.getDato()));
            }
        }

        if (nodo == null) {
            return null; // el nodo eliminado no tenía hijos
        }

        // 2. Actualizar altura
        nodo.setAltura(1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho())));

        // 3. Re-balancear igual que en insertar, usando el factor de balance de los hijos
        int balance = factorBalance(nodo);

        if (balance > 1 && factorBalance(nodo.getIzquierdo()) >= 0) {
            return rotacionDerecha(nodo);
        }
        if (balance > 1 && factorBalance(nodo.getIzquierdo()) < 0) {
            nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
            return rotacionDerecha(nodo);
        }
        if (balance < -1 && factorBalance(nodo.getDerecho()) <= 0) {
            return rotacionIzquierda(nodo);
        }
        if (balance < -1 && factorBalance(nodo.getDerecho()) > 0) {
            nodo.setDerecho(rotacionDerecha(nodo.getDerecho()));
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    private NodoAVL<T> minimo(NodoAVL<T> nodo) {
        NodoAVL<T> actual = nodo;
        while (actual.getIzquierdo() != null) {
            actual = actual.getIzquierdo();
        }
        return actual;
    }

    /** Búsqueda: O(log n) garantizado gracias al balanceo AVL (a diferencia de un BST simple). */
    public boolean buscar(T dato) {
        return buscar(raiz, dato);
    }

    private boolean buscar(NodoAVL<T> nodo, T dato) {
        if (nodo == null) {
            return false;
        }
        int cmp = dato.compareTo(nodo.getDato());
        if (cmp == 0) return true;
        return cmp < 0 ? buscar(nodo.getIzquierdo(), dato) : buscar(nodo.getDerecho(), dato);
    }
}
