package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yuan
 * @date 2019/4/13
 * @description
 */
public class 二叉树的层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curNum = queue.size();
            double d = 0;
            int t = curNum;
            while (curNum > 0) {

                TreeNode node = queue.poll();
//                System.out.print(node.val + " ");
                d+=node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
                --curNum;
            }
            result.add(d/t);
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        二叉树的层平均值 obj = new 二叉树的层平均值();
        List<Double> list = obj.averageOfLevels(root);
        list.forEach(d -> System.out.println(d));
    }

}
