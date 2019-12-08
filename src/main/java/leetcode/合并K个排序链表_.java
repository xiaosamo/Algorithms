package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yuan
 * @date 2019/12/8
 * @description
 */
public class 合并K个排序链表_ {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        int m = l + (r - l) / 2;
        return mergeTwoLists(mergeKLists(lists, l, m), mergeKLists(lists, m + 1, r));
    }
    // 归并2个链表
    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.val <= b.val) {
            a.next = mergeTwoLists(a.next, b);
            return a;
        } else {
            b.next = mergeTwoLists(a, b.next);
            return b;
        }
    }
}
