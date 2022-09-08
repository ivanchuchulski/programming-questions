package example;

import example.singly.linked.list.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {
    @Test
    public void testAddingElementsToTheBackIsCorrect() {
        String[] expectedData = new String[]{"a", "b", "c"};

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        for (String d : expectedData) {
            singlyLinkedList.insertLast(d);
        }

        String[] allElements = getAllElements(singlyLinkedList);

        System.out.println(Arrays.toString(expectedData));
        System.out.println(Arrays.toString(allElements));

        assertEquals(expectedData.length, singlyLinkedList.getSize());
        assertArrayEquals(expectedData, allElements);
    }

    @Test
    public void testAddingElementsToTheFrontIsCorrect() {
        String[] expectedData = new String[]{"a", "b", "c"};

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        for (String d : expectedData) {
            singlyLinkedList.insertFront(d);
        }

        // reversing the original array
        for (int i = 0; i < (expectedData.length / 2); i++) {
            String temp = expectedData[i];
            expectedData[i] = expectedData[expectedData.length - i - 1];
            expectedData[expectedData.length - i - 1] = temp;
        }

        String[] allElements = getAllElements(singlyLinkedList);

        System.out.println(Arrays.toString(expectedData));
        System.out.println(Arrays.toString(allElements));

        assertEquals(expectedData.length, singlyLinkedList.getSize());
        assertArrayEquals(expectedData, allElements);
    }

    @Test
    void testRemovingAnElementIsCorrect() {
        String[] expectedData = new String[]{"a", "b", "c"};

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        for (String d : expectedData) {
            singlyLinkedList.insertLast(d);
        }

        String elementToRemove = "b";
        boolean removeResult = singlyLinkedList.remove(elementToRemove);

        assertTrue(removeResult);

        String[] dataWithOneElementRemoved = new String[expectedData.length - 1];
        Arrays.stream(expectedData).filter((e) -> !e.equals(elementToRemove)).toList().toArray(dataWithOneElementRemoved);
        String[] allElements = getAllElements(singlyLinkedList);

        System.out.println(Arrays.toString(dataWithOneElementRemoved));
        System.out.println(Arrays.toString(allElements));

        assertEquals(dataWithOneElementRemoved.length, singlyLinkedList.getSize());
        assertArrayEquals(dataWithOneElementRemoved, allElements);
    }

    private String[] getAllElements(SinglyLinkedList list) {
        String[] listData = new String[list.getSize()];
        SinglyLinkedList.Node head = list.getHead();
        int i = 0;
        while (head != null) {
            listData[i++] = head.getData();
            head = head.getNext();
        }

        return listData;
    }
}