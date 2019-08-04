package leetcode;

import java.util.*;

/**
 * @author yuan
 * @date 2018/12/20
 */
public class 丑数2 {
    public int nthUglyNumber(int n) {
        int[] a = {2, 3, 5};
        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        set.add(Long.valueOf(1));
        queue.add(Long.valueOf(1));
        for (int k = 1; ; k++) {
            long t = queue.poll();
            if (k == n) {
                return (int) t;
            }
            for (int i = 0; i < 3; i++) {
                long t2 = t * a[i];
                if (!set.contains(t2)) {
                    set.add(t2);
                    queue.add(t2);
                }
            }
        }
    }

    public static void main(String[] args) {
        丑数2 obj = new 丑数2();
        System.out.println(obj.nthUglyNumber(10));

    }
}
