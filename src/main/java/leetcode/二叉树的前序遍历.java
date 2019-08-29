package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的前序遍历 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> list = new ArrayList<>();

    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }

        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }

    /**
     * 非递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
        return list;
    }


}
