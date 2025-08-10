# Cómo compilar y ejecutar este programa (Main.java)

Este `Main.java` usa **Java estándar** (sin librerías externas) pero **importa paquetes locales**:
```
BusquedaBinaria.*
BusquedaLineal.*
Fibonacci.*
OrdenamientoBurbuja.*
QuickSort.*
```
Por lo tanto, además de `Main.java`, **deben existir** las clases correspondientes en carpetas con esos nombres dentro de `src/`.

## Requisitos
- **JDK 17 o superior** instalado.
  - Comprueba con:
    ```bash
    java -version
    javac -version
    ```

## Estructura de carpetas

```
3_Estructuras_NO_Recursivas/1_ComplejidadTemp/
└─ src/
   ├─ Main.java                      (sin `package`, en el paquete por defecto)
   ├─ BusquedaBinaria/
   │  └─ BusquedaBinaria.java        (método(s) estático(s), p. ej. busquedaBinaria(...))
   ├─ BusquedaLineal/
   │  └─ BusquedaLineal.java         (p. ej. busquedaLineal(...))
   ├─ Fibonacci/
   │  └─ Fibonacci.java              (fibonacciRec(int), fibonacciOptimizado(int))
   ├─ OrdenamientoBurbuja/
   │  └─ OrdenamientoBurbuja.java    (burbuja(int[]))
   └─ QuickSort/
      └─ QuickSort.java              (quicksort(int[], int, int))
```

> **Importante**: Dado que `Main.java` **no** declara `package`, debe estar directamente bajo `src/`.  

## Compilar (macOS / Linux)
```bash
cd 3_Estructuras_NO_Recursivas/1_ComplejidadTemp
find src -name "*.java" > sources.txt
mkdir -p out
javac -encoding UTF-8 -d out @sources.txt
```

## Compilar (Windows PowerShell)
```powershell
cd 3_Estructuras_NO_Recursivas/1_ComplejidadTemp
Get-ChildItem -Recurse -Path src -Filter *.java | ForEach-Object { $_.FullName } > sources.txt
mkdir out
javac -encoding UTF-8 -d out @sources.txt
```

## Ejecutar
Como `Main` está en el **paquete por defecto**, se ejecuta así:
```bash
java -cp out Main
```

## Errores comunes
- **`error: package <X> does not exist`**  
  → Falta la carpeta/clase de ese paquete en `src/`, o la clase no tiene `package` correcto.  
  Verifica que los archivos estén exactamente bajo `src/<Paquete>/` y que comiencen con:  
  `package <Paquete>;`

- **`Could not find or load main class Main`**  
  → Revisa que **compilaste usando `-d out`** y ejecutas con `java -cp out Main`.  
  Si añadieras un `package` a `Main`, tendrías que ejecutarlo con el **nombre cualificado** (por ejemplo, `java -cp out com.ejemplo.Main`).

- **Clases desactualizadas**  
  → Borra `out/` y recompila:
  ```bash
  rm -rf out && mkdir out
  javac -encoding UTF-8 -d out @sources.txt
  ```

## Notas de buenas prácticas
- Evita el paquete por defecto para `Main`. Mejor usa un paquete, por ejemplo:
  ```java
  package complejidad;
  public class Main { ... }
  ```
  y ejecuta con `java -cp out complejidad.Main`.
- Considera migrar a **Maven** o **Gradle** para gestionar compilación, pruebas y dependencias.
