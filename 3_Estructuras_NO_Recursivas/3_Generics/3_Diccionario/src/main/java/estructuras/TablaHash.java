package estructuras;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TablaHash<K, V> implements TablaHashInterfaz<K, V> {

    private static final int CAPACIDAD_INICIAL = 16;
    private static final double FACTOR_CARGA_MAX = 0.75;

    // No es final para permitir rehashing
    private List<LinkedList<Entrada<K, V>>> cubetas;
    private int size;

    public TablaHash() {
        cubetas = crearCubetas(CAPACIDAD_INICIAL);
        size = 0;
    }

    // -----------------------------------------------------------------------
    // Operaciones principales
    // -----------------------------------------------------------------------

    @Override
    public void insertar(K clave, V valor) {
        verificarClave(clave);

        // Rehash preventivo antes de insertar si se supera el factor de carga
        if ((double) (size + 1) / cubetas.size() > FACTOR_CARGA_MAX) {
            rehash();
        }

        int indice = obtenerIndice(clave);
        LinkedList<Entrada<K, V>> cubeta = cubetas.get(indice);

        if (cubeta == null) {
            cubeta = new LinkedList<>();
            cubetas.set(indice, cubeta);
        }

        // Si la clave ya existe, actualizar el valor (no incrementa size)
        for (Entrada<K, V> entrada : cubeta) {
            if (entrada.getClave().equals(clave)) {
                entrada.setValor(valor);
                return;
            }
        }

        cubeta.add(new Entrada<>(clave, valor));
        size++;
    }

    @Override
    public V obtener(K clave) {
        verificarClave(clave);

        int indice = obtenerIndice(clave);
        LinkedList<Entrada<K, V>> cubeta = cubetas.get(indice);

        if (cubeta != null) {
            for (Entrada<K, V> entrada : cubeta) {
                if (entrada.getClave().equals(clave)) {
                    return entrada.getValor();
                }
            }
        }
        return null;
    }

    @Override
    public void eliminar(K clave) {
        verificarClave(clave);

        int indice = obtenerIndice(clave);
        LinkedList<Entrada<K, V>> cubeta = cubetas.get(indice);

        if (cubeta != null) {
            // solo decrementa size si realmente se eliminó una entrada
            boolean eliminado = cubeta.removeIf(entrada -> entrada.getClave().equals(clave));
            if (eliminado) {
                size--;
            }
        }
    }

    @Override
    public void actualizar(K clave, V nuevoValor) {
        verificarClave(clave);

        int indice = obtenerIndice(clave);
        LinkedList<Entrada<K, V>> cubeta = cubetas.get(indice);

        if (cubeta != null) {
            for (Entrada<K, V> entrada : cubeta) {
                if (entrada.getClave().equals(clave)) {
                    //
                    entrada.setValor(nuevoValor);
                    return;
                }
            }
        }

        throw new IllegalArgumentException("La clave '" + clave + "' no existe en la tabla.");
    }

    @Override
    public boolean contiene(K clave) {
        verificarClave(clave);
        return obtener(clave) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean estaVacia() {
        return size == 0;
    }

    /**
     * Calcula el índice de cubeta para una clave.
     */
    private int obtenerIndice(K clave) {
        return (clave.hashCode() & 0x7FFFFFFF) % cubetas.size();
    }

    /**
     * Duplica la capacidad de la tabla y redistribuye todas las entradas.
     * Se invoca automáticamente cuando el factor de carga supera FACTOR_CARGA_MAX.
     */
    private void rehash() {
        int nuevaCapacidad = cubetas.size() * 2;
        List<LinkedList<Entrada<K, V>>> nuevasCubetas = crearCubetas(nuevaCapacidad);

        for (LinkedList<Entrada<K, V>> cubeta : cubetas) {
            if (cubeta != null) {
                for (Entrada<K, V> entrada : cubeta) {
                    int nuevoIndice = (entrada.getClave().hashCode() & 0x7FFFFFFF) % nuevaCapacidad;
                    if (nuevasCubetas.get(nuevoIndice) == null) {
                        nuevasCubetas.set(nuevoIndice, new LinkedList<>());
                    }
                    nuevasCubetas.get(nuevoIndice).add(entrada);
                }
            }
        }

        cubetas = nuevasCubetas;
    }

    /**
     * Crea una lista de cubetas inicializadas en null con la capacidad dada.
     */
    private List<LinkedList<Entrada<K, V>>> crearCubetas(int capacidad) {
        List<LinkedList<Entrada<K, V>>> lista = new ArrayList<>(capacidad);
        for (int i = 0; i < capacidad; i++) {
            lista.add(null);
        }
        return lista;
    }

    /**
     * Valida que la clave no sea null para evitar NullPointerException en hashCode().
     */
    private void verificarClave(K clave) {
        if (clave == null) {
            throw new IllegalArgumentException("La clave no puede ser null.");
        }
    }

    // -----------------------------------------------------------------------
    // Clase interna: Entrada
    // -----------------------------------------------------------------------

    /**
     * Representa un par clave-valor almacenado en una cubeta.
     * La clave es inmutable; el valor puede actualizarse.
     */
    private static class Entrada<K, V> {

        private final K clave;  // inmutable: nunca cambia después de la inserción
        private V valor;

        Entrada(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }

        K getClave() {
            return clave;
        }

        V getValor() {
            return valor;
        }

        void setValor(V nuevoValor) {
            this.valor = nuevoValor;
        }
    }

}