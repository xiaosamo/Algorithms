package 剑指Offer;

/**
 * @author yuan
 * @date 2019/2/12
 * @description
 */
public class 反转链表 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode revHead = null;
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            if (next == null) {
                revHead = node;
            }

            node.next = pre;
            pre = node;
            node = next;
        }
        return revHead;
    }
}
