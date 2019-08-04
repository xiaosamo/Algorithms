package 剑指Offer;

import java.util.Stack;

/**
 * @author yuan
 * @date 2019/1/30
 * @description
 * in 栈用来处理入栈（push）操作，out 栈用来处理出栈（pop）操作。一个元素进入 in 栈之后，出栈的顺序被反转。当元素要出栈时，需要先进入 out 栈，此时元素出栈顺序再一次被反转，因此出栈顺序就和最开始入栈顺序是相同的，先进入的元素先退出，这就是队列的顺序。
 *
 */
public class 用两个栈实现队列 {

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        if (out.isEmpty()) {
            throw new Exception("queue is empty");
        }

        return out.pop();
    }


    public static void main(String[] args) throws Exception {
        用两个栈实现队列 obj = new 用两个栈实现队列();

        obj.push(1);
        obj.push(2);
        obj.push(3);

        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());

    }
}
