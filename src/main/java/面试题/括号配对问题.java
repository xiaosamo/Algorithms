package 面试题;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author yuan
 * @date 2019/9/29
 * @description
 */
public class 括号配对问题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        System.out.println(solve(s));
    }

    private static boolean solve(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            switch (c) {
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                default:

            }
        }
        return stack.isEmpty();
    }
}
