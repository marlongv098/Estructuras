package cola;

public interface ColaInterfaz<T> {
    void encolar(T elemento);
    T desencolar();
    T frente();
    boolean estaVacia();
    int size();
}
