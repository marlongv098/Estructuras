# Diccionario (Tabla Hash con encadenamiento separado)

Implementación de una tabla hash genérica `TablaHash<K,V>` (encadenamiento separado + rehash automático) usada para construir un `Diccionario` de palabras y definiciones.

> **Nota de corrección**: el README anterior describía paquetes (`ui`, `diccionario`, `tablashash`) que no coincidían con el código real (`modelo.Diccionario`, `estructuras.TablaHash`), y el proyecto no tenía clase `Main`. Se actualizó este README y se agregó `ui.Main` con una demostración funcional.

## Estructura Maven

```
3_Diccionario/
├── pom.xml
├── src/main/java/
│   ├── ui/Main.java
│   ├── modelo/Diccionario.java
│   └── estructuras/{TablaHash, TablaHashInterfaz}.java
└── src/test/java/
    ├── modelo/DiccionarioTest.java
    └── estructuras/TablaHashTest.java
```

`Diccionario` depende de la interfaz `TablaHashInterfaz<K,V>`, no de la clase concreta `TablaHash` — esto permite inyectar una implementación distinta (o un doble de prueba) sin modificar `Diccionario`.

## Compilar, probar y ejecutar

```bash
cd 3_Estructuras_NO_Recursivas/3_Generics/3_Diccionario
mvn compile
mvn test
mvn exec:java
```

## Cómo funciona la tabla hash

* **Encadenamiento separado**: cada "cubeta" (`bucket`) del arreglo es una `LinkedList<Entrada<K,V>>`; las claves cuyo hash cae en el mismo índice se acumulan en la misma lista en vez de sobrescribirse.
* **Índice**: `(clave.hashCode() & 0x7FFFFFFF) % capacidad`. El `& 0x7FFFFFFF` limpia el bit de signo para evitar índices negativos si `hashCode()` es negativo.
* **Factor de carga**: cuando `size / capacidad > 0.75`, se duplica la capacidad y se redistribuyen (`rehash`) todas las entradas — esto es lo que mantiene el promedio de O(1) a medida que la tabla crece, en vez de degradar a listas cada vez más largas.

## Complejidad temporal y espacial

| Operación | Caso promedio | Peor caso | Motivo del peor caso |
|---|---|---|---|
| `insertar` | O(1) | O(n) | Todas las claves colisionan en la misma cubeta (mal `hashCode()`, o ataque adversario) |
| `obtener` / `contiene` | O(1) | O(n) | Igual: hay que recorrer la cadena de la cubeta |
| `eliminar` | O(1) | O(n) | Igual |
| `rehash` | O(n) | O(n) | Redistribuye las n entradas existentes; ocurre O(log n) veces en total a medida que la tabla crece (duplicando capacidad), por lo que el costo **amortizado** por inserción sigue siendo O(1) |

**Espacio**: O(n + capacidad) — el arreglo de cubetas (proporcional a la capacidad, que crece geométricamente) más una `Entrada<K,V>` por cada par clave-valor almacenado.

### ¿Por qué O(1) es "promedio" y no garantizado?

A diferencia de `TreeMap` (que garantiza O(log n) siempre, sin importar el `hashCode()`), una tabla hash depende de que `hashCode()` distribuya las claves uniformemente entre las cubetas. Si muchas claves distintas producen el mismo `hashCode()` (colisión), esa cubeta se convierte en una lista larga y las operaciones sobre ella degradan a O(k) donde k es el tamaño de esa cadena — en el caso extremo (todas las claves en una sola cubeta), a O(n). Por esto la elección de un buen `hashCode()` (como el de `String`, ya bien distribuido) es tan importante como el algoritmo de la tabla misma.
