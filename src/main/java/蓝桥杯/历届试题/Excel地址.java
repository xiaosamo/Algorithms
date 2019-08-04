    package 蓝桥杯.历届试题;

    import java.math.BigInteger;
    import java.util.Scanner;

    /**
     * @author yuan
     * @date 2019/3/23
     * @description
     */
    public class Excel地址 {
        public static void main(String[] args) {
            char[] chars = new char[26];
            int i=0;
            for (char c = 'A'; c <= 'Z'; c++) {
                chars[i++] = c;
            }
            Scanner in = new Scanner(System.in);

            int n = in.nextInt();


            String s = "";
            while (n > 0) {

                int t = n % 26;

                if (t == 0) {
                    s = 'Z' + s;
                    n /= 26;
                    --n;
                    continue;
                }

                n /= 26;
                char c = chars[t-1];
                s = c + s;
            }
            System.out.println(s);

//            BigInteger b = new BigInteger(n + "");


    //        System.out.println(b.toString(26));
    //
    //        String s = in.next();
    //        int sum = 0;
    //        for (int i = 0; i < s.length(); i++) {
    //            sum = sum * 26 + (s.charAt(i) - 'A' + 1);
    //
    //        }
    //        System.out.println(sum);

    //        int l = 1, r = Integer.MAX_VALUE;
    //        while (l <= r) {
    //            int m = l + (r - l) / 2;
    //            if (isok(m)) {
    //
    //            }
    //        }

        }
    }
