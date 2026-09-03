# BFS — Recorrido en Anchura (Breadth-First Search)

> Antes de este trabajo esta carpeta solo tenía un `README.md` vacío. Se implementó el algoritmo completo como proyecto Maven, con pruebas y esta documentación. Para la teoría general de grafos (tipos, representaciones, matriz/lista de adyacencia, caminos, conectividad) ver el [README principal de `5_Grafos`](../README.md); este documento se enfoca únicamente en BFS.

## ¿Qué es BFS?

BFS explora un grafo **"por niveles"**: desde el vértice de inicio, visita primero todos sus vecinos directos (nivel 1), luego los vecinos de esos vecinos que no se hayan visitado todavía (nivel 2), y así sucesivamente. Se implementa con una **cola FIFO** (First In, First Out): cada vértice se encola en el momento en que se descubre, y se procesa exactamente en ese orden — garantizando que el algoritmo nunca "salte" a un nivel más profundo antes de terminar el nivel actual.

### ¿Por qué una cola y no una pila?

Una cola FIFO asegura que los vértices se procesen en el mismo orden en que se descubrieron. Eso es precisamente lo que separa a BFS de DFS (`2_DFS`, en esta misma carpeta padre): DFS usa una pila (o la pila de llamadas recursivas) y por eso profundiza en una rama antes de explorar las demás.

### Propiedad clave: camino más corto

En un grafo **no ponderado**, la primera vez que BFS alcanza un vértice `v` es, garantizadamente, a través del camino con **menor número de aristas** posible desde el origen. Por eso BFS es el algoritmo estándar para responder "¿cuál es la distancia mínima (en saltos) entre A y B?" en un grafo que no tiene pesos en las aristas.

## Estructura Maven

```
1_BFS/
├── pom.xml
├── src/main/java/bfs/
│   ├── Grafo.java   (lista de adyacencia, no dirigido, no ponderado)
│   ├── BFS.java     (recorrido() y distancias())
│   └── Main.java
└── src/test/java/bfs/BFSTest.java
```

## Compilar, probar y ejecutar

```bash
cd 5_Grafos/1_BFS
mvn compile
mvn test
mvn exec:java
```

## Complejidad temporal y espacial

Sea `V` el número de vértices y `E` el número de aristas.

| Operación | Complejidad | Explicación |
|---|---|---|
| `recorrido(grafo, inicio)` | **O(V + E)** | Cada vértice se encola y desencola exactamente una vez (O(V)); al procesarlo se recorren todos sus vecinos, y la suma de los grados de todos los vértices es 2E en un grafo no dirigido (O(E)) |
| `distancias(grafo, inicio)` | **O(V + E)** | Mismo recorrido, solo que además se guarda la distancia acumulada — no cambia el orden de complejidad |

**¿Por qué O(V + E) y no O(V · E) o algo peor?** Porque cada arista se examina como máximo dos veces en total (una desde cada uno de sus dos extremos), y cada vértice entra y sale de la cola una sola vez gracias al conjunto `visitados` que evita reprocesarlo. Esto es asintóticamente óptimo: no se puede recorrer un grafo sin al menos mirar cada vértice y cada arista una vez.

**Espacio**: **O(V)** — la cola, el conjunto de visitados y la lista/mapa de resultado guardan a lo sumo un elemento por vértice. A diferencia de DFS recursivo, BFS **no** usa la pila de llamadas, así que no hay riesgo de desbordarla (`StackOverflowError`) en grafos muy grandes o muy "profundos".
