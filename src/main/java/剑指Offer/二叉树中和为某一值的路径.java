package 剑指Offer;

import java.util.ArrayList;

/**
 * @author yuan
 * @date 2019/2/17
 * @description
 */
public class 二叉树中和为某一值的路径 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        dfs(root, target, new ArrayList<>(), 0, result);
        return result;
    }

    /**
     * 用前序遍历，因为前序是先访问根节点
     * @param root
     * @param target
     * @param list 记录当前的一条路径
     * @param cur 记录当前一条路径的和
     * @param result 结果
     */
    private void dfs(TreeNode root, int target, ArrayList<Integer> list, int cur, ArrayList<ArrayList<Integer>> result) {
        if (root == null) {
            return;
        }

        cur += root.val;
        // 如果叶节点
        if (root.left == null && root.right == null && cur == target) {
            ArrayList<Integer> li = new ArrayList<>(list);
            li.add(root.val);
            result.add(li);
            return;
        }
        // 把当前节点保存下来，继续遍历节点的左右子树
        list.add(root.val);
        if (root.left != null) {
            dfs(root.left, target, list, cur, result);
        }
        if (root.right != null) {
            dfs(root.right, target, list, cur, result);
        }
        // 返回上一个父节点前，需要路径上删除当前节点
        list.remove(list.size() - 1);
    }


    public static void main(String[] args) {
        二叉树中和为某一值的路径 obj = new 二叉树中和为某一值的路径();
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(12);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);

        ArrayList<ArrayList<Integer>> arrayLists = obj.FindPath(root, 22);
        for (ArrayList<Integer> list : arrayLists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
