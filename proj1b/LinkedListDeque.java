public class LinkedListDeque<T> implements Deque<T> {
    private TNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new TNode((T) Integer.valueOf(1), null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(T item) {
        TNode temp = sentinel.next;
        TNode newNode = new TNode(item, temp, sentinel);
        sentinel.next = newNode;
        temp.prev = newNode;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        TNode temp = sentinel.prev;
        TNode newNode = new TNode(item, sentinel, temp);
        sentinel.prev = newNode;
        temp.next = newNode;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void printDeque() {
        TNode cur = sentinel;
        while (cur.next != sentinel) {
            cur = cur.next;
            System.out.print(cur.item + " ");

        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        TNode temp = sentinel.next;
        sentinel.next = temp.next;
        temp.next.prev = sentinel;
        size -= 1;
        return temp.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        TNode temp = sentinel.prev;
        sentinel.prev = temp.prev;
        temp.prev.next = sentinel;
        size -= 1;
        return temp.item;
    }

    @Override
    public T get(int index) {
        int count = 0;
        TNode cur = sentinel;
        while (cur.next != sentinel) {
            cur = cur.next;
            if (count == index) {
                return cur.item;
            }
            count += 1;
        }
        return null;
    }

    private T getHelper(int index, TNode cur, int count) {
        if (index == count) {
            return cur.item;
        }
        return getHelper(index, cur.next, count + 1);
    }

    public T getRecursive(int index) {
        return getHelper(index, sentinel.next, 0);
    }

    private class TNode {
        public T item;
        public TNode next;
        public TNode prev;

        public TNode(T item, TNode next, TNode prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

}
