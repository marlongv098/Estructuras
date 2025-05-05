# Introducción

### ¿Por qué son importantes los árboles binarios?

- Operaciones básicas como insertar, borrar y buscar toman un tiempo proporcional a la **altura** del árbol.
- Para un árbol binario completo con $n$ nodos, las operaciones básicas toman $\Theta(\log n)$.
- Si el árbol se construye como una cadena lineal de $n$ nodos, tomarán $\Theta(n)$.

---

### ¿Qué es un árbol de búsqueda binaria?

- Es un árbol binario en el cual se cumple que para cada nodo $x$:
  - Los nodos del subárbol izquierdo son **menores o iguales** a $x$.
  - Los nodos del subárbol derecho son **mayores o iguales** a $x$.

![Árbol de búsqueda binaria](arbolbb1)

---

# Propiedad del árbol de búsqueda binaria

### ¿Qué propiedad debe cumplir?

- Sea $x$ un nodo del árbol:
  - Si $y$ es un nodo en el subárbol izquierdo de $x$, entonces $key[y] \leq key[x]$.
  - Si $y$ es un nodo en el subárbol derecho de $x$, entonces $key[y] \geq key[x]$.

![Propiedad árbol BST](arbolbb1)


### ¿Cuál es otra característica del árbol de búsqueda binaria?

Si son recorridos **en inorden**, producen una lista de las claves **ordenada ascendentemente**.

![Recorrido inorden](arbolbb6)


###  ¿Por qué son importantes?

- Permiten operaciones como insertar, borrar y buscar en tiempo proporcional a la altura del árbol.
- En un árbol binario **completo** con `n` nodos:  
  ⮞ Tiempo de operación: `Θ(log n)`
- En un árbol **degenerado** (como una lista):  
  ⮞ Tiempo de operación: `Θ(n)`

### ¿Qué es un Árbol de Búsqueda Binaria?

- Es un árbol binario donde, para cada nodo `x`:
	- Todos los nodos del subárbol izquierdo tienen claves `≤ x`
	- Todos los nodos del subárbol derecho tienen claves `≥ x`

### Propiedades del ABB

- **Propiedad estructural**:
	- Sea `x` un nodo del árbol.
	- Si `y` está en el subárbol izquierdo de `x`, entonces `key[y] ≤ key[x]`
 	- Si `y` está en el subárbol derecho de `x`, entonces `key[y] ≥ key[x]`

- **Ordenamiento mediante recorrido**:
  	- El recorrido **inorden** del árbol produce una lista de claves **en orden ascendente**.

- **Complejidad del recorrido inorden**:
  	- `Θ(n)`

---

# Consultas sobre un ABB

### Tipos de consultas:

- Buscar una clave
- Encontrar el **mínimo**
- Encontrar el **máximo**
- Encontrar el **sucesor** de un nodo
- Encontrar el **predecesor** de un nodo

### Complejidad de las consultas:

- Cada operación se puede hacer en **O(h)** donde `h` es la altura del árbol.

---

#  Ejemplos de consultas

###  Búsqueda de una clave `k`
- Comenzar en la raíz `x`.
- Si `k < key[x]` ⮞ ir al subárbol izquierdo.
- Si `k > key[x]` ⮞ ir al subárbol derecho.
- Si `k == key[x]` ⮞ nodo encontrado.

### Búsqueda iterativa
- Igual lógica, pero en ciclo en lugar de recursión.

###  Mínimo
- Ir al subárbol izquierdo hasta llegar a una hoja.

###  Máximo
- Ir al subárbol derecho hasta llegar a una hoja.

###  Predecesor de un nodo `x`
- Es el nodo `y` tal que `key[y]` es la mayor clave **menor que** `key[x]`.

###  Sucesor de un nodo `x`
- Es el nodo `y` tal que `key[y]` es la menor clave **mayor que** `key[x]`.


# Consultas en un Árbol de Búsqueda Binaria

### ¿Cómo se obtiene el sucesor de un nodo `x`?

- El **sucesor** de un nodo `x` es el nodo `y` tal que `key[y]` es la **menor clave mayor que** `key[x]`.

### Ilustración del sucesor de un nodo

![Sucesor de un nodo en ABB](arbolbb14)

---

### Otra ilustración relacionada con las consultas

![Consultas sobre ABB](arbolbb15)


# Inserción en un Árbol de Búsqueda Binaria

### Ilustración del proceso de inserción

![Inserción en un ABB](arbolbb19e)


# Eliminación en un Árbol de Búsqueda Binaria

### Ejemplo paso a paso del proceso de eliminación

### Paso 1
![Eliminación paso 1](arbolbb23e)

### Paso 2
![Eliminación paso 2](arbolbb24)

### Paso 3
![Eliminación paso 3](arbolbb25)

### Paso 4
![Eliminación paso 4](arbolbb26)

### Paso 5
![Eliminación paso 5](arbolbb27)

### Paso 6
![Eliminación paso 6](arbolbb28)

### Paso 7
![Eliminación paso 7](arbolbb30)

### Paso 8
![Eliminación paso 8](arbolbb31)

### Paso 9
![Eliminación paso 9](arbolbb32)

### Paso 10
![Eliminación paso 10](arbolbb33)

---


