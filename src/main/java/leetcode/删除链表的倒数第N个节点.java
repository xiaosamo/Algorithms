package leetcode;

/**
 * @author yuan
 * @date 2019/2/12
 * @description
 */
public class 删除链表的倒数第N个节点 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 删除第0个节点不合法、如果只有一个节点，删除后为null
        if (head == null || n == 0 || head.next == null) {
            return null;
        }

        ListNode p = head, pHead = head;
        for (int i = 0; i < n - 1; i++) {
            if (head.next != null) {
                head = head.next;
            } else {
                // 如果链表没有k-1个节点
                return null;
            }
        }
        ListNode q = p;
        // 如果是删除第一个节点
        if (head.next == null) {
            return p.next;
        }
        while (head.next != null) {
            head = head.next;
            q = p;
            p = p.next;
        }
        // p为要删除的节点，q指向p的前一个节点
        q.next = p.next;
        return pHead;
    }

    public static void main(String[] args) {
        删除链表的倒数第N个节点 obj = new 删除链表的倒数第N个节点();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;

        ListNode list = obj.removeNthFromEnd(l1, 2);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }

    }
}

