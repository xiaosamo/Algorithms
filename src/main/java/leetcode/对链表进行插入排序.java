package leetcode;

/**
 * @author yuan
 * @date 2019/11/22
 * @description
 * https://leetcode-cn.com/problems/insertion-sort-list/solution/lian-biao-de-cha-ru-pai-xu-by-a380922457/
 */
public class 对链表进行插入排序 {
    /**
     * 构建一个以newHead为头结点的新链表
     * 不断遍历当前链表，再找到newHead中合适的位置插入
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode cur = newHead;
            ListNode next = head.next;

            while (cur.next != null && cur.next.val < head.val) {
                cur = cur.next;
            }
            head.next = cur.next;
            cur.next = head;
            head = next;
        }
        return newHead.next;
    }
}
