package leetcode;

/**
 * @author yuan
 * @date 2019/11/16
 * @description
 */
public class K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {

        // 检查k是否大于链表长度，是则直接返回
        ListNode p = head;
        int n = 0;
        while (p != null) {
            ++n;
            p = p.next;
        }
        if (k > n) {
            return head;
        }

        ListNode prev = null;
        ListNode cur =head;
        ListNode next = null;
        n = k;
        while (cur != null && n-- > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = reverseKGroup(cur, k);
        return prev;
    }
}
