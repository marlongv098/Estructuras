package main;
import notificacion.Notificador;
import notificacion.NotificadorEmail;
import notificacion.NotificadorSMS;
import notificacion.NotificadorWhastApp;
import servicio.ServicioNotificacion;
public class Main {
    public static void main(String[] args) {
        // Crear instancias de notificaciones específicas
        Notificador email = new NotificadorEmail();
        Notificador sms = new NotificadorSMS();
        Notificador WhastApp = new NotificadorWhastApp();

        // Inyectar la dependencia en el servicio
        ServicioNotificacion servicioEmail = new ServicioNotificacion(email);
        servicioEmail.enviar("Hola, este es un correo electrónico!");

        ServicioNotificacion servicioSMS = new ServicioNotificacion(sms);
        servicioSMS.enviar("Hola, este es un mensaje de texto!");

        ServicioNotificacion servicioWastApp = new ServicioNotificacion(WhastApp);
        servicioSMS.enviar("Hola, este es un mensaje de WhatsApp!");
    }
}