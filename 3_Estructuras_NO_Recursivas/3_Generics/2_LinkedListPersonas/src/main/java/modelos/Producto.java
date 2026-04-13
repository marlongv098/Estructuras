package modelos;

public class Producto {
    private String codigoProducto;
    private String nombre;
    private double precio;

    public Producto(String codigoProducto, String nombre, double precio) {
        this.codigoProducto = codigoProducto;
        this.nombre         = nombre;
        this.precio         = precio;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // equals basado en código — dos productos son iguales si tienen el mismo código
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto otro = (Producto) o;
        return codigoProducto.equals(otro.codigoProducto);
    }

    @Override
    public String toString() {
        return "Producto{codigo='" + codigoProducto
                + "', nombre='" + nombre
                + "', precio=" + precio + "}";
    }
}

