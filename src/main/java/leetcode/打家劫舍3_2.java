package leetcode;

/**
 * @author yuan
 * @date 2019/3/8
 * @description
 */
public class 打家劫舍3_2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }


    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] dfs(TreeNode root) {
        int[] ans = new int[2];
        if (root == null) {
            return ans;
        }

        //对于以l.left为根的树，计算抢劫根节点(l.left)与不抢劫根节点可获得最大金额. left[0]为不抢可获得的最大金额,left[1]则为抢可获得的最大金额
        // 以下right[] 分析同理
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // 计算不抢劫当前根节点可获得的最大金额(那么其左右子树可以随便抢)
        ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        ans[1] = root.val + left[0] + right[0];
        return ans;
    }





    public static void main(String[] args) {

        打家劫舍3_2 obj = new 打家劫舍3_2();
        TreeNode x = new TreeNode(3);
        x.left = new TreeNode(2);
        x.right = new TreeNode(3);
        x.left.right = new TreeNode(3);
        x.right.right = new TreeNode(1);

        System.out.println(obj.rob(x));
    }


}
