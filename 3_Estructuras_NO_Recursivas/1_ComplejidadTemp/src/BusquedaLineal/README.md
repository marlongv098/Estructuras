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
# Desglose de operaciones por linea

| Línea | Código                                  |Operaciones realizadas | Costo |
|-------|----------------------------------------|-------|------------------------|
| 1     | for( int i = 0                                 | asignación  | 1 |
| 2     | i < arreglo.length:                 | comparacion   | n+1 |
| 3     | i++                                 | incremento   | n | 
| 4     | if (arreglo[i] == objetivo)         |Acceso al arreglo  | n | 
| 5     | if (arreglo[i] == objetivo)         | comparación de igualdad    | n |
| 6     | return i                           | Retorno (solo una vez si encuentra) | 1 |
| 7     |return -1;                           | Retorno (al final) | 1 |

# Análisis de Complejidad Temporal

### Mejor Caso - O(1)

* Si el primer elemento del arreglo es el buscado, solo se realiza una comparación.

  T_mejor(n) = 1 comparación
  T_mejor(n) = O(1)

### Peor Caso - O(n)

* El elemento se encuentra en al final de la lista, requiriendo aproximadamente n comparaciones. En términos de complejidad asintótica, O(n).

  T_peor(n) = n comparaciones
  T_peor(n) = O(n)

### Caso Promedio  - O(n)

* El elemento se encuentra a la mitad de la lista, requiriendo aproximadamente n/2 comparaciones. En términos de complejidad asintótica, sigue siendo O(n).



### Límite superior notacion $O$: 

$T(n) ≤ c·n$ para $n ≥ n₀$

Demostración: 

Para $c = 2, n₀ = 1$ $T(n) = n ≤ 2n$ para todo $n ≥ 1$

### Límite inferior $\Omega$: 

$T(n) ≥ c·n$ para $n ≥ n₀$

Demostración:

Para $c = 1, n₀ = 1$  $T(n) = n ≥ 1·n$ para todo $n ≥ 1$

Por lo tanto: $T(n) = Θ(n)$


# Análisis de Complejidad Espacial

### Parámetros de entrada:

* arreglo: Solo almacena una referencia (puntero) al arreglo original (8 bytes en arquitecturas de 64 bits)

* objetivo: Variable primitiva int (4 bytes)

* Total parámetros: Tamaño fijo, no depende de n

### Variables locales:

* i: Variable primitiva int
* Se crea una sola vez y se reutiliza
* Total variables locales: Tamaño fijo

### Espacio en el stack (pila de llamadas):

* Frame de la función con sus variables
* Tamaño constante independiente de n

# Conclusion 

* La búsqueda lineal no es eficiente para grandes listas, ya que en el peor caso requiere recorrer todos los elementos.
* Es útil para listas desordenadas o de tamaño pequeño.
* Para listas ordenadas, se recomienda búsqueda binaria (O(log n)).