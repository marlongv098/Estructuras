# Complejidad Temporal del Algoritmo de Búsqueda Binaria

La **búsqueda binaria** es un algoritmo eficiente para encontrar un elemento en una lista **ordenada**. En cada paso, **divide el espacio de búsqueda a la mitad**, reduciendo significativamente el número de comparaciones en comparación con la búsqueda lineal.

## Código en Java  
```java
public class BusquedaBinaria {    public static int buscarIterativo(int[] arr, int objetivo) {
    int inicio = 0, fin = arr.length - 1;
    while (inicio <= fin) {
        int medio = inicio + (fin - inicio) / 2;
        if (arr[medio] == objetivo) return medio;
        else if (arr[medio] < objetivo) inicio = medio + 1;
        else fin = medio - 1;
    }
    return -1;
}

}
```

# Análisis de Complejidad Temporal

### Mejor Caso  - O(1)

* Si el elemento buscado está en el centro del arreglo en la primera comparación, la búsqueda termina inmediatamente.

### Peor Caso - O(log n)

* En cada iteración, el tamaño de la lista se reduce a la mitad. El número máximo de comparaciones es aproximadamente log₂(n).

### Ejemplo:

* Para una lista de n = 16, se necesitan como máximo log₂(16) = 4 comparaciones.


### Caso Promedio - O(log n)

* Dado que en cada iteración se descarta la mitad de los elementos, el tiempo de ejecución promedio sigue siendo O(log n).

# Conclusión

* La búsqueda binaria es mucho más eficiente que la búsqueda lineal para listas ordenadas.
* Su complejidad O(log n) la hace ideal para grandes conjuntos de datos.
* Limitación: Solo funciona en listas ordenadas. Si la lista está desordenada, primero hay que ordenarla (O(n log n)) antes de aplicar la búsqueda binaria.






