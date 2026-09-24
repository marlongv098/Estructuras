# Dijkstra — Camino Más Corto desde un Único Origen

> Antes de este trabajo esta carpeta solo tenía un `README.md` vacío. Se implementó el algoritmo completo como proyecto Maven, con pruebas y esta documentación. El nombre de la carpeta (`3_Dijsktra`) conserva la ortografía original del repositorio; el nombre correcto del algoritmo es **Dijkstra**. Para la teoría general de grafos ver el [README principal de `5_Grafos`](../README.md).

## ¿Qué problema resuelve?

Dado un grafo **ponderado** (con pesos ≥ 0 en las aristas) y un vértice de origen, Dijkstra calcula la distancia mínima desde el origen hasta **todos** los demás vértices alcanzables, y permite reconstruir el camino que logra esa distancia.

## ¿Cómo funciona?

Es una variante "voraz" (greedy) de BFS (`1_BFS`): en vez de una cola FIFO simple (donde avanzar cuesta siempre 1), usa una **cola de prioridad** ordenada por la distancia acumulada. En cada paso:

1. Se extrae de la cola el vértice no visitado con la menor distancia conocida.
2. Esa distancia se declara **definitiva** — no puede existir un camino más corto, porque cualquier otro camino tendría que pasar por un vértice todavía no procesado, y como todos los pesos son ≥ 0, ese camino no podría ser más corto.
3. Se **relajan** las aristas salientes: si pasar por el vértice actual mejora la distancia conocida de un vecino, se actualiza esa distancia y se vuelve a encolar el vecino.

### Eliminación perezosa (lazy deletion)

`java.util.PriorityQueue` no soporta "bajar la prioridad" de un elemento que ya está adentro (no hay una operación `decreaseKey` eficiente). La solución estándar —usada en esta implementación— es simplemente **agregar una nueva entrada** cada vez que se mejora una distancia, dejando la entrada vieja obsoleta en la cola. Cuando esa entrada obsoleta sale de la cola más adelante, se descarta con una comprobación `visitados.add(...)`: si el vértice ya fue procesado, la entrada es vieja y se ignora. Esto no cambia la complejidad asintótica, porque cada arista genera como máximo una entrada nueva en la cola.

### ¿Por qué no admite pesos negativos?

Todo el argumento de correctez depende de que, al procesar un vértice, su distancia ya sea mínima. Con un peso negativo, podría existir un camino más largo (en número de aristas) pero de menor costo total que solo se descubre **después** de haber declarado "definitiva" la distancia de un vértice — violando la propiedad central del algoritmo. Por eso `GrafoPonderado.agregarArista` lanza `IllegalArgumentException` si el peso es negativo, en vez de producir silenciosamente un resultado incorrecto. Para grafos con pesos negativos (pero sin ciclos negativos) se necesita Bellman-Ford; para *todos los pares* incluso con pesos negativos, ver `4_Floyd_Warshall`.

## Estructura Maven

```
3_Dijsktra/
├── pom.xml
├── src/main/java/dijkstra/
│   ├── GrafoPonderado.java   (lista de adyacencia ponderada, valida pesos ≥ 0)
│   ├── Dijkstra.java         (calcular() y reconstruirCamino())
│   └── Main.java
└── src/test/java/dijkstra/DijkstraTest.java
```

## Compilar, probar y ejecutar

```bash
cd 5_Grafos/3_Dijsktra
mvn compile
mvn test
mvn exec:java
```

## Complejidad temporal y espacial

Sea `V` el número de vértices y `E` el número de aristas.

| Operación | Complejidad | Explicación |
|---|---|---|
| `calcular(grafo, origen)` | **O((V + E) · log V)** | Cada arista puede generar como máximo una inserción en la cola de prioridad (O(E) inserciones), y cada operación de cola (insertar/extraer) cuesta O(log V) sobre un heap binario; el `poll()` de cada uno de los V vértices agrega otro término O(V · log V), dominado por el término de las aristas en grafos densos |
| `reconstruirCamino` | **O(camino)** | En el peor caso O(V), recorriendo el mapa de predecesores desde el destino hasta el origen |

Esto es, en espíritu, el mismo análisis que la cola de prioridad basada en heap binario de `3_Estructuras_NO_Recursivas/3_Generics/6_GestorTareas` (`ColaPrioridad`) — la diferencia es que aquí la "prioridad" de cada elemento cambia dinámicamente durante la ejecución del algoritmo.

**Espacio**: **O(V + E)** — el grafo ocupa O(V + E) (lista de adyacencia), y las estructuras auxiliares (`distancia`, `predecesor`, `visitados`, la cola de prioridad con sus entradas obsoletas) ocupan como mucho O(V + E) adicionales, ya que la cola puede llegar a contener hasta una entrada por cada arista relajada.
