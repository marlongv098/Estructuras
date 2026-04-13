package modelos;

public class Estudiante {
    private Integer codigo;
    private String  nombre;
    private String  apellido;
    private String  carrera;

    public Estudiante(Integer codigo, String nombre, String apellido, String carrera) {
        this.codigo   = codigo;
        this.nombre   = nombre;
        this.apellido = apellido;
        this.carrera  = carrera;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    // equals basado en código — dos estudiantes son iguales si tienen el mismo código
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante)) return false;
        Estudiante otro = (Estudiante) o;
        return codigo.equals(otro.codigo);
    }

    @Override
    public String toString() {
        return "Estudiante{codigo=" + codigo
                + ", nombre='" + nombre + " " + apellido + "'"
                + ", carrera='" + carrera + "'}";
    }
}

