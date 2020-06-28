package leetcode.每日一题;

import leetcode.TreeNode;

/**
 * @author yuan
 * @date 2020/3/10
 */
public class 二叉树的直径 {
    int ans = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans - 1;
    }

    private int height(TreeNode root){
        if (root == null) {
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1; // 返回该节点为根的子树的深度
    }

}
