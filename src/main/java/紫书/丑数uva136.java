package 紫书;

import java.util.*;

public class 丑数uva136 {
    public static void main(String[] args) {
        final int[] dd = {2, 3, 5};
        Queue<Long> q = new PriorityQueue<>();
        q.offer(Long.valueOf(1));
        for (int i = 1; ; i++) {
            long t = q.poll();
            if (i == 1500) {
                System.out.printf("The 1500'th ugly number is %d.\n", t);
                break;
            }
            for (int k = 0; k < 3; k++) {
                long p = t * dd[k];
                if (!q.contains(p)) q.offer(p);
            }

        }
    }

}
