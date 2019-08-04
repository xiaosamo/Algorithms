package 面试题;

import java.util.Arrays;

/**
 * @author yhf
 * @date 2019/5/6
 * @description
 */
public class 大数乘法2 {
    public static void main(String[] args) {
        大数乘法2 obj = new 大数乘法2();
        System.out.println(obj.multiply("123", "456"));
        System.out.println(obj.multiply("98", "9"));

    }


    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int l1 = num1.length();
        int l2 = num2.length();

        int l = l1 + l2;

        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();

        char[] ans = new char[l];

        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                ans[i + j + 1] += (c1[i] - '0') * (c2[j] - '0');
            }
        }

        for (int i = l - 1; i > 0; i--) {
            if (ans[i] > 9) {
                ans[i - 1] += ans[i] / 10;
                ans[i] %= 10;
            }
        }

        // 去掉前面的0
        int i = 0;
        while (ans[i] == 0) {
            ++i;
        }
        StringBuilder sb = new StringBuilder();
        for (; i < ans.length; i++) {
            sb.append((char) (ans[i] + '0'));
        }
        return sb.toString();
    }

//    public String multiply(String num1, String num2) {
//        if (num1.equals("0") || num2.equals("0")) {
//            return "0";
//        }
//        int l1 = num1.length(), l2 = num2.length(), l = l1 + l2;
//        char[] ans = new char[l];
//        char[] c1 = num1.toCharArray();
//        char[] c2 = num2.toCharArray();
//        for (int i = l1 - 1; i >= 0; --i) {
//            for (int j = l2 - 1; j >= 0; --j) {
//                ans[i + j + 1] += (c1[i] - '0') * (c2[j] - '0');
//            }
//        }
//        for (int i = l - 1; i > 0; --i) {
//            if (ans[i] > 9) {
//                ans[i - 1] += ans[i] / 10;
//                ans[i] %= 10;
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        int i = 0;
//        for (; ; ++i) {
//            if (ans[i] != 0) {
//                break;
//            }
//        }
//        for (; i < ans.length; ++i) {
//            sb.append((char) (ans[i] + '0'));
//        }
//        return sb.toString();
//    }
}
