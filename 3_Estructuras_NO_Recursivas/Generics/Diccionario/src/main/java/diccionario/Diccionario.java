package diccionario;

import tablahash.TablaHash;
import tablahash.TablaHashInterfaz;


public class Diccionario implements DiccionarioInterfaz {

    private final TablaHashInterfaz<String, String> tablaHash;

    public Diccionario() {
        this.tablaHash = new TablaHash<>();
    }

    @Override
    public void agregarPalabra(String palabra, String definicion) {
        tablaHash.insertar(palabra, definicion);
    }

    @Override
    public String obtenerDefinicion(String palabra) {
        return tablaHash.obtener(palabra);
    }

    @Override
    public void eliminarPalabra(String palabra) {
        tablaHash.eliminar(palabra);
    }

    @Override
    public int size() {
        return tablaHash.size();
    }

    @Override
    public boolean estaVacio() {
        return tablaHash.estaVacia();
    }
}