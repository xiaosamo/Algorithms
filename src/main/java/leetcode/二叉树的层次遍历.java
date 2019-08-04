package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yuan
 * @date 2019/3/14
 * @description
 */
public class 二叉树的层次遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curLevelNum = queue.size();
            List<Integer> list = new LinkedList<>();
            while (curLevelNum > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                --curLevelNum;
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        二叉树的层次遍历 obj = new 二叉树的层次遍历();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> lists = obj.levelOrder(root);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");

            }
            System.out.println();
        }
    }
}
