package servicio;

import notificacion.Notificador;
import notificacion.NotificadorEmail;
import notificacion.NotificadorSMS;
import notificacion.NotificadorWhastApp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioNotificacionTest {

    /** Notificador de prueba (test double) que solo registra el último mensaje recibido. */
    static class NotificadorEspia extends Notificador {
        String ultimoMensaje;

        @Override
        public void enviarMensaje(String mensaje) {
            this.ultimoMensaje = mensaje;
        }
    }

    @Test
    void delegaElEnvioAlNotificadorInyectado() {
        NotificadorEspia espia = new NotificadorEspia();
        ServicioNotificacion servicio = new ServicioNotificacion(espia);

        servicio.enviar("mensaje de prueba");

        assertEquals("mensaje de prueba", espia.ultimoMensaje);
    }

    @Test
    void funcionaConCadaImplementacionConcretaSinLanzarExcepcion() {
        // Cubre el bug ya corregido: antes se reusaba servicioSMS para "enviar" el
        // WhatsApp en Main.java. Aquí se prueba cada notificador de forma aislada
        // para que un error de ese tipo no pase inadvertido.
        for (Notificador n : new Notificador[]{new NotificadorEmail(), new NotificadorSMS(), new NotificadorWhastApp()}) {
            ServicioNotificacion servicio = new ServicioNotificacion(n);
            assertDoesNotThrowSending(servicio);
        }
    }

    private void assertDoesNotThrowSending(ServicioNotificacion servicio) {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> servicio.enviar("hola"));
    }
}
