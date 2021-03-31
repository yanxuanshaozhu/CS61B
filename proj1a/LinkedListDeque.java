public class LinkedListDeque<T> {
    private TNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new TNode((T) Integer.valueOf(1), null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(T item) {
        sentinel = new TNode((T) Integer.valueOf(1), null, null);
        TNode newNode = new TNode(item, sentinel, sentinel);
        sentinel.prev = newNode;
        sentinel.next = newNode;
        size = 1;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        TNode temp = sentinel.next;
        TNode newNode = new TNode(item, temp, sentinel);
        sentinel.next = newNode;
        temp.prev = newNode;
        size += 1;
    }

    public void addLast(T item) {
        TNode temp = sentinel.prev;
        TNode newNode = new TNode(item, sentinel, temp);
        sentinel.prev = newNode;
        temp.next = newNode;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        TNode cur = sentinel;
        while (cur.next != sentinel) {
            cur = cur.next;
            System.out.print(cur.item + " ");

        }
    }

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

    public T getHelper(int index, TNode cur, int count) {
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