package binario;

class NodoAVL<T extends Comparable<T>> {
    T dato;
    NodoAVL<T> izquierdo;
    NodoAVL<T> derecho;
    int altura;

    public NodoAVL(T dato) {
        this.dato = dato;
        this.altura = 1; // Nuevo nodo inicialmente se añade como hoja
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoAVL<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoAVL<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoAVL<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoAVL<T> derecho) {
        this.derecho = derecho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
