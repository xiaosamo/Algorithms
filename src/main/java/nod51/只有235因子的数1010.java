package nod51;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class 只有235因子的数1010 {
    public static void main(String[] args) {
        long []a=new long[10000+5];
//        Set<Integer> set = new TreeSet<>();
        TreeSet<Long> set = new TreeSet<>();
        a[1]=2;
        a[2]=3;
        a[3]=4;
        set.add(Long.valueOf(2));
        set.add(Long.valueOf(3));
        set.add(Long.valueOf(4));
        for(int i=4;i<=10000;i+=3) {
            long t1 = set.pollFirst();
            long t2 = set.pollFirst();
            long t3 = set.pollFirst();

//            a[i]=t1;
//            a[i+1]=t2;
//            a[i+2]=t3;
//            System.out.println(t);
//            a[i]=t;
            set.add(2 * t1);
            set.add(3 * t1);
            set.add(5 * t1);

            set.add(2 * t2);
            set.add(3 * t2);
            set.add(5 * t2);



            set.add(2 * t3);
            set.add(3 * t3);
            set.add(5 * t3);

            a[i] = set.pollFirst();
            a[i+1] = set.pollFirst();
            a[i+2] = set.pollFirst();

            set.add(a[i]);
            set.add(a[i+1]);
            set.add(a[i+2]);
//            a[i]=set.first();
//            a[i+1]=t2;
//            a[i+2]=t3;
//
//            set.first()
        }
        for (int i = 1; i <= 15; i++) {
            System.out.println(a[i]);
        }
//        }
            Scanner in = new Scanner(System.in);
            int T = in.nextInt();
            while (T-- > 0) {
                int n = in.nextInt();
                System.out.println(a[n]);
            }
        }
}
