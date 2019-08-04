package 剑指Offer;

import java.util.Stack;

/**
 * @author yuan
 * @date 2019/2/14
 * @description
 */
public class 包含min函数的栈 {
    /**
     * 数据栈
     */
    private Stack<Integer> dataStack = new Stack<>();

    /**
     * 辅助栈min
     */
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);

        if (minStack.isEmpty() || node < minStack.peek()) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (!dataStack.isEmpty() && !minStack.isEmpty()) {
            dataStack.pop();
            minStack.pop();
        }
    }

    /**
     * 获取数据栈顶的元素，不弹出
     * @return
     */
    public int top() {
        return dataStack.peek();
    }

    /**
     * 获取min站顶的元素，不弹出
     * @return
     */
    public int min() {
        return minStack.peek();
    }

}
