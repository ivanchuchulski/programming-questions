package example.stack;

public interface Stack<T> {

    void push(T data);

    T pop();

    T peek();

    boolean isEmpty();

    int size();

    void clear();

}
