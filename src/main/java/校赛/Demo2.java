package 校赛;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            s = f(s);
        }
        System.out.println(s);

    }

    public static String f(String s){
        int l = s.length();
        if (l == 1) {
            s = 1 + "" + s;
            return s;

        } else {
            String tep = "";
            char c = s.charAt(0);
            int t = 1;
            for (int i = 1; i < l; i++) {
                if (s.charAt(i) == c) {
                    ++t;
                } else {
                    tep = tep + t + "" + c;
                    t = 1;
                    c = s.charAt(i);
                }

            }
            tep = tep + t + "" + c;
            return tep;
        }
    }
}
