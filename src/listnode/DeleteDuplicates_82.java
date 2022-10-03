package listnode;

import struct.ListNode;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/">82. 删除排序链表中的重复元素 II</a>
 */
public class DeleteDuplicates_82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int x = curr.next.val;
                while (curr.next != null && curr.next.val == x) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
