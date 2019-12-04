package leetcode;

/**
 * @author yuan
 * @date 2019/12/3
 * @description
 * https://leetcode-cn.com/problems/odd-even-linked-list/solution/qi-ou-lian-biao-by-leetcode/
 */
public class 奇偶链表 {
    // 自己的
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        // odd奇，even偶
        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);

        ListNode oddHead = odd;
        ListNode eventHead = even;

        int num = 1;
        while (head != null) {
            if (num % 2 == 1) {
                // 奇
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            head = head.next;
            ++num;
        }
        odd.next = eventHead.next;
        eventHead = null;
        even.next = null;
        return oddHead.next;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null) {
            return null;
        }
        // head保存奇节点的头，odd保存寄节点的尾
        // evenHead 和 even 保存偶链表的头和尾指针
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;

    }

    public static void main(String[] args) {
        奇偶链表 obj = new 奇偶链表();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode node = obj.oddEvenList(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}