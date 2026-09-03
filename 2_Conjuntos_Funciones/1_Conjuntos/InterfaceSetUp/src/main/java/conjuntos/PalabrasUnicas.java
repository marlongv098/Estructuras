package conjuntos;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PalabrasUnicas {
    private final Set<String> palabras = new HashSet<>();

    public void procesarDesdeConsola(Scanner scanner) {
        System.out.println("\nIngresa una oración:");
        String oracion = scanner.nextLine();
        agregarDesdeOracion(oracion);
        mostrarPalabras();
    }

    public void agregarDesdeOracion(String oracion) {
        String[] palabrasArray = oracion.split("\\s+");
        for (String palabra : palabrasArray) {
            String normalizada = palabra.toLowerCase().replaceAll("[^a-zA-Záéíóúüñ]", "");
            // Sin esta comprobación, un token compuesto solo por signos de puntuación
            // (p. ej. "--" o "...") queda como cadena vacía y contamina el conjunto.
            if (!normalizada.isEmpty()) {
                palabras.add(normalizada);
            }
        }
    }

    public void mostrarPalabras() {
        System.out.println("\nPalabras únicas encontradas:");
        palabras.forEach(System.out::println);
        System.out.println("Total: " + palabras.size() + " palabras únicas");
    }

    /** Vista de solo lectura del conjunto de palabras acumuladas (útil para pruebas). */
    public Set<String> getPalabras() {
        return Collections.unmodifiableSet(palabras);
    }
}
