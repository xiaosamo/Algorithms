package leetcode;

/**
 * @author yuanshijia
 * @date 2019-08-05
 * @description
 */
public class 路径总和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root != null) {
            if (root.left == null && root.right == null && root.val == sum) {
                // 如果是叶子节点
                return true;
            }
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
        return false;
    }

    static class TreeNode {
        
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

