package persona;

public class PersonaGenerica<T, U> {
    private T nombre;
    private U edad;

    public PersonaGenerica(T nombre, U edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public T getNombre() {
        return nombre;
    }

    public void setNombre(T nombre) {
        this.nombre = nombre;
    }

    public U getEdad() {
        return edad;
    }

    public void setEdad(U edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre=" + nombre +
                ", edad=" + edad +
                '}';
    }
}