package 剑指Offer;

/**
 * @author yuan
 * @date 2019/2/12
 * @description
 */
public class 链表中倒数第k个节点 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode p = head;
        for (int i = 0; i < k - 1; i++) {
            if (head.next != null) {
                head = head.next;
            } else {
                // 如果链表没有k-1个节点
                return null;
            }
        }
        while (head.next != null) {
            head = head.next;
            p = p.next;
        }
        return p;
    }
}
