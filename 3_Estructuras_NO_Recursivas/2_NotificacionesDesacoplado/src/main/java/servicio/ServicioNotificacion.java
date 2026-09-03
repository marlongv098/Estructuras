package servicio;

import notificacion.Notificador;

public class ServicioNotificacion {
    private final Notificador notificador;

    // Inyección de dependencia por constructor
    public ServicioNotificacion(Notificador notificador) {
        this.notificador = notificador;
    }

    public void enviar(String mensaje) {
        notificador.enviarMensaje(mensaje);
    }
}
