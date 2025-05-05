
# Introducción

###**¿Qué es un árbol AVL?**

- Es un árbol binario de búsqueda balanceado en altura.  
- Su nombre proviene de las iniciales de sus dos creadores, Adelson-Velskii y Landis.  
- Fue el primer ABB balanceado publicado en la historia.  
- Este árbol permite implementar las operaciones de diccionario, todas en tiempo logarítmico, gracias a la noción de balanceo que utiliza.

---

###**¿Cuál sería un concepto clave a la hora de hablar de balanceo en altura?**

**Definición de factor de balanceo**  
Se define el factor de balanceo de un nodo $v$ de un árbol binario como:

$$
fb(v) = \text{altura del subárbol derecho de } v - \text{altura del subárbol izquierdo de } v
$$

Mientras cada nodo de un árbol rojinegro tiene un color, en el AVL cada nodo tiene un `fb`.

---

### **¿Cuándo estaría balanceado en altura un árbol binario?**

- Estaría balanceado en altura si para cada nodo $v$, $|fb(v)| \leq 1.$  
- En particular, cada nodo de un AVL tendría un factor de balanceo 0, 1 o -1.

---

### **¿Qué propiedades debe cumplir un ABB para ser un árbol AVL?**

1. Los subárboles de cada nodo difieren en altura en 1 como máximo.  
2. Cada subárbol es un árbol AVL.

---

### **¿Qué beneficios brinda un árbol AVL?**

- Gracias al balanceo se garantiza que sus operaciones tengan un coste logarítmico.

**¿Qué operaciones difieren entre un árbol de búsqueda binaria y un AVL?**

- Inserción  
- Eliminación  

---

### Imágenes de AVL

![AVL Ejemplo 1](Images/avl1.pdf)

![AVL Ejemplo 2](Images/avl2.pdf)

---

### **¿Cuál sería el esquema de operaciones para la inserción y la eliminación en un árbol AVL?**

1. Realizar la operación como en un ABB.  
2. Rebalancear aquellos nodos desbalanceados.


# Rotaciones

### **¿Cómo solucionamos el problema de los nodos desbalanceados?**

- Se realiza, sobre ciertos nodos, una clase de operaciones que se conocen como *rotaciones*.  
- El objetivo es recuperar la condición de AVL:  
  - Arreglar los factores de balanceo  
  - Mantener el invariante de ABB  

---

### **¿Qué operaciones de rotación se utilizan?**

- Rotación a la izquierda  
- Rotación a la derecha  

---

### Imagen de rotaciones

![Rotaciones AVL](Images/avl3.pdf)

---

### **¿Qué se ha de notar con respecto a estas rotaciones?**

- Estas operaciones son independientes de cualquier noción de balanceo.  
- Son aplicables en cualquier ABB, puesto que preservan el invariante de representación de estos árboles.  
- Al aplicar cualquiera de las rotaciones a un ABB, el resultado es otro ABB.  
- Las dos operaciones son una inversa de la otra.  

---

### ¿Qué hace `LEFT-ROTATE(x)`?

![Rotación izquierda](Images/avl3.pdf)

- Toma un nodo $x$, que debe tener un hijo derecho $y$  
- Rota hacia la izquierda a $x$, dejando a $y$ como raíz del subárbol  
- Cuelga a la derecha de $x$ el subárbol izquierdo de $y$ (si hubiera uno).  
- Nótese que al rotar a $x$ a la izquierda, estamos bajando a este nodo y levantando al nodo $y$.  

---

### ¿Qué hace `RIGHT-ROTATE(y)`?

![Rotación derecha](Images/avl3.pdf)

- Toma un nodo $y$, que debe tener un hijo izquierdo $x$  
- Rota hacia la derecha a $y$, dejando a $x$ como raíz del subárbol  
- Cuelga a la izquierda de $y$ el subárbol derecho de $x$ (si hubiera uno).  
- Nótese que al rotar a $y$ a la derecha, estamos bajando a este nodo y levantando al nodo $x$.  

### Rotaciones en ABB

**¿Intuitivamente, cómo se utilizarán estas operaciones?**

- Utilizaremos `LEFT-ROTATE(x)` para trasladar un poco del peso del subárbol derecho hacia el izquierdo.  
- `RIGHT-ROTATE(y)`, contrariamente, para llevar peso del subárbol izquierdo hacia el derecho.  
- En este caso, cuando hablamos de *peso*, no nos referimos a una cantidad de nodos sino a una *altura*, que es aquello que intentamos balancear.  

---

# Casos de desbalanceo

### **¿Qué se debe hacer cuando al realizar una inserción o eliminación algunos factores de balanceo son estrictamente mayores que 1?**

- Resulta conveniente resolver cada uno de estos problemas progresivamente.  
- Rebalanceando los nodos más profundos.  
- Continuando hacia los más cercanos a la raíz.  
- Por esta razón, es útil plantearse los distintos escenarios en los que tenemos un subárbol cuya raíz está desbalanceada en una unidad (es decir, tiene factor de balanceo -2 o 2), pero tal que todo otro nodo debajo de dicho nodo está balanceado.  

---

### Análisis de caso: fb(p) = 2

![Subárbol desbalanceado](Images/avl4.pdf)

- Llamemos $p$ a la raíz de un subárbol.  
- Se toma el caso $fb(p) = 2$.  
- Supongamos que el subárbol izquierdo de $p$ tiene altura $h$.  
- El subárbol derecho de $p$ tiene altura $h + 2$.  
- Este subárbol derecho debe tener al menos dos nodos, con lo cual podemos nombrar $q$ a su raíz.  

---

### **¿Qué hacemos ahora?**

- Dividimos nuevamente en casos, según el valor de $fb(q)$.  
- Como asumimos que todos los nodos debajo de $p$ están balanceados, debe ser $fb(q) \in \{-1, 0, 1\}$.  

---

### Caso A: $fb(q) = 1$

- Esto determina las alturas de ambos subárboles de $q$.  
- Como el subárbol derecho de $p$ es mucho más alto que el izquierdo, debemos realizar algún tipo de rotación que traslade peso desde la derecha hacia la izquierda.  
- Se ejecuta `LEFT-ROTATE(p)` y se restablece el balance.  

![Caso A](Images/avl5.pdf)

---

### Caso B: $fb(q) = 0$

- De nuevo, el subárbol derecho de $p$ es más alto que el izquierdo.  
- Se ejecuta `LEFT-ROTATE(p)` y se restablece el balance.  

![Caso B](Images/avl6.pdf)

---

### Caso C: $fb(q) = -1`

- Este caso requiere un tratamiento especial.  
- Se verá con una doble rotación: primero `RIGHT-ROTATE(q)`, luego `LEFT-ROTATE(p)`.

![Caso C](Images/avl7.pdf)

---

### Casos de desbalanceo (continuación)

**¿Qué casos restan?**

- Cuando $fb(p) = -2$  
- Dividimos nuevamente en casos según el valor de $fb(q)$  
- Como asumimos que todos los nodos debajo de $p$ están balanceados, debe ser $fb(q) \in \{-1, 0, 1\}$.  
- Estos casos son completamente simétricos a los tres previos (A, B y C).  

---

### Caso D: $fb(q) = -1$

![Caso D](Iamges/avl8.pdf)

---

### Caso E: $fb(q) = 0$

![Caso E](Images/avl9.pdf)

---

### Caso F: $fb(q) = 1$

![Caso F](Images/avl10.pdf)

---

# Inserción

### **¿Cómo es la inserción de un nodo en un árbol AVL?**

- La inserción en un AVL agrega un nuevo nodo como una hoja del árbol.  
- Esto implica que sólo pueden cambiar los factores de balanceo de nodos que se encuentren en el camino entre la raíz y el nodo agregado.  
- Si se logra rebalancear cada factor desbalanceado a lo largo de este camino, se restablecería el balance en todo el árbol.  
- Esta idea motiva el algoritmo de inserción sobre árboles AVL.  

---

### **¿Cuál es el pseudocódigo para el algoritmo de inserción en un árbol AVL?**

![Pseudocódigo de inserción](Images/avl11.pdf)

---

### **¿Cuál es el pseudocódigo para el rebalanceo en un árbol AVL?**

![Pseudocódigo de rebalanceo](Images/avl12.pdf)

---

# Ejemplos de Inserción

### **Dado $T$, siga el algoritmo `AVL-TREE-INSERT(T, 7)`**

![AVL Insertar 7](Images/av1.pdf)

---

### **Dado $T$, siga el algoritmo `AVL-TREE-INSERT(T, 5)`**

![AVL Insertar 5](Images/av1.pdf)

---

### **Dado $T$, siga el algoritmo `AVL-TREE-INSERT(T, 1)`**

![AVL Insertar 1](Images/av2.pdf)

---

### **Dado $T$, siga el algoritmo `AVL-TREE-INSERT(T, 4)`**

![AVL Insertar 4](Images/av2.pdf)



