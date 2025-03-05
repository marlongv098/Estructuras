# Complejidad Temporal del Algoritmo de Ordenamiento Burbuja

 El **Ordenamiento Burbuja (Bubble Sort)** es un algoritmo de ordenación simple que **compara pares de elementos adyacentes** e intercambia sus posiciones si están en el orden incorrecto. Este proceso se repite hasta que la lista está ordenada.

## Código en Java  
```java
public class OrdenamientoBurbuja {
    ppublic static void ordenar(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
```

# Análisis Complejidad Temporal

### Caso Mejor Caso  - O(n)

* Si el arreglo ya está ordenado, el algoritmo solo hace una pasada completa (n iteraciones) y termina sin hacer intercambios.

### Peor Caso  - O(n²)

* Ocurre cuando el arreglo está ordenado de forma inversa. En este caso, el algoritmo debe realizar $$(n-1) + (n-2) + ... + 1 = n(n-1)/2 ≈ O(n²)$$ comparaciones e intercambios.

### Caso Promedio  - O(n²)

* En la mayoría de los casos, el algoritmo sigue realizando $n^2$ comparaciones e intercambios, lo que lo hace ineficiente para listas grandes.


# Conclusión

* Ordenamiento Burbuja no es eficiente para grandes conjuntos de datos debido a su complejidad O(n²) en la mayoría de los casos.
* Para mejorar su rendimiento, se recomienda usar algoritmos más eficientes como QuickSort o MergeSort.