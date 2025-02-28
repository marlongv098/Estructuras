import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PalabrasUnicasT {

        private final Set<String> palabrasUnicasT;

        // Constructor
        public PalabrasUnicasT() {
            this.palabrasUnicasT = new HashSet<>();
        }

        // Método para leer un archivo y extraer palabras únicas
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

        // Método privado para procesar texto y agregar palabras únicas
        private void agregarDesdeTexto(String texto) {
            String[] palabras = texto.toLowerCase().split("\\s+|\\p{Punct}");
            for (String palabra : palabras) {
                if (!palabra.isEmpty()) {
                    palabrasUnicasT.add(palabra);
                }
            }
        }

        // Método para obtener la cantidad de palabras únicas
        public int getCantidadUnicas() {
            return palabrasUnicasT.size();
        }

        // Método para obtener el conjunto de palabras únicas
        public Set<String> getPalabrasUnicas() {
            return palabrasUnicasT;
        }

        // Método para mostrar las palabras únicas
        public void mostrarPalabras() {
            System.out.println("Número de palabras únicas: " + getCantidadUnicas());
            System.out.println("Palabras únicas: " + getPalabrasUnicas());
        }
}

