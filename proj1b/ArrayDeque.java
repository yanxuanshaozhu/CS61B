public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int initialCapacity = 8;
    private double usageFactor = 0.25;
    private int front;
    private int rear;


    public ArrayDeque() {
        items = (T[]) new Object[initialCapacity];
        front = -1;
        rear = -1;

    }

    @Override
    public int size() {
        /*
        Two conditions to calculate the dequeue size:
        If front < rear: then size = rear - front + 1
        If front > rear: then size = rear - front + 1 + n
        */
        if (front < 0 || rear < 0) {
            return 0;
        }
        return (rear + 1 - front + items.length) % items.length;
    }

    private boolean isFull() {
        /*
        Two conditions for a dequeue implemented in circular array to be full:
        If front < rear: then front == 0 && rear == items.length -1
        If front > rear: then front - rear == 1
        */
        return (rear + 1) % items.length == front;
    }

    @Override
    public boolean isEmpty() {

        return front == -1 && rear == -1;
    }

    private void expandLength() {
        int temp = items.length;
        T[] newItems = (T[]) new Object[items.length * 2];
        System.arraycopy(items, 0, newItems, 0, items.length);
        items = newItems;
        front = 0;
        rear = temp - 1;
    }

    private void reduceLength() {
        T[] newItems = (T[]) new Object[items.length / 2];
        int temp = size();
        if (front < rear) {
            System.arraycopy(items, front, newItems, 0, size());
        } else if (front > rear) {
            System.arraycopy(items, front, newItems, 0, items.length - front);
            System.arraycopy(items, 0, newItems, items.length - front, rear + 1);
        }
        items = newItems;
        front = 0;
        rear = temp - 1;

    }

    @Override
    public void addFirst(T item) {
        if (isFull()) {
            expandLength();
        }
        if (front < 0) {                               // Empty dequeue
            front = 0;
            rear = 0;
        } else if (front == 0) {                       // Front is at index 0
            front = items.length - 1;
        } else {                                       // Other situations
            front -= 1;
        }
        items[front] = item;
    }

    @Override
    public void addLast(T item) {
        if (isFull()) {
            expandLength();
        }
        if (rear < 0) {                               // Empty dequeue
            front = 0;
            rear = 0;
        } else if (rear == items.length - 1) {        // Rear is at index items.length - 1
            rear = 0;
        } else {                                      // Other situations
            rear += 1;
        }
        items[rear] = item;
    }

    @Override
    public T removeFirst() {
        if (items.length >= 16 && size() * 1.0 / items.length < usageFactor) {
            reduceLength();
        }
        if (front < 0) {                              // Empty dequeue
            return null;
        } else if (front == rear) {                   // Only one item in the dequeue
            T temp = items[front];
            items[front] = null;
            front = -1;
            rear = -1;
            return temp;
        } else if (front == items.length - 1) {       // Front is at index items.length - 1
            T temp = items[front];
            items[front] = null;
            front = 0;
            return temp;
        } else {                                     // Other situations
            T temp = items[front];
            items[front] = null;
            front += 1;
            return temp;
        }
    }

    @Override
    public T removeLast() {
        if (items.length >= 16 && size() * 1.0 / items.length < usageFactor) {
            reduceLength();
        }
        if (rear < 0) {                              // Empty list
            return null;
        } else if (rear == front) {                  // Only one item in the dequeue
            T temp = items[rear];
            items[rear] = null;
            rear = -1;
            front = -1;
            return temp;
        } else if (rear == 0) {                     // Rear at index 0
            T temp = items[rear];
            items[rear] = null;
            rear = items.length - 1;
            return temp;
        } else {                                    // Other situations
            T temp = items[rear];
            items[rear] = null;
            rear -= 1;
            return temp;
        }
    }

    @Override
    public void printDeque() {
        if (front < rear) {
            for (int i = front; i < rear + 1; i++) {
                System.out.print(items[i] + " ");
            }
        } else if (front > rear) {
            for (int i = front; i < items.length; i++) {
                System.out.print(items[i] + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(items[i] + " ");
            }
        } else {
            System.out.print(items[front] + " ");
        }
    }

    @Override
    public T get(int index) {
        if (isEmpty() || index < 0 || index > size() - 1) {
            return null;
        }
        index = (front + index) % items.length;
        return items[index];
    }
}

