package leetcode;

/**
 * @author yuan
 * @date 2019/3/16
 * @description
 */
public class 反转链表 {
    /**
     * 使用3个指针
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode node = head;
        ListNode reverseHead = null;
        while (node != null) {
            ListNode next = node.next;
            if (next == null) {
                reverseHead = node;
            }
            node.next = pre;
            pre = node;
            node = next;
        }
        return reverseHead;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return head;
    }

}