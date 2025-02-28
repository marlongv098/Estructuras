# Fundamentos de Conjuntos

#### ¿Qué es un conjunto?

**Definición:**  
Es una colección desordenada de objetos.

**Ejemplos:**  
- $$V = \{a,e,i,o,u\}$$, el conjunto de las vocales.  
- $$\mathbb{N} = \{0,1,2,3,\dots\}$$, el conjunto de los números naturales.  
- $$\mathbb{Z} = \{\dots, -3,-2,-1,0,1,2,3,\dots\}$$, el conjunto de los números enteros.

---

### Preguntas de interés

#### ¿Qué es un elemento de un conjunto?

**Definición:**  
Los objetos de un conjunto se llaman también *elementos* o *miembros* del conjunto. Se dice que un conjunto contiene a sus elementos. Cuando un objeto es un elemento de un conjunto, se dice que **pertenece** a dicho conjunto.

**Ejemplos:**  
- $$a \in \{a,e,i,o,u\}$$  
- $$-1 \notin \mathbb{N}$$  
- $$0 \in \mathbb{Z}$$

---

### Preguntas de interés

#### ¿Cómo se puede definir un conjunto?

Se define por **extensión** y por **comprensión**.

**Ejemplos:**  
- **Por extensión:**  
  $$a \in \{a,e,i,o,u\}$$  
- **Por comprensión:**  
  $$\{x \mid x \text{ es una vocal}\}$$

---

### Preguntas de interés

#### ¿Cuándo son iguales dos conjuntos?

**Definición:**  
Dos conjuntos son iguales si, y sólo si, tienen los mismos elementos.

**Axioma de extensionalidad:**  
Si todo elemento de $$A$$ pertenece a $$B$$ y todo elemento de $$B$$ pertenece a $$A$$, entonces los conjuntos son iguales. Escribimos:  
$$A = B$$

**Ejemplos:**  
- $$\{1,2,3\} = \{3,2,1\}$$  
- $$\{1,2,3\} = \{1,1,1,1,2,2,2,3,3\}$$

**Nota:** Para probar que dos conjuntos son iguales, se debe demostrar que:  
$$A \subseteq B$$  
y  
$$B \subseteq A$$

---

### Preguntas de interés

#### ¿Qué es un diagrama de Venn?

**Definición:**  
Representación gráfica de conjuntos.

**Ejemplo:**  

![Diagrama de Venn](venn-numbers)

*Nota: Asegúrate de tener la imagen "venn-numbers" en la ruta adecuada o ajusta el path según corresponda.*

---

### Preguntas de interés

#### ¿Qué es la relación de inclusión?

**Definición:**  
Se dice que el conjunto $$A$$ es subconjunto de $$B$$, denotado por $$A \subseteq B$$, si todo elemento de $$A$$ es elemento de $$B$$.

**Ejemplos:**  
- $$\{e,u\} \subseteq \{a,e,i,o,u\}$$  
- $$\{-1,0,1\} \subseteq \mathbb{Z}$$

---

### Conjunto vacío

**Definición:**  
En ocasiones, existen en matemáticas conjuntos que carecen de elementos. A este conjunto se le denomina **Conjunto vacío**. Se puede simbolizar como $$\{\}$$ o $$\emptyset$$.

La existencia de este conjunto se establece como un axioma.

**Axioma del conjunto vacío:**  
Existe un conjunto que no tiene elementos.

---

### Subconjuntos

**Teorema:**  
Para cualquier conjunto $$S$$ se cumple:
1. $$\emptyset \subseteq S$$  
2. $$S \subseteq S$$

---

### Tamaño o número de elementos

#### ¿Cómo se denomina el número de elementos de un conjunto?

**Definición:**  
El número de elementos distintos de un conjunto $$A$$ se denomina **Cardinalidad** de $$A$$. Se simboliza como $$\#(A)$$, $$Car(A)$$ o $$|A|$$.

**Ejemplos:**  
- $$|\{a,e,i,o,u\}| = 5$$  
- $$|\{x \mid x \text{ es un dígito}\}| = 10$$  
- $$|\emptyset| = 0$$

**Definición adicional:**  
Un conjunto **finito** es un conjunto con una cantidad finita de elementos. De lo contrario, se denomina conjunto **infinito**.
