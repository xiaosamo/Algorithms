package leetcode;

public class 二叉树的直径 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDeep(root);
        return ans;
    }

    private int maxDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDeep(root.left);
        int r = maxDeep(root.right);
        ans = Math.max(l + r, ans);
        return Math.max(l, r) + 1;
    }



}
