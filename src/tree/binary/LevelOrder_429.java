package tree.binary;

import struct.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-level-order-traversal/">429. N 叉树的层序遍历</a>
 */
public class LevelOrder_429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                level.add(curr.val);
                for (Node child : curr.children) {
                    if (child != null) q.offer(child);
                }
            }
            res.add(level);
        }
        return res;
    }
}
