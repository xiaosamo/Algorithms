package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yuan
 * @date 2019/12/8
 * @description
 */
public class 合并K个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 定义一个最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode newHead = new ListNode(-1);
        ListNode p = newHead;

        int k = lists.length;
        // 将k个链表头放到堆
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }

        while (!pq.isEmpty()) {
            // 从堆中取出最小节点
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;
            // 如果改节点还有后续节点，加入堆中
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return newHead.next;
    }
}
