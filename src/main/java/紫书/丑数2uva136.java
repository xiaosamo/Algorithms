package 紫书;

import java.util.TreeSet;

public class 丑数2uva136 {
    public static void main(String[] args) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(Long.valueOf(1));
        for(int i=1;i<1500;i++) {
            long n = set.pollFirst();
            set.add(2 * n);
            set.add(3 * n);
            set.add(5 * n);
        }
        System.out.println("The 1500'th ugly number is " + set.pollFirst() + ".");
    }
}
