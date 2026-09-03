package ui;

import modelo.Diccionario;

public class Main {
    public static void main(String[] args) {
        Diccionario diccionario = new Diccionario();

        diccionario.agregarPalabra("algoritmo", "Secuencia finita de pasos para resolver un problema.");
        diccionario.agregarPalabra("recursión", "Técnica en la que una función se llama a sí misma.");
        diccionario.agregarPalabra("hash", "Función que transforma una clave en un índice de tabla.");

        System.out.println("¿Existe 'hash'? " + diccionario.contienePalabra("hash"));
        System.out.println("Definición de 'algoritmo': " + diccionario.obtenerDefinicion("algoritmo"));

        diccionario.actualizarDefinicion("hash", "Función que mapea datos de tamaño variable a un valor de tamaño fijo.");
        System.out.println("Definición actualizada de 'hash': " + diccionario.obtenerDefinicion("hash"));

        diccionario.eliminarPalabra("recursión");
        System.out.println("¿Existe 'recursión' tras eliminarla? " + diccionario.contienePalabra("recursión"));

        System.out.println("Total de palabras: " + diccionario.size());
    }
}
