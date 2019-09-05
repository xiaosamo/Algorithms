package 基础练习;

import java.util.Scanner;

/**
 * @author yuan
 * @date 2019/9/4
 * @description
 */
public class 表达式计算_leetcode {

    /**
     * 先将中缀表达式转后缀表达式，在计算后缀表达式
     * @param s
     * @return
     */
    public int calculate(String s) {

        Stack<Character> opes = new Stack<>(); // 操作符栈
        Stack<Integer> nums = new Stack<>(); // 数字栈


        /**
         * 1.转为后缀表达式
         */
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ) {
            if (chars[i] == ' ') {
                continue;
            }
            if (Character.isDigit(chars[i])) {
                String num = "";
                while (i < chars.length && Character.isDigit(chars[i])) {
                    num += chars[i++];
                }
                nums.push(Integer.valueOf(num));
            } else {
                // + - * / ( )
                switch (chars[i]) {
                    case '(':
                        opes.push(chars[i]);
                        break;
                    case ')':
                        // 抛出'('前面的所有操作符
                        while (opes.peek() != '(') {
                            int t = cal(nums.pop(), nums.pop(), opes.pop());
                            nums.push(t);
                        }
                        // 抛出'('
                        opes.pop();
                        break;
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        if (opes.isEmpty()) {
                            // 栈为空直接入栈
                            opes.push(chars[i]);
                        } else {
                            // 若栈顶元素优先级大于或等于要入栈的元素,将栈顶元素弹出并计算,然后入栈
                            if (getPriority(opes.peek()) >= getPriority(chars[i])) {
                                int t = cal(nums.pop(), nums.pop(), opes.pop());
                                nums.push(t);
                            }
                            opes.push(chars[i]);
                        }
                        break;
                    default:
                        // 不合法
                }
                ++i;

            }
        }

        // 计算后缀表达式
        while (!opes.isEmpty()) {
            int num = cal(nums.pop(), nums.pop(), opes.pop());
            nums.push(num);
        }

        return nums.size() > 0 ? nums.peek() : Integer.valueOf(s);
    }

    private int cal(Integer n1, Integer n2, Character ope) {
        switch (ope) {
            case '+':
                return n2 + n1;
            case '-':
                return n2 - n1;
            case '*':
                return n2 * n1;
            case '/':
                return n2 / n1;
            default:
                return 0;
        }
    }

    /**
     * 获取优先级
     *
     * @param c
     * @return
     */
    private int getPriority(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        }
        // ( ) 不用管
        return 0;
    }

    public static void main(String[] args) {
        String s = "1-2+3*(4-5)";
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();

        表达式计算_leetcode obj = new 表达式计算_leetcode();
        System.out.println(obj.calculate(s));


    }
}
