import java.util.HashSet;
import java.util.Set;

public class PalabrasUnicas {

        private final Set<String> palabrasUnicas;

        // Constructor
        public PalabrasUnicas() {
            this.palabrasUnicas = new HashSet<>();
        }

        // Método para agregar palabras desde una oración
        public void agregarDesdeOracion(String oracion) {
            String[] palabras = oracion.toLowerCase().split("\\s+|\\p{Punct}");
            for (String palabra : palabras) {
                if (!palabra.isEmpty()) {
                    palabrasUnicas.add(palabra);
                }
            }
        }

        // Método para obtener la cantidad de palabras únicas
        public int getCantidadUnicas() {
            return palabrasUnicas.size();
        }

        // Método para obtener el conjunto de palabras únicas
        public Set<String> getPalabrasUnicas() {
            return palabrasUnicas;
        }

        // Método para mostrar las palabras únicas
        public void mostrarPalabras() {
            System.out.println("Número de palabras únicas: " + getCantidadUnicas());
            System.out.println("Palabras únicas: " + getPalabrasUnicas());
        }
}





