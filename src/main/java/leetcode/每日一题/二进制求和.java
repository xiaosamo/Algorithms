package leetcode.每日一题;

/**
 * @author yuan
 * @date 2020/6/23
 */
public class 二进制求和 {
    public String addBinary(String a, String b) {
        if ("".equals(a)) {
            return b;
        }
        if ("".equals(b)) {
            return a;
        }
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int l1 = c1.length, l2 = c2.length;
        int i = l1 - 1, j = l2 - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int t;
            if (i < 0) {
                t = carry + c2[j--] - '0';
            } else if (j < 0) {
                t = carry + c1[i--] - '0';
            } else {
                t = c1[i--] - '0' + c2[j--] - '0' + carry;

            }
            if (t > 1) {
                carry = t / 2;
                t %= 2;
            } else {
                carry = 0;
            }
            sb.append(t);
        }
        if (carry != 0) {
            sb.append(carry % 2);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new 二进制求和().addBinary("11", "1"));
        System.out.println(new 二进制求和().addBinary("1010", "1011"));
    }
}
