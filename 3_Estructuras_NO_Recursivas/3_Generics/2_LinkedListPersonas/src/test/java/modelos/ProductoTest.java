package modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {

    private Producto producto;

    @BeforeEach
    void setUp() {
        producto = new Producto("P-001", "Cuaderno", 3500.0);
    }

    @Test
    void getCodigoProducto() {
        assertEquals("P-001", producto.getCodigoProducto());
    }

    @Test
    void setCodigoProducto() {
        producto.setCodigoProducto("P-099");
        assertEquals("P-099", producto.getCodigoProducto());
    }

    @Test
    void getNombre() {
        assertEquals("Cuaderno", producto.getNombre());
    }

    @Test
    void setNombre() {
        producto.setNombre("Borrador");
        assertEquals("Borrador", producto.getNombre());
    }

    @Test
    void getPrecio() {
        assertEquals(3500.0, producto.getPrecio());
    }

    @Test
    void setPrecio() {
        producto.setPrecio(4200.0);
        assertEquals(4200.0, producto.getPrecio());
    }

    @Test
    void testEquals() {
        // Mismo código → son iguales (equals compara solo por codigoProducto)
        Producto mismoCodigo = new Producto("P-001", "", 0);
        assertEquals(producto, mismoCodigo);

        // Distinto código → son distintos
        Producto otroCodigo = new Producto("P-999", "Cuaderno", 3500.0);
        assertNotEquals(producto, otroCodigo);
    }

    @Test
    void testToString() {
        String resultado = producto.toString();
        assertTrue(resultado.contains("P-001"));
        assertTrue(resultado.contains("Cuaderno"));
        assertTrue(resultado.contains("3500.0"));
    }
}