package tree.binary;

import struct.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/balanced-binary-tree/">110. 平衡二叉树</a>
 */
public class IsBalanced_110 {

    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalanced;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        if (Math.abs(rightMax - leftMax) > 1) {
            isBalanced = false;
        }
        return Math.max(leftMax, rightMax) + 1;
    }
}
