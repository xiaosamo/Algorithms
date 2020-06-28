package leetcode.每日一题;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuan
 * @date 2020/6/26
 */
public class 移除重复节点 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        Set<Integer> set = new HashSet<>();
        set.add(head.val);

        ListNode p = head;
        while (p.next != null) {
            if (!set.contains(p.next.val)) {
                p = p.next;
                set.add(p.val);
            } else {
                p.next = p.next.next;
            }
        }
        p.next=null;
        return head;
    }
}
