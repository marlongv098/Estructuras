# HOWTO_EJECUTAR (Proyecto Maven)

Guía para compilar, ejecutar y probar un proyecto Java con **estructura Maven** usando paquetes:
- `ui` (contiene `Main.java`)
- `diccionario` (`Diccionario`, `DiccionarioInterfaz`)
- `tablashash` (`TablaHash`, `TablaHashInterfaz`)

---

## 1) Estructura esperada

```
<raiz-del-proyecto>/
├─ pom.xml
└─ src/
   ├─ main/
   │   └─ java/
   │       ├─ ui/
   │       │   └─ Main.java                 (package ui;)
   │       ├─ diccionario/
   │       │   ├─ Diccionario.java          (package diccionario;)
   │       │   └─ DiccionarioInterfaz.java  (package diccionario;)
   │       └─ tablashash/
   │           ├─ TablaHash.java            (package tablashash;)
   │           └─ TablaHashInterfaz.java    (package tablashash;)
   └─ test/
       └─ java/
           ├─ diccionario/
           │   └─ DiccionarioTest.java      (package diccionario;)
           └─ tablashash/
               └─ TablaHashTest.java        (package tablashash;)
```

> Los `package` en cada `.java` deben coincidir con su ruta relativa dentro de `src/main/java` o `src/test/java`.

---

## 2) Requisitos
- **JDK 17+** instalado (`java -version`, `javac -version`).
- **Apache Maven 3.8+** (`mvn -v`).

---

## 3) `pom.xml` mínimo recomendado

Incluye **JUnit 5** para pruebas y el plugin **exec** para ejecutar `ui.Main` desde Maven.

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.ejemplo</groupId>
  <artifactId>proyecto-estructuras</artifactId>
  <version>1.0.0</version>
  <properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <junit.version>5.10.2</junit.version>
  </properties>

  <dependencies>
    <!-- JUnit 5 (tests) -->
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>${junit.version}</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <!-- Permite ejecutar la clase main con mvn exec:java -->
      <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <version>3.1.0</version>
        <configuration>
          <mainClass>ui.Main</mainClass>
        </configuration>
      </plugin>
      <!-- Usa Surefire para correr JUnit 5 -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.2.5</version>
        <configuration>
          <useModulePath>false</useModulePath>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>
```


---

## 4) Compilar, ejecutar y probar

### Compilar
```bash
mvn clean compile
```

### Ejecutar la aplicación
```bash
mvn exec:java -Dexec.mainClass="ui.Main"
```
*No necesitas `-Dexec.mainClass` si ya está configurado en el `pom.xml`.*

### Ejecutar pruebas
```bash
mvn test
```

### Construir JAR ejecutable (opcional)
Agrega el plugin `maven-jar-plugin` y un **manifest** con la `Main-Class`, o usa `shade` para un fat‑jar:
```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-shade-plugin</artifactId>
  <version>3.5.0</version>
  <executions>
    <execution>
      <phase>package</phase>
      <goals><goal>shade</goal></goals>
      <configuration>
        <transformers>
          <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
            <mainClass>ui.Main</mainClass>
          </transformer>
        </transformers>
      </configuration>
    </execution>
  </executions>
</plugin>
```
Empaquetar:
```bash
mvn clean package
```
Ejecutar el jar generado (en `target/`):
```bash
java -jar target/proyecto-estructuras-1.0.0-shaded.jar
```

---

## 5) IntelliJ IDEA (recomendado)

1. **Abrir**: `File → Open…` y selecciona la carpeta con `pom.xml`.
2. **SDK**: `File → Project Structure…` → Project SDK = **Java 17**.
3. **Run**:
   - Clic derecho sobre `Main.java` → **Run 'Main.main()'**; o
   - **Run/Debug Configurations → + → Maven** y usa el goal `exec:java`.

---

## 6) Errores comunes

- **`package X does not exist`**  
  Ruta/paquete no coinciden. Verifica que el archivo está bajo `src/main/java/<ruta del package>` y que el `package` en el `.java` coincide.

- **`no main manifest attribute` al ejecutar el JAR**  
  El JAR no es ejecutable. Usa `exec:java` o configura `shade`/`jar` con `Main-Class`.

- **Pruebas no detectadas**  
  Asegúrate de que las clases de test estén bajo `src/test/java` y usen `@Test` de JUnit 5.

---

## 7) Ejemplo de comandos (de 0 a ejecución)

```bash
# Desde la raíz (donde está pom.xml)
mvn -v
mvn clean compile
mvn test
mvn exec:java -Dexec.mainClass="ui.Main"
# (opcional) jar ejecutable
mvn -q -DskipTests package
java -jar target/proyecto-estructuras-1.0.0-shaded.jar
```

---

