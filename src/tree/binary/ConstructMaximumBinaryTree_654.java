package tree.binary;

import struct.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/maximum-binary-tree/">654. 最大二叉树</a>
 */
public class ConstructMaximumBinaryTree_654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) return null;

        int index = -1, max = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (max < nums[i]) {
                index = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);
        return root;
    }
}
