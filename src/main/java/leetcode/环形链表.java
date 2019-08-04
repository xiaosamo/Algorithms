package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yuan
 * @date 2019/2/12
 * @description
 */
public class 环形链表 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 哈希表O(n)
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 双指针O(n)
     * 空间复杂度O(1)
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }

            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return false;
    }
}
