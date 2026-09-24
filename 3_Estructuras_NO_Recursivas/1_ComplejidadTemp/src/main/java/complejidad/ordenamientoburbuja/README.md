# Complejidad Temporal del Algoritmo de Ordenamiento Burbuja

 El **Ordenamiento Burbuja (Bubble Sort)** es un algoritmo de ordenación simple que **compara pares de elementos adyacentes** e intercambia sus posiciones si están en el orden incorrecto. Este proceso se repite hasta que la lista está ordenada.

## Código en Java  
```java
package complejidad.ordenamientoburbuja;

public class OrdenamientoBurbuja {
    public static void ordenar(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean huboIntercambio = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    huboIntercambio = true;
                }
            }
            if (!huboIntercambio) {
                break; // ya está ordenado, corta la ejecución
            }
        }
    }
}
```

> **Nota de corrección**: la versión original de este algoritmo no tenía el `huboIntercambio` (flag de intercambio). Sin ese flag, el algoritmo **siempre** recorre las n² comparaciones sin importar el orden de entrada — el mejor caso también sería O(n²), no O(n). El flag es precisamente lo que hace *cierta* la afirmación de mejor caso O(n) de la sección siguiente: al no haber intercambios en una pasada completa, se corta la ejecución en vez de seguir iterando.

# Análisis Complejidad Temporal

### Caso Mejor Caso  - O(n)

* Si el arreglo ya está ordenado, el algoritmo hace una pasada completa (n-1 comparaciones), no encuentra ningún intercambio, y el flag `huboIntercambio` corta la ejecución inmediatamente.

### Peor Caso  - O(n²)

* Ocurre cuando el arreglo está ordenado de forma inversa. En este caso, el algoritmo debe realizar $$(n-1) + (n-2) + ... + 1 = n(n-1)/2 ≈ O(n²)$$ comparaciones e intercambios.

### Caso Promedio  - O(n²)

* En la mayoría de los casos, el algoritmo sigue realizando $n^2$ comparaciones e intercambios, lo que lo hace ineficiente para listas grandes.


# Análisis de Complejidad Espacial

* El ordenamiento es **in-place**: solo usa una variable temporal (`temp`) y el flag `huboIntercambio` para el intercambio, sin estructuras auxiliares proporcionales a n.
* **Espacio: O(1)**, independiente del tamaño del arreglo.

# Conclusión

* Ordenamiento Burbuja no es eficiente para grandes conjuntos de datos debido a su complejidad O(n²) en la mayoría de los casos.
* Para mejorar su rendimiento, se recomienda usar algoritmos más eficientes como QuickSort o MergeSort.