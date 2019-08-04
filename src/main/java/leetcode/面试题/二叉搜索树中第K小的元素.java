package leetcode.面试题;

/**
 * @author yuan
 * @date 2019/3/5
 * @description
 */
public class 二叉搜索树中第K小的元素 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int K;
    private int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        K = k;
        if (root != null) {
            if (root.left != null) {
                kthSmallest(root.left, K);
            }

            --K;
            if (K == 0) {
                result = root.val;
                return result;
            }
            if (root.right != null) {
                kthSmallest(root.right, K);
            }
        }
        return result;
    }
}
