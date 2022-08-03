package example;

import java.util.Objects;

public class SinglyLinkedList {
    private Node head;
    private int size;

    public SinglyLinkedList(String data) {
        head = new Node(data);
        size = 1;
    }

    public SinglyLinkedList() {
        size = 0;
    }

    public Node getHead() {
        return head;
    }

    public void insertLast(String data) {
        if (size == 0) {
            head = new Node(data);
            size++;
            return;
        }

        Node temp = head;

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(new Node(data));
        size++;
    }

    public void insertFront(String data) {
        Node node = new Node(data);
        node.setNext(head);
        head = node;
        size++;
    }

    public boolean remove(String data) {
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            if (temp.getData().equals(data)) {
                if (prev != null) {
                    prev.setNext(temp.getNext());
                } else {
                    head = temp.getNext();
                }

                size--;
                return true;
            }
            prev = temp;
            temp = temp.getNext();
        }

        return false;
    }

    public int getSize() {
        return size;
    }

    public static class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return Objects.equals(data, node.data) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }
    }
}
