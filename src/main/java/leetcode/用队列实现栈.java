package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yuan
 * @date 2019/1/30
 * @description
 */
public class 用队列实现栈 {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    /** Initialize your data structure here. */
    public 用队列实现栈() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()) {
            throw new RuntimeException("队列为空");
        }
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }else{
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if (empty()) {
            throw new RuntimeException("队列为空");
        }
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.peek();
        }else{
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.peek();
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }


    public static void main(String[] args) {
        用队列实现栈 obj = new 用队列实现栈();

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        obj.push(1);
        obj.push(2);

        System.out.println(obj.pop());
        System.out.println(stack.pop());

        System.out.println();
        obj.push(3);
        stack.push(3);

        System.out.println(obj.top());
        System.out.println(stack.peek());

        while (!obj.empty()) {
            System.out.println(obj.pop());
            System.out.println(stack.pop());
        }

        stack.push(9);
        obj.push(9);

        System.out.println(obj.pop());
        System.out.println(stack.pop());

    }
}
