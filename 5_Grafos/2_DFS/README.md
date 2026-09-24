# DFS — Recorrido en Profundidad (Depth-First Search)

> Antes de este trabajo esta carpeta solo tenía un `README.md` vacío. Se implementó el algoritmo completo como proyecto Maven, con pruebas y esta documentación. Para la teoría general de grafos ver el [README principal de `5_Grafos`](../README.md); este documento se enfoca únicamente en DFS.

## ¿Qué es DFS?

DFS explora un grafo avanzando **todo lo posible por una rama** antes de retroceder ("backtrack") y probar la siguiente rama no explorada. Se puede implementar de dos formas equivalentes:

- **Recursiva** (`recorridoRecursivo`): la propia pila de llamadas del lenguaje hace el trabajo de "recordar" a qué vértice regresar cuando una rama se agota.
- **Iterativa** (`recorridoIterativo`): se usa una pila (`Deque`) explícita en vez de la recursión, evitando el límite de profundidad de la pila de llamadas en grafos muy grandes o con ramas muy largas.

Ambas versiones visitan el mismo conjunto de vértices (ver `DFSTest.recorridoIterativoVisitaLosMismosVerticesQueElRecursivo`), aunque el **orden exacto** puede diferir según cómo se apilen los vecinos.

### BFS vs. DFS

| | BFS (`1_BFS`) | DFS (este módulo) |
|---|---|---|
| Estructura | Cola (FIFO) | Pila (LIFO) o recursión |
| Orden de visita | Por niveles (anchura) | Por ramas (profundidad) |
| Uso típico | Camino más corto en grafos no ponderados | Detección de ciclos, orden topológico, componentes conexas |

## Detección de ciclos

`DFS.tieneCiclo(grafo)` recorre cada componente conexa del grafo (por si el grafo no es conexo) y, durante el recorrido, compara cada vecino visitado con el **padre** desde el que se llegó al vértice actual. En un grafo no dirigido, la arista `u—v` siempre aparece dos veces en la lista de adyacencia (una en `u` y otra en `v`); si no se descartara al padre, cualquier arista simple se reportaría falsamente como un ciclo. Un ciclo real existe cuando se encuentra un vecino ya visitado que **no** es el padre inmediato.

## Estructura Maven

```
2_DFS/
├── pom.xml
├── src/main/java/dfs/
│   ├── Grafo.java   (misma representación que 1_BFS: lista de adyacencia)
│   ├── DFS.java     (recorridoRecursivo(), recorridoIterativo(), tieneCiclo())
│   └── Main.java
└── src/test/java/dfs/DFSTest.java
```

## Compilar, probar y ejecutar

```bash
cd 5_Grafos/2_DFS
mvn compile
mvn test
mvn exec:java
```

## Complejidad temporal y espacial

Sea `V` el número de vértices y `E` el número de aristas.

| Operación | Complejidad | Explicación |
|---|---|---|
| `recorridoRecursivo` / `recorridoIterativo` | **O(V + E)** | Igual que BFS: cada vértice se visita una sola vez (O(V)) y cada arista se examina desde ambos extremos como máximo (O(E)) |
| `tieneCiclo` | **O(V + E)** | Es un DFS completo sobre todas las componentes conexas, con trabajo O(1) adicional por arista para comparar contra el padre |

**Espacio**:
- `recorridoRecursivo`: **O(V)** para el conjunto de visitados y el resultado, **más O(h)** en la pila de llamadas, donde `h` es la altura del árbol de recursión — en el peor caso (un grafo que se comporta como una lista), `h = O(V)`, lo que puede provocar `StackOverflowError` en grafos muy grandes y muy "profundos".
- `recorridoIterativo`: **O(V)** en todos los casos — la pila explícita vive en el heap, no en la pila de llamadas, así que no hereda esa limitación. Esta es la razón práctica para preferir la versión iterativa cuando se procesan grafos de tamaño desconocido o potencialmente muy grande.
