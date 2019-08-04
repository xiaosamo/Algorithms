package leetcode;

/**
 * @author yuan
 * @date 2019/3/8
 * @description
 */
public class 打家劫舍3 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }


    public int rob(TreeNode root) {
        return solve(root);
    }

  
    private int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }

        if (root.left != null && root.right != null) {
            return Math.max(solve(root.left) + solve(root.right), solve(root.left.left) + solve(root.left.right) + solve(root.right.left) + solve(root.right.right) + root.val);
        }

        if (root.left != null) {
            return Math.max(solve(root.left), solve(root.left.left) + solve(root.left.right) + root.val);
        }else{
            // root.right!=null
            return Math.max(solve(root.right), solve(root.right.left) + solve(root.right.right) + root.val);
        }
    }


    public static void main(String[] args) {

        打家劫舍3 obj = new 打家劫舍3();
        TreeNode x = new TreeNode(3);
        x.left = new TreeNode(2);
        x.right = new TreeNode(3);
        x.left.right = new TreeNode(3);
        x.right.right = new TreeNode(1);

        System.out.println(obj.rob(x));
    }


}
