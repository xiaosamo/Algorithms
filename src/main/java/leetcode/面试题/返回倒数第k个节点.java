package leetcode.面试题;

import leetcode.ListNode;

/**
 * @author yuan
 * @date 2020/3/1
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 快慢指针，快指针先走k个节点，然后快慢指针一起走
 */
public class 返回倒数第k个节点 {
    public int kthToLast(ListNode head, int k) {
        ListNode fast  = head,slow = head;
        // 快指针先走k个节点
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;

        }
        return slow.val;
    }

}
