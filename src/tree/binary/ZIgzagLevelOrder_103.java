package tree.binary;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/">103. 二叉树的锯齿形层序遍历</a>
 */
public class ZIgzagLevelOrder_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean f = true;
        while (!q.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (f) list.addLast(curr.val);
                else list.addFirst(curr.val);

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            f = !f;
            res.add(list);
        }
        return res;
    }
}
