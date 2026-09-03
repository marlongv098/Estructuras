# Complejidad Temporal y Espacial — Ejemplos en Java

Proyecto Maven con cinco algoritmos clásicos usados para introducir el análisis de complejidad temporal (Big-O) y espacial: búsqueda lineal, búsqueda binaria, ordenamiento burbuja, quicksort y Fibonacci (con cuatro implementaciones distintas para comparar).

## Estructura Maven

```
1_ComplejidadTemp/
├── pom.xml
├── src/main/java/complejidad/
│   ├── Main.java                     (menú interactivo para probar cada algoritmo)
│   ├── busquedalineal/BusquedaLineal.java
│   ├── busquedabinaria/BusquedaBinaria.java
│   ├── ordenamientoburbuja/OrdenamientoBurbuja.java
│   ├── quicksort/QuickSort.java
│   └── fibonacci/Fibonacci.java      (recursivo, iterativo O(n), optimizado O(1), matriz O(log n))
└── src/test/java/complejidad/
    └── AlgoritmosTest.java
```

Cada subpaquete tiene su propio `README.md` con el análisis de complejidad temporal **y espacial** detallado, con demostraciones formales de las cotas (usando la notación O/Ω/Θ presentada en `1_Logica_Formal/`):

* [`busquedalineal/README.md`](src/main/java/complejidad/busquedalineal/README.md) — O(n), mejor caso O(1)
* [`busquedabinaria/README.md`](src/main/java/complejidad/busquedabinaria/README.md) — O(log n)
* [`ordenamientoburbuja/README.md`](src/main/java/complejidad/ordenamientoburbuja/README.md) — O(n²), mejor caso O(n) con flag de intercambio
* [`quicksort/README.md`](src/main/java/complejidad/quicksort/README.md) — O(n log n) promedio, O(n²) peor caso
* [`fibonacci/README.md`](src/main/java/complejidad/fibonacci/README.md) — O(2ⁿ) → O(n) → O(1) espacio → O(log n) tiempo (cuatro variantes comparadas)

## Requisitos

* JDK 21 o superior.
* Maven.

## Compilar, probar y ejecutar

```bash
cd 3_Estructuras_NO_Recursivas/1_ComplejidadTemp
mvn compile        # compila
mvn test           # corre AlgoritmosTest.java (JUnit 5)
mvn exec:java      # ejecuta el menú interactivo de Main.java
```

## Resumen comparativo

| Algoritmo | Mejor caso | Caso promedio | Peor caso | Espacio |
|---|---|---|---|---|
| Búsqueda lineal | O(1) | O(n) | O(n) | O(1) |
| Búsqueda binaria | O(1) | O(log n) | O(log n) | O(1) |
| Ordenamiento burbuja | O(n) | O(n²) | O(n²) | O(1) |
| QuickSort | O(n log n) | O(n log n) | O(n²) | O(log n) prom. / O(n) peor caso |
| Fibonacci recursivo | — | O(2ⁿ) | O(2ⁿ) | O(n) |
| Fibonacci iterativo (array) | — | O(n) | O(n) | O(n) |
| Fibonacci optimizado | — | O(n) | O(n) | O(1) |
| Fibonacci matriz | — | O(log n) | O(log n) | O(log n) |

## Correcciones aplicadas en esta revisión

* **`OrdenamientoBurbuja`**: se agregó el flag `huboIntercambio` para cortar la ejecución cuando una pasada no hace intercambios. Sin él, el algoritmo siempre hacía O(n²) comparaciones sin importar si el arreglo ya estaba ordenado, lo cual contradecía la afirmación de "mejor caso O(n)" que ya tenía su README.
* **`Fibonacci`**: se agregó `fibonacciMatriz` (exponenciación de matrices, O(log n)) — el método que la tabla comparativa del README ya mencionaba pero que no estaba implementado — y se hizo estático `fibonacciIterativo` para que sea utilizable/testeable igual que los demás métodos.
* Se migró todo el módulo de "paquete por defecto" (sin Maven, con `javac` manual) a estructura Maven estándar (`src/main/java`, `src/test/java`), con paquetes en minúscula según la convención de Java.
