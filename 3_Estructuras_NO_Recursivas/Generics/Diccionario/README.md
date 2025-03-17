📦  Diccionario

┣ 📂 src

┃ ┣ 📂 main

┃ ┃ ┣ 📂 java

┃ ┃ ┃ ┣ 📂 diccionario

┃ ┃ ┃ ┃ ┣   📜  Diccionario

┃ ┃ ┃ ┃ ┣  📜  DiccionarioIntefaz

┃ ┃ ┃ ┣ 📂 tablahash

┃ ┃ ┃ ┃ ┣  📜 TablaHash

┃ ┃ ┃ ┃ ┣  📜  TablaHashInterfaz

┃ ┃ ┃ ┣ 📂 ui

┃ ┃ ┃ ┃ ┣  📜  Main

┃ ┣ 📂 test

┃ ┃ ┣ 📂  java 

┃ ┃ ┃ ┣ 📂 diccionario

┃ ┃ ┃ ┃ ┣   📜 DiccionarioTest

┃ ┃ ┃ ┣ 📂 tablahash

┃ ┃ ┃ ┃ ┣   📜  TablaHashTest


## Diccionarios

### ¿Qué es una estructura de datos de tipo Diccionario?

- Es una estructura utilizada para manipular objetos en la que se insertan y extraen elementos periódicamente.
- Se puede verificar si un elemento específico pertenece o no a la colección.

### ¿Cómo se conocen los diccionarios?

- **Arreglos asociativos** o **Mapas**.

### ¿Qué tiene cada elemento en un diccionario?

- Cada elemento tiene:
  - **Una clave (key)**.
  - **Un valor asociado (value)** a esa clave.

- La analogía con un diccionario del mundo real es que:
  - **Las palabras** representan las claves.
  - **Las definiciones** representan los valores asociados a esas claves.

### ¿Cómo almacena los datos un diccionario?

- A través de pares:
- **(clave, valor)**.
- Los datos almacenados en la estructura son los **valores**.
- La **clave** se usa para buscar y encontrar los valores requeridos.

### ¿En qué ejemplos del mundo real se pueden usar diccionarios?

[Diccionario](https://github.com/marlongv098/Estructuras/blob/master/3_Estructuras_NO_Recursivas/Generics/Diccionario/src/main/java/diccionario/Diccionario.java)

### ¿Cuál es la diferencia entre un array y un diccionario?

- En un **array**, la clave debe ser un número (entero positivo o no negativo).
- En un **diccionario**, la clave puede ser cualquier tipo de objeto.

### ¿Qué suelen ser estas claves?

- Un conjunto de valores aleatorios como números reales o cadenas de texto.
- **Cada clave debe ser única** dentro del diccionario.

### ¿Qué operaciones básicas define esta estructura de datos?

- $void Add(K key, V value)$ → Agregar un par clave-valor.
- $V Get(K key)$ → Obtener el valor asociado a una clave.
- $boolean Remove(K key)$ → Eliminar un par clave-valor.

### ¿Qué métodos adicionales pueden existir?

- $boolean Contains(K key)$ → Verificar si una clave está en el diccionario.
- $int Count()$ → Obtener la cantidad de elementos almacenados.

---

### ¿Por qué es importante la implementación de operaciones en un diccionario?

- Muchas aplicaciones requieren un conjunto dinámico que soporte únicamente las operaciones **INSERTAR, BUSCAR y ELIMINAR**.

### ¿Algunos ejemplos?

- **Compiladores** (traductores de lenguajes de programación):
  - Mantienen una **tabla de símbolos**.
  - En ella, las claves son **cadenas de caracteres arbitrarias** que corresponden a identificadores en el lenguaje.

### ¿Cuál es una forma eficiente de implementar diccionarios?

- **Utilizando tablas hash**.

[Tabla Hash](https://github.com/marlongv098/Estructuras/blob/master/3_Estructuras_NO_Recursivas/Generics/Diccionario/src/main/java/tablahash/TablaHash.java)

### ¿Por qué?

- Aunque en el peor caso la búsqueda en una tabla hash puede tardar **Θ(n)**, en la práctica el rendimiento es muy bueno.
- Bajo suposiciones razonables, el **tiempo promedio de búsqueda** en una tabla hash es **O(1)**.

### ¿Qué hace una tabla hash?

- Generaliza la noción de un **array ordinario**.
- **Acceder directamente** a una posición en un array se hace en **O(1)**.
- Cuando se pueden asignar posiciones a todas las claves posibles, **los arrays son eficientes**.
- Si el número de claves almacenadas es pequeño en comparación con el número total de claves posibles, las **tablas hash son una alternativa efectiva**.

# Direccionamiento Directo

### ¿Qué es el direccionamiento directo?

- Es una técnica sencilla que funciona bien cuando el universo $U$ de claves es relativamente pequeño.
- Supongamos que una aplicación necesita un conjunto dinámico en el que cada elemento tiene una clave tomada del universo $U = {0,1,...,m-1}$, donde $m$ no es muy grande y no hay dos elementos con la misma clave.
	- Para representar el conjunto dinámico, se usa un **array** o **tabla de direccionamiento directo**, denotado como $T[0..m-1]$.
	- Cada posición o **slot** en el array corresponde a una clave en el universo $U$.
	- El **slot $k$** apunta a un elemento del conjunto con clave $k$.
	- Si el conjunto no contiene un elemento con clave $k$, entonces $T[k] = NIL$.

### ¿Cómo sería la implementación de operaciones en un diccionario usando direccionamiento directo?

```java
// Búsqueda en direccionamiento directo
T[k] 

// Inserción en direccionamiento directo
T[x.key] = x 

// Eliminación en direccionamiento directo
T[x.key] = NIL 
```

Cada una de estas operaciones tiene un tiempo de ejecución de $O(1)$.

### Ejemplo

Dado el universo $U={0,1,...,9}$ y el conjunto de claves $K={2,3,5,8}$:

[Directo](Images/hash.pdf)

### ¿Cuál es la desventaja del direccionamiento directo?

* Si el universo $U$ es muy grande, almacenar una tabla $T$ de tamaño $|U|$ puede ser impráctico o incluso imposible debido a las limitaciones de memoria de un ordenador típico.
* Si $|K|<<|U|$ la mayor parte del espacio reservado para $T$ sería desperdiciado.

### ¿Qué hacer si $|K|<<|U|$?

* Usar una tabla hash, ya que requiere mucho menos almacenamiento que una tabla de direccionamiento directo.
* Se puede reducir el requisito de almacenamiento a $Θ(|K|)$.
* Se mantiene la ventaja de que la búsqueda de un elemento en la tabla hash sigue requiriendo solo $O(1)$ en el caso promedio. Sin embargo, en el peor caso puede tomar más tiempo.

### ¿Qué es el hashing?

* Mientras que en el direccionamiento directo un elemento con clave $k$ se almacena en la posición $k$, con hashing se almacena en la posición $h(k)$. Se utiliza una función hash $h$ para calcular la posición a partir de la clave $k$.
* La función $h$ mapea el universo $U$ de claves en los slots de una tabla hash $T[0..m−1]$.

### Representación matemática

$$
h:U→{0,1,...,m−1}
$$

* Donde $m<<|U|$ y cada elemento tiene una clave distinta $h(k)$ es el valor hash de la clave $k$.
* La función hash reduce el rango de índices del array y, por lo tanto, el tamaño del array.
* En lugar de tener un tamaño de $|U|$, la tabla puede tener un tamaño de $m$.

[HashMap](Images/hash1.pdf)


### ¿Cuál es el problema con esta solución?

- **Dos claves pueden generar el mismo valor hash**, es decir, pueden ser asignadas al mismo espacio en la tabla.
- A esta situación se le llama **colisión**.

### ¿Cómo resolver el problema de las colisiones?

- La solución ideal sería evitarlas por completo:
	- Elegir una función de hash $h$ adecuada.
	- Hacer que $h$ parezca aleatoria para minimizar las colisiones.
	- Sin embargo, dado que $|U| > m$, al menos dos claves deben compartir el mismo valor hash, por lo que **es imposible evitarlas por completo**.

---

### ¿Cuál es otra manera de resolver este problema?

- Mediante técnicas de **resolución de colisiones**, como **encadenamiento**.

#### ¿Qué es el encadenamiento?

- Es un mecanismo donde todos los elementos que generan el mismo hash se agrupan en una **lista enlazada**.
- El **espacio $j$ de la tabla contiene un puntero** a la cabeza de la lista de elementos que tienen el mismo hash.
- Si no hay elementos en ese espacio, **contiene NIL**.

[Encadenamiento](Images/hash2.pdf)

---

### Implementación de operaciones en diccionario usando hash y encadenamiento

```java
// Inserción en hash con encadenamiento
CHAINED-HASH-INSERT(T, x)
  insertar x al inicio de la lista T[h(x.key)]

// Búsqueda en hash con encadenamiento
CHAINED-HASH-SEARCH(T, k)
  buscar un elemento con clave k en la lista T[h(k)]

// Eliminación en hash con encadenamiento
CHAINED-HASH-DELETE(T, x)
  eliminar x de la lista T[h(x.key)]
```

### ¿Cuáles son los tiempos de ejecución de estas operaciones?
* Inserción: $O(1)$ en el peor caso.
* Búsqueda: depende de la longitud de la lista, en el peor caso puede ser $O(n)$.
* Eliminación: $O(1)$ si las listas están doblemente enlazadas.

Nota: En la eliminación, la función CHAINED-HASH-DELETE recibe el elemento $x$ en lugar de su clave $k$, para evitar una búsqueda adicional.

### ¿Cuánto tiempo toma buscar un elemento en una tabla hash con encadenamiento?

* Sea una tabla hash $T$ con $m$ espacios y $n$ elementos. Se define el factor de carga $α$ como: $\alpha$ de $T$ como $\frac{n}{m}$
* $\alpha$ representa el número promedio de elementos en cada lista.
* En el peor caso, todas las claves colisionan en el mismo espacio, generando una lista de longitud $n$. En este caso, el tiempo de búsqueda sería $Θ(n)$, más el tiempo para calcular la función hash.
* Conclusión: No usamos tablas hash por su rendimiento en el peor caso, sino por su rendimiento en promedio.

### Rendimiento promedio

* El rendimiento promedio del hashing con encadenamiento depende de qué tan bien la función hash $h$ distribuya uniformemente los elementos.
* Se asume hashing uniforme simple, donde cada elemento es igualmente probable de ser asignado a cualquier espacio en la tabla.

### Casos de búsqueda:

* Búsqueda sin éxito: no hay un elemento con clave $k$.
* Búsqueda exitosa: encontramos un elemento con clave $k$.


### Teoremas:

* Búsqueda sin éxito: en promedio, toma tiempo $Θ(1+\alpha)$.
* Búsqueda exitosa: en promedio, toma tiempo $Θ(1+\alpha)$.

**Nota:** ambos resultados bajo el supuesto de estar haciendo hashing uniforme.

### ¿Qué significa este análisis?

* Si el número de espacios en la tabla es proporcional al número de elementos, es decir, $n=O(m)$ 

$$
 \alpha=O(m)/m=O(1)
$$

* La búsqueda toma tiempo constante en promedio.
* Todas las operaciones del diccionario pueden realizarse en $O(1)$ en promedio.

# Funciones Hash 

### ¿Qué hace que una función hash sea buena?

- Que satisfaga (aproximadamente) la suposición de hashing uniforme simple.
- Es decir, que cada clave tenga la misma probabilidad de dispersarse en cualquiera de los $m$ espacios, independientemente de dónde hayan sido asignadas otras claves.
- Desafortunadamente, típicamente no tenemos forma de verificar esta condición.
- Rara vez conocemos la distribución de probabilidad de la que provienen las claves.

---

### Ejemplo: Identificadores similares

- Es bastante común en un programa tener nombres de identificadores similares, como `var1`, `var2`, etc.
- Una buena función hash debe asignarlos a diferentes espacios.
- De esta manera, se puede observar la independencia entre cada par de claves.

---

### Ejemplo: Distribución conocida de claves

- Ocasionalmente, conocemos la distribución de las claves.
- Si sabemos que las claves son números reales aleatorios  $k$, distribuidos de manera uniforme e independiente en el rango $0 \leq k \leq 1$, entonces la función hash:

$$
h(k) = \lfloor km \rfloor
$$

  satisface la condición de hashing uniforme simple.

---

### ¿Qué hacer si las claves son cadenas de texto?

- La mayoría de las funciones hash asumen que el universo de claves es el conjunto $\mathbb{N} = \{0,1,...\}$.
- Si las claves no son números naturales, debemos encontrar una forma de interpretarlas como tales.
- Para interpretar una cadena de texto, podemos usar la tabla ASCII, que asigna valores entre 0 y 127 a los caracteres.
- Podemos interpretar el identificador $pt$ como el par de enteros decimales $(112, 116)$, ya que en ASCII:
	- $p = 112$
	- $t = 116$
- Finalmente, lo expresamos como un número en base 128:

$$
pt = 112 \times 128^1 + 116 \times 128^0 = 14452
$$


# Métodos para crear funciones hash

### Método de división

- $h(k) = k \mod m$
- En este caso, $m$ no debe ser una potencia de $2$.
- Si $m = 2^p$, entonces $h(k)$ son simplemente los $p$ bits menos significativos de $k$.
- Una buena elección para $m$ suele ser un número primo que no esté demasiado cerca de una potencia de $2$.

---

### Ejemplo: Método de división con $m = 2^3 = 8$

Aquí, $h(k)$ corresponde a los 3 bits menos significativos de $k$:

- $k = 8 \quad \longrightarrow \quad 8 \mod 8 = 0 \quad \longrightarrow \quad 1\underline{000}$
- $k = 16 \quad \longrightarrow \quad 16 \mod 8 = 0 \quad \longrightarrow \quad 10\underline{000}$
- $k = 24 \quad \longrightarrow \quad 24 \mod 8 = 0 \quad \longrightarrow \quad 11\underline{000}$
- $k = 4 \quad \longrightarrow \quad 4 \mod 8 = 4 \quad \longrightarrow \quad \underline{100}$
- $k = 12 \quad \longrightarrow \quad 12 \mod 8 = 4 \quad \longrightarrow \quad 1\underline{100}$
- $k = 20 \quad \longrightarrow \quad 20 \mod 8 = 4 \quad \longrightarrow \quad 10\underline{100}$
- $k = 28 \quad \longrightarrow \quad 28 \mod 8 = 4 \quad \longrightarrow \quad 11\underline{100}$

---

### Método de multiplicación

- $h(k) = \lfloor m \times (k \cdot A \mod 1) \rfloor$
- Donde $k \cdot A \mod 1$ es la parte fraccionaria de $k \cdot A$, es decir, $(k \cdot A - \lfloor k \cdot A \rfloor)$.
- Se debe cumplir que  $0 < A < 1$.

---

### Consideraciones sobre el método de multiplicación

- El valor de $m$ no es crítico.
- No es necesario evitar ciertos valores de $m$ como en el método de división.
- Comúnmente, $m$ se elige como una potencia de $2$ ( $m = 2^p$ para algún entero $p$).
- Esto simplifica los cálculos.

---

### Elección óptima del valor de $A$

- Aunque este método funciona con cualquier valor de la constante $A$, algunos valores ofrecen mejores resultados.
- La elección óptima depende de las características de los datos a dispersar. **Knuth** sugiere usar $A\approx(\sqrt{5} - 1)/2=0.6180339887...$.

---

### Hashing universal

- En el hashing universal, al inicio de la ejecución se selecciona aleatoriamente una función hash de una clase cuidadosamente diseñada.
- Sea $\mathcal{H} = \{h_1, h_2, ..., h_l\}$ una colección finita de funciones hash que asignan un universo $U$ de claves al rango $\{0,1,...,m-1\}$.
- Dicha colección se considera **universal** si, para cada par de claves distintas $x, y \in U$, la cantidad de funciones hash $h \in \mathcal{H}$ que cumplen $h(x) = h(y)$ es como máximo $|\mathcal{H}| / m$.
- En otras palabras, al elegir una función hash al azar de $\mathcal{H}$, la probabilidad de colisión entre dos claves distintas  $x, y$ no es mayor que $1/m$, lo que equivale a una asignación aleatoria e independiente en el rango $\{0,1,...,m-1\}$.



