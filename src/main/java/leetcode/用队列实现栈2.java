package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yuan
 * @date 2019/1/30
 * @description
 */
public class 用队列实现栈2 {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    /** Initialize your data structure here. */
    public 用队列实现栈2() {
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
        // 如果队列2为空
        if (queue2.isEmpty()) {
            // 把队列1的元素放入队列2，再删除队列1的最后一个元素
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        } else if (queue1.isEmpty()) {
            // 如果队列1为空
            // 把队列2的元素放入队列1，再删除队列2的最后一个元素
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        } else {
            // 如果队列1和队列2都不为空，先抛出队列1的，因为队列1的元素比队列2的元素后放入，栈是后进先出
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
    }

    // top不对
    /** Get the top element. */
    public int top() {
        // 如果队列2为空
        if (queue2.isEmpty()) {
            // 把队列1的元素放入队列2，再删除队列1的最后一个元素
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.peek();
        } else if (queue1.isEmpty()) {
            // 如果队了1为空
            // 把队列2的元素放入队列1，再删除队列2的最后一个元素
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.peek();
        } else {
            // 如果队列1和队列2都不为空，先抛出队列1的，因为队列1的元素比队列2的元素后放入，栈是后进先出
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.peek();
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }


    public static void main(String[] args) {
        用队列实现栈2 obj = new 用队列实现栈2();

        obj.push(1);
        obj.push(2);
        obj.push(3);

        // 3
        System.out.println(obj.top());
        System.out.println();
        System.out.println(obj.pop());
        System.out.println();

        // 2
        System.out.println(obj.top());
        System.out.println();
        System.out.println(obj.pop());

    }
}
