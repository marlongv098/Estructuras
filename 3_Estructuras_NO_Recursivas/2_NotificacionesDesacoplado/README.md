# Notificaciones Desacopladas (Inyección de Dependencias)

Ejemplo del patrón **Strategy** + **inyección de dependencias por constructor** para desacoplar un servicio de las implementaciones concretas de notificación (Email, SMS, WhatsApp) que usa.

## Diseño

```
Notificador (abstracta)
   ├── NotificadorEmail
   ├── NotificadorSMS
   └── NotificadorWhastApp

ServicioNotificacion  --(recibe en el constructor)--> Notificador
```

`ServicioNotificacion` no conoce ni depende de ninguna clase concreta de notificación: solo conoce el contrato `Notificador`. Esto permite:

* Agregar un nuevo canal (por ejemplo `NotificadorPush`) sin modificar `ServicioNotificacion`.
* Probar `ServicioNotificacion` con un "espía" de prueba en vez de un canal real (ver `ServicioNotificacionTest`).

## Estructura Maven

```
2_NotificacionesDesacoplado/
├── pom.xml
├── src/main/java/
│   ├── main/Main.java
│   ├── notificacion/{Notificador, NotificadorEmail, NotificadorSMS, NotificadorWhastApp}.java
│   └── servicio/ServicioNotificacion.java
└── src/test/java/servicio/ServicioNotificacionTest.java
```

## Compilar, probar y ejecutar

```bash
cd 3_Estructuras_NO_Recursivas/2_NotificacionesDesacoplado
mvn compile
mvn test
mvn exec:java
```

Salida esperada:
```
Enviando Email: Hola, este es un correo electrónico!
Enviando SMS: Hola, este es un mensaje de texto!
Enviando WhatsApp: Hola, este es un mensaje de WhatsApp!
```

## Correcciones aplicadas en esta revisión

* **Bug de `Main.java`** (ya diagnosticado en una versión anterior de este README pero nunca corregido en el código): el mensaje de WhatsApp se enviaba llamando a `servicioSMS.enviar(...)` en vez de `servicioWhatsApp.enviar(...)`, así que WhatsApp nunca recibía su propio mensaje. Se corrigió para usar la instancia correcta. `ServicioNotificacionTest` prueba cada notificador de forma aislada para que este tipo de error no pase inadvertido de nuevo.
* **`Notificador`** pasó de ser una clase concreta con un método vacío a una clase **abstracta**: antes era posible instanciar `new Notificador()` directamente y obtener un "notificador" que silenciosamente no hacía nada. Al declarar `enviarMensaje` como `abstract`, el compilador obliga a toda subclase a implementarlo.
* Se migró de "paquete por defecto ejecutado manualmente con `javac`" a estructura Maven estándar, y se agregaron pruebas unitarias con JUnit 5 (antes el proyecto no tenía ninguna).

## Complejidad

Cada operación (`enviar`, `enviarMensaje`) es una única llamada a método sin ciclos ni estructuras de datos de por medio: **O(1) en tiempo y en espacio**, independientemente de cuántos canales de notificación existan. El valor de este ejemplo no está en su complejidad algorítmica sino en el **desacoplamiento** — el costo de _agregar_ un nuevo canal es O(1) (una clase nueva) en vez de tener que modificar código existente, que es la propiedad de diseño (principio abierto/cerrado) que se busca ilustrar.
