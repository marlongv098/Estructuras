# Editor de Texto con Deshacer/Rehacer (Pilas)

Editor de texto simple cuyo `deshacer`/`rehacer` se implementa con **dos pilas** (`Interfaz<String>`): `pilaDeshacer` guarda los estados anteriores del texto, y `pilaRehacer` guarda los estados "deshechos" para poder recuperarlos.

## Dos implementaciones intercambiables de la pila

El paquete `pila` implementa `Interfaz<T>` respaldado por un `ArrayList` (equivalente a un arreglo dinámico), y el paquete `pilalistaenlazada` implementa la **misma interfaz** respaldado por una lista enlazada propia. `EditorTexto` depende únicamente de `Interfaz<String>`, así que las dos implementaciones son intercambiables sin tocar el resto del editor — de hecho, en `editor/EditorTexto.java` los imports de `pila.*` están dejados comentados junto a los de `pilalistaenlazada.*` que sí están activos, precisamente para que se pueda experimentar cambiando de una a otra:

```java
// import pila.Pila;
// import pila.Interfaz;

import pilalistaenlazada.Pila;
import pilalistaenlazada.Interfaz;
```

## Estructura Maven

```
4_EditorTexto/
├── pom.xml
├── src/main/java/
│   ├── ui/Main.java                          (menú interactivo)
│   ├── editor/{EditorTexto, EditorTextoInterfaz}.java
│   ├── pila/{Pila, Interfaz}.java             (respaldada por ArrayList)
│   └── pilalistaenlazada/{Pila, Interfaz, Nodo}.java  (respaldada por lista enlazada)
└── src/test/java/
    ├── editor/EditorTextoTest.java
    ├── pila/PilaTest.java
    └── pilalistaenlazada/PilaTest.java
```

## Compilar, probar y ejecutar

```bash
cd 3_Estructuras_NO_Recursivas/3_Generics/4_EditorTexto
mvn compile
mvn test
mvn exec:java
```

## Cómo funciona deshacer/rehacer con dos pilas

* **`escribir(texto)`**: apila el estado *anterior* del texto en `pilaDeshacer`, luego agrega el texto nuevo, y **vacía** `pilaRehacer` (escribir contenido nuevo invalida cualquier "rehacer" pendiente — el mismo comportamiento que Word o VS Code).
* **`deshacer()`**: si `pilaDeshacer` no está vacía, guarda el estado *actual* en `pilaRehacer` (para poder rehacerlo luego) y restaura el estado en el tope de `pilaDeshacer`.
* **`rehacer()`**: simétrico — mueve el estado actual a `pilaDeshacer` y restaura el tope de `pilaRehacer`.

Esta es la razón por la que se necesita una pila (LIFO) y no una simple variable: cada `deshacer()` debe devolver el estado **más reciente**, en orden inverso al que se escribieron.

## Complejidad temporal y espacial

| Operación | `pila` (ArrayList) | `pilalistaenlazada` |
|---|---|---|
| `apilar` | O(1) amortizado (ocasionalmente O(n) si el arreglo interno debe crecer) | O(1) siempre (se enlaza en la cabeza) |
| `desapilar` / `tope` | O(1) | O(1) |
| `estaVacia` / `size` | O(1) | O(1) |

Ambas variantes tienen la misma complejidad **asintótica**, con una diferencia práctica: `ArrayList` amortiza O(1) para `apilar` (ocasionalmente redimensiona el arreglo interno duplicando su capacidad, un costo que se reparte entre todas las inserciones anteriores), mientras que la lista enlazada da O(1) estricto en cada operación individual, a cambio de un nodo extra (puntero `siguiente`) por elemento.

**Espacio de `EditorTexto`**: cada operación `escribir`/`deshacer`/`rehacer` guarda una copia completa del texto como `String` en la pila correspondiente. Si el texto tiene longitud L y se hacen n operaciones, el espacio total de las pilas de historial es **O(n·L)** en el peor caso — un editor de texto real (como VS Code) usa en cambio estructuras de *diffs* incrementales para evitar guardar el documento completo en cada paso, pero para fines didácticos esta versión prioriza la claridad del uso de la pila sobre la eficiencia de memoria.
