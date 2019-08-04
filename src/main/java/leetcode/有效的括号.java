package leetcode;

import java.util.Stack;

public class 有效的括号 {
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character t = stack.pop();

                if (c == ')' && t != '(') {
                    return false;
                }
                if (c == ']' && t != '[') {
                    return false;
                }
                if (c == '}' && t != '{') {
                    return false;
                }

            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }
}
