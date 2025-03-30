package main;
import listas.simple.ListaSimple;
import listas.doble.ListaDoble;
import listas.circular.ListaCircular;
public class Main {
    public static void main(String[] args) {
        System.out.println("Lista Simple:");
        ListaSimple<Integer> listaSimple = new ListaSimple<>();
        listaSimple.insertar(10);
        listaSimple.insertar(20);
        listaSimple.insertar(30);
        listaSimple.imprimir();
        listaSimple.invertir();
        listaSimple.imprimir();

        System.out.println("\nLista Doblemente Enlazada:");
        ListaDoble<String> listaDoble = new ListaDoble<>();
        listaDoble.insertar("A");
        listaDoble.insertar("B");
        listaDoble.insertar("C");
        listaDoble.imprimir();
        listaDoble.insertarDespuesDe("B","E");
        listaDoble.imprimir();

        System.out.println("\nLista Circular:");
        ListaCircular<Double> listaCircular = new ListaCircular<>();
        listaCircular.insertar(1.1);
        listaCircular.insertar(2.2);
        listaCircular.insertar(3.3);
        listaCircular.imprimir();
        listaCircular.eliminar(3.3);
        listaCircular.imprimir();

    }
}