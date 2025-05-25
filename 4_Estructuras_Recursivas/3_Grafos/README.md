# GRAFOS

# Introducción

### ¿Cuándo fueron presentadas las ideas básicas sobre grafos?

Las ideas básicas fueron presentadas por el matemático suizo **Leonhard Euler** en el siglo XVIII.

### ¿Para qué utilizó Euler la noción de grafo?

Para resolver el famoso **problema de los puentes de Könisberg**.

---

### ¿Para qué se emplean los grafos?

- Diferenciar dos compuestos químicos con la misma fórmula molecular, pero diferente estructura.
- Estudiar la estructura de la **Red de Internet**.

---

# El problema de los puentes de Könisberg

### ¿Cuál es el problema?

Es un célebre problema matemático que fue resuelto por **Leonhard Euler** en 1736 y dio origen a la teoría de grafos.

- Dos islas en el río Pregel que cruza Könisberg se unen entre ellas y con la tierra firme mediante siete puentes.
- ¿Es posible dar un paseo empezando por cualquiera de las cuatro partes de tierra firme, cruzando cada puente una sola vez y volviendo al punto de partida?
- Euler, replanteando el problema usando teoría de grafos, descubrió que **no tiene solución**.

![Puentes de Könisberg](konisberg)

---

# Elementos del grafo

### ¿Qué son los vértices?

- Son uno de los elementos que forman un grafo.
- La teoría de grafos no se interesa por lo que *son* los vértices, sino por cómo se conectan.
- Pueden verse simplemente como **objetos**.
- Situaciones con objetos y relaciones que cumplen la definición de grafo pueden representarse como tal y analizarse con esta teoría.

---

### ¿Qué es un grafo?

Es una estructura discreta que consta de **vértices** y **aristas** que conectan entre sí esos vértices.

![Ejemplo de grafo](grafo1)

---

### ¿Cómo se diferencian los grafos?

- Se diferencian por el tipo y número de aristas que pueden conectar cada par de vértices.

---

### ¿Cuáles serían algunos ejemplos de grafos?

Muchas redes de uso cotidiano pueden representarse como grafos:

- Una red de **carreteras** que conecta ciudades
- Una red **eléctrica**
- El sistema de **drenaje** de una ciudad
- Una red de **transferencia de datos digitales**

# Tipos de grafos

### ¿Cuáles son los tipos de grafos?

- Grafo simple  
- Multigrafo  
- Pseudografo  
- Grafo dirigido  
- Multigrafo dirigido  

---

### ¿Qué es un grafo simple?

Un grafo simple $G = (V, E)$ consta de $V$, un conjunto no vacío de vértices, y de $E$, un conjunto de pares no ordenados de elementos distintos de $V$. A estos pares se les llama **aristas**.

![Grafo simple](grafo2)

---

### ¿Qué es un multigrafo?

Un multigrafo $G = (V, E)$ consta de un conjunto $V$ de vértices, un conjunto $E$ de aristas y una función $f$ de $E$ en  

<p align="center">
	{ { $u$, $v$ } | $u, v ∈ V, u ≠ v$ } 
</p>

                                       

Se dice que las aristas $e_1$ y $e_2$ son **múltiples o paralelas** si $f(e_1) = f(e_2)$.

![Multigrafo](grafo3)

---

### ¿Qué es un pseudografo?

Un pseudografo $G = (V, E)$ consta de un conjunto $V$ de vértices, un conjunto $E$ de aristas y una función $f$ de $E$ en  

<p align="center"> 
	{ { $u$, $v$ } | $u, v \in V$ }.  
 </p>
 
 Una arista $e$ es un **bucle o lazo** si $f(e) =$ { $u$, $u$ }= { $u$ } para algún $u \in V$.

![Pseudografo](grafo4)

---

### ¿Qué es un grafo dirigido?

Un grafo dirigido $G = (V, E)$ consta de un conjunto $V$ de vértices y de un conjunto $E$ de aristas, que son **pares ordenados** de elementos de $V$.

![Grafo dirigido](grafo5)

---

### ¿Qué es un multigrafo dirigido?

- Un multigrafo dirigido $G = (V, E)$ consta de un conjunto $V$ de vértices, un conjunto $E$ de aristas y una función $f$ de $E$ en  

<p align="center"> 
	{ { $u, v$ } | $u, v \in V$ }
 </p>

Se dice que las aristas $e_1$ y $e_2$ son **múltiples** si $f(e_1)=f(e_2)$.

![Multigrafo dirigido](directedmg)

---

### ¿Cuál es la terminología en teoría de grafos?

![Terminología en grafos](grafo7)


# Modelos con grafos

### ¿Cuáles son algunos modelos con grafos?

- Grafos de solapamiento de nichos en Ecología  
- Grafos de conocidos  
- Grafos de influencia  
- Grafo de Hollywood  
- Torneos de todos contra todos  
- Grafos de colaboración  
- Grafos de llamadas  
- Grafo de la web  
- Grafos de precedencia y procesamiento concurrente  

---

### ¿Cuáles son los grafos de solapamiento de nichos en Ecología?

Una arista no dirigida conecta dos vértices si las dos especies representadas por esos vértices **compiten entre sí**.

![Grafo de nichos ecológicos](grafo8)

---

### ¿Cuáles son los grafos de conocidos?

Se utilizan para representar **relaciones entre personas**.  
Cada vértice representa una persona y las aristas conectan personas que **se conocen**.

![Grafo de conocidos](grafo9)

---

### ¿Cuáles son los grafos de influencia?

Representan la **influencia de unas personas sobre otras**.

---

### ¿Cuál es el grafo de Hollywood?

Cada vértice representa un actor y hay una arista entre dos actores si **han trabajado juntos** en una película.

---

### ¿Cuál es el grafo de torneos de todos contra todos?

Cada vértice representa un equipo, y existe una arista de un equipo a otro si **le ha ganado**.

---

### ¿Cuáles son los grafos de colaboración?

Representan a personas y su **colaboración en artículos de investigación**.

---

### ¿Cuáles son los grafos de llamadas?

Representan las **llamadas telefónicas** en una red.

---

### ¿Cuál es el grafo de la Web?

La Web puede representarse como un grafo en el que:

- Cada **vértice** es un recurso accesible por una URL
- Existe una **arista** de un vértice a otro si hay un **enlace entre las páginas**

---

### ¿Cuáles son los grafos de precedencia y procesamiento concurrente?

Representan la **dependencia de ejecución** de sentencias respecto a otras que deben ejecutarse **previamente**.

# Adyacencia

### ¿Cuándo son dos vértices adyacentes en un grafo no dirigido?

Se dice que dos vértices $u$ y $v$ de un grafo no dirigido $G$ son adyacentes (vecinos) en $G$ si { $u, v$ } es una arista de $G$.

---

### ¿Qué más se puede decir a partir de la definición anterior?

Si $e =$ { $u, v$ }, se dice que la arista $e$ es incidente con los vértices $u$ y $v$. También se dice que la arista $e$ conecta $u$ y $v$. Se dice que los vértices $u$ y $v$ son extremos de la arista $e$.

---

### ¿Cuál es el grado de un vértice en un grafo no dirigido?

El grado de un vértice de un grafo no dirigido es el número de aristas incidentes con él,  exceptuando los bucles, cada uno de los cuales contribuye con **dos unidades** al grado del vértice.  El grado del vértice se denota por:

$$
\delta(v)
$$

---

### ¿Cuáles son los vértices aislados?

A los vértices de grado cero se les llama **aislados**.  Claramente, un vértice aislado **no es adyacente** a ningún otro vértice.

---

### ¿Qué es un vértice colgante?

Se dice que un vértice es **colgante**, o que es una **hoja**, si y sólo si tiene grado uno.

---

### ¿Qué se puede decir si $(u, v)$ es una arista del grafo dirigido $G$?

Si $(u, v)$ es una arista del grafo dirigido $G$, se dice que:

- $u$ es adyacente a $v$  
- $v$ es adyacente desde $u$  

Al vértice $u$ se le llama **vértice inicial** de $(u, v)$ y a $v$ se le llama **vértice final** o **terminal** de $(u, v)$. Los vértices inicial y final de un **bucle** coinciden.

---

### ¿Cuál es el teorema del apretón de manos?

**Teorema:**  
Sea $G = (V,E)$ un grafo no dirigido con $e$ aristas. Entonces:

$$
2e = \sum\limits_{v \in V} \delta(v)
$$

- Esto es cierto incluso cuando hay **aristas múltiples** y **bucles** en el grafo.
- ¿Cuántas aristas hay en un grafo con **10 vértices**, cada uno con grado **6**?

---

### ¿Qué característica especial tienen los vértices de un grafo no dirigido?

Todo grafo no dirigido tiene un número **par** de vértices de **grado impar**.

---

### ¿Cuál es el grado de entrada de un vértice en un grafo dirigido?

En un grafo dirigido, el grado de **entrada** de un vértice $v$, denotado por $\delta^-(v)$, es el número de aristas que tienen a $v$ como vértice final.

---

### ¿Cuál es el grado de salida de un vértice en un grafo dirigido?

En un grafo dirigido, el grado de **salida** de un vértice $v$, denotado por $\delta^+(v)$, es el número de aristas que tienen a $v$ como vértice inicial.

---

### ¿Cuál es la relación entre la sumatoria de los grados de entrada y salida en un grafo dirigido?

Sea $G = (V,E)$ un grafo dirigido. Entonces:

$$
\sum\limits_{v \in V} \delta^-(v) = \sum\limits_{v \in V} \delta^+(v) = |E|
$$

# Tipos de grafos simples

### ¿Cuáles son los tipos de grafos simples?

- Grafos completos  
- Ciclos  
- Ruedas  
- n-Cubos  

---

### ¿Cuáles son los grafos completos?

Un grafo completo de $n$ vértices, que se denota por:

$$
K_n
$$

es el grafo simple que contiene exactamente **una arista entre cada par de vértices distintos**.

![Grafo completo](grafo11)

---

### ¿Cuáles son los ciclos?

El ciclo $C_n$, con $n \geq 3$, consta de los vértices:

$$
v_1, v_2, \dots, v_n
$$

y las aristas:

<p align="center"> 
	{ $v_1, v_2$ }, { $v_2, v_3$ }, $\dots$, { $v_{n-1}, v_n$ }, { $v_n, v_1$ }
 </p>

![Ciclo](grafo12)

---

### ¿Cuáles son las ruedas?

Obtenemos la rueda $W_n$ cuando añadimos un vértice adicional al ciclo $C_n$, con $n \geq 3$, y conectamos este nuevo vértice con cada uno de los $n$ vértices de $C_n$ mediante una nueva arista.

![Rueda](grafo13)

---

### ¿Cuáles son los n-Cubos?

El **cubo n-dimensional**, o **n-cubo**, denotado por:

$$
Q_n
$$

es el grafo cuyos vértices representan las $2^n$ cadenas de bits de longitud $n$.  
Dos vértices son adyacentes **si y solo si** las cadenas de bits que representan difieren **exactamente en un bit**.

![n-Cubo](grafo14)


# Grafos bipartitos

### ¿Qué es un grafo bipartito?

Se dice que un grafo simple $G$ es bipartito si su conjunto de vértices $V$ se puede dividir en dos conjuntos disjuntos $V_1$ y $V_2$ tales que cada arista del grafo conecta un vértice de $V_1$ con un vértice de $V_2$, de manera que no haya ninguna arista que conecte entre sí dos vértices de $V_1$ ni tampoco dos vértices de $V_2$.

---

### Características adicionales

- Un grafo es bipartito si, y solo si, se pueden colorear los vértices del grafo con dos colores de modo que ningún par de vértices adyacentes sean del mismo color.
- También se considera grafo bipartito si cumple con la condición de que no sea posible empezar en un vértice y regresar a ese mismo vértice después de recorrer un número impar de aristas distintas.
- El grafo bipartito completo $K_{m, n}$ es el grafo cuyo conjunto de vértices está formado por dos subconjuntos con $m$ y $n$ vértices, respectivamente, y hay una arista entre dos vértices si, y sólo si, un vértice está en el primer subconjunto y el otro en el segundo.

---

# Ejemplos gráficos

![Grafo bipartito completo](grafo20)

![Otro ejemplo de grafo bipartito](grafo15)

# Operaciones entre grafos

### ¿Qué es un subgrafo?

Un **subgrafo** de un grafo $G = (V, E)$ es un grafo $H = (W, F)$ tal que:

$$
W \subseteq V \quad \text{y} \quad F \subseteq E
$$

![Subgrafo](grafo16)

---

### ¿Cómo es la unión entre grafos?

La **unión** de dos grafos simples $G_1 = (V_1, E_1)$ y $G_2 = (V_2, E_2)$ es el grafo simple cuyo conjunto de vértices es:

$$
V_1 \cup V_2
$$

y cuyo conjunto de aristas es:

$$
E_1 \cup E_2
$$

La unión de $G_1$ y $G_2$ se denota por $G_1 \cup G_2$.

---

### ¿Cómo es el grafo complementario?

El **grafo complementario** $\overline{G}$ de un grafo simple $G$ tiene los **mismos vértices** que $G$, y dos vértices son adyacentes en $\overline{G}$ **si, y sólo si**, **no son adyacentes en** $G$.

---

### ¿Cómo es el grafo recíproco?

El **recíproco** de un grafo dirigido $G = (V, E)$, que se denota por $G^c$, es el grafo dirigido $G^c = (V, F)$ tal que:

$$
(u, v) \in F \quad \text{si, y sólo si,} \quad (v, u) \in E
$$

# Representación de Grafos

### ¿Cómo representar un grafo?

- Existen muchas maneras útiles de representación de grafos.
- Al trabajar con un grafo, conviene tener la posibilidad de elegir su representación más conveniente.
- Entre las posibilidades de representación se encuentran:
  	- Listas de aristas
  	- Listas de adyacencia
  	- Matrices de adyacencia
  	- Matrices de incidencia

---

### ¿Qué es una lista de adyacencia?

- Es una forma de representar grafos sin aristas múltiples.
- Especifica los vértices que son adyacentes a cada uno de los vértices del grafo.

![Lista de adyacencia](grafo21)

---

### ¿Qué ocurre cuando el grafo es dirigido?

- Cuando el grafo es dirigido, una representación por listas de adyacencia enumera todos los vértices finales de las aristas que salen de cada uno de los vértices del grafo.

![Grafo dirigido con listas](grafo22)

---

### ¿Qué es una matriz de adyacencia?

- Sea $G = (V, E)$ un grafo simple con $|V| = n$.
- Se enumeran los vértices de $G$ de manera arbitraria como $v_1, v_2, ..., v_n$.
- La matriz de adyacencia $A$ (o $A_G$) de $G$ con respecto a este listado de los vértices es la matriz booleana $n \times n$ que tiene un $1$ en la posición $(i, j)$ si $v_i$ y $v_j$ son adyacentes, y tiene un $0$ en la posición $(i, j)$ si no lo son.
- También se expresa como: si la matriz de adyacencia es $A = [a_{ij}]$, entonces:

$$
a_{ij} =
\begin{cases}
1, & \text{si } \{v_i, v_j\} \text{ es una arista de } G \\
0, & \text{en caso contrario}
\end{cases}
$$

---

### ¿Qué más se puede decir sobre una matriz de adyacencia?

- Las matrices de adyacencia pueden usarse para representar grafos dirigidos con bucles y con aristas múltiples.
- Un bucle en el vértice $a_i$ se representa por medio de un $1$ en la posición $(i, i)$ de la matriz de adyacencia.
- Cuando hay aristas múltiples, la matriz de adyacencia deja de ser booleana, ya que el elemento en la posición $(i, j)$ de esta matriz es igual al número de aristas asociadas con $\{a_i, a_j\}$.

---

- Todos los grafos no dirigidos, incluyendo multigrafos y pseudografos, tienen matrices de adyacencia simétricas.
- La matriz de un grafo dirigido $G = (V, E)$ tiene un $1$ en su posición $(i, j)$ si hay una arista de $v_i$ a $v_j$, siendo $v_1, v_2, ..., v_n$ un listado arbitrario de los vértices del grafo dirigido.

![Matriz de adyacencia grafo dirigido](grafo23)

---

### ¿Qué es una matriz de incidencia?

- Sea $G = (V, E)$ un grafo no dirigido y $v_1, v_2, ..., v_n$ los vértices y $e_1, e_2, ..., e_m$ las aristas de $G$.
- Entonces la matriz de incidencia con respecto a este ordenamiento de $V$ y de $E$ es la matriz $M = [m_{ij}]$ de $n \times m$ dada por:

$$
m_{ij} =
\begin{cases}
1, & \text{si la arista } e_j \text{ es incidente con } v_i \\
0, & \text{en caso contrario}
\end{cases}
$$

![Matriz de incidencia](grafo24)



# Caminos, circuitos y conexión

### ¿Qué es un camino?

- Un camino es una secuencia de aristas que comienza en un vértice del grafo y recorre ciertas aristas del grafo, siempre conectando pares de vértices adyacentes.
- Sea $n$ un entero no negativo y sea $G$ un grafo no dirigido.
- Un camino de longitud $n$ de $u$ a $v$ en $G$ es una secuencia de $n$ aristas $a_1, a_2, \ldots, a_n$ de $G$ tal que:

  $$
  f(a_1) = \{x_0, x_1\},\quad f(a_2) = \{x_1, x_2\},\quad \ldots,\quad f(a_n) = \{x_{n-1}, x_n\},
  $$

  donde $x_0 = u$ y $x_n = v$.
- Si el grafo es simple, denotamos este camino por su secuencia de vértices:  
  $$x_0, x_1, \ldots, x_n$$  
  (ya que enumerar estos vértices determina el camino de forma única).

---

### ¿Qué es un circuito?

- El camino es un circuito si comienza y termina en el mismo vértice, esto es, si $u = v$, y tiene longitud mayor que cero.
- Se dice que el camino o circuito pasa por los vértices $x_1, x_2, \ldots, x_{n-1}$ o también que recorre las aristas $a_1, a_2, \ldots, a_n$.
- Un camino o circuito es *simple* si no contiene la misma arista más de una vez.

---

### ¿Cómo es la conexión en grafos no dirigidos?

- Se dice que un grafo no dirigido es *conexo* si hay un camino entre cada par de vértices distintos del grafo.
- Hay un camino simple entre cada par de vértices distintos de un grafo no dirigido conexo.
- Un grafo que no es conexo es la unión de dos o más subgrafos conexos que no tienen ningún vértice en común entre ellos.

---

### ¿Son conexos los siguientes grafos?

![Conexos](grafo29)

---

### ¿Qué es un vértice de corte?

- Se le llama *vértice de corte* o *punto de articulación* a aquel vértice que, al ser eliminado junto a todas las aristas incidentes en él, produce un subgrafo con más componentes conexas.
- Eliminar un vértice de corte de un grafo conexo produce un grafo que no es conexo.

### ¿Qué es una arista de corte?

- Una arista cuya eliminación produce un grafo con más componentes conexas que el grafo original se llama *arista de corte* o *puente*.

---

### ¿Cuáles son los vértices de corte y aristas de corte del siguiente grafo?

![Ejemplo](grafo30)

---

### ¿Cómo es la conexión en grafos dirigidos?

- Considerando la dirección de las aristas, estos grafos pueden ser *fuertemente conexos* o *débilmente conexos*.

### ¿Cuándo un grafo dirigido es fuertemente conexo?

- Se dice que un grafo dirigido es *fuertemente conexo* si hay un camino de $a$ a $b$ y un camino de $b$ a $a$ para cualesquiera dos vértices $a$ y $b$ del grafo.

### ¿Cuándo un grafo dirigido es débilmente conexo?

- Se dice que un grafo dirigido es *débilmente conexo* si hay un camino entre cada dos vértices del grafo no dirigido subyacente.


### ¿Qué es un circuito euleriano?

**Definición:**  
Un circuito euleriano de un grafo $G$ es un circuito simple que contiene a todas las aristas de $G$.

### ¿Qué es un camino euleriano?
**Definición:**  
Un camino euleriano es un camino simple que contiene a todas las aristas de $G$.

**Ejemplo:**  
¿Cuáles de los grafos no dirigidos de la siguiente figura contienen un circuito euleriano?  
Entre aquellos que no lo contienen, ¿cuáles contienen un camino euleriano?  

![graph3](graph3)

**Solución:**  
El grafo $G_1$ contiene un circuito euleriano, por ejemplo, $a,e,c,d,e,b,a.$  
Ni $G_2$ ni $G_3$ contienen un circuito euleriano.  
No obstante, $G_3$ contiene un camino euleriano, a saber, $a,c,d,e,b,d,a,b.$  
El grafo $G_2$ no contiene ningún camino euleriano.

**Ejemplo:**  
¿Cuáles de los grafos dirigidos de esta figura contienen un circuito euleriano?  
Entre aquellos que no lo contienen, ¿cuáles contienen un camino euleriano?  

![graph4](graph4)

### ¿Para qué pueden utilizarse los caminos y circuitos eulerianos?

**Aplicaciones:**
- Los caminos y circuitos eulerianos pueden utilizarse para resolver muchos problemas prácticos.
- En muchas aplicaciones se requiere hallar un camino o circuito que pase exactamente una vez por cada una de las calles de un barrio, cada una de las carreteras de una red vial, cada conexión de una red de distribución de agua, o cada enlace de una red de comunicaciones.
- Hallar un camino o un circuito euleriano en un modelo apropiado de grafos puede resolver este tipo de problemas.
- Por ejemplo, si un cartero puede hallar un camino euleriano en el grafo de las calles por las que debe repartir la correspondencia, este camino produce una ruta que pasa por cada calle exactamente una vez.
- Si no hay ningún camino euleriano, el cartero tendrá que pasar más de una vez por alguna de las calles.
- Otras áreas en las que se aplican los circuitos y caminos eulerianos son el diseño de circuitos impresos, redes de multidifusión, y también la biología molecular, donde se utilizan para secuenciar el ADN.

### ¿Qué es un camino hamiltoniano?
Un camino $x_0, x_1,..., x_{n-1},x_n$ del grafo $G = (V, E)$ es hamiltoniano si  
$V=\{x_0,x_1,..., x_{n-1},x_n\}$ y $x_i 
eq x_j$ para $0 \leq i< j \leq n.$

### ¿Qué es un circuito hamiltoniano?
Un circuito $x_0, x_1,..., x_{n-1},x_n,x_0$ con $n > 1$ del grafo $G = (V, E)$ es hamiltoniano si  
$x_0,x_1,..., x_{n-1},x_n$ es un camino hamiltoniano.

### ¿Cuál es el origen de esta terminología?
- El origen es un juego, el juego icosiano, inventado en 1857 por el matemático irlandés Sir William Rowan Hamilton.
- Consistía en un dodecaedro de madera, un poliedro de 12 caras, cada una un pentágono regular, con un alfiler saliendo de cada vértice y un trozo de cuerda.

![ham1](ham1)

- Los 20 vértices estaban etiquetados con el nombre de distintas ciudades del mundo.
- El objetivo era comenzar en una ciudad, viajar siguiendo las aristas visitando cada una de las otras 19 ciudades exactamente una vez, y terminar en la primera.
- El circuito seguido se marcaba utilizando la cuerda y los alfileres.

### ¿Qué pregunta puede ser equivalente al juego?
- ¿Hay algún circuito en el grafo, que se muestra a continuación, que pase por cada vértice exactamente una vez?

![ham2](ham2)

- Esto resuelve el juego, ya que este grafo es isomorfo al grafo de vértices y aristas del dodecaedro.

**Solución visual:**  
En la siguiente figura se presenta una solución del juego de Hamilton.  

![ham3](ham3)

**Ejemplo:**  
¿Cuáles de los grafos simples de esta figura contienen un circuito hamiltoniano o, si no, un camino hamiltoniano?  
\
![ham4](ham4)

**Solución:**  
$G_1$ contiene un circuito hamiltoniano: $a, b, c, d, e, a.$  
No hay circuitos hamiltonianos en $G_2$ (cualquier circuito que pase por todos los vértices debe contener dos veces la arista {$a$, $b$}).  
Pero $G_2$ contiene un camino hamiltoniano: $a, b, c, d.$  
El grafo $G_3$ no contiene ni circuito ni camino hamiltoniano, ya que cualquier camino debe usar más de una vez alguna de las aristas {$a$, $b$}, {$e$, $f$} o {$c$, $d$}.

---

### Ejercicios
**Tarea:**  
Comience la implementación de su estructura grafo utilizando listas de adyacencia y matriz de adyacencia.




