package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yuan
 * @date 2019/12/24
 * @description
 */
public class 计算右侧小于当前元素的个数 {
    static class Node{
        int l,r;
        int count ;
        Node left,right;

        public Node(int l, int r, int count) {
            this.l = l;
            this.r = r;
            this.count = count;
        }
    }

    private Node root;

    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> list = new LinkedList<>();
        int max = nums[0], min = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            root = add(root, nums[i], min, max);
            list.add(0, count(root, nums[i]));
        }
        return list;
    }

    private int count(Node x, int n) {
        if (x == null) {
            return 0;
        }

        int sum = 0;

        if (x.l <= n && x.r >= n) {
            sum = count(x.left, n) + count(x.right, n);
        } else if (x.r < n) {
            return x.count;
//        } else if (x.l > n) {
        } else{
            return 0;
        }
        return sum;
    }

    private Node add(Node x, int n, int l, int r) {

        if (x == null) {
            // 根节点
            x = new Node(l, r, 0);
        }

        if (x.l <= n && n <= x.r) {
            x.count += 1;
        }

        if (x.l == x.r) {
            // 叶子节点
            return x;
        }

        int m = l + (r - l) / 2;
        x.left = add(x.left, n, l, m);
        x.right = add(x.right, n, m + 1, r);

        return x;
    }


    public static void main(String[] args) {
        计算右侧小于当前元素的个数 obj = new 计算右侧小于当前元素的个数();
        List<Integer> list = obj.countSmaller(new int[]{5, 2, 6, 1});
        list.forEach(i -> System.out.print(i + " "));
    }
}
