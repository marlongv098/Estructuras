package persona;

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
