package 面试题;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author yuan
 * @date 2020/1/13
 * @description
 */
public class 压缩算法 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
//        String s = "HG[3|B[2|CA]]F";

        System.out.println(solve(s));

    }

    private static String solve(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            switch (c){
                case ']':

                    String t = "";
                    while (stack.peek() != '|') {
                        t = stack.pop() + t;
                    }
                    stack.pop();
                    // 取数字
                    int num = 0;
                    while (Character.isDigit(stack.peek())) {
                        num = num * 10 + stack.pop() - '0';
                    }
                    stack.pop();

                    // 重新压入
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < t.length(); j++) {
                            stack.push(t.charAt(j));
                        }
                    }

                    break;
                default:
                    stack.push(c);
            }
        }
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;

    }
}
