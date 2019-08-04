package 剑指Offer;

/**
 * @author yuan
 * @date 2019/2/13
 * @description
 */
public class 树的子结构 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            // 比较两个根节点
            if (root1.val == root2.val) {
                // 如果根节点相等， 继续比较子树
                result = tree1HaveTree2(root1, root2);
            }

            if (!result) {
                // 如果不是子树，继续比较
                result = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    private boolean tree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }
        // 如果两个根节点相等，继续比较左右节点
        return tree1HaveTree2(root1.left, root2.left) && tree1HaveTree2(root1.right, root2.right);
    }
}
