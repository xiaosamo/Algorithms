package 面试题;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author yuan
 * @date 2019/9/18
 * @description
 */
public class 最小栈 {
    private static Stack<Integer> dataStack = new Stack<>();
    private static Stack<Integer> minStack = new Stack<>();

    private static void push(Integer val) {
        dataStack.push(val);
        if (minStack.isEmpty() || val < minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    private static Integer pop(){
        minStack.pop();
        return dataStack.pop();
    }

    private static Integer min(){
        return minStack.peek();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0) {
            int a = in.nextInt();
            switch (a) {
                case 0:
                    System.out.println(min());
                    break;
                case 1:
                    push(in.nextInt());
                    break;
                case 2:
                    System.out.println(pop());
                    break;
                default:
            }
        }
    }



}
