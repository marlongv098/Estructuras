# HOWTO_EJECUTAR.md

## Requisitos
- **JDK 17 o superior** instalado y configurado en tu sistema.
- **IntelliJ IDEA** (Community o Ultimate).

## Estructura esperada del proyecto
Asegúrate de que las carpetas coincidan exactamente con los `package` declarados en cada archivo `.java`.

```
src/
 ├─ main/
 │   └─ Main.java                      (package main;)
 ├─ notificacion/
 │   ├─ Notificador.java               (package notificacion;)
 │   ├─ NotificadorEmail.java
 │   ├─ NotificadorSMS.java
 │   └─ NotificadorWhastApp.java
 └─ servicio/
     └─ ServicioNotificacion.java      (package servicio;)
```

## Ejecución en IntelliJ IDEA

1. **Abrir el proyecto**
   - Ve a **File → Open…**.
   - Selecciona la carpeta raíz que contiene `src/`.

2. **Configurar el SDK**
   - Ve a **File → Project Structure…** (`Ctrl+Alt+Shift+S` en Windows/Linux, `Cmd+;` en macOS).
   - En **Project SDK**, selecciona **Java 17** o superior.
   - En **Project language level**, selecciona el mismo o superior.

3. **Marcar carpeta de código fuente**
   - En el panel lateral de IntelliJ, clic derecho en `src/` → **Mark Directory as → Sources Root**.

4. **Crear configuración de ejecución**
   - Arriba a la derecha, abre **Run/Debug Configurations**.
   - Pulsa **+** → **Application**.
   - En **Name**, escribe `Ejecutar Main`.
   - En **Main class**, selecciona `main.Main`.
   - En **Use classpath of module**, elige el módulo que contiene `src/`.
   - Pulsa **Apply** y **OK**.

5. **Ejecutar**
   - Pulsa el botón verde **▶ Run** o usa `Shift+F10`.
   - La consola debería mostrar:
     ```
     Hola, este es un correo electrónico!
     Hola, este es un mensaje de texto!
     Hola, este es un mensaje de WhatsApp!
     ```

## Ejecución desde la terminal (opcional)

Si prefieres ejecutar desde la terminal en vez de IntelliJ:

```bash
cd ruta/al/proyecto
find src -name "*.java" > sources.txt
mkdir -p out
javac -encoding UTF-8 -d out @sources.txt
java -cp out main.Main
```

En Windows PowerShell:
```powershell
cd rutal\proyecto
Get-ChildItem -Recurse -Path src -Filter *.java | ForEach-Object { $_.FullName } > sources.txt
mkdir out
javac -encoding UTF-8 -d out @sources.txt
java -cp out main.Main
```

## Notas
- Si cambias el `package` de `Main`, también tendrás que ajustar la configuración de ejecución.
- El código actual usa `servicioSMS` para enviar el mensaje de WhatsApp. Lo correcto sería:

  ```java
  servicioWastApp.enviar("Hola, este es un mensaje de WhatsApp!");
  ```
