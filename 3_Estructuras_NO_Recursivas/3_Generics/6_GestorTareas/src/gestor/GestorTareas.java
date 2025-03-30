package gestor;

import colaprioridad.HeapMinimo;
import tareas.Tarea;

import java.util.Scanner;

public class GestorTareas {
    public static void main(String[] args) {
        HeapMinimo<Tarea, String> colaPrioridad = new HeapMinimo<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Gestor de Tareas ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Procesar tareas");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la tarea: ");
                    String nombreTarea = scanner.nextLine();
                    System.out.print("Ingrese la prioridad de la tarea: ");
                    int prioridadTarea = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    colaPrioridad.agregar(new Tarea(nombreTarea, prioridadTarea));
                    System.out.println("Tarea agregada.");
                    break;
                case 2:
                    System.out.println("\n--- Procesando tareas ---");
                    while (!colaPrioridad.estaVacio()) {
                        Tarea tarea = colaPrioridad.extraerMinimo();
                        System.out.println("Procesando: " + tarea.obtenerDatos() + " (Prioridad: " + tarea.obtenerPrioridad() + ")");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del gestor de tareas.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}