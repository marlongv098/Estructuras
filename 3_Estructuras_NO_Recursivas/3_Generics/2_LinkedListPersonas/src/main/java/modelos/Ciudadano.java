package modelos;

public class Ciudadano {
    private String cedula;
    private String nombre;
    private String apellido;

    public Ciudadano(String cedula, String nombre, String apellido) {
        this.cedula   = cedula;
        this.nombre   = nombre;
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Necesario para que Gestor.buscar() funcione correctamente
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ciudadano)) return false;
        Ciudadano otra = (Ciudadano) o;
        return cedula.equals(otra.cedula);
    }

    @Override
    public String toString() {
        return "Ciudadano{cedula='" + cedula + "', nombre='" + nombre + " " + apellido + "'}";
    }
}
