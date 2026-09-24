package notificacion;

public class NotificadorEmail extends Notificador {
    @Override
    public void enviarMensaje(String mensaje) {

        System.out.println("Enviando Email: " + mensaje);
    }
}
