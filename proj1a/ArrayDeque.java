public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int initial_capacity = 8;
    private double usage_factor = 0.25;
    private int nextFirst;
    private int nextLast;


    public ArrayDeque() {
        items = (T[]) new Object[initial_capacity];
        size = 0;
        nextFirst = 0;
        nextLast = 0;

    }

    public int size() {
        return size;
    }

    private void expandLength() {
        T[] newItems = (T[]) new Object[items.length * 2];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    private void reduceLength() {
        T[] newItems = (T[]) new Object[items.length / 2];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            expandLength();
        }

    }

    public void addLast(T item) {

    }

    public T removeFirst() {

    }

    public T removeLast() {

    }

    public void printDeque() {

    }

    public T get(int index) {

    }
}
