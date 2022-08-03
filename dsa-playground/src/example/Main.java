package example;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList("a");
        list.insertLast("b");
        list.insertLast("c");

        printList(list);
        list.insertFront("d");
        printList(list);
    }

    private static void printList(SinglyLinkedList list) {
        SinglyLinkedList.Node head = list.getHead();
        while (head != null) {
            System.out.println(head.getData());
            head = head.getNext();
        }

        System.out.println();
    }
}
