package tree.binary;

import struct.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">104. 二叉树的最大深度</a>
 */
public class MaxDepth_104 {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lm = maxDepth(root.left);
        int lr = maxDepth(root.right);
        return Math.max(lm, lr) + 1;
    }


}
