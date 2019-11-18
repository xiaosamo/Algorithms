package leetcode;

import java.util.Stack;

public class 有效的括号 {
    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
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
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }
}
