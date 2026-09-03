package notificacion;

/**
 * Contrato para cualquier canal de notificación. Se declara abstracta (en vez de
 * una clase concreta con un método vacío) para que sea imposible instanciar un
 * "notificador" que no hace nada por error — el compilador obliga a cada subclase
 * a implementar enviarMensaje.
 */
public abstract class Notificador {
    public abstract void enviarMensaje(String mensaje);
}
