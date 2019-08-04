package 剑指Offer;

/**
 * @author yuan
 * @date 2019/2/15
 * @description
 */
public class 二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int[] sequence, int start, int length) {
        // 根节点的值
        int root = sequence[length - 1];

        // 二叉搜索树中左子树节点的值小于根节点
        int i = start;
        for (; i < length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        // 二叉搜索树中右子树节点的值大于根节点
        int j = i;
        for (; j < length - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        // 判断左子树是不是二叉搜索树
        boolean left = true;
        if (i > 0) {
            left = VerifySquenceOfBST(sequence, 0, i);
        }

        // 判断右子树是不是二叉搜索树
        boolean right = true;
        if (i < length - 1) {
            right = VerifySquenceOfBST(sequence, i, length - i - 1);
        }
        return left && right;
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length);
    }
    
    
}
