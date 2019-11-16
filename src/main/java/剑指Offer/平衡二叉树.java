package 剑指Offer;

import leetcode.TreeNode;

/**
 * @author yuan
 * @date 2019/10/8
 * @description
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 平衡二叉树（Balanced Binary Tree）具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 */
public class 平衡二叉树 {
    boolean ok = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        getLen(root);
        return ok;
    }

    private int getLen(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getLen(root.left);
        int r = getLen(root.right);
        if (Math.abs(l - r) > 1) {
            ok = false;
        }
        return Math.max(l, r) + 1;
    }
}
