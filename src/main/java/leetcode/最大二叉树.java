package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class 最大二叉树 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        int max = nums[0], p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                p = i;
            }
        }

        int[] a = new int[p];

        int[] b = new int[nums.length - p - 1];


        for (int i = 0; i < p; i++) {
            a[i] = nums[i];
        }
        for (int i = p + 1, j = 0; i < nums.length; i++) {
            b[j++] = nums[i];
        }


        // 构造左子树
        TreeNode left = constructMaximumBinaryTree(a);
        // 构造右子树
        TreeNode right = constructMaximumBinaryTree(b);

        TreeNode root = new TreeNode(max);
        root.left = left;
        root.right = right;

        return root;
    }

    /**
     * 层次遍历
     * @param node
     */
    public static void levelOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            System.out.println(t.val);
            if (t.left != null) {
                queue.add(t.left);
            }
            if (t.right != null) {
                queue.add(t.right);
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {3, 2, 1, 6, 0, 5};
        TreeNode root = constructMaximumBinaryTree(a);
        levelOrder(root);


    }

}
