# Complejidad Temporal del Algoritmo de Fibonacci

La **sucesión de Fibonacci** se define de la siguiente manera:

$$
F(n) =
\begin{cases} 
    0, & \text{si } n = 0 \\
    1, & \text{si } n = 1 \\
    F(n-1) + F(n-2), & \text{si } n \geq 2
\end{cases}
$$

Cada término es la suma de los dos anteriores.

---

## Código en Java. Recursivo

```java
public class Fibonacci {
    public static int fibonacciRec(int n) {
        if (n <= 1) return n;
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }
}
```

# Análisis de Complejidad

* La recursión genera un árbol binario de llamadas.
* Cada llamada recursiva crea dos subproblemas, lo que da una recurrencia de: $$T(n)=T(n−1)+T(n−2)+O(1)$$
* La solución de esta recurrencia es O(2ⁿ), un crecimiento exponencial, lo que lo hace ineficiente.


## Código en Java. Optimizado
```java
 public class Fibonacci {
 
 	public static int fibonacciOptimizado(int n) {
       	  if (n <= 1) return n;
       	  int a = 0, b = 1, temp;
     	  for (int i = 2; i <= n; i++) {
         	temp = a + b;
            	a = b;
            	b = temp;
        	  }
        	  return b;
        }

	public int fibonacciIterativo(int n) {
       	  if (n <= 1) return n;

       	  int[] fib = new int[n + 1];
        	  fib[0] = 0;
        	  fib[1] = 1;

        	  for (int i = 2; i <= n; i++) {
            		fib[i] = fib[i - 1] + fib[i - 2];
        		}
        	  return fib[n];
    	 }
}   
``` 

# Análisis de Complejidad

### Recursivo

* La recursión genera un árbol binario de llamadas.
* Cada llamada recursiva crea dos subproblemas, lo que da una recurrencia de: $$T(n)=T(n−1)+T(n−2)+O(1)$$
* La solución de esta recurrencia es O(2ⁿ), un crecimiento exponencial, lo que lo hace ineficiente.

### Método Iterativo (sin optimización de espacio)

Utiliza un array para almacenar los valores previos de Fibonacci.

* Complejidad de tiempo: $$O(n)$$

* Complejidad de espacio: $$O(n)$$ (debido al almacenamiento de todos los valores previos en un array)

### Método Optimizado con Espacio

Solo mantiene en memoria los dos últimos valores de la secuencia en lugar de todo el array.

* Complejidad de tiempo: $$O(n)$$

* Complejidad de espacio: $$O(1)$$ (ya que solo usa unas pocas variables, independientemente del tamaño de $n$

# Otros algoritmos y Comparación de sus complejidades

| Método                   | Complejidad de Tiempo | Complejidad de Espacio |
|--------------------------|----------------------|------------------------|
| Recursivo         | O(2ⁿ)                | O(n) (por la pila de recursión) |
| Programación Dinámica    | O(n)                 | O(n) (almacenamiento en array) |
| Optimizado con Espacio   | O(n)                 | O(1) |
| Matrices                 | O(log n)             | O(1) |

   


# Conclusiónes

### Iterativo y optimización

* Ambos métodos son iterativos y tienen complejidad de tiempo $$O(n)$$.
* La diferencia está en el espacio usado: el primero usa un array $$O(n)$$, mientras que el segundo usa solo dos variables $$O(1)$$.
* Si buscas eficiencia en memoria, el método optimizado con espacio es mejor.

### Otros métodos

* El método recursivo es ineficiente (O(2ⁿ)), solo útil para valores pequeños.
* La versión optimizada con espacio O(1) es la más usada en la práctica.
* El método de matrices es el más rápido (O(log n)), recomendado para valores grandes de n.
* La programación dinámica mejora el rendimiento a O(n), pero consume más espacio.
* Si necesitas eficiencia en cálculos grandes, usa el método de matrices o la versión optimizada con espacio O(1).

 
   