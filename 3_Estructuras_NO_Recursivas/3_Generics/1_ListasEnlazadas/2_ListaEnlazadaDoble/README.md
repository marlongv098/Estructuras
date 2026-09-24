# Lista Genérica Doblemente Enlazada

## Descripción

El objetivo de este proyecto es implementar una **lista genérica doblemente enlazada** en Java, llamada `ListaG<T>`.  
La lista debe ser capaz de almacenar elementos de cualquier tipo y permitir operaciones básicas como:

- Insertar al inicio y al final.
- Eliminar elementos.
- Consultar tamaño.
- Recorrer hacia adelante y hacia atrás.
- Verificar si un elemento existe.

La implementación está en la clase:

`src/main/java/ListaDoble/Generica/ListaG.java`

y pasa los tests que están en:

`src/test/java/ListaDoble/Generica/ListaGTest.java`

> **Nota**: en la versión anterior de este repositorio, `ListaG.java` no existía — solo estaba `NodeG.java` y el archivo de tests, por lo que el proyecto ni siquiera compilaba. Se implementó `ListaG<T>` completa (`insertAtStart`, `insertAtEnd`, `remove`, `getHeadData`, `getTailData`, `contains`, `size`, `recorrerAdelante`, `recorrerAtras`) verificando que pasa exactamente los casos de `ListaGTest`.

## Compilar y probar (Maven)

```bash
cd 3_Estructuras_NO_Recursivas/3_Generics/1_ListasEnlazadas/2_ListaEnlazadaDoble
mvn test
```

## Complejidad temporal y espacial

Gracias a mantener punteros `head` **y** `tail` (a diferencia de una lista simplemente enlazada que solo mantiene `head`):

| Operación | Complejidad temporal | Motivo |
|---|---|---|
| `insertAtStart` | O(1) | Se enlaza directo con `head`, sin recorrer la lista |
| `insertAtEnd` | O(1) | Se enlaza directo con `tail` — en una lista simple sin puntero a tail, esto sería O(n) |
| `getHeadData` / `getTailData` | O(1) | Acceso directo a los punteros |
| `remove(dato)` | O(n) | Hay que recorrer para encontrar el dato (aunque la desconexión en sí, una vez encontrado, es O(1) gracias a `prev`) |
| `contains(dato)` | O(n) | Recorrido completo en el peor caso |
| `recorrerAdelante` / `recorrerAtras` | O(n) | Visita cada nodo una vez |

**Espacio**: O(n) — cada nodo guarda el dato más dos referencias (`next` y `prev`), es decir, el doble de punteros que una lista simplemente enlazada (que solo guarda `next`). Ese espacio extra es precisamente lo que permite `insertAtEnd` y `recorrerAtras` en tiempo O(1)/O(n) respectivamente, sin tener que recorrer desde el head — es el clásico intercambio (trade-off) espacio-por-tiempo.
