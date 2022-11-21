package common;

/**
 * 双向链表结点
 */
public class DoubleNode {
    int key, val;
    DoubleNode prev, next;

    public DoubleNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
