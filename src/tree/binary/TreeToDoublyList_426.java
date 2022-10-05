package tree.binary;


import struct.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/">剑指 Offer 36. 二叉搜索树与双向链表</a>
 */
public class TreeToDoublyList_426 {

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;

        TreeNode leftHead = treeToDoublyList(root.left);
        TreeNode rightHead = treeToDoublyList(root.right);

        TreeNode leftTail, rightTail;

        if (leftHead != null) {
            leftTail = leftHead.left;
            root.left = leftTail;
            leftTail.right = root;
        } else {
            leftTail = leftHead = root;
        }

        if (rightHead != null) {
            rightTail = rightHead.left;
            root.right = rightHead;
            rightHead.left = root;
        } else {
            rightTail = rightHead = root;
        }

        leftHead.left = rightTail;
        rightTail.right = leftHead;
        return leftHead;
    }
}
