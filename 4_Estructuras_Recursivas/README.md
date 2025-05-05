# Introducción

### ¿Qué es un árbol n-ario?

- Es una estructura recursiva en la que cada elemento puede tener cualquier número de subárboles n-arios asociados.  
- Generalización de los árboles binarios.  
- En este caso el orden de los subárboles no es importante.  
- No es necesario saber cuál subárbol es el primero o el último, sino simplemente saber que es un subárbol.

---

![Árbol N-ario Ejemplo 1](arboln1)

---

### ¿Qué conceptos se extienden de árboles binarios?

- **Nodo**: elemento del árbol  
- **Raíz**: nodo inicial del árbol  
- **Hoja**: nodo sin hijos  
- **Camino**: nodos entre dos elementos, incluyéndolos  
- **Rama**: camino entre la raíz y una hoja  
- **Altura**: número de nodos en la rama más larga  
- **Peso**: número de nodos en el árbol  

---

### Orden de un árbol n-ario

- **Orden de un elemento**:
  - Número de subárboles asociados
  - Una hoja es un elemento de orden 0
- **Orden de un árbol n-ario**:
  - Máximo orden de sus elementos

---

### ¿Cuál es el algoritmo preorden para un árbol n-ario?

- En este recorrido se incluye primero la raíz del árbol.  
- Luego se recorren en preorden todos los subárboles que tiene asociados.  
- El orden en el que se recorren los elementos del árbol no cumple ninguna propiedad particular.  
- Pero se garantiza que en el recorrido va a aparecer una vez cada uno de los elementos del árbol.

---

![Árbol N-ario Ejemplo 2](arboln2)

---

### ¿Qué es un camino en un árbol n-ario?

- Un camino entre dos elementos $·E_1$ y $E_2$ de un árbol n-ario es una secuencia de elementos presentes en el árbol $⟨N_1, ..., N_K⟩$ que cumple:
  1. $N_1 = E_1$
  2. $N_k = E_2$
  3. $N_i$ es el padre de $N_{i+1}$
- Dicha secuencia no necesariamente existe entre todo par de elementos del árbol.


### ¿Qué pasa si existe un camino entre $E_1$ y $E_2$?

- Se dice que $E_1$ es un **ancestro** de $E_2$.
- Se dice que $E_2$ es un **descendiente** de $E_1$.

---

### ¿Cómo se define la longitud de un camino?

- Se define como el **número de elementos de la secuencia menos 1**.

---

### ¿Qué es una rama?

- Una **rama** es un camino que lleva de la raíz a una hoja del árbol.
- Eso quiere decir que en un árbol existe el **mismo número de ramas que de hojas**.
- La **altura** de un árbol es la **longitud de la rama más larga más 1**.

---

### ¿Qué diferencia hay al insertar y eliminar respecto a los árboles binarios ordenados?

- Para agregar o suprimir un elemento, se debe indicar el **punto del árbol** donde se desea realizar la operación.
 	- Como **no hay un orden**, no sabríamos dónde insertar un nuevo elemento automáticamente.
 	- Se debe **dar el padre** al que se le va a insertar o eliminar un nodo hijo.
	

# Árbol n-ario genérico

### ¿Cómo sería la implementación genérica de un árbol n-ario?


```java
public class NodoArbolNArio<T> {
  private T elem;
  private List<NodoArbolNArio<T>> hijos;
  
}

public class ArbolNArio<T> {
  private NodoArbolNArio<T> raiz;
  
}
```
### ¿Cómo es la estructura de un algoritmo para árboles n-arios?

Similar a árboles binarios:
	* Primer nivel:
		* Trata el caso de un árbol vacío
		* Delega la responsabilidad
	* Segundo nivel:
		* Planteamiento recursivo
		* Se tienen n avances posibles en la recursión
		* Se requiere un ciclo para iterar sobre cada avance

### ¿Cómo sería el algoritmo de búsqueda?

* Implementamos el algoritmo en dos niveles:
	* Primer nivel: En la clase ArbolNArio
	* Segundo nivel: En la clase NodoArbolNArio

### Algoritmo de primer nivel
```java
public T buscar(T elemento) {
  if(raiz == null)
    return null;
  else
    return raiz.buscar(elemento);
}
```

### Algoritmo de segundo nivel

```java
public T buscar(T elemento) {
  if(elem.equals(elemento))
    return elem;
  else if(esHoja())
    return null;
  else {
    for(int i = 0; i < hijos.size(); i++) {
      T temp = hijos.get(i).buscar(elemento);
      if(temp != null)
        return temp;
    }
    return null;
  }
}

public boolean esHoja() {
  return (hijos.size() == 0);
}
```

### ¿Cómo sería el algoritmo darPeso() en el primer nivel?


```java
public int darPeso() {
  if(raiz == null)
    return 0;
  else
    return raiz.darPeso();
}
```
### ¿Cómo sería el algoritmo darPeso() en el segundo nivel?

```java
public int darPeso() {
  if(esHoja()) {
    return 1;
  } else {
    int pesoAcum = 1;
    for(int i = 0; i < hijos.size(); i++) {
      pesoAcum += hijos.get(i).darPeso();
    }
    return pesoAcum;
  }
}

public boolean esHoja() {
  return (hijos.size() == 0);
}
```

### ¿Cómo sería el algoritmo darNroHojas() en el primer nivel?

```java
public int darNroHojas() {
  if(raiz == null)
    return 0;
  else
    return raiz.darNroHojas();
}
```
### ¿Cómo sería el algoritmo darNroHojas() en el segundo nivel?

```java
public int darNroHojas() {
  if(esHoja()) {
    return 1;
  } else {
    int numHojas = 0;
    for(int i = 0; i < hijos.size(); i++) {
      numHojas += hijos.get(i).darNroHojas();
    }
    return numHojas;
  }
}

public boolean esHoja() {
  return (hijos.size() == 0);
}
```
### ¿Cómo sería el algoritmo darAltura() en el primer nivel?


```java
public int darAltura() {
  if(raiz == null)
    return 0;
  else
    return raiz.darAltura();
}
```

### ¿Cómo sería el algoritmo darAltura() en el segundo nivel?


```java
public int darAltura() {
  if(esHoja()) {
    return 1;
  } else {
    int maxAltura = 0;
    for(int i = 0; i < hijos.size(); i++) {
      NodoArbolNArio<T> hijo = hijos.get(i);
      int tempAltura = hijo.darAltura();
      if(tempAltura > maxAltura) {
        maxAltura = tempAltura;
      }
    }
    return maxAltura + 1;
  }
}
```
### ¿Cómo sería el algoritmo insertarElemento(T padre, T elemento) en el primer nivel?

```java
public void insertarElemento(T elementoPadre, T elemento) throws Exception {
  if(raiz == null) {
    NodoArbolNArio<T> nuevo = new NodoArbolNArio<T>();
    nuevo.setElem(elemento);
    raiz = nuevo;
  } else {
    NodoArbolNArio<T> padreTemp = buscarNodo(elementoPadre);
    if(padreTemp == null)
      throw new Exception("Padre no existe");
    else
      padreTemp.insertarElemento(elemento);
  }
}
```

### ¿Cómo sería el algoritmo insertarElemento(T elemento) en el segundo nivel?

```java
public void insertarElemento(T elemento) {
  NodoArbolNArio<T> nuevo = new NodoArbolNArio<T>();
  nuevo.setElem(elemento);
  hijos.add(nuevo);
}
```

### ¿Cómo sería el algoritmo eliminarElemento(T elemento) en el primer nivel?

```java
public void eliminarElemento(T elemento) throws Exception {
  if(raiz == null)
    throw new Exception("El árbol está vacío");
  else if(elemento.equals(raiz.getElem())) {
    if(raiz.esHoja())
      raiz = null;
    else
      throw new Exception("Imposible eliminar");
  } else {
    NodoArbolNArio<T> padre = buscarPadre(elemento);
    if(padre == null)
      throw new Exception("Nodo inválido");
    else
      padre.eliminarElemento(elemento);
  }
}
```

### ¿Cómo sería el algoritmo eliminarElemento(T elemento) en el segundo nivel?

```java
public void eliminarElemento(T elemento) throws Exception {
  for(int i = 0; i < hijos.size(); i++) {
    NodoArbolNArio<T> hijo = hijos.get(i);
    if(hijo.getElem().equals(elemento) && hijo.esHoja()) {
      hijos.remove(i); // corrección del método eliminar
      return;
    }
  }
  throw new Exception("No eliminable");
}
```

### ¿Cuáles son los patrones principales para los algoritmos sobre árboles n-arios?

* Descenso recursivo
* Recorrido total



