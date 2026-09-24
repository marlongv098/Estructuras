package notificacion;

public class NotificadorSMS extends Notificador{
    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("Enviando SMS: " + mensaje);
    }
}
