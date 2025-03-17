package ui;

import editor.EditorTexto;
import editor.EditorTextoInterfaz;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EditorTextoInterfaz editor = new EditorTexto();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nEditor de Texto:");
            System.out.println("1. Escribir texto");
            System.out.println("2. Deshacer");
            System.out.println("3. Rehacer");
            System.out.println("4. Mostrar texto actual");
            System.out.println("5. Mostrar tope Deshacer");
            System.out.println("6. Mostrar tope Rehacer");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el texto a agregar: ");
                    String texto = scanner.nextLine();
                    editor.escribir(texto);
                    break;
                case 2:
                    editor.deshacer();
                    System.out.println("Deshacer realizado.");
                    break;
                case 3:
                    editor.rehacer();
                    System.out.println("Rehacer realizado.");
                    break;
                case 4:
                    System.out.println("Texto actual: " + editor.obtenerTextoActual());
                    break;

                case 5:
                    System.out.println("Tope de deshacer: " + editor.obtenerTopeDeshacer());
                    break;

                case 6:
                    System.out.println("Tope de rehacer: " + editor.obtenerTopeRehacer());
                    break;

                case 0:
                    System.out.println("Saliendo del editor de texto...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}