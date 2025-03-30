package impresion;

public class TrabajoImpresion {
    private final String documento;
    private final String usuario;

    public TrabajoImpresion(String documento, String usuario) {
        this.documento = documento;
        this.usuario = usuario;
    }

    public String getDocumento() {
        return documento;
    }

    public String getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "Documento: " + documento + ", Usuario: " + usuario;
    }
}