package struct;

public class ArrayQueue {

    private Object[] items;

    private int n = 0;

    private int head = 0;

    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new Object[capacity];
        n = capacity;
    }

    public boolean enqueue(Object item) {
        if (tail == n) return false;
        items[tail++] = items;
        return true;
    }

    public Object dequeue() {
        if (head == tail) return null;
        return items[head++];
    }
}
