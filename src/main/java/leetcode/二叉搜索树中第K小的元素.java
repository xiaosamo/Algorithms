package leetcode;

/**
 * @author yuan
 * @date 2019/2/21
 * @description
 * 二叉搜索树（二叉查找树、二叉排序树、BST）的中序遍历就是其所有节点的val按照升序排列。这样根据中序遍历，每找到一个元素判断他是否是第k个元素即可。
 */
public class 二叉搜索树中第K小的元素 {

    private int i = 0;
    private int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        Inorder(root, k);
        return result;
    }

    /**
     * 中序遍历
     * @param root
     * @param k
     */
    private void Inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        Inorder(root.left, k);
        if (++i == k) {
            result = root.val;
        }
        Inorder(root.right, k);
    }


}
