package leetcode.每日一题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2020/3/1
 */
public class 用队列实现栈 {
    static class MyStack {

        Queue<Integer> q1;
        Queue<Integer> q2;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            if (q1.isEmpty()) {
                q1.offer(x);
                while (!q2.isEmpty()) {
                    q1.offer(q2.poll());
                }
            } else {
                q2.offer(x);
                while (!q1.isEmpty()) {
                    q2.offer(q1.poll());
                }
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (q1.isEmpty()) {
                return q2.poll();
            } else {
                return q1.poll();
            }
        }

        /**
         * Get the top element.
         */
        public int top() {
            if (q1.isEmpty()) {
                return q2.peek();
            } else {
                return q1.peek();
            }
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

    }

}
