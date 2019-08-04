package leetcode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class 二叉树的右视图 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {

            return ans;
        }

        ans.add(root.val);

        TreeNode p = root.right;
        while (p != null) {
            ans.add(p.val);
            p = p.right;
        }


        return ans;

    }

    public static void main(String[] args) {

    }
}
