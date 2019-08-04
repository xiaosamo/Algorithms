package leetcode;

/**
 * @author yuan
 * @date 2019/3/11
 * @description
 */
public class 七进制数 {
    public String convertToBase7(int num) {
        if (num < 0) {
            return "-" + transfor(-num, 7);
        }
        return transfor(num, 7);
    }

    public String transfor(int num, int n) {
        if (num == 0) {
            return "0";
        }
        String res = "";
        while (num > 0) {
            int t = num % n;
            num /= n;
            if (t > 9) {
                char c = (char) ('a' + (t - 10));
                res = c + res;
            } else {
                res = t + res;
            }
        }
//        res = res.replaceAll("[0-9a-z]*-", "");
        return res;
    }

    public static void main(String[] args) {
        七进制数 obj = new 七进制数();
        System.out.println(obj.convertToBase7(100));
        System.out.println(obj.convertToBase7(-7));
        System.out.println(obj.convertToBase7(-8));
        System.out.println(obj.convertToBase7(8));
    }
}
