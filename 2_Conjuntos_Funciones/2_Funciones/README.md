# Introducción
En matemáticas, una función representa una relación entre dos conjuntos, donde a cada elemento del conjunto de partida (dominio) le corresponde exactamente un elemento del conjunto de llegada (codominio). Las funciones permiten modelar dependencias entre cantidades, analizar fenómenos naturales, y formalizar conceptos fundamentales en disciplinas como la informática, la física y la ingeniería.

Una función se denota comúnmente como:

$$
f : A \rightarrow B
$$

lo que significa que $f$ asigna a cada elemento de $A$ un único elemento de $B$.

## Objetivos

* Comprender la noción formal de función como asignación entre conjuntos.
* Identificar el dominio, codominio, imagen y preimagen de una función.
* Distinguir tipos de funciones: inyectiva, sobreyectiva y biyectiva.
* Analizar funciones crecientes y decrecientes en el contexto de los números reales.
* Aplicar operaciones básicas con funciones como suma y producto.

## Usos
* Matemáticas: Estudio de relaciones, límites, derivadas e integrales.
* Informática: Diseño de algoritmos, programación funcional y estructuras de datos.
* Ciencias naturales: Modelado de fenómenos físicos, biológicos y económicos.
* Educación: Construcción de funciones como herramienta de razonamiento lógico.

## Tipos de funciones

* **Inyectiva** (uno a uno): elementos distintos del dominio tienen imágenes distintas. Formalmente, f(x₁) = f(x₂) ⟹ x₁ = x₂.
* **Sobreyectiva** (sobre): todo elemento del codominio es imagen de al menos un elemento del dominio (Img(f) = B).
* **Biyectiva**: inyectiva y sobreyectiva a la vez; en ese caso existe la función inversa f⁻¹.

## Composición de funciones

Dadas f : A → B y g : B → C, la composición (g ∘ f) : A → C se define como (g ∘ f)(x) = g(f(x)). La composición es asociativa pero, en general, **no conmutativa**: (g ∘ f) ≠ (f ∘ g).

## Por qué esto importa para el análisis de algoritmos

La **notación Big-O**, que se usa en todo este repositorio para describir la complejidad temporal y espacial de los algoritmos, es formalmente una relación entre funciones: decir que un algoritmo es O(g(n)) significa que su función de costo real f(n) (tiempo o memoria en función del tamaño de entrada n) está acotada superiormente por c·g(n) para alguna constante c y n suficientemente grande, es decir:

$$
f(n) = O(g(n)) \iff \exists\, c > 0,\ n_0 \in \mathbb{N} \text{ tal que } f(n) \le c \cdot g(n) \ \forall n \ge n_0
$$

Así, cuando en los README de `3_Estructuras_NO_Recursivas/`, `4_Estructuras_Recursivas/` y `5_Grafos/` se afirma que una operación es "O(log n)" o "O(n²)", se está clasificando la función de costo real del algoritmo dentro de una familia de funciones (logarítmica, cuadrática, etc.) — el mismo concepto de función que se introduce aquí, aplicado al análisis de eficiencia.