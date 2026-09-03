# Árbol AVL (Árbol de Búsqueda Binaria Auto-balanceado)

Un árbol AVL es un árbol de búsqueda binaria (BST) que, tras cada inserción o eliminación, se **rebalancea automáticamente** mediante rotaciones para garantizar que la altura sea siempre O(log n), sin importar el orden en que lleguen los datos — resolviendo el problema del "árbol degenerado" descrito en el README de `1_ArbolBinario`.

> Este módulo no tenía README, ni pruebas, ni operación de eliminación en la versión anterior; se agregaron los tres.

## Propiedad AVL

Para cada nodo, el **factor de balance** (altura del subárbol izquierdo − altura del subárbol derecho) debe estar siempre en `{-1, 0, 1}`. Cuando una inserción o eliminación rompe esta propiedad, se aplican una o dos **rotaciones** para restaurarla:

| Caso | Cuándo ocurre | Rotación |
|---|---|---|
| Izquierda-Izquierda | El nodo pesa a la izquierda y el nuevo dato fue a la izquierda de ese hijo | Rotación simple a la derecha |
| Derecha-Derecha | El nodo pesa a la derecha y el nuevo dato fue a la derecha de ese hijo | Rotación simple a la izquierda |
| Izquierda-Derecha | El nodo pesa a la izquierda pero el nuevo dato fue a la derecha de ese hijo | Rotación izquierda sobre el hijo, luego derecha sobre el nodo |
| Derecha-Izquierda | El nodo pesa a la derecha pero el nuevo dato fue a la izquierda de ese hijo | Rotación derecha sobre el hijo, luego izquierda sobre el nodo |

## Estructura Maven

```
2_ArbolAVL/
├── pom.xml
├── src/main/java/binario/
│   ├── Main.java
│   ├── ArbolAVL.java     (insertar, eliminar, buscar, rotaciones)
│   ├── NodoAVL.java
│   └── Recorrido.java    (preorden, inorden, postorden)
└── src/test/java/binario/ArbolAVLTest.java
```

## Compilar, probar y ejecutar

```bash
cd 4_Estructuras_Recursivas/2_ArbolAVL
mvn compile
mvn test
mvn exec:java
```

## Adición: operación `eliminar`

La versión anterior solo tenía `insertar` (con las 4 rotaciones) pero ninguna forma de eliminar un dato. Se agregó `eliminar(dato)` siguiendo el mismo patrón que `insertar`: primero se hace la eliminación estándar de BST (con los tres casos clásicos — nodo hoja, un hijo, o dos hijos usando el sucesor in-order, igual que en `1_ArbolBinario`), y luego, **en el camino de regreso de la recursión**, se actualiza la altura y se verifica el factor de balance de cada ancestro, aplicando la rotación que corresponda — exactamente igual que hace `insertar`, pero evaluado en cada nodo desde el punto de eliminación hasta la raíz, porque eliminar (a diferencia de insertar) puede desbalancear más de un nivel del árbol.

`ArbolAVLTest.eliminarMantieneElArbolBalanceadoYOrdenado` verifica, recorriendo **todo** el árbol (no solo la raíz), que el factor de balance de cada nodo se mantiene en `{-1,0,1}` después de varias eliminaciones.

## Complejidad temporal y espacial

| Operación | Complejidad garantizada |
|---|---|
| `insertar` | O(log n) — inserción BST O(h) + como máximo O(1) rotaciones en el camino de vuelta, y h = O(log n) siempre |
| `eliminar` | O(log n) — igual razonamiento; a diferencia de insertar, puede requerir una rotación en **cada** nivel del camino de vuelta, pero eso sigue siendo O(log n) rotaciones, cada una O(1) |
| `buscar` | O(log n) **garantizado**, a diferencia del BST simple de `1_ArbolBinario` que degrada a O(n) en el peor caso |

**¿Por qué la altura es O(log n)?** Se puede demostrar (por inducción, con las herramientas de `1_Logica_Formal/`) que un árbol AVL con altura h tiene como mínimo Fib(h+2) − 1 nodos (donde Fib es la sucesión de Fibonacci de `3_Estructuras_NO_Recursivas/1_ComplejidadTemp/`), lo que acota la altura por aproximadamente 1.44·log₂(n) — es decir, **siempre** O(log n), nunca O(n) como el peor caso del BST simple.

**Espacio**: O(n) — un `NodoAVL<T>` por elemento (dato + dos referencias + un entero de altura, ligeramente más que `Nodo<T>` del BST simple por ese campo extra). La recursión de `insertar`/`eliminar` usa O(log n) de espacio en la pila de llamadas — a diferencia del BST simple, aquí esa cota **sí** está garantizada, nunca degrada a O(n).
