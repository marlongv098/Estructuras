# Lista Enlazada Simple: con y sin Generics

Este módulo compara dos implementaciones de una **lista simplemente enlazada** con las mismas operaciones (`add`, `remove`, `isEmpty`, `size`, `getHead`), para ilustrar el problema que resuelven los *generics* en Java:

* `listasimple.list.List` — versión **sin generics**, guarda `Object`.
* `listasimple.Generica.ListG<T>` — versión **con generics**, guarda `T`.

## ¿Por qué importa la diferencia?

Con `List` (basada en `Object`), al leer un elemento hay que **hacer cast** manualmente y el compilador no puede avisar si el tipo es incorrecto:

```java
List lista = new List();
lista.add("un texto");
Integer x = (Integer) lista.getHead().data; // compila, pero explota en tiempo de ejecución (ClassCastException)
```

Con `ListG<T>`, el compilador conoce el tipo desde que se declara la lista y **rechaza el error en tiempo de compilación**, no en producción:

```java
ListG<String> lista = new ListG<>();
lista.add("un texto");
Integer x = lista.getHead().data; // ERROR DE COMPILACIÓN inmediato, no en tiempo de ejecución
```

Este es el beneficio central de los generics: mueven los errores de tipo de *runtime* a *compile-time*, sin sacrificar la posibilidad de reutilizar la misma clase para cualquier tipo de dato.

## Estructura Maven

```
1_ListasEnlazadaSimple/
├── pom.xml
├── src/main/java/listasimple/
│   ├── Main.java
│   ├── list/{List, Node}.java          (sin generics)
│   └── Generica/{ListG, NodeG}.java    (con generics)
└── src/test/java/listasimple/
    ├── list/ListTest.java
    └── Generica/ListGTest.java
```

## Compilar, probar y ejecutar

```bash
cd 3_Estructuras_NO_Recursivas/3_Generics/1_ListasEnlazadas/1_ListasEnlazadaSimple
mvn compile
mvn test
mvn exec:java
```

## Complejidad temporal y espacial

Ambas implementaciones tienen **exactamente la misma complejidad** — los generics son un mecanismo del compilador (type erasure), no cambian el algoritmo en tiempo de ejecución:

| Operación | Complejidad temporal | Motivo |
|---|---|---|
| `add` | O(n) | Solo se guarda `head`, así que hay que recorrer hasta el final para encontrar dónde encadenar el nuevo nodo. Ver `2_ListaEnlazadaDoble` en este mismo repositorio para la versión O(1) que logra mantener también un puntero `tail`. |
| `remove(dato)` | O(n) | Hay que recorrer buscando el dato a eliminar. |
| `isEmpty` | O(1) | Solo verifica si `head == null`. |
| `size` | O(n) | Recorre toda la lista contando nodos (no se mantiene un contador incremental). |
| `getHead` | O(1) | Acceso directo al puntero. |

**Espacio**: O(n) — un nodo por elemento, cada uno con el dato y una referencia `next` (la mitad del espacio por nodo que la versión doblemente enlazada, que además guarda `prev`).

> Nota de diseño: `size()` recorre toda la lista en cada llamada (O(n)) en vez de mantener un campo `size` que se actualiza en `add`/`remove` (lo que la haría O(1)). Se deja así intencionalmente para que quien complete los ejercicios de este curso pueda comparar ambos enfoques como ejercicio propio.
