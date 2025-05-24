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



