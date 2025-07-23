import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instancias de las clases
        OperacionesConConjuntos operaciones = new OperacionesConConjuntos();
        PalabrasUnicas palabrasUnicas = new PalabrasUnicas();
        PalabrasUnicasTexto palabrasUnicasTexto = new PalabrasUnicasTexto();
        PalabrasUnicasOrdenadas palabrasOrdenadas = new PalabrasUnicasOrdenadas();

        while(true) {
            mostrarMenu();

            int opcion;
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.nextLine(); // Limpiar buffer
                continue;
            }

            switch(opcion) {
                case 1:
                    operaciones.ejecutarOperaciones();
                    break;
                case 2:
                    palabrasUnicas.procesarDesdeConsola(scanner);
                    break;
                case 3:
                    palabrasUnicasTexto.procesarDesdeArchivo(scanner);
                    break;
                case 4:
                    palabrasOrdenadas.procesarDesdeArchivo(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Operaciones con Conjuntos");
        System.out.println("2. Procesar palabras únicas desde consola");
        System.out.println("3. Procesar palabras únicas desde archivo");
        System.out.println("4. Procesar palabras únicas ordenadas desde archivo");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }
}