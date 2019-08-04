package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yuan
 * @date 2019/2/21
 * @description
 */
public class 二叉树的中序遍历 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> list = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }

}
