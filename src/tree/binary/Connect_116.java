package tree.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/">116. 填充每个节点的下一个右侧节点指针</a>
 */
public class Connect_116 {

    public Node connect(Node root) {
        if (root == null) return null;
        connectTwo(root.left, root.right);
        return root;
    }

    void connectTwo(Node x, Node y) {
        if (x == null || y == null) return;

        x.next = y;

        connectTwo(x.left, x.right);
        connectTwo(x.right, y.left);
        connectTwo(y.left, y.right);
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}