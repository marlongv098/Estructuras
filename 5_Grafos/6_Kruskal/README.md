# Kruskal — Árbol de Expansión Mínima (MST), vía Union-Find

> Antes de este trabajo esta carpeta solo tenía un `README.md` vacío. Se implementó el algoritmo completo como proyecto Maven, con pruebas y esta documentación. Para la teoría general de grafos ver el [README principal de `5_Grafos`](../README.md). Para la definición de Árbol de Expansión Mínima (MST), ver el README de `5_Prim`, que resuelve el mismo problema con una estrategia distinta.

## ¿Cómo funciona Kruskal?

Mientras Prim (`5_Prim`) hace crecer **un solo árbol** desde un vértice inicial, Kruskal razona de forma completamente distinta:

1. Se ordenan **todas** las aristas del grafo por peso ascendente.
2. Se recorren en ese orden, agregando cada arista al MST **a menos que** formar esa arista cree un ciclo con lo ya agregado.
3. Se detiene cuando el MST tiene `V - 1` aristas (todos los vértices conectados).

Es, igual que Prim, una estrategia voraz (greedy) — y por la misma propiedad de corte de los MST, produce un árbol de **peso total mínimo** idéntico al que produce Prim (aunque el orden en que se construye sea totalmente distinto).

### Union-Find (Conjuntos Disjuntos): ¿cómo se detecta un ciclo en O(casi 1)?

El paso clave — "¿agregar esta arista formaría un ciclo?" — se resuelve con la estructura `ConjuntosDisjuntos` (también llamada *Union-Find* o *Disjoint Set Union*): cada vértice pertenece a un conjunto, y dos vértices en el **mismo** conjunto ya están conectados por otro camino dentro del árbol que se está construyendo, así que unir esa arista formaría un ciclo. Se descarta.

`ConjuntosDisjuntos` combina dos optimizaciones clásicas que juntas dan complejidad casi constante **O(α(V))** por operación, donde `α` es la función inversa de Ackermann (crece tan lento que es ≤ 4 para cualquier cantidad de vértices imaginable en la práctica — a efectos prácticos se trata como O(1)):

- **Compresión de caminos** (*path compression*): al buscar la raíz de un conjunto (`encontrar`), cada nodo visitado en el camino se re-apunta directamente a la raíz, aplanando el árbol para futuras búsquedas.
- **Unión por rango** (*union by rank*): al unir dos conjuntos (`unir`), la raíz del árbol de menor rango se cuelga de la raíz del árbol de mayor rango, evitando que los árboles crezcan innecesariamente en altura.

## Estructura Maven

```
6_Kruskal/
├── pom.xml
├── src/main/java/kruskal/
│   ├── Grafo.java              (lista de aristas, no lista/matriz de adyacencia)
│   ├── ConjuntosDisjuntos.java (Union-Find: hacerConjunto(), encontrar(), unir())
│   ├── Kruskal.java            (calcularMST() y pesoTotal())
│   └── Main.java
└── src/test/java/kruskal/KruskalTest.java
```

**Nota sobre la representación**: a diferencia de los demás módulos de `5_Grafos`, aquí `Grafo` no usa lista ni matriz de adyacencia, sino una simple **lista de aristas**. Kruskal recorre todas las aristas del grafo sin importar a qué vértice pertenecen (las ordena globalmente por peso), así que no necesita nunca preguntar "¿cuáles son los vecinos de este vértice?" — la lista de aristas es la representación más directa para lo que el algoritmo realmente hace.

## Compilar, probar y ejecutar

```bash
cd 5_Grafos/6_Kruskal
mvn compile
mvn test
mvn exec:java
```

## Complejidad temporal y espacial

Sea `V` el número de vértices y `E` el número de aristas.

| Operación | Complejidad | Explicación |
|---|---|---|
| `calcularMST(grafo)` | **O(E log E)** | Ordenar las aristas domina el costo: O(E log E). El recorrido posterior hace `E` llamadas a `unir`/`encontrar`, cada una O(α(V)) ≈ O(1) amortizado, sumando O(E · α(V)) — dominado por el término de ordenamiento |
| `ConjuntosDisjuntos.encontrar` | **O(α(V))** amortizado | Casi constante gracias a la compresión de caminos |
| `ConjuntosDisjuntos.unir` | **O(α(V))** amortizado | Dos llamadas a `encontrar` más O(1) de trabajo adicional |
| `pesoTotal(mst)` | **O(V)** | Recorre las `V - 1` aristas del árbol resultante |

**Kruskal vs. Prim — ¿cuándo usar cuál?** Como `E ≤ V²`, se tiene `log E = O(log V)`, así que Kruskal es **O(E log V)** y Prim es **O((V + E) log E)** — asintóticamente muy similares. En la práctica: Kruskal es más simple de razonar y funciona muy bien cuando el grafo es **disperso** (pocas aristas) porque el cuello de botella es solo ordenarlas; Prim suele preferirse en grafos **densos** representados con matriz de adyacencia, donde se puede implementar en O(V²) sin siquiera necesitar una cola de prioridad.

**Espacio**: **O(V + E)** — la lista de aristas ocupa O(E), y `ConjuntosDisjuntos` ocupa O(V) (dos mapas de tamaño V: `padre` y `rango`). El MST resultante ocupa O(V) adicional (`V - 1` aristas).
