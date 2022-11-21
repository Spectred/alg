package tree.binary;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">144. 二叉树的前序遍历</a>
 */
public class PreorderTraversal_144 {

    private List<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();

        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }
}
