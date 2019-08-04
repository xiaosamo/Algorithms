package 校赛;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Demo4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            int l = s.length();
            Set<Character> set = new HashSet<>();


            for (int i = 0; i < l; i++) {
                set.add(s.charAt(i));
            }

            int t = 0;
            for (int i = 0; i < l - 1; i++) {

                if (s.charAt(i) == s.charAt(i + 1)) {
                    ++t;
                }
            }


            if (t == 0) {
                System.out.println(0);
            } else {
                if (set.size() > 1) {
                    System.out.println(t);
                }

            }

        }

    }
}
