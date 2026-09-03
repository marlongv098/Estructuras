# Prim — Árbol de Expansión Mínima (MST)

> Antes de este trabajo esta carpeta solo tenía un `README.md` vacío. Se implementó el algoritmo completo como proyecto Maven, con pruebas y esta documentación. Para la teoría general de grafos ver el [README principal de `5_Grafos`](../README.md).

## ¿Qué es un Árbol de Expansión Mínima (MST)?

Dado un grafo **no dirigido, ponderado y conexo**, un Árbol de Expansión Mínima (*Minimum Spanning Tree*) es un subconjunto de `V - 1` aristas que conecta a todos los `V` vértices (es decir, es un árbol que "abarca" todo el grafo) y cuya suma de pesos es la mínima posible entre todos los árboles de expansión posibles. Tiene aplicaciones directas en diseño de redes (tender la menor cantidad de cable para conectar un conjunto de ciudades, por ejemplo).

## ¿Cómo funciona Prim?

Prim construye el MST **haciendo crecer un solo árbol** desde un vértice inicial:

1. Se empieza con un árbol que contiene únicamente el vértice de inicio.
2. En cada paso, se busca la arista de **menor peso** que conecta un vértice ya dentro del árbol con un vértice todavía fuera de él, y se agrega esa arista (y ese vértice) al árbol.
3. Se repite hasta que todos los vértices estén incluidos (`V - 1` aristas agregadas).

Es una estrategia **voraz** (greedy): en cada paso se toma la decisión localmente óptima (la arista más barata disponible), y se puede demostrar —mediante la llamada "propiedad de corte" de los MST— que esa serie de decisiones locales produce un resultado globalmente óptimo.

### Similitud y diferencia con Dijkstra

Prim y Dijkstra (`3_Dijsktra`) comparten estructura: ambos usan una cola de prioridad y hacen crecer un árbol vértice por vértice, con eliminación perezosa para manejar las actualizaciones de prioridad (ver la explicación en el README de `3_Dijsktra`). La diferencia está en **qué** prioriza la cola:

| | Dijkstra | Prim |
|---|---|---|
| Prioriza | Distancia **acumulada** desde el origen | Peso de la **siguiente arista individual** |
| Admite pesos negativos | No | **Sí** |
| Resuelve | Camino más corto desde un origen | Árbol de expansión mínima |

Como Prim nunca compara sumas acumuladas —solo compara aristas individuales una contra otra—, un peso negativo no rompe su correctez de la misma forma en que rompe la de Dijkstra.

## Estructura Maven

```
5_Prim/
├── pom.xml
├── src/main/java/prim/
│   ├── Grafo.java   (lista de adyacencia ponderada, no dirigido)
│   ├── Prim.java    (calcularMST() y pesoTotal())
│   └── Main.java
└── src/test/java/prim/PrimTest.java
```

## Compilar, probar y ejecutar

```bash
cd 5_Grafos/5_Prim
mvn compile
mvn test
mvn exec:java
```

## Complejidad temporal y espacial

Sea `V` el número de vértices y `E` el número de aristas.

| Operación | Complejidad | Explicación |
|---|---|---|
| `calcularMST(grafo, inicio)` | **O((V + E) · log E)** | Cada arista puede generar como máximo una inserción en la cola de prioridad (O(E) inserciones/extracciones a O(log E) cada una); recorrer los vecinos de cada vértice procesado suma O(E) adicional |
| `pesoTotal(mst)` | **O(V)** | Recorre las `V - 1` aristas del árbol resultante |

`PrimTest.elResultadoEsElMismoSinImportarElVerticeInicial` verifica una propiedad importante: el **peso total** del MST no depende de con cuál vértice se empiece (aunque el conjunto exacto de aristas elegidas sí puede variar si hay pesos empatados).

**Espacio**: **O(V + E)** — igual razonamiento que Dijkstra: el grafo ocupa O(V + E), y la cola de prioridad puede llegar a contener hasta una entrada por cada arista considerada.
