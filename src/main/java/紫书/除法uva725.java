package 紫书;

import java.util.Arrays;
import java.util.Scanner;

public class 除法uva725 {
    static String ans="0123456789";
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);

        int kase=0;   //保证输出多换行
        int n ;
        while ((n=in.nextInt())!=0) {
            if(kase!=0) System.out.println();
            String s;
            boolean ok = false;
            ++kase;
            for (int i = 1234; i <= 50000; i++) {
                s = String.valueOf(i);
                if(s.length()<=4) s='0'+s;
                int a = i * n;
                s =a+s;
                if(isok(s)){
                    ok = true;
                    System.out.printf("%05d / %05d = %d\n",a,i,n);
                }
            }
            if (!ok) System.out.printf("There are no solutions for %d.\n", n);

        }
    }

    private static boolean isok(String s) {
        if(s.length()>10) return false;
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        if (String.valueOf(ch).equals(ans)) {
            return true;
        }
        return false;
    }
}
