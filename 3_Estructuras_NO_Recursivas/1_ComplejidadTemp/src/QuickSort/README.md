# Complejidad Temporal del Algoritmo Quicksort

 El **Quicksort** es un algoritmo de ordenación basado en el principio de **divide y vencerás**.  Elige un elemento llamado **pivote**, divide el arreglo en dos subarreglos (**menores y mayores que el pivote**) y ordena recursivamente cada parte.

## Código en Java  
```java
public class QuickSort {
    public static void quicksort(int[] arr, int izq, int der) {
        if (izq < der) {
            int pi = particion(arr, izq, der);
            quicksort(arr, izq, pi - 1);
            quicksort(arr, pi + 1, der);
        }
    }

    private static int particion(int[] arr, int izq, int der) {
        int pivote = arr[der];
        int i = izq - 1;
        for (int j = izq; j < der; j++) {
            if (arr[j] < pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[der];
        arr[der] = temp;
        return i + 1;
    }
}
```

# Análisis de Complejidad Temporal


### Mejor Caso (Best Case) - O(n log n)

* Ocurre cuando el pivote divide el arreglo en dos mitades iguales en cada paso.
* La recursión se realiza en $log(n)$ niveles y cada nivel tiene O(n) operaciones.
* Complejidad: $$O(nlogn)$$

###  Peor Caso (Worst Case) - O(n²)
* Ocurre cuando el pivote elegido es el elemento más pequeño o el más grande en cada paso.
* En este caso, no se logra una partición equilibrada y el algoritmo se comporta como un Insertion Sort.
* Número de comparaciones: $$n+(n−1)+(n−2)+...+1=O(n^ 2)$$


### Caso Promedio (Average Case) - O(n log n)

* En la mayoría de los casos, el pivote divide el arreglo de manera aproximadamente balanceada.
* Similar al mejor caso, se obtiene $O(nlog( n))$ en promedio.

# Conclusión

* Quicksort es uno de los algoritmos más eficientes para ordenar grandes conjuntos de datos debido a su $O(nlog (n))$ en la mayoría de los casos.
* Su rendimiento depende de la elección del pivote.
* Para evitar el caso peor, se pueden usar técnicas como pivote aleatorio o mediana de tres.
