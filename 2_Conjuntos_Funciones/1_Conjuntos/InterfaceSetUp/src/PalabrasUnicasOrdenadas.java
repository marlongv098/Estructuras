import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PalabrasUnicasOrdenadas {
    private final Set<String> palabras = new TreeSet<>();

    public void procesarDesdeArchivo(Scanner scanner) {
        System.out.print("\nIngresa la ruta del archivo de texto: ");
        String rutaArchivo = scanner.nextLine();
        leerDesdeArchivo(rutaArchivo);
        mostrarPalabrasOrdenadas();
    }

    public void leerDesdeArchivo(String rutaArchivo) {
        try (Scanner fileScanner = new Scanner(new File(rutaArchivo))) {
            while (fileScanner.hasNext()) {
                String palabra = fileScanner.next().toLowerCase().replaceAll("[^a-zA-Záéíóúüñ]", "");
                if (!palabra.isEmpty()) {
                    palabras.add(palabra);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado - " + e.getMessage());
        }
    }

    public void mostrarPalabrasOrdenadas() {
        System.out.println("\nPalabras únicas ordenadas alfabéticamente:");
        palabras.forEach(System.out::println);
        System.out.println("Total: " + palabras.size() + " palabras únicas ordenadas");
    }
}