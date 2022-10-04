package tree.binary;

import struct.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/sum-root-to-leaf-numbers/">129. 求根节点到叶节点数字之和</a>
 */
public class SumNumbers_129 {


    int res = 0;
    StringBuilder path = new StringBuilder();

    public int sumNumbers(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        path.append(root.val);
        if (root.left == null && root.right == null)
            res += Integer.parseInt(path.toString());
        traverse(root.left);
        traverse(root.right);
        path.deleteCharAt(path.length() - 1);
    }


}
