# Introducción

Este programa en Java está diseñado para realizar operaciones con conjuntos (Sets) y procesamiento de texto, permitiendo al usuario trabajar con datos estructurados y analizar contenido de diferentes fuentes (consola o archivos).

El sistema está compuesto por cuatro clases:

* Operaciones con Conjuntos: Realiza uniones, intersecciones y diferencias entre conjuntos.
* Palabras Únicas desde Consola: Extrae palabras únicas de un texto ingresado manualmente.
* Palabras Únicas desde Archivo: Lee un archivo de texto y muestra palabras únicas encontradas.
* Palabras Únicas Ordenadas: Procesa un archivo y devuelve las palabras únicas en orden alfabético.

## Objetivos

* Demostrar el uso de estructuras de datos en Java
    * Implementación de HashSet, LinkedHashSet y TreeSet.
    * Operaciones básicas con conjuntos (addAll, retainAll, removeAll).

* Procesamiento eficiente de texto
    * Extracción de palabras únicas desde diferentes fuentes (consola o archivos).
    * Filtrado de caracteres no deseados y normalización de texto (minúsculas, sin signos de puntuación).

* Ofrecer una herramienta modular y reusable
    * Cada funcionalidad está encapsulada en clases independientes.
    * Fácil extensión para nuevas características.

* Facilitar el análisis de datos textuales
    * Conteo de palabras únicas.
    * Ordenamiento alfabético automático.
    
## Requisitos Previos

* Tener instalado JDK 21 o superior.
* Maven (o el wrapper del IDE) para compilar y ejecutar el proyecto.

## Estructura Maven

El proyecto sigue la convención estándar de Maven:

```
InterfaceSetUp/
├── pom.xml
├── src/main/java/conjuntos/
│   ├── Main.java
│   ├── OperacionesConConjuntos.java
│   ├── PalabrasUnicas.java
│   ├── PalabrasUnicasTexto.java
│   └── PalabrasUnicasOrdenadas.java
└── src/test/java/conjuntos/
    ├── PalabrasUnicasTest.java
    └── PalabrasUnicasOrdenadasTest.java
```

## Pasos para Ejecutar el Programa

Desde la carpeta `InterfaceSetUp/`:

```bash
mvn compile              # compila el proyecto
mvn test                 # corre las pruebas unitarias (JUnit 5)
mvn exec:java             # ejecuta Main.java de forma interactiva
```

También puede abrirse en un IDE (IntelliJ, Eclipse, VS Code) como proyecto Maven e importarse directamente desde el `pom.xml`.


# Jerarquia de clases

java.lang.Object

   └── java.util.Collection (interface)
   
         └── java.util.Set (interface)
         
               └── java.util.SortedSet (interface)
               
                     └── java.util.NavigableSet (interface)
                     
                           └── java.util.TreeSet (clase)


## Collection<E> (interfaz)

* La raíz de la jerarquía de colecciones en Java. 
* Define operaciones generales: add, remove, size, iterator, etc. 
* Es la superinterfaz de casi todas las estructuras de colección.

## Set<E> (interfaz)

* Especializa Collection.
* Define la colección sin elementos duplicados.
* **Ejemplos:** HashSet, LinkedHashSet, TreeSet.

## SortedSet<E> (interfaz)

* Extiende Set.
* Garantiza que los elementos estén ordenados según el orden natural (Comparable) o un Comparator.
* Métodos adicionales:
      first(), last()
      headSet(E toElement)
      tailSet(E fromElement)
      subSet(E from, E to)
      
## NavigableSet<E> (interfaz)

* Extiende SortedSet.
* Proporciona métodos de navegación más avanzados:
      lower(E e) → el elemento inmediatamente menor.
      floor(E e) → el elemento ≤ e.
      ceiling(E e) → el elemento ≥ e.
      higher(E e) → el elemento inmediatamente mayor.
      pollFirst(), pollLast().

## TreeSet<E> (clase)

* Implementación concreta de NavigableSet.
* Ordena los elementos con:
      El orden natural (Comparable).
      Un Comparator proporcionado en el constructor.
* Mantiene los elementos ordenados en un árbol rojo-negro (estructura balanceada).

## Complejidad temporal y espacial

La elección de implementación de `Set` cambia radicalmente el costo de las operaciones. Sea **n** el número de elementos:

| Implementación | add / contains / remove | Recorrido ordenado | Espacio |
|---|---|---|---|
| `HashSet` | O(1) promedio (O(n) peor caso por colisiones) | No garantizado | O(n) |
| `LinkedHashSet` | O(1) promedio | Orden de inserción, O(n) | O(n) (algo más que HashSet por la lista enlazada interna) |
| `TreeSet` (árbol rojo-negro) | O(log n) | Orden natural/Comparator, O(n) | O(n) |

Esto explica las decisiones de diseño de este proyecto:

* `PalabrasUnicas` y `PalabrasUnicasTexto` usan `HashSet`: no importa el orden, solo la deduplicación, así que se prioriza el O(1) promedio de inserción/búsqueda.
* `PalabrasUnicasOrdenadas` usa `TreeSet`: se paga O(log n) por inserción a cambio de mantener el orden alfabético sin tener que ordenar al final (que costaría O(n log n) con una lista).

### Operaciones de conjuntos (`OperacionesConConjuntos`)

Para dos conjuntos de tamaño **n** y **m** respaldados por tabla hash:

* **Unión** (`addAll`): O(m) para insertar los elementos del segundo conjunto en una copia del primero → total O(n + m).
* **Intersección** (`retainAll`): recorre un conjunto y consulta `contains` en el otro → O(n) si se recorre el más pequeño (aunque la implementación de Java no siempre elige el más pequeño automáticamente, conviene llamarlo así: `pequeño.retainAll(grande)`).
* **Diferencia** (`removeAll`): O(n) donde n es el tamaño del conjunto sobre el que se llama.
* En todos los casos el espacio adicional es O(n + m) porque se crea un conjunto nuevo para no mutar los originales.

## Corrección aplicada

`PalabrasUnicas.agregarDesdeOracion` no verificaba si, tras quitar los signos de puntuación con `replaceAll`, la palabra resultante quedaba vacía (por ejemplo un token como `"--"` o `"..."`). Esto contaminaba el conjunto con una cadena vacía `""` que se contaba como "palabra única". Se corrigió para que solo se agreguen palabras no vacías, igual que ya hacían `PalabrasUnicasTexto` y `PalabrasUnicasOrdenadas`. La prueba `ignoraTokensQueSonSoloPuntuacion` en `PalabrasUnicasTest` cubre este caso.