package leetcode;

/**
 * @author yuan
 * @date 2019/3/19
 * @description
 */
public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root != null) {
            return solve(root.left, root.right);
        }
        return false;
    }

    private boolean solve(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }

        if (l.left != null && r.left != null && l.right != null && r.right != null) {
            return l.val == r.val;
        }


        // l!=null && r !=null
        if (l.left != null && r.left != null) {
            return solve(l.left, r.left);
        }

        if (l.right != null && r.right != null) {
            return solve(l.right, r.right);
        }
        return false;

    }
}
