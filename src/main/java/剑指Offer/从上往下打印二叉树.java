package 剑指Offer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2019/2/14
 * @description 层次遍历
 */
public class 从上往下打印二叉树 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);

            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;

    }
}
