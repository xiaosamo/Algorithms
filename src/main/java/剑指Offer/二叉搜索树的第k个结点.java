package 剑指Offer;

/**
 * @author yuan
 * @date 2019/2/21
 * @description
 */
public class 二叉搜索树的第k个结点 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private int K = 0;
    private TreeNode result = null;
    TreeNode KthNode(TreeNode pRoot, int k) {
        // 注意使用全局变量保存k
        K = k;
        if (pRoot != null) {
            if (pRoot.left != null) {
                KthNode(pRoot.left, K);
            }
            if (K == 1) {
                result = pRoot;
            }
            --K;
            if (pRoot.right != null) {
                KthNode(pRoot.right, K);

            }
        }
        return result;
    }

}
