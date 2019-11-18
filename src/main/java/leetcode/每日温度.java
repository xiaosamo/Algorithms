package leetcode;

import 基础练习.Stack;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2019/11/16
 * @description
 */
public class 每日温度 {
    /**
     * 复杂度O(n)
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        Stack<Node> stack = new Stack<>();
        int n = T.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                // 栈空，直接入栈
                stack.push(new Node(i, T[i]));
            } else if (T[i] > stack.peek().t) {
                // 当前温度大于栈顶，取出
                while (!stack.isEmpty() && stack.peek().t < T[i]) {
                    Node node = stack.pop();
                    result[node.index] = i - node.index;
                }
                stack.push(new Node(i, T[i]));
            } else if (T[i] <= stack.peek().t) {
                // 当前温度小于等于栈顶，直接压入
                stack.push(new Node(i, T[i]));
            }
        }
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result[node.index] = 0;
        }
        return result;
    }

    static class Node{
        int index; // 下标
        int t;// 温度

        Node(int index, int t) {
            this.index = index;
            this.t = t;
        }
    }

    public static void main(String[] args) {
        每日温度 obj = new 每日温度();
        int[] T = {23, 24, 25, 21, 19, 22, 26, 23};
        int[] result = obj.dailyTemperatures(T);
        System.out.println(Arrays.toString(result));

    }
}
