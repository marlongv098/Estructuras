package ui;

import diccionario.Diccionario;
import diccionario.DiccionarioInterfaz;

public class Main {
    public static void main(String[] args) {
        DiccionarioInterfaz diccionario = new Diccionario();

        diccionario.agregarPalabra("java", "Lenguaje de programación orientado a objetos.");
        diccionario.agregarPalabra("python", "Lenguaje de programación de alto nivel.");
        diccionario.agregarPalabra("computadora", "Máquina electrónica capaz de procesar datos.");

        System.out.println("Definición de java: " + diccionario.obtenerDefinicion("java"));
        System.out.println("Tamaño del diccionario: " + diccionario.size());

        diccionario.eliminarPalabra("python");
        System.out.println("Tamaño del diccionario después de eliminar python: " + diccionario.size());
    }
}