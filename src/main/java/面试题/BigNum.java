package 面试题;

/**
 * @author yuan
 * @date 2019/4/22
 * @description
 */
public class BigNum {
    /**
     * 假设啊a、b都为>= 0
     * @param a
     * @param b
     * @return
     */
    public static String add(String a,String b) {
        if (a == null || b == null) {
            return null;
        }
        if ("".equals(a)) {
            return b;
        }
        if ("".equals(b)) {
            return a;
        }
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();

        int i = a.length() - 1, j = b.length() - 1;
        int s = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 && j >= 0) {

            int t = c1[i] - '0' + c2[j] - '0' + s;
            if (t > 9) {
                s = t / 10;
                t %= 10;
            }
            --j;
            --i;

            ans.append(String.valueOf(t));
        }
        while (i >= 0) {
            int t = c1[i] - '0' + s;
            if (t > 9) {
                s = t / 10;
                t %= 10;
            }
            ans.append(String.valueOf(t));
            --i;
        }

        while (j >= 0) {
            int t = c2[j] - '0' + s;
            if (t > 9) {
                s = t / 10;
                t %= 10;
            }
            ans.append(String.valueOf(t));
            --j;
        }
        if (s > 0) {
            ans.append(s);
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(add("101", "10"));
        System.out.println(add("123", "456"));
        System.out.println(add("1234", "2341"));
        System.out.println(add("999", "1"));
        System.out.println(add("9998", "2"));
        System.out.println(add("5555", "5555"));
    }
}
