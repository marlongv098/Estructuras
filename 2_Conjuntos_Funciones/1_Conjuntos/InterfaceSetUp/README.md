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

* Tener instalado Java JDK 8 o superior.
* Un editor de código como IntelliJ IDEA, Eclipse o VS Code (opcional, también puede compilarse desde terminal).

## Pasos para Ejecutar el Programa

* Usando un IDE Descarga o clona el proyecto con las 5 clases 
    * Main.java
    * OperacionesConConjuntos.java
    * PalabrasUnicas.java
    * PalabrasUnicasTexto.java
    * PalabrasUnicasOrdenadas.java

* Abre el proyecto en tu IDE.
* Ejecuta el archivo Main.java.


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