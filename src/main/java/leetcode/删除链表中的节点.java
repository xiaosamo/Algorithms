package leetcode;

/**
 * @author yuan
 * @date 2019/1/31
 * @description
 *  node这个节点就是需要删除的节点；之前我们可以用head->next->val去判断下一个是否是删除的节点，然后head->next=head->next->next
 *  这题可以用把 node下一节点复制到node，把下一节点跳过！这道题出的挺好的啊！
 */
public class 删除链表中的节点 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public static void main(String[] args) {
        删除链表中的节点 obj = new 删除链表中的节点();

    }
}
