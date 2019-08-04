package leetcode;

/**
 * @author yhf
 * @date 2019/5/14
 * @description
 */
public class 二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }


        TreeNode l = searchBST(root.left, val);
        TreeNode r = searchBST(root.right, val);

        return r == null ? l : r;
    }

}
