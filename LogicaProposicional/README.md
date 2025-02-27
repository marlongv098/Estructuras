# Métodos de Demostración

## Introducción

En matemáticas, una demostración es un argumento lógico que establece la verdad de una proposición. Existen diversos métodos de demostración, cada uno adecuado para diferentes tipos de afirmaciones. A continuación, se describen algunos de los métodos más comunes.

## 1. Demostración Directa

Este método se usa cuando se parte de hipótesis verdaderas y se aplican reglas lógicas y propiedades matemáticas para llegar a la conclusión deseada.

**Ejemplo:** Demostrar que la suma de dos números pares es un número par.

**Demostración:**
Sean \( a \) y \( b \) dos números pares. Entonces existen enteros \( k \) y \( m \) tales que:
\[
    a = 2k, \quad b = 2m
\]
Sumando ambos números,
\[
    a + b = 2k + 2m = 2(k + m)
\]
Dado que \( k + m \) es un número entero, se concluye que \( a + b \) es par.

## 2. Demostración por Contraposición

Se basa en demostrar que la negación de la conclusión implica la negación de la hipótesis.

**Ejemplo:** Demostrar que si \( n^2 \) es impar, entonces \( n \) es impar.

**Demostración:**
Supongamos que \( n \) es par. Entonces \( n = 2k \) para algún entero \( k \). Elevando al cuadrado:
\[
    n^2 = (2k)^2 = 4k^2 = 2(2k^2)
\]
Como \( n^2 \) es múltiplo de 2, es par. Esto contradice la hipótesis, por lo que \( n \) debe ser impar.

## 3. Demostración por Reducción al Absurdo

Se asume que la proposición es falsa y se llega a una contradicción lógica.

**Ejemplo:** Demostrar que \( \sqrt{2} \) es irracional.

**Demostración:**
Supongamos que \( \sqrt{2} \) es racional. Entonces se puede escribir como \( \frac{p}{q} \), con \( p \) y \( q \) enteros primos entre sí. Elevando al cuadrado,
\[
    2 = \frac{p^2}{q^2} \Rightarrow p^2 = 2q^2
\]
Esto implica que \( p^2 \) es par, lo que implica que \( p \) también es par. Sea \( p = 2k \), entonces,
\[
    (2k)^2 = 2q^2 \Rightarrow 4k^2 = 2q^2 \Rightarrow q^2 = 2k^2
\]
Por lo tanto, \( q^2 \) es par, lo que implica que \( q \) también es par. Pero esto contradice la suposición de que \( p \) y \( q \) son primos entre sí. Por lo tanto, \( \sqrt{2} \) es irracional.

## 4. Demostración por Inducción Matemática

Se usa para demostrar afirmaciones sobre los números naturales.

**Ejemplo:** Demostrar que para todo \( n \geq 1 \):
\[
    1 + 2 + \dots + n = \frac{n(n+1)}{2}
\]

**Paso Base:** Para \( n = 1 \):
\[
    1 = \frac{1(1+1)}{2} = 1
\]
Lo cual es cierto.

**Paso Inductivo:** Supongamos que la fórmula es cierta para algún \( n = k \), es decir:
\[
    1 + 2 + \dots + k = \frac{k(k+1)}{2}
\]
Demostramos que es cierta para \( n = k + 1 \):
\[
    1 + 2 + \dots + k + (k+1) = \frac{k(k+1)}{2} + (k+1)
\]
Sacamos factor común \( k+1 \):
\[
    = \frac{k(k+1) + 2(k+1)}{2} = \frac{(k+1)(k+2)}{2}
\]
Que es la fórmula para \( n = k+1 \). Por lo tanto, la afirmación es verdadera para todo \( n \geq 1 \).

## Conclusión

Cada método de demostración tiene su utilidad y aplicación dependiendo del tipo de problema a resolver. La práctica y la comprensión de estos métodos son fundamentales en la matemática y otras disciplinas científicas.
