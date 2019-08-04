package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2019/4/14
 * @description
 */
public class 二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root,"",res);
        return res;
    }

    private void dfs(TreeNode root, String s, List<String> res) {

        if (root.left == null && root.right == null) {
            res.add(s + root.val);
            return;
        }

        if (root.left != null) {
            dfs(root.left, s + root.val + "->", res);
        }
        if (root.right != null) {
            dfs(root.right, s + root.val + "->", res);
        }

    }

    public static void main(String[] args) {
        二叉树的所有路径 obj = new 二叉树的所有路径();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);


        List<String> list = obj.binaryTreePaths(root);
        list.forEach(i -> System.out.println(i));
    }
}
