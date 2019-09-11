package 面试题.去哪儿;

/**
 * @author yuan
 * @date 2019/9/7
 * @description
 */
public class 字符串替换 {
    public String formatString(String A, int n, char[] arg, int m) {
        if (n < 2) {
            return A;
        }

        // write code here
        StringBuilder sb = new StringBuilder();
        char[] chars = A.toCharArray();
        int t = 0;
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] == '%' && chars[i + 1] == 's') {
                sb.append(arg[t++]);
                if (t > arg.length - 1) {
                    break;
                }
                ++i;
            } else {
                sb.append(chars[i]);
            }

        }
        if (A.charAt(n-2) == '%' && A.charAt(n-1) == 's') {
        }else{
            sb.append(A.charAt(n - 1));
        }


        while (t < arg.length) {
            sb.append(arg[t++]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        字符串替换 obj = new 字符串替换();
        System.out.println(obj.formatString("A%sC%sE", 7, new char[]{'B', 'D', 'F'}, 0));
        System.out.println(obj.formatString("A%sCE%s", 7, new char[]{'B', 'D', 'F'}, 0));
        System.out.println(obj.formatString("%s", 2, new char[]{'B', 'D', 'F'}, 0));
    }
}
