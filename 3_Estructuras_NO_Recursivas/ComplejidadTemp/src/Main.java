import java.util.Arrays;
import java.util.Scanner;
import BusquedaBinaria.*;
import BusquedaLineal.*;
import Fibonacci.*;
import OrdenamientoBurbuja.*;
import QuickSort.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numeros = {10, 20, 30, 40, 50};
        int[] desordenados = {5, 1, 4, 2, 8};

        System.out.println("Seleccione un algoritmo:");
        System.out.println("1 - Búsqueda Lineal");
        System.out.println("2 - Búsqueda Binaria");
        System.out.println("3 - Ordenamiento Burbuja");
        System.out.println("4 - QuickSort");
        System.out.println("5 - Fibonacci Recursivo vs Iterativo");

        int opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> {
                System.out.print("Ingrese el número a buscar: ");
                int num = sc.nextInt();
                int resultado = BusquedaLineal.buscar(numeros, num);
                System.out.println("Índice encontrado: " + resultado);
            }
            case 2 -> {
                System.out.print("Ingrese el número a buscar: ");
                int num2 = sc.nextInt();
                int resultado2 = BusquedaBinaria.buscarIterativo(numeros, num2);
                System.out.println("Índice encontrado: " + resultado2);
            }
            case 3 -> {
                OrdenamientoBurbuja.ordenar(desordenados);
                System.out.println("Ordenado: " + Arrays.toString(desordenados));
            }
            case 4 -> {
                QuickSort.quicksort(desordenados, 0, desordenados.length - 1);
                System.out.println("Ordenado: " + Arrays.toString(desordenados));
            }
            case 5 -> {
                System.out.print("Ingrese el número de Fibonacci: ");
                int n = sc.nextInt();
                System.out.println("Recursivo: " + Fibonacci.fibonacciRec(n));
                System.out.println("Iterativo: " + Fibonacci.fibonacciOptimizado(n));
            }
            default -> System.out.println("Opción inválida");
        }

        sc.close();
    }
}