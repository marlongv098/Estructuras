# Árbol Binario de Búsqueda (BST)

## Compilar, probar y ejecutar (Maven)

```bash
cd 4_Estructuras_Recursivas/1_ArbolBinario
mvn compile
mvn test
mvn exec:java
```

## Corrección aplicada: `encontrarMinimo` bajaba en la dirección incorrecta

Al eliminar un nodo con **dos hijos**, hay que reemplazarlo por el sucesor in-order, que es el **mínimo del subárbol derecho** — y para encontrar el mínimo de un subárbol hay que bajar siempre por la **izquierda** hasta quedarse sin hijo izquierdo. La versión anterior de `encontrarMinimo` hacía:

```java
while (actual.izquierdo != null) {
    minimo = actual.izquierdo.valor;
    actual = actual.derecho;   // ← bajaba por la DERECHA en vez de la izquierda
}
```

Esto podía lanzar `NullPointerException` (si `actual.derecho` se volvía `null` mientras `actual.izquierdo` seguía sin serlo) o devolver un valor que no era realmente el mínimo del subárbol, corrompiendo el árbol al eliminar cualquier nodo con dos hijos. Se corrigió para bajar por `actual.izquierdo`. La prueba `eliminarNodoConDosHijosUsaElSucesorInorden` en `ArbolBinarioTest` cubre exactamente este caso.

## Complejidad temporal y espacial

| Operación | Árbol balanceado | Árbol degenerado (peor caso) |
|---|---|---|
| `insertar` | O(log n) | O(n) — si se insertan datos ya ordenados, el árbol degenera en una lista enlazada |
| `buscar` | O(log n) | O(n) |
| `eliminar` | O(log n) | O(n) |

En todos los casos, el costo real es **O(h)** donde h es la altura del árbol — de ahí que este README hable de Θ(log n) para un árbol "completo" y Θ(n) para uno degenerado (ver más abajo). Este es precisamente el problema que resuelve el **árbol AVL** de `2_ArbolAVL` en este mismo repositorio: garantiza h = O(log n) **siempre**, balanceando automáticamente tras cada inserción/eliminación, sin importar el orden en que lleguen los datos.

**Espacio**: O(n) — un `Nodo<T>` por elemento, cada uno con el dato y dos referencias (`izquierdo`, `derecho`). La recursión de `insertarRecursivo`/`buscarRecursivo`/`eliminarRecursivo` añade además O(h) de espacio en la pila de llamadas (O(log n) balanceado, O(n) degenerado).

---

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


