package example.stack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {

    private final static int INITIAL_CAPACITY = 3;
    private T[] elements;

    private int topIndex;
    private int size;

    private int capacity;

    private Class<T> typeClassname;

    public ArrayStack(Class<T> classname) {
        topIndex = -1;
        size = 0;
        capacity = INITIAL_CAPACITY;

        this.typeClassname = classname;
        elements = (T[]) Array.newInstance(classname, capacity);
    }

    @Override
    public void push(T data) {
        if (size >= capacity) {
            growStack();
        }
        elements[++topIndex] = data;
        size++;
    }

    @Override
    public T pop() {
        if (topIndex == -1) {
            throw new EmptyStackException();
        }

        T element = elements[topIndex--];
        size--;

        return element;
    }

    @Override
    public T peek() {
        return elements[topIndex];
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


    }

    private void growStack() {
        capacity = capacity * 2;
        T[] extendedElements = (T[]) Array.newInstance(typeClassname, capacity);
        System.arraycopy(elements, 0, extendedElements, 0, elements.length);

        elements = extendedElements;
    }

    static class EmptyStackException extends RuntimeException {
    }
}
