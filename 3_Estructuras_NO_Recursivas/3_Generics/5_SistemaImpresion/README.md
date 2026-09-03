# Sistema de Impresión (Cola + Cola de Prioridad)

Simula un spooler de impresión con dos estructuras: una **cola FIFO** (`cola.Cola<T>`) para trabajos regulares y una **cola de prioridad** (`colaPrioridad.ColaPrioridad<T>`, implementada como lista enlazada ordenada) para trabajos urgentes.

> Este módulo no tenía README ni pruebas unitarias en la versión anterior; se agregaron ambos.

## Estructura Maven

```
5_SistemaImpresion/
├── pom.xml
├── src/main/java/
│   ├── ui/Main.java
│   ├── cola/{Cola, ColaInterfaz, NodoCola}.java
│   ├── colaPrioridad/{ColaPrioridad, ColaPrioridadInterfaz, NodoPrioridad}.java
│   └── impresion/{Impresora, TrabajoImpresion, TrabajoImpresionPrioridad}.java
└── src/test/java/
    ├── cola/ColaTest.java
    └── colaPrioridad/ColaPrioridadTest.java
```

`TrabajoImpresionPrioridad extends TrabajoImpresion` — un trabajo con prioridad *es* un trabajo regular con un dato extra, lo que permite que `Impresora` reutilice `TrabajoImpresion` como tipo común.

## Compilar, probar y ejecutar

```bash
cd 3_Estructuras_NO_Recursivas/3_Generics/5_SistemaImpresion
mvn compile
mvn test
mvn exec:java
```

## Convención de prioridad

En `ColaPrioridad`, **el número más bajo es la prioridad más alta** (1 se imprime antes que 5) — es la misma convención que usan los `nice` de Unix o `PriorityQueue` de Java con un comparador ascendente. Al insertar, se recorre la lista para ubicar el nuevo nodo en la posición que mantiene el orden ascendente por prioridad; entre dos trabajos de la **misma** prioridad, se respeta el orden de llegada (FIFO), porque la condición de avance es `prioridad <= prioridad` (con `<=`, no `<`), lo que hace que el nuevo nodo se inserte **después** de los que ya tienen esa misma prioridad.

## Nota honesta sobre `interrumpirTrabajoEnCurso()`

`Impresora.agregarTrabajoPrioridad` llama a `interrumpirTrabajoEnCurso()`, cuyo nombre sugiere que un trabajo prioritario puede interrumpir uno que se está imprimiendo. En la implementación actual esto **no llega a ocurrir en la práctica**: `imprimir()` es un método síncrono que corre de principio a fin en el mismo hilo que atiende el menú (`ui.Main`), así que mientras `imprimir()` se ejecuta, no hay forma de que el usuario llame a `agregarTrabajoPrioridad` al mismo tiempo — `trabajoEnCurso` vuelve a `null` apenas termina cada trabajo, antes de que el control regrese al menú. El mecanismo de interrupción solo tendría efecto real en una versión con impresión en un hilo aparte (por ejemplo, usando un `ExecutorService` para `imprimir()`), lo cual queda fuera del alcance de este ejercicio. Se documenta aquí para que quede claro qué hace el código realmente, en vez de dejar que el nombre del método sugiera un comportamiento que no ocurre.

## Complejidad temporal y espacial

| Estructura | Operación | Complejidad | Motivo |
|---|---|---|---|
| `Cola` (FIFO, con puntero a cola) | `encolar` | O(1) | Se enlaza directo con el puntero `cola` (tail) |
| `Cola` | `desencolar` / `frente` | O(1) | Acceso directo a `cabeza` |
| `ColaPrioridad` (lista enlazada ordenada) | `insertar` | O(n) | Hay que recorrer para encontrar la posición correcta según la prioridad |
| `ColaPrioridad` | `eliminar` / `frente` | O(1) | El de mayor prioridad siempre está en la cabeza |

**Comparación con un heap binario**: este `ColaPrioridad` prioriza que `eliminar`/`frente` sean O(1) a costa de que `insertar` sea O(n). Un **montículo binario** (heap) —usado en `6_GestorTareas` de este mismo repositorio— hace el trade-off inverso y más equilibrado: O(log n) tanto para insertar como para eliminar el mínimo, lo cual es preferible cuando se insertan muchos más elementos de los que se eliminan, o cuando ambas operaciones son igual de frecuentes. La elección correcta depende del patrón de uso esperado.

**Espacio**: O(n) en ambas estructuras — un nodo por elemento encolado/insertado.
