package binario;

import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol;
        arbol = new ArbolBinario<>(Comparator.<Integer>naturalOrder());

        // Insertar algunos valores
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        RecorridoArbol recorridosInt = new RecorridoArbol();

        System.out.print("Recorrido Inorden (Integer): ");
        RecorridoArbol.inorden(arbol.getRaiz());
        System.out.println();

        System.out.print("Recorrido Preorden (Integer): ");
        RecorridoArbol.preorden(arbol.getRaiz());
        System.out.println();

        System.out.print("Recorrido Postorden (Integer): ");
        RecorridoArbol.postorden(arbol.getRaiz());
        System.out.println();

        System.out.print("Recorrido por Niveles (Integer): ");
        RecorridoArbol.recorridoPorNiveles(arbol.getRaiz());
        System.out.println();

        System.out.println("Buscar 40 (Integer): " + arbol.buscar(40));
        System.out.println("Buscar 90 (Integer): " + arbol.buscar(90));

        arbol.eliminar(30);
        System.out.println("Árbol después de borrar 30 (Inorden - Integer):");
        RecorridoArbol.inorden(arbol.getRaiz());

        System.out.println("\n-----------------------\n");

        ArbolBinario<String> arbolString = new ArbolBinario<>(Comparator.<String>naturalOrder());
        arbolString.insertar("Manzana");
        arbolString.insertar("Banana");
        arbolString.insertar("Cereza");
        arbolString.insertar("Dátil");

        RecorridoArbol recorridosString = new RecorridoArbol();

        System.out.print("Recorrido Inorden (String): ");
        RecorridoArbol.inorden(arbolString.getRaiz());
        System.out.println();

        System.out.println("Buscar Banana (String): " + arbolString.buscar("Banana"));
        System.out.println("Buscar Uva (String): " + arbolString.buscar("Uva"));

        arbolString.eliminar("Manzana");
        System.out.println("Árbol después de borrar manzana (Inorden - Integer):");
        RecorridoArbol.inorden(arbolString.getRaiz());
    }
}