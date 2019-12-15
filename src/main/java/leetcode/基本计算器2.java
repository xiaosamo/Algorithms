package leetcode;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yuan
 * @date 2019/12/15
 * @description
 */
public class 基本计算器2 {
    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                queue.offer(c);
            }
        }
        queue.offer('+');

        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        int sum = 0, num = 0;

        while (!queue.isEmpty()) {
            char c = queue.poll();

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                num=0;
                sign = c; // 更新符号
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        基本计算器2 obj = new 基本计算器2();
        System.out.println(obj.calculate("-10"));
    }
}
