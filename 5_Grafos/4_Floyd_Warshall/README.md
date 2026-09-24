# Floyd-Warshall — Caminos Más Cortos entre Todos los Pares

> Antes de este trabajo esta carpeta solo tenía un `README.md` vacío. Se implementó el algoritmo completo como proyecto Maven, con pruebas y esta documentación. Para la teoría general de grafos ver el [README principal de `5_Grafos`](../README.md).

## ¿Qué problema resuelve?

Mientras Dijkstra (`3_Dijsktra`) calcula distancias mínimas desde **un único** origen, Floyd-Warshall calcula las distancias mínimas entre **todos** los pares de vértices de una sola vez, mediante **programación dinámica**.

## ¿Cómo funciona?

La idea central: `dist[i][j]` se va refinando considerando, para cada vértice intermedio `k` (recorriendo `k = 0, 1, ..., n-1` en ese orden), si pasar por `k` acorta el camino de `i` a `j`:

```java
if (dist[i][k] + dist[k][j] < dist[i][j]) {
    dist[i][j] = dist[i][k] + dist[k][j];
}
```

Después de haber considerado los `n` vértices como posibles intermediarios, `dist[i][j]` contiene garantizadamente la distancia mínima real entre `i` y `j` — la demostración es por inducción sobre el conjunto de vértices intermedios permitidos (las mismas herramientas formales de `1_Logica_Formal/`), y es crucial que el bucle de `k` sea el **más externo**: al momento de calcular `dist[i][j]` usando el intermediario `k`, `dist[i][k]` y `dist[k][j]` ya deben reflejar los mejores caminos usando solo intermediarios `0..k-1` (o `k` mismo, cuando `i` o `j` es igual a `k`), lo cual la iteración `k`-externa garantiza.

### Representación: matriz de adyacencia

A diferencia de BFS/DFS/Dijkstra —que solo necesitan consultar "los vecinos de un vértice a la vez"—, Floyd-Warshall necesita acceso O(1) a la distancia entre **cualquier** par `(i, j)` en cada iteración. Por eso `GrafoMatriz` usa una matriz de adyacencia `int[][]` en vez de una lista de adyacencia, siguiendo exactamente la sugerencia del [ejercicio del README principal](../README.md#ejercicios) de implementar el grafo tanto con listas como con matriz de adyacencia.

### Pesos negativos y ciclos negativos

A diferencia de Dijkstra, Floyd-Warshall **sí admite pesos negativos**, siempre que no exista un **ciclo negativo** alcanzable (una secuencia de aristas que regresa al mismo vértice con costo total negativo) — en ese caso, "camino más corto" deja de tener sentido, porque se podría dar vueltas al ciclo indefinidamente para reducir el costo sin límite. `FloydWarshall.tieneCicloNegativo` detecta esta situación revisando la diagonal de la matriz resultante: si `dist[i][i] < 0` para algún `i`, existe un ciclo negativo alcanzable desde `i` (dar la vuelta "mejoró" el costo de volver al mismo lugar).

## Estructura Maven

```
4_Floyd_Warshall/
├── pom.xml
├── src/main/java/floydwarshall/
│   ├── GrafoMatriz.java     (matriz de adyacencia n×n)
│   ├── FloydWarshall.java   (calcular(), distanciaEntre(), tieneCicloNegativo())
│   └── Main.java
└── src/test/java/floydwarshall/FloydWarshallTest.java
```

## Compilar, probar y ejecutar

```bash
cd 5_Grafos/4_Floyd_Warshall
mvn compile
mvn test
mvn exec:java
```

## Complejidad temporal y espacial

Sea `V` el número de vértices.

| Operación | Complejidad | Explicación |
|---|---|---|
| `calcular(grafo)` | **Θ(V³)** | Tres bucles anidados de tamaño V (k, i, j), cada uno haciendo trabajo O(1) |
| `distanciaEntre` | **O(1)** | Consulta directa en la matriz precomputada |
| `tieneCicloNegativo` | **O(V)** | Un solo recorrido de la diagonal |

**Comparación con Dijkstra**: correr Dijkstra una vez por cada uno de los `V` vértices también resuelve el problema de todos-los-pares, con complejidad total O(V · (V + E) · log V). Para un grafo **denso** (E cercano a V²), eso es aproximadamente O(V³ · log V) — peor que los Θ(V³) de Floyd-Warshall. Para un grafo **disperso** (E cercano a V), V llamadas a Dijkstra son más eficientes. Floyd-Warshall es preferible cuando el grafo es denso, cuando se necesitan *todos* los pares (no solo desde un origen), o cuando hay pesos negativos sin ciclos negativos.

**Espacio**: **Θ(V²)** — la matriz de distancias es de tamaño V×V, sin importar cuántas aristas tenga realmente el grafo. Esto contrasta con la lista de adyacencia de los demás módulos (`1_BFS`, `2_DFS`, `3_Dijsktra`, `5_Prim`, `6_Kruskal`), que ocupa O(V + E) — para un grafo muy disperso, una matriz de adyacencia desperdicia mucho espacio en entradas `INFINITO` que representan "sin conexión directa".
