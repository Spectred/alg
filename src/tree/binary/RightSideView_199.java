package tree.binary;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-right-side-view/">199. 二叉树的右视图</a>
 */
public class RightSideView_199 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> lists = levelOrder(root);
        List<Integer> res = new ArrayList<>();
        for (List<Integer> list : lists) {
            res.add(list.get(list.size() - 1));
        }
        return res;
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                level.add(curr.val);

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            res.add(level);
        }
        return res;
    }
}


