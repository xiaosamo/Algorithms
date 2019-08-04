package leetcode;

public class Main2 {

      class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = 0, b = 0,x=1;

        while (l1.next != null) {
            a += l1.val*x;
            x*=10;
            l1 = l1.next;
        }
        x=1;
        while (l2.next != null) {
            b += l1.val*x;
            x*=10;
            l2 = l2.next;
        }

        ListNode head=new ListNode(-1);
        ListNode q=head;
        int ans = a + b;
        while (ans > 0) {

            x = ans % 10;
            ans/=10;

            ListNode p = new ListNode(x);
            head.next=p;
            q=head.next;

//            node.next=p;
//            node = node.next;
//            p=head;
        }

//        return head.next;
        return head.next;
    }


    public static void main(String[] args) {

        double d = 12*Math.pow(16,3)+11*Math.pow(16,2)+8*16+4;
        System.out.println(d);

    }
}
