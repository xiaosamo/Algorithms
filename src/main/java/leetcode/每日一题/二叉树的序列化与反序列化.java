package leetcode.每日一题;

import leetcode.TreeNode;
import org.springframework.util.StringUtils;
import utils.T;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yuan
 * @date 2020/6/16
 */
public class 二叉树的序列化与反序列化 {


    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<String> list = levelOrder(root);
            return String.join(",", list);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.length() == 0) {

                return null;
            }
            List<String> list = Arrays.stream(data.split(",")).collect(Collectors.toList());
            if (list.size() == 0 || "null".equals(list.get(0))) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int len = list.size();
            int level = 1;
            int index = 1;
            while (index < len) {
                int curLevel = (int) Math.pow(2, level);
                for (int i = 1; i <= curLevel; i += 2) {
                    TreeNode x = queue.poll();
                    if (index >= len) {
                        return root;
                    }
                    if (x != null) {
                        String l = list.get(index++);
                        if ("null".equals(l)) {
                            x.left = null;
                        } else {
                            x.left = new TreeNode(Integer.parseInt(l));
                        }
                        queue.offer(x.left);

                        String r = list.get(index++);
                        if ("null".equals(r)) {
                            x.right = null;
                        } else {
                            x.right = new TreeNode(Integer.parseInt(r));
                        }
                        queue.offer(x.right);
                    }
                }
                ++level;
            }
            return root;
        }


        public List<String> levelOrder(TreeNode root) {
            List<String> result = new LinkedList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    result.add(String.valueOf(node.val));
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    result.add("null");
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
//        Codec obj = new 二叉树的序列化与反序列化.Codec();
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);
//
//        String data = obj.serialize(root);
//        System.out.println(data);
//
//        TreeNode node = obj.deserialize(data);
//        System.out.println(obj.levelOrder(node));

        Codec obj = new 二叉树的序列化与反序列化.Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

//        String data = obj.serialize(root);
//        System.out.println(data);

//        TreeNode node = obj.deserialize(data);
//        System.out.println(obj.levelOrder(node));


        System.out.println(obj.levelOrder(obj.deserialize("1,null,2,3,null,4,null,null,5,null,6,7,null,8,null,null,9,null,10")));

    }
}
