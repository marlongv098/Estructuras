package ListaDoble.Generica;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListaGTest {

    private ListaG<Integer> setupIntegerEmptyList(){
        ListaG<Integer> lista = new ListaG<>();
        return lista;
    }

    private ListaG<String> setupStringEmptyList(){
        ListaG<String> lista = new ListaG<>();
        return lista;
    }

    private ListaG<Double> setupDoubleEmptyList(){
        ListaG<Double> lista = new ListaG<>();
        return lista;
    }

    @Test
    void testInsertAtStart() {
        ListaG<Integer> list = setupIntegerEmptyList();
        list.insertAtStart(1);
        assertEquals(1, list.getHeadData());
        assertEquals(1, list.getTailData());

        list.insertAtStart(2);
        assertEquals(2, list.getHeadData());
        assertEquals(1, list.getTailData());

    }

    @Test
    void testInsertAtEnd() {

        ListaG<String> list = setupStringEmptyList();
        list.insertAtEnd("a");
        assertEquals("a", list.getHeadData());
        assertEquals("a", list.getTailData());

        list.insertAtEnd("b");
        assertEquals("a", list.getHeadData());
        assertEquals("b", list.getTailData());

    }

    @Test
    void testMixedInsert() {

        ListaG<Double> list = setupDoubleEmptyList();
        list.insertAtEnd(1.0);
        list.insertAtStart(2.0);
        list.insertAtEnd(3.0);
        assertEquals(2.0, list.getHeadData());
        assertEquals(3.0, list.getTailData());

    }

    @Test
    void testRemove() {

        ListaG<Integer> list = setupIntegerEmptyList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);

        // Remove from the middle
        list.remove(3);
        assertEquals(1, list.getHeadData());
        assertEquals(5, list.getTailData());

        // Remove the head
        list.remove(1);
        assertEquals(2, list.getHeadData());

        // Remove the tail
        list.remove(5);
        assertEquals(4, list.getTailData());

        // Remove non-existent element
        list.remove(10);
        assertEquals(2, list.getHeadData());
        assertEquals(4, list.getTailData());


    }
}
