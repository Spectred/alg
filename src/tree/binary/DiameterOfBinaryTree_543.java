package tree.binary;

import struct.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/diameter-of-binary-tree/">543. 二叉树的直径</a>
 */
public class DiameterOfBinaryTree_543 {


    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int lm = maxDepth(root.left);
        int lr = maxDepth(root.right);
        maxDiameter = Math.max(maxDiameter, lm + lr);
        return Math.max(lm, lr) + 1;
    }
}
