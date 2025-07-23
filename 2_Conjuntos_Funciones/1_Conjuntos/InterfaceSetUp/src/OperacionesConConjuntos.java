import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class OperacionesConConjuntos {
    public void ejecutarOperaciones() {
        // Datos iniciales
        String[] friends = {"Stuart", "Ivy", "Johnny", "Alex", "Igor", "Tanya"};
        String[] friends1 = {"Stuart1", "Ivy1", "Johnny1", "Alex1", "Igor1", "Tanya1"};
        Integer[] integers1 = {1, 3, 2, 4, 8, 9, 0};
        Integer[] integers2 = {1, 3, 7, 5, 4, 0, 7, 5};

        // Creación de conjuntos
        Set<String> mySet1 = new HashSet<>(Arrays.asList(friends));
        Set<Integer> mySet2 = new HashSet<>(Arrays.asList(integers1));
        LinkedHashSet<String> mySet3 = new LinkedHashSet<>(Arrays.asList(friends));
        HashSet<Integer> mySet4 = new HashSet<>(Arrays.asList(integers2));
        Set<Integer> mySet5 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8, 3));
        Set<String> mySet6 = new HashSet<>(Arrays.asList(friends1));

        // Mostrar conjuntos
        System.out.println("\nConjuntos iniciales:");
        System.out.println("mySet1: " + mySet1);
        System.out.println("mySet2: " + mySet2);
        System.out.println("mySet3 (LinkedHashSet): " + mySet3);
        System.out.println("mySet4: " + mySet4);
        System.out.println("mySet5: " + mySet5);
        System.out.println("mySet6: " + mySet6);

        // Operaciones con conjuntos
        realizarOperacionesNumericas(mySet2, mySet5);
        realizarOperacionesTexto(mySet1, mySet6);
    }

    private void realizarOperacionesNumericas(Set<Integer> set1, Set<Integer> set2) {
        System.out.println("\nOperaciones con conjuntos de enteros:");

        // Unión
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Unión: " + union);

        // Intersección
        Set<Integer> interseccion = new HashSet<>(set1);
        interseccion.retainAll(set2);
        System.out.println("Intersección: " + interseccion);

        // Diferencia
        Set<Integer> diferencia = new HashSet<>(set1);
        diferencia.removeAll(set2);
        System.out.println("Diferencia: " + diferencia);

        // Comparación
        boolean contiene = union.containsAll(set2);
        System.out.println("¿La unión contiene todos los elementos del segundo conjunto? " + contiene);
    }

    private void realizarOperacionesTexto(Set<String> set1, Set<String> set2) {
        System.out.println("\nOperaciones con conjuntos de texto:");

        // Unión
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Unión: " + union);
    }
}