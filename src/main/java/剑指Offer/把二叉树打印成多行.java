package 剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2019/2/14
 * @description 层次遍历，分层打印
 */
public class 把二叉树打印成多行 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        // 下一层的节点数
        int nextLevel = 0;
        // 当前层还未打印的节点数
        int toBePrint = 1;

        ArrayList<Integer> curLevel = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            curLevel.add(node.val);
            // 打印了一个节点
            --toBePrint;

            if (node.left != null) {
                queue.offer(node.left);
                ++nextLevel;
            }
            if (node.right != null) {
                queue.offer(node.right);
                ++nextLevel;
            }

            // 如果当前层全部打印完
            if (toBePrint == 0) {
                result.add(curLevel);
                curLevel = new ArrayList<>();
                // 重新赋值
                toBePrint = nextLevel;
                nextLevel = 0;
            }
        }

        return result;
    }
}
