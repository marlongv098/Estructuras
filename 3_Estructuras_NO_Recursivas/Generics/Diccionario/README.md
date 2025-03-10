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








