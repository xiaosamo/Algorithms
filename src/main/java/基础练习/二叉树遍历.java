package 基础练习;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class 二叉树遍历 {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 插入节点到root
     * @param root
     * @param val
     */
    public  void insert(TreeNode root, int val) {
        if (val > root.val) {
            // 在右边插入，右节点比根节点大
            if (root.right != null) {
                insert(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        } else {
            // 在左边插入，左节点比根节点小
            if (root.left != null) {
                insert(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }
        }

    }

    /**
     * 先序遍历,递归
     */
    public  void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);

        }
    }

    /**
     * 中序遍历,递归
     */
    public  void InOrder(TreeNode node) {
        if (node != null) {
            InOrder(node.left);
            System.out.print(node.val + " ");
            InOrder(node.right);

        }
    }

    /**
     * 后序遍历,递归
     */
    public  void PostOrder(TreeNode node) {
        if (node != null) {
            PostOrder(node.left);
            PostOrder(node.right);
            System.out.print(node.val + " ");
        }
    }


    /**
     * 先序遍历，非递归
     * 手算的思想，边访问边找，找到最左下方的，然后向上退一步再访问右边的
     */
    public  void preOrder2(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.print(node.val + " ");
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 先序遍历，非递归
     * 栈的思想，按层次倒着进栈，利用后进先出解决顺序问题
     * @param node
     */
    public void preOrder3(TreeNode node) {
        if (node == null) {
            throw new NullPointerException();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            System.out.print(t.val + " ");
            if (t.right != null) {
                stack.push(t.right);
            }
            if (t.left != null) {
                stack.push(t.left);
            }
        }
    }

    /**
     * 中序遍历，非递归
     * 和先序遍历基本一样，只需修改下输出的位置
     * @param p
     */
    public void InOrder2(TreeNode p) {
        if (p == null) {
            throw new NullPointerException();
        }
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                System.out.print(p.val + " ");
                p = p.right;
            }
        }
    }

    /**
     * 后序遍历，非递归
     * 双栈法，易于理解
     * @param p
     */
    public void PostOrder2(TreeNode p) {
        if (p == null) {
            throw new NullPointerException();
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> result = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                result.push(p);
                p = p.right;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.left;
            }
        }
        while (!result.isEmpty()) {
            p = result.pop();
            System.out.print(p.val + " ");
        }
    }



    /**
     * 计算二叉树深度
     *
     * @param node
     * @return
     */
    private  int diameter = 0;

    public  int deep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = deep(node.left);
        int r = deep(node.right);
        // 求二叉树的直径
        diameter = Math.max(l + r, diameter);

        return Math.max(l, r) + 1;
    }


    /**
     * 层次遍历
     * @param node
     */
    public  void levelOrder(TreeNode node) {
        if (node == null) {
            throw new NullPointerException();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            System.out.print(t.val + " ");
            if (t.left != null) {
                queue.add(t.left);
            }
            if (t.right != null) {
                queue.add(t.right);
            }
        }
    }

    public  void sum(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            System.out.print(t.val);
            if (t.left != null) {
                queue.add(t.left);
            }else{
                sum += t.val;
            }
            if (t.right != null) {
                queue.add(t.right);
            }
        }
        System.out.println(sum);
    }



    public static void main(String[] args) {
        二叉树遍历 obj = new 二叉树遍历();

        obj.test(obj);
    }

    private void test(二叉树遍历 obj){
        int[] a = {48, 35, 76, 90, 22, 16, 12, 46, 18, 40};
        TreeNode root = new TreeNode(a[0]);

        for (int i = 1; i < a.length; i++) {
            obj.insert(root, a[i]);
        }

        System.out.println("\n先序遍历结果：");
        obj.preOrder2(root);

        System.out.println("\n中序遍历结果：");
        obj.InOrder2(root);

        System.out.println("\n后序遍历结果：");
        obj.PostOrder2(root);

        System.out.println("\n层次遍历结果：");
        levelOrder(root);

        System.out.println("\n二叉树的深度为：" + deep(root));
//        sum(root);
    }

}
