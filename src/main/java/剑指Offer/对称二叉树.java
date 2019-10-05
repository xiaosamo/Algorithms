package 剑指Offer;

import leetcode.TreeNode;

/**
 * @author yuan
 * @date 2019/10/5
 * @description
 */
public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            // 都为null
            return true;
        }
        if (left == null || right == null) {
            // 一个为null
            return false;
        }
        if (left.val == right.val) {
            return dfs(left.left, right.right) && dfs(left.right, right.left);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
