package 剑指Offer;

import 基础练习.Stack;

/**
 * @author yuan
 * @date 2019/10/6
 * @description
 */
public class 最小栈 {
    
}
class MinStack {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        dataStack.push(x);

        if (minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();

    }

    public int getMin() {
        return minStack.peek();
    }

}
