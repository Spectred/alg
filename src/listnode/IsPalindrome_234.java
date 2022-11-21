package listnode;

import struct.ListNode;

/**
 * <a href="https://leetcode.cn/problems/palindrome-linked-list/">234. 回文链表</a>
 */
public class IsPalindrome_234 {
    public boolean isPalindrome(ListNode head) {
        // 快满指针寻找终点
        ListNode slow = head, fast = head, curr = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 将后半部分进行翻转
        ListNode half = reverse(slow);

        // 顺序判断，如果有一个不等则不是回文
        while (half != null) {
            if (half.val != curr.val) return false;
            half = half.next;
            curr = curr.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode last = reverse(curr.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
