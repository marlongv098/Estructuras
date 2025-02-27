# Métodos de demostración

**¿Qué es una demostración?**  Es un argumento en que se ha empleado una razonamiento lógico para demostrar la veracidad de algo.

**¿Cuándo un argumento es válido?**  Cuando las premisas o hipótesis verdaderas dan como resultado la conclusión verdadera.

**¿Qué forma tiene un teorema?**  $p → q$

**¿Qué tipo de demostraciones existen?** Directas e Indirectas ...

# Método directo

Se supone la(s) hipótesis y se emplea un proceso lógico deductivo para demostrar de manera directa la conclusión.

**Ejemplo**  La suma de enteros pares es par. Escribimos este enunciado en la forma $p → q$.  Si $n$ es par y $m$ es par, entonces $n + m$ es par

**Demostración:** Suponemos que la hipótesis de esta implicación es verdadera, es decir $n=2k$ y $m=2l$ donde $k$ y $l$ son enteros. Se sigue que
$n + m = 2k + 2l = 2(k + l)$ y sabemos que $k + l$ es un entero. Por tanto $n + m$ es par.

# Método indirecto

Para mostrar $p → q$ se muestra $¬q → ¬p$.

¿Por qué es válido el método de la contrarecíproca? $p → q$ es lógicamente equivalente a $¬q → ¬p$.
¿Qué significa que dos fórmulas sean lógicamente equivalentes? Los valores de verdad de ambas fórmulas siempre son iguales .
En ocasiones es más fácil demostrar su contrarecíproca que la implicación inicial

**Ejemplo** Para todo entero $n$, si $n^2$ es impar entonces $n$ es impar.

**Demostración** Como $p → q ≡ ¬q → ¬p$ lo anterior es equivalente a decir que para todo entero $n$, si $n$ es par, $n^2$ es par. 
Suponemos que la hipótesis de esta implicación es verdadera, es decir $n = 2k$ donde $k$ es un entero. Se sigue que $n^2 = 4k^2 = 2(2k^2)$. Por tanto $n^2$ se puede representar como $2m$ donde $m = 2k$ y concluimos que $n^2$ es par.