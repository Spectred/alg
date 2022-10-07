package common;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {

    Map<Integer, Node> map;

    DoubleList cache;

    int cap;

    public LRUCache_146(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            cache.remove(node);

            Node newNode = new Node(key, value);
            cache.addLast(newNode);
            map.put(key, newNode);
            return;
        }

        if (cache.size == cap) {
            Node node = cache.removeFirst();
            map.remove(node.key);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        cache.addLast(node);
    }

    class Node {
        int key, val;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList {
        Node head, tail;

        int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addLast(Node x) {
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node removeFirst() {
            if (head.next == null) return null;
            Node first = head.next;
            remove(first);
            return first;
        }
    }
}
