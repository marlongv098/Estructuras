package main;
import listas.simple.ListaSimple;
import listas.doble.ListaDoble;
import listas.circular.ListaCircular;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lista Simple:");
        ListaSimple<Integer> listaSimple = new ListaSimple<>();
        System.out.println("Esta vacia? " + listaSimple.estaVacia());
        listaSimple.insertar(10);
        listaSimple.insertar(20);
        listaSimple.insertar(30);
        listaSimple.insertarAlFinal(40);
        listaSimple.imprimir();
        System.out.println("Tamano: " + listaSimple.getTamano());
        listaSimple.invertir();
        listaSimple.imprimir();
        System.out.println("Esta vacia? " + listaSimple.estaVacia());

        System.out.println("\nLista Doblemente Enlazada:");
        ListaDoble<String> listaDoble = new ListaDoble<>();
        System.out.println("Esta vacia? " + listaDoble.estaVacia());
        listaDoble.insertar("A");
        listaDoble.insertar("B");
        listaDoble.insertar("C");
        listaDoble.insertarAlFinal("D");
        listaDoble.imprimir();
        System.out.println("Tamano: " + listaDoble.getTamano());
        listaDoble.insertarDespuesDe("B","E");
        listaDoble.imprimir();
        System.out.println("Tamano: " + listaDoble.getTamano());
        System.out.println("Esta vacia? " + listaDoble.estaVacia());

        System.out.println("\nLista Circular:");
        ListaCircular<Double> listaCircular = new ListaCircular<>();
        System.out.println("Esta vacia? " + listaCircular.estaVacia());
        listaCircular.insertar(1.1);
        listaCircular.insertar(2.2);
        listaCircular.insertar(3.3);
        listaCircular.insertarAlFinal(4.4);
        listaCircular.imprimir();
        System.out.println("Tamano: " + listaCircular.getTamano());
        listaCircular.eliminar(3.3);
        listaCircular.imprimir();
        System.out.println("Tamano: " + listaCircular.getTamano());
        System.out.println("Esta vacia? " + listaCircular.estaVacia());
    }
}
