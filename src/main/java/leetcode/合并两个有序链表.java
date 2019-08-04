package leetcode;

/**
 * @author yuan
 * @date 2019/6/23
 * @description
 */
public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode p = new ListNode(-1);
        ListNode head = p;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                // add l2
                p.next = new ListNode(l2.val);
                p = p.next;
                l2 = l2.next;
            } else if (l2 == null) {
                // add l1
                p.next = new ListNode(l1.val);
                p = p.next;
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                // add l1
                p.next = new ListNode(l1.val);
                p = p.next;
                l1 = l1.next;
            } else if (l2.val < l1.val) {
                // add l2
                p.next = new ListNode(l2.val);
                p = p.next;
                l2 = l2.next;
            } else {
                // add l1,l2
                p.next = new ListNode(l1.val);
                p = p.next;

                p.next = new ListNode(l2.val);
                p = p.next;

                l1 = l1.next;
                l2 = l2.next;
            }

        }

        return head.next;
    }

    /**
     * 更简洁的做法，递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode list = null;
        if (l1.val < l2.val) {
            list = new ListNode(l1.val);
            list.next = mergeTwoLists2(l1.next, l2);
        } else {
            list = new ListNode(l2.val);
            list.next = mergeTwoLists2(l1, l2.next);
        }
        return list;
    }

    /**
     * 循环
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                // add l1
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                // add l2
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条
        if (l1 == null) {
            p.next = l2;
        } else {
            p.next = l1;
        }
        return head.next;
    }




        public static void main(String[] args) {
        合并两个有序链表 obj = new 合并两个有序链表();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode p = obj.mergeTwoLists(l1, l2);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }

//        ListNode l3 = new ListNode(5);
//        ListNode p = obj.mergeTwoLists(l3, l1);
//        while (p != null) {
//            System.out.print(p.val + " ");
//            p = p.next;
//        }
    }
}
