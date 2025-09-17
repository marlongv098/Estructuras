package listasimple.Generica;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListGTest {

    @Test
    public void testAdd() {
        ListG<Integer> list = new ListG<>();
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
    }

    @Test
    public void testRemove() {
        ListG<String> list = new ListG<>();
        list.add("Hello");
        list.add("World");
        list.add("Test");
        list.remove("World");
        assertEquals(2, list.size());
        assertEquals("Hello", list.getHead().data);
        assertEquals("Test", list.getHead().next.data);
    }

    @Test
    public void testIsEmpty() {
        ListG<Double> list = new ListG<>();
        assertTrue(list.isEmpty());
        list.add(1.0);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testSize() {
        ListG<Character> list = new ListG<>();
        assertEquals(0, list.size());
        list.add('a');
        list.add('b');
        assertEquals(2, list.size());
    }
}
