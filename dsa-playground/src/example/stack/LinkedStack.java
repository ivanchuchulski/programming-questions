package example.stack;

public class LinkedStack<T> implements Stack<T> {

    private Node<T> head;
    private int size;

    public LinkedStack() {
        size = 0;
    }

    @Override
    public void push(T data) {
        size++;
        Node<T> node = new Node<>(data);

        if (size == 0) {
            head = node;
            return;
        }

        node.setNext(head);
        head = node;
    }

    @Override
    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("poping from empty stack");
        }

        size--;

        T result = head.getData();
        head = head.getNext();

        return result;
    }

    @Override
    public T peek() {
        return head.getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
    }

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this(data, null);
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}
