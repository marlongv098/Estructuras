package complejidad;

import complejidad.busquedabinaria.BusquedaBinaria;
import complejidad.busquedalineal.BusquedaLineal;
import complejidad.fibonacci.Fibonacci;
import complejidad.ordenamientoburbuja.OrdenamientoBurbuja;
import complejidad.quicksort.QuickSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AlgoritmosTest {

    private static final int[] ORDENADO = {10, 20, 30, 40, 50};

    @Test
    void busquedaLinealEncuentraYNoEncuentra() {
        assertEquals(2, BusquedaLineal.buscar(ORDENADO, 30));
        assertEquals(-1, BusquedaLineal.buscar(ORDENADO, 99));
    }

    @Test
    void busquedaBinariaEncuentraYNoEncuentra() {
        assertEquals(0, BusquedaBinaria.buscarIterativo(ORDENADO, 10));
        assertEquals(4, BusquedaBinaria.buscarIterativo(ORDENADO, 50));
        assertEquals(-1, BusquedaBinaria.buscarIterativo(ORDENADO, 99));
    }

    @Test
    void ordenamientoBurbujaOrdenaCorrectamente() {
        int[] arr = {5, 1, 4, 2, 8};
        OrdenamientoBurbuja.ordenar(arr);
        assertArrayEquals(new int[]{1, 2, 4, 5, 8}, arr);
    }

    @Test
    void quickSortOrdenaCorrectamenteIncluyendoCasosBorde() {
        int[] arr = {5, 1, 4, 2, 8};
        QuickSort.quicksort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{1, 2, 4, 5, 8}, arr);

        int[] vacio = {};
        QuickSort.quicksort(vacio, 0, vacio.length - 1);
        assertArrayEquals(new int[]{}, vacio);

        int[] unElemento = {42};
        QuickSort.quicksort(unElemento, 0, 0);
        assertArrayEquals(new int[]{42}, unElemento);
    }

    @Test
    void lasTresImplementacionesDeFibonacciCoinciden() {
        for (int n = 0; n <= 15; n++) {
            int rec = Fibonacci.fibonacciRec(n);
            int iter = Fibonacci.fibonacciIterativo(n);
            int opt = Fibonacci.fibonacciOptimizado(n);
            long mat = Fibonacci.fibonacciMatriz(n);
            assertEquals(rec, iter, "difieren en n=" + n);
            assertEquals(rec, opt, "difieren en n=" + n);
            assertEquals(rec, mat, "difieren en n=" + n);
        }
    }

    @Test
    void fibonacciValoresConocidos() {
        assertEquals(0, Fibonacci.fibonacciOptimizado(0));
        assertEquals(1, Fibonacci.fibonacciOptimizado(1));
        assertEquals(55, Fibonacci.fibonacciOptimizado(10));
    }
}
