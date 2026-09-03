# Gestor Genérico de Personas/Entidades (Generics)

Implementación de una lista enlazada genérica (`ListaEnlazada<T>`) envuelta por un `Gestor<T>` de propósito general, reutilizado para gestionar tres tipos de entidades distintas (`Ciudadano`, `Estudiante`, `Producto`) sin duplicar código.

> **Nota de corrección**: el README anterior de este módulo (`HOWTO_EJECUTAR.md`) describía una estructura (`ui.Main`, `persona.Persona`) que ya no correspondía al código real del proyecto (`gestor.Gestor`, `modelos.{Ciudadano,Estudiante,Producto}`), y el proyecto no tenía ninguna clase `Main` para ejecutarlo. Se actualizó este README para reflejar la estructura real y se agregó `main.Main` con una demostración de los tres tipos de entidades.

## Estructura Maven

```
2_LinkedListPersonas/
├── pom.xml
├── src/main/java/
│   ├── main/Main.java
│   ├── estructuras/{ListaEnlazada, Nodo}.java
│   ├── gestor/Gestor.java
│   └── modelos/{Ciudadano, Estudiante, Producto}.java
└── src/test/java/         (mismo paquete, con tests para cada clase)
```

`Gestor<T>` es un envoltorio (wrapper) delgado sobre `ListaEnlazada<T>` — separa la responsabilidad de "estructura de datos genérica" (`estructuras`) de la responsabilidad de "gestión de negocio" (`gestor`), que es donde en un proyecto real se agregarían validaciones específicas del dominio.

## Compilar, probar y ejecutar

```bash
cd 3_Estructuras_NO_Recursivas/3_Generics/2_LinkedListPersonas
mvn compile
mvn test
mvn exec:java
```

## Corrección aplicada: `equals` sin `hashCode`

`Ciudadano`, `Estudiante` y `Producto` sobrescribían `equals()` (necesario para que `Gestor.buscar()` funcione) pero **no** `hashCode()`. Esto viola el contrato de `Object`: *"si dos objetos son iguales según `equals()`, deben tener el mismo `hashCode()`"*. Mientras estos objetos solo se usen dentro de `ListaEnlazada` (una lista, no una tabla hash) el bug no se manifiesta, pero en cuanto alguien los guarde en un `HashSet<Ciudadano>` o los use como llave de un `HashMap`, dos ciudadanos "iguales" por cédula podrían terminar en *buckets* distintos y `contains`/`get` fallarían silenciosamente. Se agregó `hashCode()` a las tres clases, delegando en el mismo campo que ya usa `equals()`.

## Complejidad temporal y espacial de `ListaEnlazada<T>`

| Operación | Complejidad temporal | Notas |
|---|---|---|
| `agregar` (al final) | O(n) | Solo se mantiene `cabeza`; hay que recorrer hasta el final. |
| `obtener(indice)` | O(n) | Acceso secuencial, no hay acceso aleatorio como en un arreglo. |
| `eliminar(indice)` | O(n) | Hay que llegar hasta la posición antes de desenlazar. |
| `buscar(dato)` | O(n) | Recorrido completo en el peor caso, usa `equals()` de `T`. |
| `size` | O(1) | A diferencia de `1_ListasEnlazadaSimple`, aquí sí se mantiene un contador `size` actualizado en cada `agregar`/`eliminar`, evitando recorrer la lista. |
| `estaVacia` | O(1) | Consulta directa de `size == 0`. |

**Espacio**: O(n) — un `Nodo<T>` por elemento (dato + referencia `siguiente`). El costo adicional de mantener `size` como campo es O(1) (una sola variable extra), a cambio de convertir `size()` de O(n) a O(1) — una buena relación costo/beneficio frente a la versión de `1_ListasEnlazadaSimple`.
