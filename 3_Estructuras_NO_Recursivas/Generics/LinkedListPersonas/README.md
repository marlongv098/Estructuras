📦  LinkedListPersonas/

┣ 📂 src

┃ ┣ 📂 persona

┃ ┃ ┣  📜  Persona.java

┃ ┃ ┣  📜 PersonaGenerica.java

┃ ┣ 📂  estructuras

┃ ┃ ┣ 📜 Nodo.java

┃ ┃ ┣  📜 ListaEnlazada.java

┃ ┣ 📂 ui

┃ ┃ ┣ 📜 Main.java

┣ 📂 test

┃ ┣ 📜 ListaEnlazadaTest.java


# Crear carpetas de test en un proyecto de IntelliJ IDEA

La carpeta test se creo como un directorio dentro de tu módulo principal. Luego, se marca como "Test Sources Root" para que IntelliJ IDEA reconozca que contiene código de prueba. Esta práctica es coherente con las convenciones de desarrollo de Java y facilita la gestión de las pruebas en tu proyecto.

### Ventajas de hacer Persona genérica:

* Mayor flexibilidad: Podrías crear diferentes tipos de "personas" que tengan atributos de diferentes tipos. Por ejemplo, podrías tener $Persona<String, Integer>$ para nombre y edad, o $Persona<String, Double>$ si quisieras almacenar la altura como un número decimal.
* Reutilización: Si necesitas crear objetos similares a Persona pero con diferentes tipos de datos, una clase genérica podría evitar la duplicación de código.

### Desventajas de hacer Persona genérica:

* Complejidad innecesaria: En muchos casos, los atributos de una persona (nombre, edad, etc.) tienen tipos de datos bien definidos. Hacer la clase genérica podría añadir complejidad sin aportar beneficios significativos.
* Pérdida de claridad: Si los tipos de datos de los atributos no son relevantes para la lógica de tu aplicación, hacer la clase genérica podría dificultar la lectura y comprensión del código.
* Posibles problemas de tipado: Si no se usan correctamente, los genéricos pueden llevar a errores de tipado más difíciles de depurar.

### Cuándo podría ser útil hacer Persona genérica:

* Si necesitas almacenar atributos de Persona que pueden variar en tipo de datos.
* Si estás creando una biblioteca o framework que necesita ser muy flexible.
* Si tu aplicación tiene una lógica muy compleja que se beneficia de la flexibilidad de los genéricos.

