package binario;

public class Main {
    public static void main(String[] args) {
        // Crear un árbol AVL de enteros
        ArbolAVL<Integer> arbolEnteros = new ArbolAVL<>();

        // Insertar valores
        arbolEnteros.insertar(10);
        arbolEnteros.insertar(20);
        arbolEnteros.insertar(30);
        arbolEnteros.insertar(40);
        arbolEnteros.insertar(50);
        arbolEnteros.insertar(25);

        // Recorrer el árbol
        System.out.println("Recorrido Preorden:");
        Recorrido.preorden(arbolEnteros.getRaiz());
        System.out.println("\nRecorrido Inorden:");
        Recorrido.inorden(arbolEnteros.getRaiz());
        System.out.println("\nRecorrido Postorden:");
        Recorrido.postorden(arbolEnteros.getRaiz());

        // Crear un árbol AVL de strings
        ArbolAVL<String> arbolStrings = new ArbolAVL<>();

        arbolStrings.insertar("manzana");
        arbolStrings.insertar("banana");
        arbolStrings.insertar("cereza");
        arbolStrings.insertar("durazno");

        System.out.println("\n\nÁrbol de Strings - Inorden:");
        Recorrido.inorden(arbolStrings.getRaiz());
    }
}