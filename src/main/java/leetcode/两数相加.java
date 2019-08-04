package leetcode;

/**
 * @author yuan
 * @date 2018/12/21
 */
public class 两数相加 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        int s = 0, carry = 0;
        while (l1 != null || l2 != null) {
            // s = l1.val + l2.val + carry;
            s = carry;
            if (l1 != null) {
                s += l1.val;
            }
            if (l2 != null) {
                s += l2.val;
            }
            carry = s / 10;
            ListNode node = new ListNode(s % 10);
            p.next = node;
            p = p.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            p.next = node;
        }
        return head.next;
    }
}
