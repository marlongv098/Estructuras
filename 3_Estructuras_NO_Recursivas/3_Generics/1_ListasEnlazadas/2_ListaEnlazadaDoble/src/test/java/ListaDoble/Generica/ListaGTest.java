package ListaDoble.Generica;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListaGTest {

    @Test
    void testInsertAtStart() {
        System.out.println("Running test: testInsertAtStart");
        ListaG<Integer> list = new ListaG<>();
        list.insertAtStart(1);
        assertEquals(1, list.getHeadData());
        assertEquals(1, list.getTailData());

        list.insertAtStart(2);
        assertEquals(2, list.getHeadData());
        assertEquals(1, list.getTailData());
        System.out.println("Test passed.");
    }

    @Test
    void testInsertAtEnd() {
        System.out.println("Running test: testInsertAtEnd");
        ListaG<String> list = new ListaG<>();
        list.insertAtEnd("a");
        assertEquals("a", list.getHeadData());
        assertEquals("a", list.getTailData());

        list.insertAtEnd("b");
        assertEquals("a", list.getHeadData());
        assertEquals("b", list.getTailData());
        System.out.println("Test passed.");
    }

    @Test
    void testMixedInsert() {
        System.out.println("Running test: testMixedInsert");
        ListaG<Double> list = new ListaG<>();
        list.insertAtEnd(1.0);
        list.insertAtStart(2.0);
        list.insertAtEnd(3.0);
        assertEquals(2.0, list.getHeadData());
        assertEquals(3.0, list.getTailData());
        System.out.println("Test passed.");
    }

    @Test
    void testRemove() {
        System.out.println("Running test: testRemove");
        ListaG<Integer> list = new ListaG<>();
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

        System.out.println("Test passed.");
    }
}
