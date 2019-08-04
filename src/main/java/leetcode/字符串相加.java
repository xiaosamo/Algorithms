package leetcode;

public class 字符串相加 {
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();

        // 进位
        int carry = 0;
        while (len1 > 0 || len2 > 0 || carry > 0) {
            int t = carry;
            if (len1 > 0) {
                len1--;
                t += num1.charAt(len1) - '0';
            }

            if (len2 > 0) {
                len2--;
                t += num2.charAt(len2) - '0';
            }

            // 保存进位
            carry = t / 10;
            result.append(t % 10);
        }
        return result.reverse().toString();
    }


    public static String addStrings2(String num1, String num2) {
        StringBuilder result = new StringBuilder(5200);
        int carry = 0;
        int l1 = num1.length();
        int l2 = num2.length();
        while(l1>0 || l2 > 0 || carry > 0) {
            int tem = carry;
            if(l1 > 0) {
                l1--;
                tem = tem + num1.charAt(l1) - '0';
            }
            if(l2 > 0) {
                l2--;
                tem = tem + num2.charAt(l2) - '0';
            }
            carry = tem/10;
            result.append(tem%10);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("123", "17"));
        System.out.println(addStrings2("123", "17"));
    }


}
