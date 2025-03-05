📦 src
 ┣ 📂 notificacion   --> (Contiene la interfaz y las implementaciones concretas)
 ┃ ┣ 📜 Notificador.java
 ┃ ┣ 📜 NotificadorEmail.java
 ┃ ┣ 📜 NotificadorSMS.java
 ┃ ┗ 📜 NotificadorWhatsApp.java (Opcional)
 ┣ 📂 servicio       --> (Contiene la clase de alto nivel que usa Notificador)
 ┃ ┗ 📜 ServicioNotificacion.java
 ┣ 📂 main           --> (Contiene la clase principal que ejecuta el programa)
 ┃ ┗ 📜 Main.java


## ¿Por qué está desacoplado?

* La clase ServicioNotificacion no depende de una implementación específica de notificación.
*  Si queremos agregar NotificadorWhatsApp, solo implementamos la interfaz sin modificar el código existente.
*  Se facilita la prueba con mocks y la extensión sin romper código.


## Conclusiones

### Facilita la mantenibilidad del código

* Permite modificar o mejorar partes del código sin afectar otras, lo que reduce errores y facilita la evolución del software.
* Si se necesita cambiar la forma de enviar notificaciones (por ejemplo, agregar WhatsApp), solo se crea una nueva implementación de Notificador sin modificar ServicioNotificacion.

### Promueve el uso de interfaces y abstracción

* Separa la definición (Notificador) de la implementación (NotificadorEmail, NotificadorSMS), lo que permite cambiar comportamientos fácilmente.
* Sigue el Principio de Inversión de Dependencias (D en SOLID): las clases dependen de abstracciones y no de implementaciones concretas.

### Mejora la reutilización del código

* Componentes desacoplados pueden ser usados en diferentes proyectos sin depender del resto del código.
* Notificador puede utilizarse en otros sistemas sin necesidad de modificar su lógica interna.

###  Facilita la inyección de dependencias

* Permite usar frameworks como Spring para inyectar dependencias sin necesidad de instanciar clases directamente en Main.
* Evita el uso excesivo de new, lo que hace que el código sea más flexible y testable.

### Facilita las pruebas unitarias

* Se pueden crear mocks o stubs para probar ServicioNotificacion sin depender de implementaciones reales de Notificador.
* Ejemplo: Se puede probar ServicioNotificacion con un Notificador falso (Mock) sin realmente enviar emails o SMS.

**El desacoplamiento en Java mejora la modularidad, reutilización, escalabilidad y testabilidad del código. Usando interfaces, abstracción e inyección de dependencias, se logra un diseño más limpio y flexible, reduciendo la complejidad en el mantenimiento del software.**


