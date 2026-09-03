# Introducción

La teoría de conjuntos es el lenguaje fundamental de las matemáticas. A través de ella, se construyen y comprenden otras estructuras matemáticas como funciones, relaciones, estructuras algebraicas y más.

## Objetivos

* Comprender qué es un conjunto y cómo se define.
* Identificar los elementos de un conjunto y representar su pertenencia.
* Conocer operaciones y relaciones entre conjuntos, como inclusión, igualdad y cardinalidad.
* Utilizar representaciones visuales como los diagramas de Venn.
* Introducir la noción de conjuntos finitos e infinitos.

## Usos

* Es base para toda la matemática formal: lógica, álgebra, topología, etc.
* Se utiliza para definir estructuras computacionales como listas, conjuntos y diccionarios.
* Permite analizar relaciones y operaciones sobre datos en programación y ciencia de datos.
* Facilita el modelado y análisis de problemas en áreas como bases de datos, inteligencia artificial y teoría de la computación.

## Operaciones fundamentales

Dados dos conjuntos A y B:

| Operación | Notación | Definición |
|---|---|---|
| Unión | A ∪ B | elementos que están en A o en B |
| Intersección | A ∩ B | elementos que están en A y en B |
| Diferencia | A \ B | elementos que están en A pero no en B |
| Complemento | Aᶜ | elementos del universo que no están en A |
| Subconjunto | A ⊆ B | todo elemento de A está también en B |
| Cardinalidad | \|A\| | número de elementos de A (si A es finito) |

## Conexión con estructuras de datos

Estas operaciones matemáticas sobre conjuntos son exactamente las que implementa la interfaz `java.util.Set` (`addAll` = unión, `retainAll` = intersección, `removeAll` = diferencia). La carpeta `InterfaceSetUp/` de este mismo módulo contiene una implementación funcional en Java de estas operaciones junto con un análisis de su complejidad temporal y espacial según la estructura de respaldo usada (`HashSet`, `LinkedHashSet` o `TreeSet`) — ver su README para el detalle.