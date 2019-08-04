package 剑指Offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author yuan
 * @date 2019/1/30
 * @description
 */
public class 从尾到头打印链表 {


    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode p = listNode;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }

        while (stack.size() > 0) {
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        从尾到头打印链表 obj = new 从尾到头打印链表();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        ArrayList<Integer> list = obj.printListFromTailToHead(node);
        list.forEach(i -> System.out.println(i));

    }
}
