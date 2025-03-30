# Montículos

### Introducción  

**¿Qué es un montículo o heap?**  

- Es un arreglo que puede verse como un árbol binario casi completo.  
- Cada nodo del árbol corresponde a un elemento del arreglo.  
- El árbol se encuentra lleno en casi todos sus niveles:
	  - Con la excepción de posiblemente el nivel más bajo.
	  - Este se encuentra lleno desde la izquierda hasta cierto punto.

---

### Propiedades del montículo  

**¿Qué nos dice esta última propiedad sobre la forma de un montículo?**  

- El árbol está lleno en casi todos sus niveles con excepción de posiblemente el último.  
	  - La longitud de toda rama es $h$ o $h-1$, donde $h$ es la altura del árbol.  
- El último nivel se llena de izquierda a derecha.
	  - No puede existir una rama de longitud $h$ a la derecha de una rama de longitud $h-1$.

---

### Altura del montículo  

**¿Cuál es la altura de un nodo del montículo?**  

- Es el número de aristas en el camino simple más largo desde el nodo hasta la hoja.  

**¿Cuál es la altura del montículo?**  

- Al estar basado en un árbol binario completo, es:  
  $$\Theta (\log n)$$

---

### Ejemplo de montículo  

**Ejemplo de un montículo:**  

[Heap](Images/heap.pdf)

---

### Representación del montículo en un arreglo  

**¿Cómo es ese arreglo $A$ que representa al montículo?**  

- Es un arreglo con dos atributos:  
  - $A.length$ → Número de elementos del arreglo.  
  - $A.heap\_size$ → Número de elementos del montículo dentro del arreglo.  
  - $A[1..A.length]$ puede contener números.  
  - Solamente los elementos $$A[1..A.heap\_size]$$, donde $$0 \leq A.heap\_size \leq A.length$$, son válidos.  

---

### Propiedades de la representación en arreglo
  
**¿Qué más se puede decir de ese arreglo $A$?**  

- La raíz del árbol es $A[1]$.  
- El padre de $A[i]$ es:  
  $$A[\lfloor i/2 \rfloor]$$  
- El hijo izquierdo de $A[i]$ es:  
  $$A[2i]$$  
- El hijo derecho de $A[i]$ es:  
  $$A[2i+1]$$  
- El cómputo de estas operaciones es rápido utilizando la representación binaria.

### Tipos de montículos  

**¿Cuáles son los dos tipos de montículos?**  

- **Max-heap**  
  - Para todos los nodos $$i$$, excluyendo la raíz:  
    $$A[Padre(i)] \geq A[i]$$  

- **Min-heap**  
  - Para todos los nodos $$i$$, excluyendo la raíz:  
    $$A[Padre(i)] \leq A[i]$$  

---

### Ejemplos de montículos  

**Analicemos las propiedades de orden y forma de estos montículos:**  

#### Ejemplo 1  
[Heap 1](Images/heap1.pdf)  

#### Ejemplo 2  
[Heap 2](Images/heap2.pdf)  

#### Ejemplo 3  
[Heap 3](Images/heap3.pdf)  

#### Ejemplo 4  
[Heap 4](Images/heap4.pdf)  

#### Ejemplo 5  
[Heap 5](Images/heap5.pdf)  

---

### Ejercicios  

**Indique si se cumplen las propiedades de orden y de forma para los siguientes montículos:**  

#### Ejercicio 1  
[Heap 6](Images/heap6.pdf)  

#### Ejercicio 2  
[Heap 7](Images/heap7.pdf)  

---

### Almacenamiento en el arreglo  
**¿Cómo se almacenan los elementos de un montículo en el arreglo?**  

- Los datos se almacenan en el arreglo recorriendo, por niveles, de izquierda a derecha.  

[Heap 8](heap8.pdf)  

---

### Ejercicio adicional  

**Indique si se cumplen las propiedades de orden y de forma para:**  

1. $$A=\{20, 10, 5, 4, 3, 1\}$$ donde $$heap\_size[A]=6$$ y $$length[A]=6$$  
2. $$A=\{8, 4, 2, 1, 7, 9\}$$ donde $$heap\_size[A]=4$$ y $$length[A]=6$$  

### Ejercicio  

[Heap 9](Images/heap9.pdf)  

---

### Operaciones en montículos
  
**¿Cuáles son las operaciones más importantes que se realizan con montículos?**  

- **HEAPIFY**: $$O(\log n)$$  
- **BUILD-HEAP**: $$O(n)$$  
- **HEAPSORT**: $$O(n \log n)$$  

---

### ¿Qué hace la operación HEAPIFY?  

- Es importante para manipular montículos.  
- Se usa para garantizar la propiedad de orden del montículo.  

### ¿Qué hace la operación MAX-HEAPIFY?  

- Se usa para garantizar la propiedad de orden del **max-heap**.  
- Antes de aplicar MAX-HEAPIFY, $A[i]$ puede ser menor que sus hijos.  
- Se asume que los subárboles izquierdos y derechos son max-heaps.  
- Luego de MAX-HEAPIFY, el subárbol con raíz $i$ es un max-heap.  

### Algoritmo MAX-HEAPIFY  

[MAX-HEAPIFY](Images/heap10.png)  

### ¿Cómo funciona el MAX-HEAPIFY?  
- Compara $$A[i], A[LEFT(i)], A[RIGHT(i)]$$.  
- Si es necesario, intercambia $A[i]$ con el mayor de sus hijos para preservar la propiedad del max-heap.  
- Continúa con el proceso bajando sobre el montículo hasta que el subárbol con raíz $i$ sea un max-heap.  

#### Ejemplo de MAX-HEAPIFY  

[Heap 11](Images/heap11.pdf)  
[Heap 12](Images/heap12.pdf)  
[Heap 13](Images/heap13.pdf)  

### Ejercicios  

**Aplicar el algoritmo MAX-HEAPIFY(A, 1) en los siguientes casos:**  

#### Ejercicio 1  

[Heap 14](Images/heap14.pdf)  

#### Ejercicio 2  
[Heap 15](Images/heap15.pdf)  

---

  ### ¿Qué hace la operación BUILD-MAX-HEAP?  

- Utiliza MAX-HEAPIFY para convertir un arreglo $A[1..n]$ en un max-heap.  

### Algoritmo BUILD-MAX-HEAP  

[BUILD-MAX-HEAP](Images/buildmax.pdf)  

### Ejemplo de BUILD-MAX-HEAP
 
[Paso 1](Images/b1.pdf)  
[Paso 2](Images/b2.pdf)  
[Paso 3](Images/b3.pdf)  
[Paso 4](Images/b4.pdf)  
[Paso 5](Images/b5.pdf)  
[Paso 6](Images/b6.pdf)  

### Ejercicio  

**Aplique BUILD-HEAP(A) para:**  

$$A = \{5, 7, 10, 1, 4, 6, 8, 2, 9, 12\}$$ con $$heap\_size(A) = 10$$  

---




