# Gestor de Tareas (Montículo Binario / Heap Mínimo)

Cola de prioridad implementada como **montículo binario mínimo** (`HeapMinimo<T,E>`, respaldado por un `ArrayList` que representa el árbol binario completo de forma implícita), usada para procesar tareas en orden de prioridad.

> Este módulo no tenía Maven, README ni pruebas en la versión anterior; se agregaron los tres.

## Estructura Maven

```
6_GestorTareas/
├── pom.xml
└── src/main/java/
│   ├── gestor/GestorTareas.java        (contiene el main())
│   ├── colaprioridad/HeapMinimo.java
│   └── tareas/{Tarea, TareaInterfaz}.java
└── src/test/java/colaprioridad/HeapMinimoTest.java
```

`HeapMinimo<T extends TareaInterfaz<E>, E>` es genérico sobre cualquier tipo `T` que sepa reportar su prioridad (`obtenerPrioridad()`) — no está atado a `Tarea` específicamente, aunque es el único uso actual.

## Compilar, probar y ejecutar

```bash
cd 3_Estructuras_NO_Recursivas/3_Generics/6_GestorTareas
mvn compile
mvn test
mvn exec:java
```

## Cómo funciona el heap (representación implícita en arreglo)

Un montículo binario se guarda en un `ArrayList` sin punteros explícitos: para el nodo en el índice `i`, su padre está en `(i-1)/2`, su hijo izquierdo en `2i+1` y su hijo derecho en `2i+2`. La **propiedad de heap mínimo** garantiza que cada nodo es menor o igual que sus hijos, así que el mínimo global siempre está en la raíz (índice 0):

* **`agregar`**: inserta al final del arreglo y "sube" (`subir`) intercambiando con su padre mientras sea menor — esto restaura la propiedad de heap en el camino desde la hoja hasta donde corresponda, sin tener que reordenar todo el árbol.
* **`extraerMinimo`**: guarda la raíz (el mínimo) para devolverla, mueve el **último** elemento del arreglo a la raíz, y "baja" (`bajar`) intercambiándolo con el menor de sus hijos hasta restaurar la propiedad de heap.

## Complejidad temporal y espacial

| Operación | Complejidad | Motivo |
|---|---|---|
| `agregar` | O(log n) | En el peor caso, `subir` recorre la altura del árbol (log₂ n niveles) |
| `extraerMinimo` | O(log n) | En el peor caso, `bajar` recorre la altura del árbol |
| `estaVacio` | O(1) | Consulta directa de `heap.isEmpty()` |

**Espacio**: O(n) — un `ArrayList` con una referencia por elemento; a diferencia de un árbol enlazado con punteros explícitos (izquierdo/derecho/padre), la representación implícita en arreglo no gasta espacio extra en punteros, solo en el propio dato.

### Por qué esto es mejor que una lista enlazada ordenada para este caso de uso

En `5_SistemaImpresion` (mismo repositorio), la cola de prioridad se implementa como una **lista enlazada ordenada**: O(1) para extraer el mínimo, pero O(n) para insertar. El heap binario logra **O(log n) en ambas operaciones** — una mejora significativa cuando se insertan y extraen elementos con frecuencia similar (como en este gestor de tareas, donde continuamente se agregan tareas nuevas mientras se procesan las existentes). La lista ordenada solo sería preferible si las inserciones fueran muchísimo menos frecuentes que las extracciones.
