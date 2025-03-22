package pila;

import java.util.ArrayList;
import java.util.List;

public class Pila<T> implements Interfaz<T> {

    private final List<T> elementos;

    public Pila() {
        this.elementos = new ArrayList<>();
    }

    @Override
    public void apilar(T elemento) {
        this.elementos.add(elemento);
    }

    @Override
    public T desapilar() {
        if (estaVacia()) {
            return null;
        }
        return this.elementos.remove(this.elementos.size() - 1);
    }

    @Override
    public T tope() {
        if (estaVacia()) {
            return null;
        }
        return this.elementos.get(this.elementos.size() - 1);
    }

    @Override
    public boolean estaVacia() {
        return this.elementos.isEmpty();
    }

    @Override
    public int size() {
        return this.elementos.size();
    }

    public void clear() {
        this.elementos.clear();
    }

}