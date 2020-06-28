package leetcode.每日一题;

import leetcode.ListNode;

/**
 * @author yuan
 * @date 2020/3/2
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;

        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 遍历完pre就是头节点
        return pre;
    }
}
