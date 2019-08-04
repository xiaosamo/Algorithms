package leetcode;

/**
 * @author yuan
 * @date 2019/2/12
 * @description
 */
public class 环形链表2 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode mettingNode = getMettingNode(head);
        // 如果没有环
        if (mettingNode == null) {
            return null;
        }
        // 环的节点个数
        int num = 1;

        ListNode p1 = mettingNode;
        // 计算环的节点数量
        while (p1.next != null) {
            ++num;
            p1 = p1.next;
        }

        p1 = head;
        // 先移动第一个指针
        for (int i = 0; i < num; i++) {
            p1 = p1.next;
        }

        // 同时移动两个指针
        ListNode p2 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }


    /**
     * 获取环中相遇节点
     * @param head
     * @return
     */
    public ListNode getMettingNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null) {
            if (fast == slow) {
                return slow;
            }

            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }



}
