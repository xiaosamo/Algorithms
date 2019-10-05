package 剑指Offer;

import leetcode.TreeNode;

/**
 * @author yuan
 * @date 2019/10/5
 * @description
 */
public class 翻转二叉树 {
    // 先序遍历--从顶向下交换
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 保存右子树
        TreeNode right = root.right;
        // 交换左右子树的位置
        root.right = invertTree(root.left);
        root.left = invertTree(right);

        return root;
    }

}
