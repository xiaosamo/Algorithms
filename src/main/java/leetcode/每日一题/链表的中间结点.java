package leetcode.每日一题;

import leetcode.ListNode;

/**
 * @author yuan
 * @date 2020/3/23
 */
public class 链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        ListNode p = head;
        int n = 0;
        while (p != null) {
            p = p.next;
            n++;
        }

        int i = 0;
        while (head != null && i < n / 2 + 1) {
            head = head.next;
            i++;
        }
        return head;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode fast = head,slow=head;
        while (fast != null && slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
