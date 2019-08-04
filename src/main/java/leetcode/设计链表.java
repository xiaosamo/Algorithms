package leetcode;

/**
 * @author yhf
 * @date 2019/5/14
 * @description
 */
public class 设计链表 {
    static class MyLinkedList {

        private Node root;

        static class Node{
            Node next;
            int val;
            public Node(int val){
                this.val = val;
            }
        }

        /** Initialize your data structure here. */
        public MyLinkedList() {
            root = new Node(-1);
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            Node p = root;
            for (int i = 0; i < index && p != null; i++) {
                p = p.next;
            }
            return p != null ? p.val : -1;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node p = new Node(val);
            p.next = root;
            root = p;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            Node p = root;
            while (p != null) {
                System.out.println("p=" + p.val);

                p = p.next;
            }
            p = new Node(val);
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {

        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {

        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        System.out.println(list.get(0));

        list.addAtHead(2);
        System.out.println(list.get(0));

        list.addAtTail(3);
        System.out.println(list.get(1));
    }
}
