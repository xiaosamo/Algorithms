package leetcode;

/**
 * @author yuan
 * @date 2019/1/31
 * @description
 */
public class 链表的中间结点 {


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode p = head;
        // 计算链表长度
        while (p != null) {
            ++len;
            p = p.next;
        }
        int m = len / 2;
        p = head;
        for (int i = 0; i < m; i++) {
            p = p.next;
        }
        return p;
    }

    /**
     * 快慢指针法
     */
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

        public static void main(String[] args) {
        链表的中间结点 obj = new 链表的中间结点();
    }
}
