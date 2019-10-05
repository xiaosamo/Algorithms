package 剑指Offer;

import leetcode.TreeNode;

/**
 * @author yuan
 * @date 2019/10/5
 * @description
 */
public class 合并二叉树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 != null && t2 != null) {
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
        }

        if (t1 == null) {
           return t2;
        }
        if (t2 == null) {
            return t1;
        }
        return t1;
    }
}
