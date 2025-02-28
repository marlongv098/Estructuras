# Complejidad Temporal del Algoritmo de Búsqueda Lineal

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

### Mejor Caso - O(1)

* Si el primer elemento del arreglo es el buscado, solo se realiza una comparación.

### Peor Caso - O(n)

* El elemento se encuentra en al final de la lista, requiriendo aproximadamente n comparaciones. En términos de complejidad asintótica, O(n).

### Caso Promedio  - O(n)

* El elemento se encuentra a la mitad de la lista, requiriendo aproximadamente n/2 comparaciones. En términos de complejidad asintótica, sigue siendo O(n).


# Conclusion 

* La búsqueda lineal no es eficiente para grandes listas, ya que en el peor caso requiere recorrer todos los elementos.
* Es útil para listas desordenadas o de tamaño pequeño.
* Para listas ordenadas, se recomienda búsqueda binaria (O(log n)).