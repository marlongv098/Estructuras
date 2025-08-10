# HOWTO_EJECUTAR.md

Guía detallada para compilar y ejecutar el proyecto cuyo **punto de entrada** es `ui.Main` y que depende de:
- `persona.Persona`
- `estructuras.ListaEnlazada`


---

## 1) Requisitos
- **JDK 17 o superior** instalado (Java y Javac en el PATH).
  ```bash
  java -version
  javac -version
  ```
- (Opcional) **IntelliJ IDEA** Community/Ultimate.

---

## 2) Estructura esperada del proyecto
```
<raiz-del-proyecto>/
└─ src/
   ├─ ui/
   │   └─ Main.java                 (package ui;)
   ├─ persona/
   │   └─ Persona.java              (package persona;)
   └─ estructuras/
       └─ ListaEnlazada.java        (package estructuras;)
```

> Si cambias el nombre de los paquetes, ajusta las rutas y el comando de ejecución.

---

## 3) Ejecutar en IntelliJ IDEA

1. **Abrir el proyecto**
   - `File → Open…` y selecciona la **carpeta raíz** que contiene `src/`.

2. **Configurar SDK**
   - `File → Project Structure…` (`Ctrl+Alt+Shift+S` o `Cmd+;` en macOS).
   - En **Project SDK**, elige **Java 17** (o superior).
   - En **Project language level**, selecciona el mismo nivel o superior.

3. **Marcar `src` como fuente**
   - En el panel *Project*, clic derecho sobre `src/` → `Mark Directory as → Sources Root`.

4. **Crear configuración de ejecución**
   - Arriba a la derecha, abre **Run/Debug Configurations**.
   - `+ → Application`.
   - **Name**: `Ejecutar ui.Main`.
   - **Main class**: `ui.Main`.
   - **Use classpath of module**: selecciona el módulo que contiene `src/`.
   - `Apply → OK`.

5. **Run**
   - Botón **▶ Run** o `Shift+F10`.
   - Deberías ver la salida con las operaciones sobre la lista de personas (tamaño, estado, eliminaciones, etc.).

---

## 4) Ejecutar por terminal (sin IDE)

Sitúate en la **raíz del proyecto** (la carpeta que contiene `src/`).

### macOS / Linux
```bash
find src -name "*.java" > sources.txt
mkdir -p out
javac -encoding UTF-8 -d out @sources.txt
java -cp out ui.Main
```

### Windows PowerShell
```powershell
Get-ChildItem -Recurse -Path src -Filter *.java | ForEach-Object { $_.FullName } > sources.txt
mkdir out
javac -encoding UTF-8 -d out @sources.txt
java -cp out ui.Main
```

---

## 5) Verificación rápida
- **Compilación OK**: no se muestran errores tras `javac` y se generan `.class` en `out/ui`, `out/persona`, `out/estructuras`.
- **Ejecución OK**: el programa imprime en consola la lista inicial, operaciones (inserción/eliminación), y el estado resultante.

---

## 6) Errores comunes y soluciones

- **`error: package persona (o estructuras) does not exist`**  
  *Causa*: falta el archivo `.java` correspondiente o el `package` declarado no coincide con la carpeta.  
  *Solución*: asegúrate de que `Persona.java` tenga `package persona;` y esté en `src/persona/`; que `ListaEnlazada.java` tenga `package estructuras;` y esté en `src/estructuras/`.

- **`Could not find or load main class ui.Main`**  
  *Causa*: compilación sin `-d out` o ejecución con classpath incorrecto.  
  *Solución*: recompila con `javac -d out ...` y ejecuta con `java -cp out ui.Main`.

- **Caracteres extraños (acentos/ñ) al compilar**  
  *Solución*: usa `javac -encoding UTF-8 -d out @sources.txt`.

---

## 7) Recomendaciones de buenas prácticas (opcional)
- Evita el **paquete por defecto** para cualquier clase. Usa paquetes bien nombrados (`ui`, `dominio`, `infraestructura`, etc.).
- Añade una tarea de construcción (**Maven** o **Gradle**) si el proyecto va a crecer: estructura estándar `src/main/java` y `src/test/java`.
- Escribe comentarios Javadoc mínimos en clases y métodos clave (responsabilidad, pre/postcondiciones, complejidad si aplica).

---

