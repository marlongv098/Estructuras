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
            palabras.add(palabra.toLowerCase().replaceAll("[^a-zA-Záéíóúüñ]", ""));
        }
    }

    public void mostrarPalabras() {
        System.out.println("\nPalabras únicas encontradas:");
        palabras.forEach(System.out::println);
        System.out.println("Total: " + palabras.size() + " palabras únicas");
    }
}
