package leetcode.每日一题;

import leetcode.ListNode;

import java.math.BigInteger;
import java.util.Stack;

/**
 * @author yuan
 * @date 2020/4/14
 */
public class 两数相加2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuffer sb1 = new StringBuffer();
        while (l1 != null) {
            sb1.append(l1.val);
            l1 = l1.next;
        }
        StringBuffer sb2 = new StringBuffer();
        while (l2 != null) {
            sb2.append(l2.val);
            l2 = l2.next;
        }

        BigInteger a = new BigInteger(sb1.toString());
        BigInteger b = new BigInteger(sb2.toString());

        char[] chars = a.add(b).toString().toCharArray();

        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (char c : chars) {
            p.next = new ListNode(c - '0');
            p = p.next;
        }
        return head.next;
    }

    /**
     * 使用栈
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();

            // 头插法
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;

            carry = sum / 10;
        }
        return head;
    }
}