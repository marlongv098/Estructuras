package impresion;

public class TrabajoImpresionPrioridad extends TrabajoImpresion {
    public final int prioridad;

    public TrabajoImpresionPrioridad(String documento, String usuario, int prioridad) {
        super(documento, usuario);
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return super.toString() + ", Prioridad: " + prioridad;
    }
}
