# Introducción a la Lógica Formal

La lógica formal es la disciplina que estudia las reglas del pensamiento válido. Nos permite razonar con precisión y fundamentar argumentos de forma rigurosa. En el contexto de la informática y las matemáticas, la lógica proporciona herramientas para demostrar propiedades y validar algoritmos o estructuras.

## Objetivos

* Comprender los principios básicos del razonamiento lógico.
* Identificar proposiciones, conectores lógicos y estructuras argumentativas.
* Introducir y aplicar métodos de demostración, como:
    - Demostración directa
    - Demostración por contraposición
    - Reducción al absurdo
    - Demostración por casos
    - Inducción matemática
    - Familiarizarse con entornos de prueba asistida como Coq, para realizar demostraciones formales.

## Usos

* Fundamento de las demostraciones matemáticas y del pensamiento riguroso.
* Base teórica para verificación formal de programas y sistemas.
* Se aplica en diseño de circuitos lógicos, algoritmos, y estructuras computacionales.
* Facilita la comprensión de lenguajes formales, gramáticas y semánticas en ciencias de la computación.

## Proposiciones y conectores lógicos

Una **proposición** es un enunciado declarativo al que se le puede asignar exactamente un valor de verdad: verdadero (V) o falso (F). Las proposiciones simples se combinan mediante **conectores lógicos** para formar proposiciones compuestas.

| Conector | Símbolo | Nombre | Verdadero cuando... |
|---|---|---|---|
| Negación | ¬p | NOT | p es falso |
| Conjunción | p ∧ q | AND | p y q son verdaderas |
| Disyunción | p ∨ q | OR | al menos una de p, q es verdadera |
| Condicional | p → q | IF...THEN | p es falsa, o q es verdadera |
| Bicondicional | p ↔ q | IFF | p y q tienen el mismo valor de verdad |

Tabla de verdad del condicional (la que más suele confundir, porque es falsa **solo** en un caso):

| p | q | p → q |
|---|---|---|
| V | V | V |
| V | F | F |
| F | V | V |
| F | F | V |

### Leyes lógicas importantes

* **Doble negación**: ¬(¬p) ≡ p
* **Leyes de De Morgan**: ¬(p ∧ q) ≡ ¬p ∨ ¬q,  ¬(p ∨ q) ≡ ¬p ∧ ¬q
* **Contrapositiva**: p → q ≡ ¬q → ¬p (esta equivalencia es la base de la demostración por contraposición)
* **Distributividad**: p ∧ (q ∨ r) ≡ (p ∧ q) ∨ (p ∧ r), y análogamente para ∨ sobre ∧

### Cuantificadores (lógica de predicados)

* **Universal** (∀x P(x)): "para todo x, se cumple P(x)". Basta un **contraejemplo** para refutarla.
* **Existencial** (∃x P(x)): "existe al menos un x tal que se cumple P(x)". Basta **un** ejemplo para probarla.
* Negación de cuantificadores: ¬(∀x P(x)) ≡ ∃x ¬P(x), y ¬(∃x P(x)) ≡ ∀x ¬P(x).

## Métodos de demostración (con ejemplo)

**Directa**: se asume la hipótesis y se deduce la tesis por una cadena de implicaciones.
> *Ejemplo*: si n es par, entonces n² es par. Sea n = 2k. Entonces n² = 4k² = 2(2k²), que es par.

**Por contraposición**: en vez de probar p → q, se prueba ¬q → ¬p (equivalentes por la ley de contrapositiva).
> *Ejemplo*: si n² es impar, entonces n es impar. Se prueba el contrarrecíproco: si n es par (n = 2k), entonces n² = 2(2k²) es par.

**Reducción al absurdo**: se asume la negación de la tesis junto con la hipótesis, y se llega a una contradicción.
> *Ejemplo clásico*: √2 es irracional. Se asume √2 = a/b (fracción irreducible) y se llega a que a y b son ambos pares, contradiciendo la irreducibilidad.

**Por casos**: se divide el dominio en casos que cubren todas las posibilidades y se demuestra la tesis en cada uno.
> *Ejemplo*: para todo entero n, n(n+1) es par. Caso n par: n(n+1) es par por tener un factor par. Caso n impar: n+1 es par, así que el producto también.

**Inducción matemática**: para probar P(n) para todo n ≥ n₀, se prueba (1) el **caso base** P(n₀), y (2) el **paso inductivo**: P(k) → P(k+1).
> *Ejemplo*: 1 + 2 + ... + n = n(n+1)/2. Base n=1: 1 = 1·2/2 ✓. Paso inductivo: si vale para k, entonces 1+...+k+(k+1) = k(k+1)/2 + (k+1) = (k+1)(k+2)/2, que es la fórmula para k+1.

## Relación con este curso

Estos métodos de demostración son la herramienta que se usa más adelante en el repositorio para justificar formalmente la **complejidad temporal y espacial** de los algoritmos (por ejemplo, probar por inducción que la recursión de un algoritmo divide-y-vencerás cumple cierta cota, o usar reducción al absurdo para argumentar por qué un algoritmo greedy como Kruskal o Prim produce un árbol de expansión mínimo). Ver `1_Logica_Formal/Coq/README.md` para el puente hacia la prueba asistida por computadora.
