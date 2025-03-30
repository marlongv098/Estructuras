package ui;

import persona.Persona;
import estructuras.ListaEnlazada;

public class Main {
    public static void main(String[] args) {
        ListaEnlazada<Persona> listaPersonas = new ListaEnlazada<>();

        Persona persona1 = new Persona("Juan", 30);
        Persona persona2 = new Persona("María", 25);
        Persona persona3 = new Persona("Pedro", 35);

        listaPersonas.agregar(persona1);
        listaPersonas.agregar(persona2);
        listaPersonas.agregar(persona3);

        System.out.println("Lista de personas:");
        for (int i = 0; i < listaPersonas.size(); i++) {
            System.out.println(listaPersonas.obtener(i));
        }

        System.out.println("Tamaño de la lista: " + listaPersonas.size());
        System.out.println("¿La lista está vacía? " + listaPersonas.estaVacia());

        listaPersonas.eliminar(1);

        System.out.println("Lista de personas después de eliminar el elemento en el índice 1:");
        for (int i = 0; i < listaPersonas.size(); i++) {
            System.out.println(listaPersonas.obtener(i));
        }
    }
}