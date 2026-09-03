package colaprioridad;

import tareas.TareaInterfaz;
import java.util.ArrayList;
import java.util.List;

public class HeapMinimo<T extends TareaInterfaz<E>, E> {
    private final List<T> heap;

    public HeapMinimo() {
        heap = new ArrayList<>();
    }

    public void agregar(T tarea) {
        heap.add(tarea);
        subir(heap.size() - 1);
    }

    public T extraerMinimo() {
        if (heap.isEmpty()) {
            return null;
        }

        T minimo = heap.getFirst();
        int ultimoIndice = heap.size() - 1;
        heap.set(0, heap.get(ultimoIndice));
        heap.remove(ultimoIndice);
        bajar(0);
        return minimo;
    }

    public boolean estaVacio() {
        return heap.isEmpty();
    }

    private void subir(int indice) {
        int padre = (indice - 1) / 2;
        while (indice > 0 && heap.get(indice).obtenerPrioridad() < heap.get(padre).obtenerPrioridad()) {
            intercambiar(indice, padre);
            indice = padre;
            padre = (indice - 1) / 2;
        }
    }

    private void bajar(int indice) {
        int hijoIzquierdo, hijoDerecho, minimo;
        while (true) {
            hijoIzquierdo = 2 * indice + 1;
            hijoDerecho = 2 * indice + 2;
            minimo = indice;

            if (hijoIzquierdo < heap.size() && heap.get(hijoIzquierdo).obtenerPrioridad() < heap.get(minimo).obtenerPrioridad()) {
                minimo = hijoIzquierdo;
            }
            if (hijoDerecho < heap.size() && heap.get(hijoDerecho).obtenerPrioridad() < heap.get(minimo).obtenerPrioridad()) {
                minimo = hijoDerecho;
            }
            if (minimo == indice) {
                break;
            }
            intercambiar(indice, minimo);
            indice = minimo;
        }
    }

    private void intercambiar(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}