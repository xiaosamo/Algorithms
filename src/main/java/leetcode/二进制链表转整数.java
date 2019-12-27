package leetcode;

/**
 * @author yuan
 * @date 2019/12/27
 * @description
 */
public class 二进制链表转整数 {
    // 常规方法
    public int getDecimalValue(ListNode head) {
        if(head == null) return 0;
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        char[] chars = sb.toString().toCharArray();
        int res = 0;
        int x = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            res += (chars[i] - '0') * x;
            x *= 2;
        }
        return res;

    }

    /**
     * 位运算
     * 由于链表中从高位到低位存放了数字的二进制表示，因此我们可以使用二进制转十进制的方法，在遍历一遍链表的同时得到数字的十进制值。
     * @param head
     * @return
     */
    public int getDecimalValue2(ListNode head) {
        if(head == null) return 0;
        int res = 0;
        while (head != null) {
            res = (res << 1) + head.val;
            head = head.next;
        }
        return res;
    }
}
