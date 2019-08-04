package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author yuan
 * @date 2019/3/15
 * @description
 */
public class 二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> result = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                result.push(root);
                root = root.right;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.left;
            }
        }
        List<Integer> list = new LinkedList<>();
        while (!result.isEmpty()) {
            root = result.pop();
            list.add(root.val);
        }
        return list;
    }
}
