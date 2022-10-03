package tree.binary;

import struct.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/">124. 二叉树中的最大路径和</a>
 */
public class MaxPathSum_124 {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        oneSideMax(root);
        return res;
    }

    int oneSideMax(TreeNode root) {
        if (root == null) return 0;

        int l = Math.max(0, oneSideMax(root.left));
        int r = Math.max(0, oneSideMax(root.right));
        res = Math.max(root.val + l + r, res);
        return Math.max(l, r) + root.val;
    }
}
