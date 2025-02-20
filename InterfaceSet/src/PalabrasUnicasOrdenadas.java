import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class PalabrasUnicasOrdenadas {
    private final TreeSet<String> palabrasUnicasOrdendas;

    // Constructor: Usa TreeSet para almacenar palabras ordenadas alfabéticamente
    public PalabrasUnicasOrdenadas() {
       this.palabrasUnicasOrdendas = new TreeSet<>();
    }

    // Método para leer un archivo y extraer palabras únicas ordenadas
    public void leerDesdeArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                agregarDesdeTexto(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Método privado para procesar texto y agregar palabras únicas ordenadas
    private void agregarDesdeTexto(String texto) {
        String[] palabras = texto.toLowerCase().split("\\s+|\\p{Punct}");
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                palabrasUnicasOrdendas.add(palabra);
            }
        }
    }

    // Método para obtener la cantidad de palabras únicas
    public int getCantidadUnicas() {
        return palabrasUnicasOrdendas.size();
    }

    // Método para obtener el conjunto de palabras únicas ordenadas
    public Set<String> getPalabrasUnicas() {
        return palabrasUnicasOrdendas;
    }

    // Método para mostrar las palabras únicas ordenadas
    public void mostrarPalabrasOrdenadas() {
        System.out.println("Número de palabras únicas: " + getCantidadUnicas());
        System.out.println("Palabras únicas ordenadas: " + getPalabrasUnicas());
    }

}
