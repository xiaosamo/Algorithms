package leetcode;

/**
 * @author yuan
 * @date 2019/2/21
 * @description
 */
public class 二叉搜索树中第K小的元素 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int K = 0;
    private int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        K = k;
        if (root != null) {
            if (root.left != null) {
                kthSmallest(root.left, K);
            }
            if (K == 1) {
                result = root.val;
            }
            --K;
            if (root.right != null) {
                kthSmallest(root.right, K);
            }
        }
        return result;
    }


}
