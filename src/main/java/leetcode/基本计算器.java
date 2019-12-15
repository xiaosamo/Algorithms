package leetcode;

import 基础练习.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2019/12/15
 * @description
 */
public class 基本计算器 {
    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                queue.offer(c);
            }
        }
        // 加上一个+可以处理最后一个数
        queue.add('+');
        return calculate(queue);
    }

    private int calculate(Queue<Character> queue) {
        char sign = '+'; // 添加一个符号变量，初始化为+
        int sum = 0, num = 0;

        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                // 遇到左括号，递归处理，遇到右括号，表示小括号处理完毕，返回
                num = calculate(queue);
            } else {
                // 遇到了符号
                if (sign == '+') {
                    sum += num;
                } else if (sign == '-') {
                    sum -= num;
                }

                // 更新当前符号
                sign = c;
                num = 0;

                if (c == ')') {
                    // 右括号，直接返回当前总和
                    break;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        基本计算器 obj = new 基本计算器();
        System.out.println(obj.calculate("1 + (3 - 10)"));
    }
}
