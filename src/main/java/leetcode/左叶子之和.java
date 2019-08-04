package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class 左叶子之和 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * https://blog.csdn.net/yisizhu/article/details/52813108
     * 如果二叉树的左子树是一个叶子节点，则不用继续深入下去了，要找的就是它。
     * 如果二叉树的左子树不是一个叶子节点，则递归调用此过程去获取左子树的左叶子节点的值。
     * 而对于二叉树的右子树，则无论其是否是一个叶子节点都不会影响结果，直接递归调用获取右子树的左叶子节点值即可。
     *
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int t = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            t = root.left.val;
        }

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + t;
    }

    /**
     * 使用层次遍历
     */
    public static int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode cul = queue.poll();

            if (cul.left != null && cul.left.left == null && cul.left.right == null) {
                sum += cul.left.val;
            }

            if (cul.left != null) {
                queue.add(cul.left);
            }
            if (cul.right != null) {
                queue.add(cul.right);
            }
        }
        return sum;

    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add()
    }

}
