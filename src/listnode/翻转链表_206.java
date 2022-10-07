package listnode;

import struct.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/">206. 反转链表</a>
 */
public class 翻转链表_206 {

    public ListNode reverseList0(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode last = reverseList0(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
