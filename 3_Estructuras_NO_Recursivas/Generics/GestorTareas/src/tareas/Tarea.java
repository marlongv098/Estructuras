package tareas;

public class Tarea implements TareaInterfaz<String> {
    private final String datos;
    private final int prioridad;

    public Tarea(String datos, int prioridad) {
        this.datos = datos;
        this.prioridad = prioridad;
    }

    @Override
    public int obtenerPrioridad() {
        return prioridad;
    }

    @Override
    public String obtenerDatos() {
        return datos;
    }
}
