package notificacion;

public class NotificadorWhastApp extends Notificador {
    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("Enviando WhatsApp: " + mensaje);
    }
}
