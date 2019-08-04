package 蓝桥杯.模拟;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/3/23
 * @description
 * 现在给你二叉树的前序遍历，和中序遍历，让你求出它的后序遍历
 */
public class 二叉树 {

    static int n;

    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }
            TreeNode root = null;
            root = create(a, 0, a.length - 1, b, 0, b.length - 1, root);
            Queue<Integer> queue = new LinkedList<>();
            dfs(root, queue);
            while (queue.size() > 1) {
                System.out.print(queue.poll()+" ");
            }
            System.out.println(queue.poll());
        }

    }

    /**
     * 后序遍历
     * @param root
     */
    private static void dfs(TreeNode root,Queue<Integer> q){
        if (root != null) {
            dfs(root.left, q);
            dfs(root.right, q);
            q.offer(root.val);
//            System.out.print(root.val + " ");
        }
    }

    private static TreeNode create(int[] a, int l1, int r1, int[] b, int l2, int r2, TreeNode node) {
        if (l1 > r1 || l2 > r2) {
            return null;
        }
        //根节点所在的位置
        node = new TreeNode(a[l1]);

        int i;
        for (i = 0; i < n; i++) {
            if (b[i] == a[l1]) {
               break;
            }
        }
        // 左子树个数
        int leftNum = i - l2;
        // 右子树个数
        int rightNum = r2 - i;

        // 构造左子树
        node.left = create(a, l1 + 1, l1 + leftNum, b, l2, i - 1, node.left);
        // 构造右子树
        node.right = create(a, r1 - rightNum + 1, r1, b, i + 1, r2, node.right);

        return node;
    }
}
