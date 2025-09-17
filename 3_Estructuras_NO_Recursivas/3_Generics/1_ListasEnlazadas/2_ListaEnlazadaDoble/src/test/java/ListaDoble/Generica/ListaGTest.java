package ListaDoble.Generica;

import static org.junit.jupiter.api.Assertions.*;

class ListaGTest {

    public static void main(String[] args) {
        testInsertAtStart();
        testInsertAtEnd();
        testMixedInsert();
        testRemove();
    }

    private static void testInsertAtStart() {
        System.out.println("Running test: testInsertAtStart");
        ListaG<Integer> list = new ListaG<>();
        list.insertAtStart(1);
        assert list.getHeadData() == 1;
        assert list.getTailData() == 1;

        list.insertAtStart(2);
        assert list.getHeadData() == 2;
        assert list.getTailData() == 1;
        System.out.println("Test passed.");
    }

    private static void testInsertAtEnd() {
        System.out.println("Running test: testInsertAtEnd");
        ListaG<String> list = new ListaG<>();
        list.insertAtEnd("a");
        assert "a".equals(list.getHeadData());
        assert "a".equals(list.getTailData());

        list.insertAtEnd("b");
        assert "a".equals(list.getHeadData());
        assert "b".equals(list.getTailData());
        System.out.println("Test passed.");
    }

    private static void testMixedInsert() {
        System.out.println("Running test: testMixedInsert");
        ListaG<Double> list = new ListaG<>();
        list.insertAtEnd(1.0);
        list.insertAtStart(2.0);
        list.insertAtEnd(3.0);
        assert list.getHeadData() == 2.0;
        assert list.getTailData() == 3.0;
        System.out.println("Test passed.");
    }

    private static void testRemove() {
        System.out.println("Running test: testRemove");
        ListaG<Integer> list = new ListaG<>();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);

        // Remove from the middle
        list.remove(3);
        assert list.getHeadData() == 1;
        assert list.getTailData() == 5;

        // Remove the head
        list.remove(1);
        assert list.getHeadData() == 2;

        // Remove the tail
        list.remove(5);
        assert list.getTailData() == 4;

        // Remove non-existent element
        list.remove(10);
        assert list.getHeadData() == 2;
        assert list.getTailData() == 4;

        System.out.println("Test passed.");
    }
  
}