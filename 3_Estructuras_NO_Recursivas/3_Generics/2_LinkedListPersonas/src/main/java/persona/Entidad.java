package persona;

/**
 * Entidad representa una persona cuyo identificador puede variar en tipo.
 *
 * Casos de uso reales:
 *   - Ciudadano identificado por cédula (String): new Entidad<>("1020304050", "Ana López")
 *   - Estudiante identificado por código (Integer): new Entidad<>(20231045, "Luis Pérez")
 *   - Usuario identificado por UUID (String):       new Entidad<>("a1b2-c3d4", "María Gil")
 *
 * Aquí T tiene sentido como parámetro genérico porque el tipo del
 * identificador SÍ varía según el contexto de negocio.
 * El nombre, en cambio, siempre es String — por eso no se parametriza.
 */
public class Entidad<T> {
    private T id;
    private String nombre;

    public Entidad(T id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entidad<?>)) return false;
        Entidad<?> otra = (Entidad<?>) o;
        return id.equals(otra.id) && nombre.equals(otra.nombre);
    }

    @Override
    public String toString() {
        return "Entidad{id=" + id + " (" + id.getClass().getSimpleName() + ")"
                + ", nombre='" + nombre + "'}";
    }
}
