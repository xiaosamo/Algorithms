package 剑指Offer;

import java.util.Stack;

/**
 * @author yuan
 * @date 2019/2/14
 * @description
 */
public class 栈的压入_弹出序列 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || popA.length == 0 || pushA.length == 0) {
            return false;
        }
        int index = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < pushA.length; i++) {
            if (pushA[i] != popA[index]) {
                stack.push(pushA[i]);
            }
        }
        return false;


    }

}
