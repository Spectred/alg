import struct.ListNode;

public class Main {


    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4, 3, 2, 1};
        ListNode[] listNodes = new ListNode[vals.length];
        for (int i = 0; i < listNodes.length; i++) {
            listNodes[i] = new ListNode(vals[i]);
        }
        for (int i = 0; i < listNodes.length; i++) {
            if (i == listNodes.length - 1)
                listNodes[i].next = null;
            else
                listNodes[i].next = listNodes[i + 1];
        }

        ListNode head = listNodes[0];

        boolean pari = palindrome(head);
        System.out.println(pari);
    }

    private static boolean palindrome(ListNode head) {
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