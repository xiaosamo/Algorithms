package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yuan
 * @date 2018/12/20
 */
public class 用栈实现队列 {

    private Stack<Integer> stack = new Stack<>();

    /** Initialize your data structure here. */
    public 用栈实现队列() {


    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (!empty()) {
            List<Integer> list = new ArrayList<>();
            while (!empty()) {
                list.add(0, pop());
            }
            stack.push(x);
            for (Integer i : list) {
                stack.push(i);
            }
        } else {
            stack.push(x);
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        用栈实现队列 obj = new 用栈实现队列();
        for (int i = 0; i < 100; i++) {
            obj.push(i);
        }
        while (!obj.empty()) {
            System.out.println(obj.pop());
        }
//          int param_2 = obj.pop();
//          int param_3 = obj.peek();
//          boolean param_4 = obj.empty();
    }
}
