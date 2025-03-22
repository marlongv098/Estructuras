package editor;

//import pila.Pila;
//import pila.Interfaz;

import pilalistaenlazada.Pila;
import pilalistaenlazada.Interfaz;



public class EditorTexto implements EditorTextoInterfaz {

    private StringBuilder texto;
    private final Interfaz<String> pilaDeshacer;
    private final Interfaz<String> pilaRehacer;

    public EditorTexto() {
        this.texto = new StringBuilder();
        this.pilaDeshacer = new Pila<>();
        this.pilaRehacer = new Pila<>();
    }

    @Override
    public void escribir(String textoNuevo) {
        this.pilaDeshacer.apilar(this.texto.toString());
        this.texto.append(textoNuevo);
        this.pilaRehacer.clear(); // Limpiamos la pila de rehacer al escribir nuevo texto
    }

    @Override
    public void deshacer() {
        if (!this.pilaDeshacer.estaVacia()) {
            this.pilaRehacer.apilar(this.texto.toString());
            this.texto = new StringBuilder(this.pilaDeshacer.desapilar());
        }
    }

    @Override
    public void rehacer() {
        if (!this.pilaRehacer.estaVacia()) {
            this.pilaDeshacer.apilar(this.texto.toString());
            this.texto = new StringBuilder(this.pilaRehacer.desapilar());
        }
    }

    @Override
    public String obtenerTextoActual() {
        return this.texto.toString();
    }

    @Override
    public String obtenerTopeDeshacer() {
        if (!pilaDeshacer.estaVacia()) {
            return pilaDeshacer.tope();
        } else {
            return null;
        }
    }

    @Override
    public String obtenerTopeRehacer() {
        if (!pilaRehacer.estaVacia()) {
            return pilaRehacer.tope();
        } else {
            return null;
        }
    }
}