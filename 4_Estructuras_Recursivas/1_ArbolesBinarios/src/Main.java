import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class EjemploArbolGenericoDesacoplado {
    public static void main(String[] args) {
        // Ejemplo con Integers
        ArbolBinarioGenerico<Integer> arbolInt = new ArbolBinarioGenerico<>(Comparator.naturalOrder());
        arbolInt.insertar(50);
        arbolInt.insertar(30);
        arbolInt.insertar(70);
        arbolInt.insertar(20);
        arbolInt.insertar(40);
        arbolInt.insertar(60);
        arbolInt.insertar(80);

        System.out.print("Recorrido Inorden (Integer): ");
        ArbolBinarioUtilGenerico.inorden(arbolInt.getRaiz());
        System.out.println();

        System.out.print("Recorrido Preorden (Integer): ");
        ArbolBinarioUtilGenerico.preorden(arbolInt.getRaiz());
        System.out.println();

        System.out.print("Recorrido Postorden (Integer): ");
        ArbolBinarioUtilGenerico.postorden(arbolInt.getRaiz());
        System.out.println();

        System.out.print("Recorrido por Niveles (Integer): ");
        ArbolBinarioUtilGenerico.recorridoPorNiveles(arbolInt.getRaiz());
        System.out.println();

        System.out.println("Buscar 40 (Integer): " + arbolInt.buscar(40));
        System.out.println("Buscar 90 (Integer): " + arbolInt.buscar(90));

        arbolInt.borrar(30);
        System.out.println("Árbol después de borrar 30 (Inorden - Integer):");
        ArbolBinarioUtilGenerico.inorden(arbolInt.getRaiz());

        System.out.println();

        // Ejemplo con Strings
        ArbolBinarioGenerico<String> arbolString = new ArbolBinarioGenerico<>(Comparator.naturalOrder());
        arbolString.insertar("Manzana");
        arbolString.insertar("Banana");
        arbolString.insertar("Cereza");
        arbolString.insertar("Dátil");

        System.out.print("Recorrido Inorden (String): ");
        ArbolBinarioUtilGenerico.inorden(arbolString.getRaiz());
        System.out.println();

        System.out.print("Buscar Banana (String): " + arbolString.buscar("Banana"));
        System.out.println("Buscar Uva (String): " + arbolString.buscar("Uva"));
    }
}