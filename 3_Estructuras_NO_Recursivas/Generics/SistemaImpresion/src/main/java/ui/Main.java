package ui;

import impresion.Impresora;
import impresion.TrabajoImpresion;
import impresion.TrabajoImpresionPrioridad;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Impresora impresora = new Impresora();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSistema de Impresión:");
            System.out.println("1. Agregar trabajo de impresión regular");
            System.out.println("2. Agregar trabajo de impresión con prioridad");
            System.out.println("3. Imprimir todos los trabajos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del documento: ");
                    String documento = scanner.nextLine();
                    System.out.print("Nombre del usuario: ");
                    String usuario = scanner.nextLine();
                    impresora.agregarTrabajo(new TrabajoImpresion(documento, usuario));
                    System.out.println("Trabajo agregado.");
                    break;
                case 2:
                    System.out.print("Nombre del documento: ");
                    String documentoPrioridad = scanner.nextLine();
                    System.out.print("Nombre del usuario: ");
                    String usuarioPrioridad = scanner.nextLine();
                    System.out.print("Prioridad (entero): ");
                    int prioridad = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    impresora.agregarTrabajoPrioridad(new TrabajoImpresionPrioridad(documentoPrioridad, usuarioPrioridad, prioridad));
                    System.out.println("Trabajo con prioridad agregado.");
                    break;
                case 3:
                    impresora.imprimir();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema de impresión...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
