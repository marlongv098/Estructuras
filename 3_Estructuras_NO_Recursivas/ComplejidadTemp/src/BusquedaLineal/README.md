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

    public static void main(String[] args) {
        int[] datos = {10, 20, 30, 40, 50};
        int objetivo = 30;
        int resultado = buscar(datos, objetivo);
        System.out.println("Índice del elemento: " + resultado);
    }
}
```



Caso Mejor (Best Case) - O(1)
Si el primer elemento del arreglo es el buscado, solo se realiza una comparación.

## Ejemplo:

Buscar 10 en [10, 20, 30, 40, 50] requiere 1 comparación.

Caso Promedio (Average Case) - O(n)
En promedio, el elemento se encuentra a la mitad de la lista, requiriendo aproximadamente n/2 comparaciones.
En términos de complejidad asintótica, sigue siendo O(n).

