package listasimple.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class ListTest {

    @Test
    public void testAdd() {
        List list = new List();
        list.add(1);
        list.add(2);
        Assertions.assertEquals(2, list.size());
    }

    @Test
    public void testRemove() {
        List list = new List();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals(1, list.getHead().data);
        Assertions.assertEquals(3, list.getHead().next.data);
    }

    @Test
    public void testIsEmpty() {
        List list = new List();
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    private void assertTrue(boolean empty) {

    }

    @Test
    public void testSize() {
        List list = new List();
        Assertions.assertEquals(0, list.size());
        list.add(1);
        list.add(2);
        Assertions.assertEquals(2, list.size());
    }
}
