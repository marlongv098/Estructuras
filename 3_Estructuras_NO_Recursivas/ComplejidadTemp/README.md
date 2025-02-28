# Complejidad Temporal del Algoritmo de Búsqueda Lineal

## Definición  
La **búsqueda lineal** es un algoritmo que busca un elemento dentro de una lista recorriéndola secuencialmente desde el inicio hasta encontrar el elemento deseado o llegar al final de la lista.

## Código en Java  
```java
public class BusquedaLineal {
    public static int buscar(int[] arreglo, int objetivo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == objetivo) {
                return i; // Se encontró el elemento en la posición i
            }
        }
        return -1; // El elemento no está en el arreglo
    }

```

# Análisis de Complejidad Temporal

## Mejor Caso - O(1)

Si el primer elemento del arreglo es el buscado, solo se realiza una comparación.

## Peor Caso - O(n)

El elemento se encuentra en al final de la lista, requiriendo aproximadamente n comparaciones. En términos de complejidad asintótica, O(n).

## Caso Promedio  - O(n)

El elemento se encuentra a la mitad de la lista, requiriendo aproximadamente n/2 comparaciones. En términos de complejidad asintótica, sigue siendo O(n).


# Complejidad Temporal del Algoritmo de Búsqueda Binaria

## Definición  
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

## Mejor Caso  - O(1)

Si el elemento buscado está en el centro del arreglo en la primera comparación, la búsqueda termina inmediatamente.

## Peor Caso - O(log n)

En cada iteración, el tamaño de la lista se reduce a la mitad. El número máximo de comparaciones es aproximadamente log₂(n).

## Ejemplo:

Para una lista de n = 16, se necesitan como máximo log₂(16) = 4 comparaciones.


## Caso Promedio - O(log n)

Dado que en cada iteración se descarta la mitad de los elementos, el tiempo de ejecución promedio sigue siendo O(log n).






