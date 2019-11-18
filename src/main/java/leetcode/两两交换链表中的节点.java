package leetcode;

/**
 * @author yuan
 * @date 2019/11/16
 * @description
 */
public class 两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        return reverseKGroup(head, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            ++n;
            p = p.next;
        }
        if (k > n) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        n = k;
        while (cur != null && n-- > 0) {
            next = cur.next;
            cur.next = prev;
            prev= cur;
            cur = next;
        }
        head.next = reverseKGroup(cur, k);
        return prev;
    }
}
