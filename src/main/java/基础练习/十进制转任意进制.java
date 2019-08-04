package 基础练习;

/**
 * @author yuan
 * @date 2019/3/11
 * @description
 */
public class 十进制转任意进制 {

    /**
     * 将正的十进制数转任意进制
     * @param num 十进制数
     * @param n 要转成几进制数
     * @return
     */
    public static String converTo(int num, int n) {
        if (num == 0) {
            return "0";
        }

        String res = "";
        while (num > 0) {
            int t = num % n;
            num /= n;

            // 10-15 -> a-f
            if (t > 9) {
                char c = (char) ('a' + (t - 10));
                res = c + res;
            } else {
                res = t + res;
            }
        }
        return res;
    }

    public static String transfor(int num, int n) {
        if (num < 0) {
            return "-" + converTo(-num, n);
        }
        return converTo(num, n);
    }



    public static void main(String[] args) {
        System.out.println(transfor(13, 3));
        System.out.println(Integer.toString(13, 3));

        System.out.println();


        System.out.println(transfor(124, 16));
        System.out.println(Integer.toString(124, 16));

        System.out.println();
        System.out.println(transfor(24, 4));
        System.out.println(Integer.toString(24, 4));

        System.out.println();

        System.out.println(transfor(1252, 26));
        System.out.println(Integer.toString(1252, 26));

        System.out.println();
        System.out.println(transfor(0, 2));

        System.out.println();
        System.out.println(transfor(13, 3));
        System.out.println(transfor(13, 12));


        System.out.println();
        System.out.println(transfor(1000,8));
        System.out.println(transfor(1000,10));

        System.out.println();
        System.out.println(transfor(-1203,2));
        System.out.println(Integer.toString(-1203, 2));


    }
}
